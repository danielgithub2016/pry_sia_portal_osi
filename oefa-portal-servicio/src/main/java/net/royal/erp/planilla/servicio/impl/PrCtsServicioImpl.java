package net.royal.erp.planilla.servicio.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.planilla.dao.PrCtsDao;
import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsList;
import net.royal.erp.planilla.dominio.dto.DtoMontoTotalCts;
import net.royal.erp.planilla.dominio.dto.DtoRemuneracionCts;
import net.royal.erp.planilla.servicio.ConvertNumberToLetters;
import net.royal.erp.planilla.servicio.PrCtsServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioPrCts")
public class PrCtsServicioImpl extends GenericoServicioImpl implements PrCtsServicio {

	private PrCtsDao dao;

	private static Log LOGGER = LogFactory.getLog(PrCtsServicioImpl.class);

	@Autowired
	public void setDao(PrCtsDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<DtoDwPrCtsList> listarCtsEmpleado(String compania, BigDecimal cts, BigDecimal ctsfinal, String moneda,
			String estadoempleado) {
		return dao.listarCtsEmpleado(compania, cts, ctsfinal, moneda, estadoempleado);
	}

	public String obtenerSentencia() {
		StringBuilder sbd = new StringBuilder();
		sbd.append(dao.getSesionActual().getNamedQuery("prcts.listactsempleado2").getQueryString());
		String datos = String.valueOf(sbd);

		if (UValidador.estaVacio(datos)) {
			return null;
		}
		return datos;
	}

	@SuppressWarnings("rawtypes")
	public List listarRequerimientoWhere2(String sb, BigDecimal cts, BigDecimal ctsfinal) {
		StringBuilder sbd = new StringBuilder(sb);
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("p_cts", BigDecimal.class, cts));
		filtro.add(new ParametroPersistenciaGenerico("p_ctsfinal", Integer.class, ctsfinal));
		List datos = dao.listarPorSentenciaSQL(DtoDwPrCtsList.class, sbd, filtro);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listarRequerimientoWhere(String sb, Integer cts, Integer ctsfinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String obtenerMontoTotalLetras(String empleado, BigDecimal cts) {

		String montoTotal = "";
		StringBuilder sb = new StringBuilder("SELECT (PR_CTS.TiempoValorizado +NVL(PR_CTS.MontoInteres,0)- "
				+ "NVL(PR_CTS.retencionjudicial,0)) as MONTOTOTAL "
				+ "FROM sgcoresys.PR_CTS INNER JOIN sgcoresys.PR_CTSDetalle "
				+ "ON ( PR_CTS.Empleado = PR_CTSDetalle.Empleado and "
				+ "PR_CTS.CompaniaSocio = PR_CTSDetalle.CompaniaSocio and "
				+ "PR_CTS.NumeroCTS = PR_CTSDetalle.NumeroCTS ) " + "INNER JOIN sgcoresys.EmpleadoMast "
				+ "ON ( PR_CTS.Empleado = EmpleadoMast.Empleado and "
				+ "PR_CTS.CompaniaSocio = EmpleadoMast.CompaniaSocio ) "
				+ "INNER JOIN sgcoresys.PersonaMast ON ( EmpleadoMast.Empleado = PersonaMast.Persona ) "
				+ "INNER JOIN sgcoresys.CompaniaMast ON ( substr(PR_CTS.CompaniaSocio,1,6) = CompaniaMast.companiacodigo ) "
				+ "left JOIN sgcoresys.Banco ON ( Banco.Banco = PR_CTS.Banco ) "
				+ "LEFT JOIN sgcoresys.MA_UnidadNegocio ON ( EmpleadoMast.LocaciondePago = MA_UnidadNegocio.UnidadNegocio ) "
				+ "LEFT JOIN sgcoresys.MA_CTS ON ( PR_CTS.NumeroCTS = MA_CTS.NumeroCTS) "
				+ "WHERE ( PR_CTS.NumeroCTS = '" + cts + "')  and (EmpleadoMast.CodigoUsuario='" + empleado + "') and"
				+ "( pr_ctsdetalle.montolocal <> 0  OR substr(PR_CTSDetalle.Descripcion,-1) = '*')");

		List lista = dao.listarPorSentenciaSQL(DtoMontoTotalCts.class, sb, null);

		List<DtoMontoTotalCts> lst = new ArrayList<>();
		lst = lista;

		if (!UValidador.esListaVacia(lst)) {
			montoTotal = lst.get(0).getMONTOTOTAL().toString();
			String montoTotalLetras = ConvertNumberToLetters.convertNumberToLetter(montoTotal);
			return montoTotalLetras;
		}

		return "";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String obtenerRemuneracionLetras(String empleado, BigDecimal cts) {

		String remuTotal = "";
		StringBuilder sb = new StringBuilder("SELECT PR_CTS.Remuneracion as REMUNERACION FROM sgcoresys.PR_CTS "
				+ "INNER JOIN sgcoresys.PR_CTSDetalle ON (    PR_CTS.Empleado = PR_CTSDetalle.Empleado "
				+ "AND PR_CTS.CompaniaSocio = PR_CTSDetalle.CompaniaSocio "
				+ "AND PR_CTS.NumeroCTS = PR_CTSDetalle.NumeroCTS ) "
				+ "INNER JOIN sgcoresys.EmpleadoMast ON (     PR_CTS.Empleado = EmpleadoMast.Empleado "
				+ "AND PR_CTS.CompaniaSocio = EmpleadoMast.CompaniaSocio ) "
				+ "INNER JOIN sgcoresys.PersonaMast ON ( EmpleadoMast.Empleado = PersonaMast.Persona ) "
				+ "INNER JOIN sgcoresys.CompaniaMast ON ( substr(PR_CTS.CompaniaSocio,1,6) = CompaniaMast.companiacodigo ) "
				+ "LEFT JOIN sgcoresys.Banco ON ( Banco.Banco = PR_CTS.Banco ) "
				+ "LEFT JOIN sgcoresys.PersonaMast DirBanco ON ( Banco.BancoNumero = DirBanco.Persona) "
				+ "LEFT JOIN sgcoresys.MA_UnidadNegocio ON ( EmpleadoMast.LocaciondePago = MA_UnidadNegocio.UnidadNegocio ) "
				+ "LEFT JOIN sgcoresys.MA_CTS ON ( PR_CTS.NumeroCTS = MA_CTS.NumeroCTS) "
				+ "WHERE ( PR_CTS.NumeroCTS = '" + cts + "')  and (EmpleadoMast.CodigoUsuario='" + empleado + "') and "
				+ "( pr_ctsdetalle.montolocal <> 0  OR substr(PR_CTSDetalle.Descripcion,-1) = '*')");

		List lista = dao.listarPorSentenciaSQL(DtoRemuneracionCts.class, sb, null);
		List<DtoRemuneracionCts> lst = new ArrayList<>();
		lst = lista;

		if (!UValidador.esListaVacia(lst)) {
			remuTotal = lst.get(0).getREMUNERACION().toString();
			String remuLetras = ConvertNumberToLetters.convertNumberToLetter(remuTotal);
			return remuLetras;
		}

		return "";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List obtenerLiquidacion(String empleado, BigDecimal ctsinicio, BigDecimal ctsfinal) {
		StringBuilder sb = new StringBuilder("SELECT (PR_CTS.TiempoaCancelar) as LIQUIDACION FROM sgcoresys.PR_CTS "
				+ "INNER JOIN sgcoresys.EmpleadoMast ON (PR_CTS.Empleado = EmpleadoMast.Empleado and "
				+ "PR_CTS.CompaniaSocio = EmpleadoMast.CompaniaSocio ) "
				+ "INNER JOIN sgcoresys.PersonaMast ON ( EmpleadoMast.Empleado = PersonaMast.Persona ) "
				+ "INNER JOIN sgcoresys.CompaniaMast ON ( substr(PR_CTS.CompaniaSocio,1,6) = CompaniaMast.companiacodigo ) "
				+ "left JOIN sgcoresys.Banco ON ( Banco.Banco = PR_CTS.Banco ) "
				+ "LEFT JOIN sgcoresys.MA_UnidadNegocio ON ( EmpleadoMast.LocaciondePago = MA_UnidadNegocio.UnidadNegocio ) "
				+ "LEFT JOIN sgcoresys.MA_CTS ON ( PR_CTS.NumeroCTS = MA_CTS.NumeroCTS) "
				+ "WHERE ( PR_CTS.NumeroCTS >= '" + ctsinicio + "' AND PR_CTS.NumeroCTS <= '" + ctsfinal + "') "
				+ "and (EmpleadoMast.codigousuario='" + empleado + "') "
				+ "GROUP BY EmpleadoMast.Empleado ,PersonaMast.NombreCompleto,PersonaMast.PersonaAnt, "
				+ "EmpleadoMast.FechaInicioContrato, PR_CTS.NumeroCTS ,PR_CTS.TiempoaCancelar "
				+ "ORDER BY EmpleadoMast.Empleado desc");

		List lista = dao.listarPorSentenciaSQL(sb, null);

		return lista;
	}
}
