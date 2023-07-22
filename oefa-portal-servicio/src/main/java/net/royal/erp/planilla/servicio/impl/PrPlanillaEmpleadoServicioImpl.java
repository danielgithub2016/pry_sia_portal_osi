package net.royal.erp.planilla.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.erp.asistencia.symast.dominio.dto.DtoMonedaMast;
import net.royal.erp.planilla.dao.PrPlanillaEmpleadoDao;
import net.royal.erp.planilla.dominio.PrPlanillaEmpleado;
import net.royal.erp.planilla.dominio.dto.DtoAcumuladoRet;
import net.royal.erp.planilla.dominio.dto.DtoConsultaBoletasEmpleado;
import net.royal.erp.planilla.dominio.dto.DtoConsultaBoletasEmpleadoEncabezado;
import net.royal.erp.planilla.dominio.dto.DtoDeduccion;
import net.royal.erp.planilla.dominio.dto.DtoDetalleBoleta;
import net.royal.erp.planilla.dominio.dto.DtoListaCertificado;
import net.royal.erp.planilla.dominio.dto.DtoMonedaCertificado;
import net.royal.erp.planilla.dominio.dto.DtoNumResponsable;
import net.royal.erp.planilla.dominio.dto.DtoResponsable;
import net.royal.erp.planilla.dominio.dto.DtoTituloAnio;
import net.royal.erp.planilla.dominio.dto.DtoTotalNeto;
import net.royal.erp.planilla.dominio.dto.DtoVacacionBoleta;
import net.royal.erp.planilla.servicio.ConvertNumberToLetters;
import net.royal.erp.planilla.servicio.PrPlanillaEmpleadoServicio;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioPrPlanillaEmpleado")
public class PrPlanillaEmpleadoServicioImpl extends GenericoServicioImpl implements PrPlanillaEmpleadoServicio {

	private PrPlanillaEmpleadoDao dao;

	@SuppressWarnings("unused")
	private static Log LOGGER = LogFactory.getLog(PrPlanillaEmpleado.class);

	@Autowired
	public void setDao(PrPlanillaEmpleadoDao dao) {
		this.dao = dao;
		setGenericoDao(dao);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listarBoletasEmpleado(List<ParametroPersistenciaGenerico> filtros) {
		return dao.listarPorQuery(DtoConsultaBoletasEmpleado.class, "PrPlanillaEmpleado.listarBoletasEmpleado",
				filtros);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listarDetalleBoleta(List<ParametroPersistenciaGenerico> filtros) {
		return dao.listarPorQuery(DtoDetalleBoleta.class, "PrPlanillaEmpleado.listarDetalleBoleta", filtros);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listarDetalleBoletaEncabezado(List<ParametroPersistenciaGenerico> filtros) {
		return dao.listarPorQuery(DtoConsultaBoletasEmpleadoEncabezado.class,
				"PrPlanillaEmpleado.listarEncabezadoBoleta", filtros);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listarEmpleadosCertificado(StringBuilder SQL) {
		return dao.listarPorSentenciaSQL(DtoListaCertificado.class, SQL, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List obtenerResponsable(StringBuilder SQL) {
		return dao.listarPorSentenciaSQL(DtoResponsable.class, SQL, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List obtenerNumResponsable(StringBuilder SQL) {
		return dao.listarPorSentenciaSQL(DtoNumResponsable.class, SQL, null);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List obtenerDeduccion(StringBuilder SQL) {
		return dao.listarPorSentenciaSQL(DtoDeduccion.class, SQL, null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String obtenerAcumuladoRetencionLetras(String compania, String planilla, String ejerciciofiscal,
			String empleado) {
		StringBuilder sb = new StringBuilder("SELECT nvl(AcumuladoRetencion,0) + nvl(AcumuladoRetencionInterno,0) + "
				+ "nvl(AcumuladoRetencionExterno,0) + CASE WHEN nvl(EstimadoImpuestoMensual,0) "
				+ "<0 THEN 0 ELSE nvl(EstimadoImpuestoMensual,0) END   as AcumuladoRetencion "
				+ "FROM sgcoresys.PR_ImpuestoRenta " + "INNER JOIN sgcoresys.PersonaMast "
				+ "ON ( PR_ImpuestoRenta.Empleado = PersonaMast.Persona ) " + "INNER JOIN sgcoresys.EmpleadoMast "
				+ "ON ( PersonaMast.Persona = EmpleadoMast.Empleado ) " + "LEFT JOIN sgcoresys.HR_PuestoEmpresa "
				+ "ON ( EmpleadoMast.CodigoCargo = HR_PuestoEmpresa.CodigoPuesto ) "
				+ "WHERE ( PR_ImpuestoRenta.CompaniaSocio = '" + compania + "' ) and "
				+ "( EmpleadoMast.TipoPlanilla = '" + planilla + "' ) and "
				+ "( cast( PR_ImpuestoRenta.EjercicioFiscal as number) = '" + ejerciciofiscal + "' )AND "
				+ "( EmpleadoMast.Empleado IN ('" + empleado + "')) AND " + "( EmpleadoMast.EstadoEmpleado <> '2') ");

		List lista = dao.listarPorSentenciaSQL(DtoAcumuladoRet.class, sb, null);
		List<DtoAcumuladoRet> lst = new ArrayList<>();
		lst = lista;
		if (!lst.isEmpty()) {
			String acumuladoRet = lst.get(0).getACUMULADORETENCION().toString();
			String acumuladoRetLetras = ConvertNumberToLetters.convertNumberToLetter(acumuladoRet);
			return acumuladoRetLetras;
		}

		return "";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String obtenerTituloAnio(String anio) {
		StringBuilder sb = new StringBuilder("SELECT ParametrosMast.Explicacion TITULOANIO "
				+ "FROM sgcoresys.ParametrosMast " + "WHERE ( ParametrosMast.CompaniaCodigo = '999999' ) AND "
				+ "( ParametrosMast.AplicacionCodigo = 'PR' ) AND " + "( ParametrosMast.ParametroClave = 'ANIOTI" + anio
				+ "' ) ");
		List lista = dao.listarPorSentenciaSQL(DtoTituloAnio.class, sb, null);
		List<DtoTituloAnio> lst = lista;
		if (!lst.isEmpty()) {
			return lst.get(0).getTITULOANIO();
		}

		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String obtenerTotalNetoLetras(String compania, String empleado, String periodo, String planilla,
			String proceso) {
		StringBuilder sb = new StringBuilder("SELECT PR_PlanillaEmpleado.TotalNeto "
				+ "FROM sgcoresys.PR_PlanillaEmpleado " + "INNER JOIN sgcoresys.PersonaMast "
				+ "ON ( PR_PlanillaEmpleado.Empleado = PersonaMast.Persona ) " + "INNER JOIN sgcoresys.EmpleadoMast "
				+ "ON ( PR_PlanillaEmpleado.Empleado = EmpleadoMast.Empleado and PR_PlanillaEmpleado.CompaniaSocio = EmpleadoMast.CompaniaSocio) "
				+ "INNER JOIN sgcoresys.CompaniaMast "
				+ "ON ( SUBSTR(PR_PlanillaEmpleado.CompaniaSocio,1,6) = CompaniaMast.companiacodigo ) "
				+ "INNER JOIN sgcoresys.PR_ProcesoPeriodo "
				+ "                 ON ( PR_PlanillaEmpleado.CompaniaSocio = PR_ProcesoPeriodo.CompaniaSocio "
				+ "                            AND PR_PlanillaEmpleado.CompaniaSocio = PR_ProcesoPeriodo.CompaniaSocio "
				+ "                            AND PR_PlanillaEmpleado.Periodo = PR_ProcesoPeriodo.Periodo "
				+ "                            AND PR_PlanillaEmpleado.TipoPlanilla = PR_ProcesoPeriodo.TipoPlanilla "
				+ "                            AND PR_PlanillaEmpleado.TipoProceso = PR_ProcesoPeriodo.TipoProceso) "
				+ "            INNER JOIN sgcoresys.HR_GRADOSALARIOMAST "
				+ "                ON( HR_GRADOSALARIOMAST.GradoSalario=EmpleadoMast.GradoSalario ) "
				+ "            INNER JOIN sgcoresys.HR_TIPOCONTRATO "
				+ "                ON( HR_TIPOCONTRATO.TipoContrato=PR_PlanillaEmpleado.TipoContrato) "
				+ "            INNER JOIN sgcoresys.PR_TIPOPLANILLA "
				+ "                ON( PR_TIPOPLANILLA.TipoPlanilla=PR_PlanillaEmpleado.TipoPlanilla) "
				+ "            LEFT JOIN sgcoresys.MA_UnidadNegocio "
				+ "                ON ( EmpleadoMast.LocaciondePago = MA_UnidadNegocio.UnidadNegocio ) "
				+ "            LEFT JOIN sgcoresys.HR_AFP "
				+ "                ON ( PR_PlanillaEmpleado.CodigoAFP = HR_AFP.CodigoAFP ) "
				+ "            LEFT JOIN sgcoresys.HR_Empleado "
				+ "                ON ( PR_PlanillaEmpleado.Empleado = HR_Empleado.Empleado) "
				+ "            LEFT JOIN sgcoresys.PR_Planilla_Comentario PC "
				+ "                ON (    PR_PlanillaEmpleado.Empleado = PC.Empleado "
				+ "                    AND PR_PlanillaEmpleado.TipoPlanilla = PC.TipoPlanilla "
				+ "                    AND PR_PlanillaEmpleado.TipoProceso = PC.TipoProceso "
				+ "                    AND PR_PlanillaEmpleado.Periodo = PC.Periodo) "
				+ "WHERE     ( PR_PlanillaEmpleado.Periodo = '" + periodo + "' ) "
				+ "            AND ( PR_PlanillaEmpleado.TipoProceso = '" + proceso + "') "
				+ "            AND ( PR_PlanillaEmpleado.TipoPlanilla = '" + planilla + "'  ) "
				+ "				AND ( PR_PlanillaEmpleado.Empleado = '" + empleado + "' )");

		List lista = dao.listarPorSentenciaSQL(DtoTotalNeto.class, sb, null);
		List<DtoTotalNeto> lst = new ArrayList<>();
		lst = lista;
		if (!lst.isEmpty()) {
			String totalNeto = lst.get(0).getTOTALNETO().toString();
			String totalNetoLetras = ConvertNumberToLetters.convertNumberToLetter(totalNeto);
			return totalNetoLetras;
		}

		return "";

	}

	@Override
	public List<DtoVacacionBoleta> obtenerFechasVacacionBoleta(String periodo, Integer empleado) {

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();

		filtros.add(new ParametroPersistenciaGenerico("par_periodo", String.class, periodo));

		filtros.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, empleado));

		List lst = dao.listarPorQuery(DtoVacacionBoleta.class, "PrPlanillaEmpleado.obtenerFechasVacacionBoleta",
				filtros);
		List<DtoVacacionBoleta> lista = lst;

		if (lista.isEmpty()) {
			return null;
		}

		return lista;
	}

	@Override
	public String obtenerMonedaLocal() {
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<>();

		filtros.add(new ParametroPersistenciaGenerico("par_currency", String.class, "LO"));

		List lst = dao.listarPorQuery(DtoMonedaCertificado.class, "PrPlanillaEmpleado.obtenerMonedaLocal", filtros);
		List<DtoMonedaMast> lista = lst;

		if (!lista.isEmpty() && lista != null) {
			return lista.get(0).getDescripcioncorta();
		}
		return null;
	}

}
