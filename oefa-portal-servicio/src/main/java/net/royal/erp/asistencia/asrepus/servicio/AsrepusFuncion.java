package net.royal.erp.asistencia.asrepus.servicio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.royal.erp.asistencia.asmain.dominio.dto.DtoDwAsProcesoAsistenciaDiariaTipodia;
import net.royal.erp.asistencia.asrepus.dominio.dto.DtoDwAsAutorizacionPreprocesoExcepcion;
import net.royal.erp.asistencia.asrepus.dominio.dto.DtoDwAsProcesoAsistenciaDiariaTipohor;
import net.royal.erp.core.dominio.dto.DtoCompaniamast;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.ComunDao;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsrepusFuncion")
public class AsrepusFuncion {

	private static Log LOGGER = LogFactory.getLog(AsrepusFuncion.class);

	private ComunDao dao;

	@Autowired
	public void setDao(ComunDao dao) {
		this.dao = dao;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_as_autorizacion_preproceso_day
	 */
	public String FAsAutorizacionPreprocesoDay(Date par_date) {
		LOGGER.debug("test de asrepus.f_as_autorizacion_preproceso_day");
		Integer lv_dia;
		String lv_nombre;

		Calendar fecha = Calendar.getInstance();
		fecha.setTime(par_date);

		lv_dia = fecha.get(Calendar.DAY_OF_WEEK);

		switch (lv_dia) {
		case 1:
			lv_nombre = "DOMINGO";
		case 2:
			lv_nombre = "LUNES";
		case 3:
			lv_nombre = "MARTES";
		case 4:
			lv_nombre = "MIERCOLES";
		case 5:
			lv_nombre = "JUEVES";
		case 6:
			lv_nombre = "VIERNES";
		default:
			lv_nombre = "SABADO";

		}

		return lv_nombre;
	}

	/**
	 *
	 * @author desarrollo
	 * @return
	 * @throws Exception
	 * @powerbuilder asrepus.f_as_autorizacion_preproceso_tipodia
	 */
	public Date FAsAutorizacionPreprocesoTipodia(Integer par_empleado,
			Date par_fecha) throws Exception {
		LOGGER.debug("test de asrepus.f_as_autorizacion_preproceso_tipodia");

		Integer w_tipodia = null, w_tipohorario_rows, w_dias, w_j, w_filas, w_tipohorario_row;
		BigDecimal w_tipohorario;
		String w_FechaMesDia;
		Date w_Fecha = UFechaHora.convertirCadenaFecha("01/01/1990",
				"dd/MM/yyyy");
		Integer w_diasutiles, w_existe, w_tipohorarioEmpleado;
		Date w_hora = null;

		List<DtoDwAsProcesoAsistenciaDiariaTipohor> dw_tipohorario = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipohor>();
		List<DtoDwAsProcesoAsistenciaDiariaTipodia> dw_tipodia = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipodia>();
		List<DtoDwAsAutorizacionPreprocesoExcepcion> dw_tipodiax = new ArrayList<DtoDwAsAutorizacionPreprocesoExcepcion>();

		List<DtoDwAsProcesoAsistenciaDiariaTipodia> dw_tipodiaAux = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipodia>();
		List<DtoDwAsAutorizacionPreprocesoExcepcion> dw_tipodiaxAux = new ArrayList<DtoDwAsAutorizacionPreprocesoExcepcion>();

		String dia = null;

		// DATASTORE DE LOS TIPOS DE HORARIO
		List data1 = dao.listarPorQuery(
				DtoDwAsProcesoAsistenciaDiariaTipohor.class,
				"asrepus.DwAsProcesoAsistenciaDiariaTipohor");
		if (!UValidador.esListaVacia(data1)) {
			dw_tipohorario = data1;
		}
		w_tipohorario_rows = dw_tipohorario.size();

		// DATASTORE DE TODOS LOS TIPOS DE DIA
		List data2 = dao.listarPorQuery(
				DtoDwAsProcesoAsistenciaDiariaTipodia.class,
				"asmain.DwAsProcesoAsistenciaDiariaTipodia");
		if (!UValidador.esListaVacia(data2)) {
			dw_tipodia = data2;
		}

		// DATASTORE DE LOS TIPOS DE HORARIO
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class,
				par_fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_empleado", Date.class,
				par_empleado));

		List data3 = dao.listarPorQuery(
				DtoDwAsAutorizacionPreprocesoExcepcion.class,
				"asrepus.DwAsAutorizacionPreprocesoExcepcion", filtros);
		if (!UValidador.esListaVacia(data3)) {
			dw_tipodiax = data3;
		}

		for (DtoDwAsAutorizacionPreprocesoExcepcion obj : dw_tipodiax) {
			dia = FAsAutorizacionPreprocesoDay(w_Fecha);
			switch (dia) {
			case "DOMINGO":
				if (obj.getDomingo().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			case "LUNES":
				if (obj.getLunes().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			case "MARTES":
				if (obj.getMartes().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			case "MIERCOLES":
				if (obj.getMiercoles().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			case "JUEVES":
				if (obj.getJueves().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			case "VIERNES":
				if (obj.getViernes().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			case "SABADO":
				if (obj.getSabado().equals("S")) {
					dw_tipodiaxAux.add(obj);
				}
				break;
			}
		}

		w_filas = dw_tipodiaxAux.size();
		if (w_filas > 0) {
			// LE COLOQUE ESTO POR QUE SALIA ERROR
			w_tipohorario = dw_tipodiaxAux.get(0).getTipohorario();
			w_tipohorario_row = -1;
			for (DtoDwAsProcesoAsistenciaDiariaTipohor obj : dw_tipohorario) {
				if (obj.getTipohorario().equals(w_tipohorario)) {
					w_tipohorario_row = dw_tipohorario.indexOf(obj);
				}
			}

			if (w_tipohorario_row >= 0) {
				dia = FAsAutorizacionPreprocesoDay(w_Fecha);
				switch (dia) {
				case "DOMINGO":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getDomingo().intValue();
					break;
				case "LUNES":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getLunes().intValue();
					break;
				case "MARTES":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getMartes().intValue();
					break;
				case "MIERCOLES":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getMiercoles().intValue();
					break;
				case "JUEVES":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getJueves().intValue();
					break;
				case "VIERNES":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getViernes().intValue();
					break;
				case "SABADO":
					w_tipodia = dw_tipohorario.get(w_tipohorario_row)
							.getSabado().intValue();
					break;
				}

				for (DtoDwAsProcesoAsistenciaDiariaTipodia obj : dw_tipodia) {
					if (obj.getTipodia().equals(w_tipodia)) {
						dw_tipodiaAux.add(obj);
					}
				}

				if (!UValidador.esListaVacia(dw_tipodia)) {
					w_hora = dw_tipodia.get(dw_tipodia.size() - 1).getHorafin();
				}

			}
		}

		return w_hora;

	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asrepus.f_as_autorizacion_preproceso_tipodia_2
	 */
	@SuppressWarnings("unchecked")
	public List FAsAutorizacionPreprocesoTipodia2(Integer par_empleado,
			Date par_fecha) throws Exception {
		LOGGER.debug("test de asrepus.f_as_autorizacion_preproceso_tipodia_2");
		Integer w_tipodia = null, w_filas;
		Date w_desde = null, w_hasta = null;
		List respuesta = new ArrayList();

		List<DtoDwAsProcesoAsistenciaDiariaTipohor> dw_tipohorario = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipohor>();
		List<DtoDwAsProcesoAsistenciaDiariaTipodia> dw_tipodia = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipodia>();
		List<DtoDwAsAutorizacionPreprocesoExcepcion> dw_tipodiax = new ArrayList<DtoDwAsAutorizacionPreprocesoExcepcion>();

		// DATASTORE DE LOS TIPOS DE HORARIO
		List data1 = dao.listarPorQuery(
				DtoDwAsProcesoAsistenciaDiariaTipohor.class,
				"asrepus.DwAsProcesoAsistenciaDiariaTipohor");
		if (!UValidador.esListaVacia(data1)) {
			dw_tipohorario = data1;
		}

		// DATASTORE DE TODOS LOS TIPOS DE DIA
		List data2 = dao.listarPorQuery(
				DtoDwAsProcesoAsistenciaDiariaTipodia.class,
				"asmain.DwAsProcesoAsistenciaDiariaTipodia");
		if (!UValidador.esListaVacia(data2)) {
			dw_tipodia = data2;
		}

		// DATASTORE DE LOS TIPOS DE HORARIO
		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class,
				par_fecha));
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));

		List data3 = dao.listarPorQuery(
				DtoDwAsAutorizacionPreprocesoExcepcion.class,
				"asrepus.DwAsAutorizacionPreprocesoExcepcion", filtros);
		if (!UValidador.esListaVacia(data3)) {
			dw_tipodiax = data3;
		}

		w_filas = dw_tipodiax.size();

		if (w_filas > 0) {
			w_tipodia = dw_tipodiax.get(0).getTipodia().intValue();

			for (DtoDwAsProcesoAsistenciaDiariaTipodia obj : dw_tipodia) {
				if (obj.getTipodia().equals(w_tipodia)) {
					if (UValidador.esNulo(w_desde)) {
						w_desde = obj.getHorainicio(); // la primera hora
					}
					w_hasta = obj.getHorafin();
				}
			}

		} else {
			w_tipodia = FSqlDevuelveHorario(par_empleado, par_fecha);
			Boolean isprimero = true;
			for (DtoDwAsProcesoAsistenciaDiariaTipodia obj : dw_tipodia) {
				if (((Integer) obj.getTipodia().intValue()).equals(w_tipodia)) {
					// Solo tomamos en cuenta cuando es un concepto por trabajo
					if (obj.getIntervaloacceso().equals("TRAB")) {
						if (isprimero) {
							w_desde = obj.getHorainicio(); // la primera hora
							isprimero = false;
						}
						w_hasta = obj.getHorafin();
					}
				}
			}

		}

		respuesta.add(w_desde);
		respuesta.add(w_hasta);
		return respuesta;
	}

	/**
	 *
	 * @author desarrollo
	 * @return
	 * @throws Exception
	 * @powerbuilder asrepus.f_get_tiene_reprogramacion
	 */
	public Integer FGetTieneReprogramacion(Integer par_empleado, Date par_fecha)
			throws Exception {
		LOGGER.debug("test de asrepus.f_get_tiene_reprogramacion");

		Integer il_dia;

		List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
		filtros.add(new ParametroPersistenciaGenerico("p_empleado",
				Integer.class, par_empleado));
		filtros.add(new ParametroPersistenciaGenerico("p_fecha", Date.class,
				UFechaHora.convertirCadenaFecha(
						UFechaHora.convertirFechaCadena(par_fecha),
						"dd/MM/yyyy")));

		il_dia = dao.contar("asempleadoexcepciondetalle.obtenertipodia",
				filtros);
		
		if (UValidador.esNulo(il_dia)) {
			il_dia = 0;
		}

		return il_dia;

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_pr_reemplaza_cadena
	 */
	public void FPrReemplazaCadena() {
		LOGGER.debug("test de asrepus.f_pr_reemplaza_cadena");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_pr_vacacion_pendientes
	 */
	public void FPrVacacionPendientes() {
		LOGGER.debug("test de asrepus.f_pr_vacacion_pendientes");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_relative_date_tiempo_real
	 */
	public void FRelativeDateTiempoReal() {
		LOGGER.debug("test de asrepus.f_relative_date_tiempo_real");
	}

	/**
	 *
	 * @author desarrollo
	 * @throws Exception
	 * @powerbuilder asrepus.f_sql_devuelve_horario
	 */
	public Integer FSqlDevuelveHorario(Integer par_empleado, Date par_fecha)
			throws Exception {
		LOGGER.debug("test de asrepus.f_sql_devuelve_horario");
		Integer tipohorario_rows;
		List<DtoDwAsProcesoAsistenciaDiariaTipohor> dw_tipohorario = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipohor>();
		List data = dao.listarPorQuery(
				DtoDwAsProcesoAsistenciaDiariaTipohor.class,
				"asrepus.DwAsProcesoAsistenciaDiariaTipohor");
		if (!UValidador.esListaVacia(data)) {
			dw_tipohorario = data;
		}

		tipohorario_rows = dw_tipohorario.size();

		Integer w_tipohorario_row = -1, tipodia, tipohorario;

		tipodia = FGetTieneReprogramacion(par_empleado, par_fecha);

		if (UValidador.esNulo(tipodia)) {
			tipodia = 0;
		}

		if (UValidador.esCero(tipodia)) {
			List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
			filtros.add(new ParametroPersistenciaGenerico("p_empleado",
					Integer.class, par_empleado));
			filtros.add(new ParametroPersistenciaGenerico("p_fecha",
					Date.class, UFechaHora.convertirCadenaFecha(
							UFechaHora.convertirFechaCadena(par_fecha),
							"dd/MM/yyyy")));

			tipohorario = dao.contar(
					"asempleadoexcepciondetalle.obtenertipodia2", filtros);

			if (!UValidador.esNulo(tipohorario)) {
				// buscamos por el tipo horario
				for (int i = 0; i < tipohorario_rows; i++) {
					DtoDwAsProcesoAsistenciaDiariaTipohor obj = dw_tipohorario
							.get(i);
					if (UValidador.esCero(obj.getTipohorario().compareTo(
							BigDecimal.valueOf(tipohorario)))) {
						w_tipohorario_row = i;
					}
				}

				if (w_tipohorario_row >= 0) {
					if (par_empleado.equals(90)) {

					}
					Integer lv_dia;
					String lv_nombre = null;
					lv_dia = UFechaHora.obtenerNumeroDiaSemana(par_fecha);
					LOGGER.debug("lv_dia " + lv_dia);

					switch (lv_dia) {
					case 1:
						lv_nombre = "DOMINGO";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getDomingo().intValue();
						break;
					case 2:
						lv_nombre = "Lunes";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getLunes().intValue();
						break;
					case 3:
						lv_nombre = "Martes";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getMartes().intValue();
						break;
					case 4:
						lv_nombre = "Miércoles";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getMiercoles().intValue();
						break;
					case 5:
						lv_nombre = "Jueves";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getJueves().intValue();
						break;
					case 6:
						lv_nombre = "Viernes";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getViernes().intValue();
						break;
					case 7:
						lv_nombre = "Sábado";
						tipodia = dw_tipohorario.get(w_tipohorario_row)
								.getSabado().intValue();
						break;
					}

					if (UValidador.estaVacio(lv_nombre)) {
						tipodia = 0;
					}
				} else {
					return 0;
				}

				return tipodia;
			} else {
				return 0;
			}
		} else {
			return tipodia;
		}
	}

	public String FSqlDevuelveHorarioReporteMarca(Integer par_empleado,
			Date par_fecha) throws Exception {
		List<DtoDwAsProcesoAsistenciaDiariaTipohor> dw_tipohorario = new ArrayList<DtoDwAsProcesoAsistenciaDiariaTipohor>();
		List data = dao.listarPorQuery(
				DtoDwAsProcesoAsistenciaDiariaTipohor.class,
				"asrepus.DwAsProcesoAsistenciaDiariaTipohor");
		if (!UValidador.esListaVacia(data)) {
			dw_tipohorario = data;
		}

		Integer w_tipohorario_row = -1, tipohorario;
		String descripcion = null;

		Integer tipodia = FGetTieneReprogramacion(par_empleado, par_fecha);

		if (UValidador.esNulo(tipodia)) {
			tipodia = 0;
		}

		if (UValidador.esCero(tipodia)) {
			List<ParametroPersistenciaGenerico> filtros = new ArrayList<ParametroPersistenciaGenerico>();
			filtros.add(new ParametroPersistenciaGenerico("p_empleado",
					Integer.class, par_empleado));
			filtros.add(new ParametroPersistenciaGenerico("p_fecha",
					Date.class, UFechaHora.convertirCadenaFecha(
							UFechaHora.convertirFechaCadena(par_fecha),
							"dd/MM/yyyy")));

			tipohorario = dao.contar(
					"asempleadoexcepciondetalle.obtenertipodia2", filtros);

			if (!UValidador.esNulo(tipohorario)) {
				// buscamos por el tipo horario
				for (int i = 0; i < dw_tipohorario.size(); i++) {
					DtoDwAsProcesoAsistenciaDiariaTipohor obj = dw_tipohorario
							.get(i);
					if (UValidador.esCero(obj.getTipohorario().compareTo(
							BigDecimal.valueOf(tipohorario)))) {
						w_tipohorario_row = i;
						break;
					}
				}

				if (w_tipohorario_row >= 0) {
					List<ParametroPersistenciaGenerico> filtros2 = new ArrayList<>();
					filtros2.add(new ParametroPersistenciaGenerico("p_tipodia",
							Integer.class, tipohorario));
					List data3 = dao.listarPorQuery(
							DtoDwAsProcesoAsistenciaDiariaTipohor.class,
							"astipodiaasistencia.obtenerdescripcion", filtros2);
					if (!UValidador.esListaVacia(data3)) {
						descripcion = ((DtoDwAsProcesoAsistenciaDiariaTipohor) data3
								.get(0)).getDescripcionlocal();
					}
				}
			} else
				descripcion = "Ninguno";
		}

		return descripcion;
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_devuelve_horario_des
	 */
	public void FSqlDevuelveHorarioDes() {
		LOGGER.debug("test de asrepus.f_sql_devuelve_horario_des");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_devuelve_horasalida
	 */
	public void FSqlDevuelveHorasalida() {
		LOGGER.debug("test de asrepus.f_sql_devuelve_horasalida");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_documentofiscal_compania
	 */
	public String FSqlDocumentofiscalCompania(String par_compania) {
		LOGGER.debug("test de asrepus.f_sql_documentofiscal_compania");
		List<ParametroPersistenciaGenerico> parametro = new ArrayList<ParametroPersistenciaGenerico>();
		parametro.add(new ParametroPersistenciaGenerico("par_compania",
				String.class, par_compania));

		List datos = dao.listarPorQuery(DtoCompaniamast.class,
				"asrepus.fsqldocumentofiscalcompania", parametro);

		String w_ruc = "";
		DtoCompaniamast ruc = new DtoCompaniamast();

		if (!UValidador.esListaVacia(datos)) {
			ruc = (DtoCompaniamast) datos.get(0);
			w_ruc = ruc.getDocumentofiscal();
		}

		return w_ruc;

	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_documentofiscal_companyowner
	 */
	public void FSqlDocumentofiscalCompanyowner() {
		LOGGER.debug("test de asrepus.f_sql_documentofiscal_companyowner");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_get_fechaingreso
	 */
	public void FSqlGetFechaingreso() {
		LOGGER.debug("test de asrepus.f_sql_get_fechaingreso");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_get_flaghorasextra
	 */
	public void FSqlGetFlaghorasextra() {
		LOGGER.debug("test de asrepus.f_sql_get_flaghorasextra");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_get_horas_autorizacion
	 */
	public void FSqlGetHorasAutorizacion() {
		LOGGER.debug("test de asrepus.f_sql_get_horas_autorizacion");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_get_max_periodo
	 */
	public void FSqlGetMaxPeriodo() {
		LOGGER.debug("test de asrepus.f_sql_get_max_periodo");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_get_max_secuencia
	 */
	public void FSqlGetMaxSecuencia() {
		LOGGER.debug("test de asrepus.f_sql_get_max_secuencia");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_pr_valorizaciondias
	 */
	public void FSqlPrValorizaciondias() {
		LOGGER.debug("test de asrepus.f_sql_pr_valorizaciondias");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_read_sucursal_name
	 */
	public void FSqlReadSucursalName() {
		LOGGER.debug("test de asrepus.f_sql_read_sucursal_name");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_read_tipoplanilla_name
	 */
	public void FSqlReadTipoplanillaName() {
		LOGGER.debug("test de asrepus.f_sql_read_tipoplanilla_name");
	}

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder asrepus.f_sql_verifica_vacacion
	 */
	public void FSqlVerificaVacacion() {
		LOGGER.debug("test de asrepus.f_sql_verifica_vacacion");
	}

}
