package net.royal.erp.rrhh.hrproc.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.ascommon.dominio.dto.DtoDwMaPrTipoplanillaSelect;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.dto.DtoEmpleadomast;
import net.royal.erp.planilla.dominio.dto.DtoDwPrCtsList;
import net.royal.erp.rrhh.dominio.dto.DtoDWHrTipoContratoSelect;
import net.royal.erp.rrhh.dominio.dto.DtoDddWMaHrGradoSalairalMastSelect;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwFactoresCompetenciaHistorial;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoEdit;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.erp.sistema.dominio.dto.DtoDwMaHrPuestoempresaSelect;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrprocDatawindow")
public class HrprocDatawindow {

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDWHrTipoContratoSelect> dWHrTipoContratoSelect() {
		return (List) dao.listarPorQuery(DtoDWHrTipoContratoSelect.class, "hrProc.DWHrTipoContratoSelect");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object[] obtenerDatosSolicitante(String codigoUsuario) {
		Object[] obj = new Object[3];
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("codigo_usuario", String.class, codigoUsuario));
		List<DtoEmpleadomast> lista = (List) dao.listarPorQuery(DtoEmpleadomast.class, "hrProc.obtenerDatosSolicitante",
				parametros);
		if (!UValidador.esListaVacia(lista)) {
			obj[0] = lista.get(0).getEmpleado();
			obj[1] = lista.get(0).getCodigoposicion();
			obj[2] = lista.get(0).getCentrocostos();
		}
		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BigDecimal[] obtenerCodigoUnidadCargo(BigDecimal empleado) {
		BigDecimal[] obj = new BigDecimal[2];
		List<Empleadomast> lista = (List) dao.listarPorCriterios(dao.getCriteria(Empleadomast.class)
				.add(Restrictions.eq("pk.empleado", UValidador.esNulo(empleado) ? null : empleado.intValue())));
		if (!UValidador.esListaVacia(lista)) {
			obj[0] = new BigDecimal(
					UValidador.esNulo(lista.get(0).getCodigounidad()) ? 0 : lista.get(0).getCodigounidad());
			obj[1] = new BigDecimal(
					UValidador.esNulo(lista.get(0).getCodigocargo()) ? 0 : lista.get(0).getCodigocargo());
		}

		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DtoDwHrRequerimientoEdit DwHrRequerimientoEdit(String par_companyowner, String par_requerimiento) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_companyowner", String.class, par_companyowner));
		parametros.add(new ParametroPersistenciaGenerico("par_requerimiento", String.class, par_requerimiento));
		List<DtoDwHrRequerimientoEdit> lista = (List) dao.listarPorQuery(DtoDwHrRequerimientoEdit.class,
				"hrProc.dwHrRequerimientoEdit", parametros);

		if (!UValidador.esListaVacia(lista))
			return lista.get(0);

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String[] obtenerCategoriaFuncional(BigDecimal ll_codigopuesto) {
		String[] obj = new String[2];
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("ll_codigopuesto", BigDecimal.class, ll_codigopuesto));

		List<DtoDwMaHrPuestoempresaSelect> lista = (List) dao.listarPorQuery(DtoDwMaHrPuestoempresaSelect.class,
				"hrProc.obtenerCategoriaFuncional", parametros);

		if (!UValidador.esListaVacia(lista)) {
			obj[0] = lista.get(0).getLineacarrera();
			obj[1] = lista.get(0).getCategoriafuncional();
		}
		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String obtenerMinGradoSalario(String ls_familia) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("ls_familia", String.class, ls_familia));

		List<DtoDddWMaHrGradoSalairalMastSelect> lista = (List) dao
				.listarPorQuery(DtoDddWMaHrGradoSalairalMastSelect.class, "hrProc.obtenerMinGradoSalario", parametros);

		if (!UValidador.esListaVacia(lista))
			return lista.get(0).getGradosalario();

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<DtoDddWMaHrGradoSalairalMastSelect> DddWMaHrGradoSalairalMastSelect(String ls_familia) {

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_categoria", String.class, ls_familia));

		return (List) dao.listarPorQuery(DtoDddWMaHrGradoSalairalMastSelect.class,
				"hrProc.dddWMaHrGradoSalairalMastSelect", filtros);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object[] obtenerTipoTrabajadorPlanillaPerfil(String par_tipoplanilla) {
		Object[] obj = new Object[2];
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("par_tipoplanilla", String.class, par_tipoplanilla));
		List<DtoDwMaPrTipoplanillaSelect> lista = (List) dao.listarPorQuery(DtoDwMaPrTipoplanillaSelect.class,
				"hrProc.obtenerTipoTrabajadorPlanillaPerfil", parametros);

		if (!UValidador.esListaVacia(lista)) {
			obj[0] = lista.get(0).getTipotrabajador();
			obj[1] = lista.get(0).getPlanillaperfil();
		}

		return obj;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] obtenerTipoPlanillaCentroCosto(Integer empleado) {
		String[] obj = new String[2];

		Criteria c = dao.getCriteria(Empleadomast.class);
		c.add(Restrictions.eq("pk.empleado", empleado));

		List<Empleadomast> lista = (List) dao.listarPorCriterios(c);

		if (!UValidador.esListaVacia(lista)) {
			obj[0] = lista.get(0).getTipoplanilla();
			obj[1] = lista.get(0).getCentrocostos();
		}
		return obj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String obtenerCentroCostoXUnidadCompania(Integer w_codigounidad, String w_companiasocio) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("w_codigounidad", Integer.class, w_codigounidad));
		parametros.add(new ParametroPersistenciaGenerico("w_companiasocio", String.class, w_companiasocio));
		List<DtoEmpleadomast> lista = (List) dao.listarPorQuery(DtoEmpleadomast.class,
				"hrProc.obtenerCentroCostoXUnidadCompania", parametros);
		if (!UValidador.esListaVacia(lista))
			return lista.get(0).getCentrocostos();

		return null;
	}

	/**
	 * @powerbuilder dw_factores_competencia_historial
	 */
	public List listarDw1(String par_compania, Integer par_empleado, Integer par_factor, Integer par_secuencia) {
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_compania", String.class, par_compania));
		filtro.add(new ParametroPersistenciaGenerico("par_empleado", Integer.class, par_empleado));
		filtro.add(new ParametroPersistenciaGenerico("par_factor", Integer.class, par_factor));
		filtro.add(new ParametroPersistenciaGenerico("par_secuencia", Integer.class, par_secuencia));

		List datos = dao.listarPorQuery(DtoDwFactoresCompetenciaHistorial.class,
				"hrProc.dwfactorescompetenciahistorial", filtro);
		return datos;
	}

	public List listarRequerimientoList(BigDecimal par_codigopuesto) {// dw_hr_requerimiento_list
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_codigopuesto", BigDecimal.class, par_codigopuesto));

		List datos = dao.listarPorQuery(DtoDwHrRequerimientoList.class, "hrProc.listarRequerimientoList", filtro);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;
	}

	public String obtenerSentencia() {
		StringBuilder sbd = new StringBuilder();
		sbd.append(dao.getSesionActual().getNamedQuery("hrProc.listarRequerimientoList").getQueryString());
		String datos = String.valueOf(sbd);

		if (UValidador.estaVacio(datos)) {
			return null;
		}
		return datos;

	}

	public List listarRequerimientoWhere(String sb, Integer ll_codigopuesto, Date p_fini, Date p_ffin, Integer p_an_sid,
			boolean valida, String p_userid) {
		StringBuilder sbd = new StringBuilder(sb);
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_codigopuesto", Integer.class, ll_codigopuesto));
		if (!valida) {
			filtro.add(new ParametroPersistenciaGenerico("p_fini", Date.class, p_fini));
			filtro.add(new ParametroPersistenciaGenerico("p_ffin", Date.class, p_ffin));
		}

		filtro.add(new ParametroPersistenciaGenerico("p_an_sid", Integer.class, p_an_sid));
		filtro.add(new ParametroPersistenciaGenerico("p_userid", String.class, p_userid));

		List datos = dao.listarPorSentenciaSQL(DtoDwHrRequerimientoList.class, sbd, filtro);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;
	}

}
