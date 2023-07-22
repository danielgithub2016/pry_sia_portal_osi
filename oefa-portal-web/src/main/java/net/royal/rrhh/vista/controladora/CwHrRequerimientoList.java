package net.royal.rrhh.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.servlet.ServletContext;

import org.primefaces.event.SelectEvent;

import net.royal.asistencia.vista.conversion.CVTDtoCompania;
import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.HrPuestoempresa;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.HrRequerimientoobservacion;
import net.royal.erp.rrhh.dominio.HrRequerimientoobservacionPk;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDsHrComparaCursoPuestoPostulante;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDsHrComparaExpePuestoPostulante;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDsHrComparaFormacadePuestoPostula;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDsHrComparaIdiomaPuestoPostulante;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDsHrComparaInformaticaPostulante;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoPosition;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.vista.paginacion.PwDwHrRequerimientoList;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrRequerimientoList extends CBaseBean implements UIMantenimientoController {

	private String str_pass;
	private String iv_modo;
	private List<DtoDsHrComparaCursoPuestoPostulante> ids_comparacurso;
	private List<DtoDsHrComparaExpePuestoPostulante> ids_comparaexperiencia;
	private List<DtoDsHrComparaFormacadePuestoPostula> ids_comparaformaacademica;
	private List<DtoDsHrComparaIdiomaPuestoPostulante> ids_comparaformaidiomatica;
	private List<DtoDsHrComparaInformaticaPostulante> ids_comparainformatica;
	private DtoDwHrRequerimientoPosition dw_position;
	private List<HrPuestoempresa> lst_codigopuesto = new ArrayList<HrPuestoempresa>();
	private List<DtoDwMaCompanyownerSelect> lst_entidad;
	private String iv_sql = "";
	private List<DtoDwHrRequerimientoList> dw_list;
	private DtoDwHrRequerimientoList registroseleccionado;
	private ListDataModel<DtoDwHrRequerimientoList> dw_listlist;
	private Integer iv_row;
	private StrPass gstr_pass;
	private String queryJasper = "";
	private Date fecIni, fecFin;
	private Integer codPuesto;
	private String nombreArchivoPDF;
	private boolean boolImprimir;

	private boolean cb_agregar, cb_ver, cb_modificar, cb_aprobaroad, cb_aprobar, cb_carta, cb_convocatoria, cb_revisar,
			cb_contratar, cb_terminar, cb_eliminar, cb_desierto;
	private String title = "";

	private String user = getUsuarioActual().getLoginUsuario().toUpperCase();
	private String app = "HR";
	private Boolean puedeenviar;

	public CwHrRequerimientoList() {
		this.PANTALLA_LISTADO = "whrrequerimientolist";
	}
	

	public static CwHrRequerimientoList getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrRequerimientoList}", CwHrRequerimientoList.class);
	}

	@SuppressWarnings("unchecked")
	public String open() throws Exception {

		lst_entidad = getFacCore().getCompanyownerServicio()
				.DwMaCompanyownerSelect(CComunSession.syroyal().StrGlobal().getGv_companyowner());
		CVTDtoCompania.lista = lst_entidad;

		lst_codigopuesto = this.getFacRrhh().getHrPuestoempresaServicio().listarComboPuestos();

		LOGGER.debug("lst_entidad == " + lst_entidad.size());
		iv_modo = str_pass;
		wf_open();
		return null;
	}

	public String wf_open() throws Exception {
		Date lv_aux1, lv_aux2;
		Date lv_dt1, lv_dt2;
		Date[] result = new Date[2];

		// condiciones de busqueda iniciales:
		dw_position.setAll_companyowner(false); // dw_hr_requerimiento_position
		dw_position.setCompania(lst_entidad.get(0).getCompanyowner());

		dw_position.setAll_numero(true);
		dw_position.setAll_estado(true);
		dw_position.setAll_codigopuesto(true);
		dw_position.setAll_area(true);
		dw_position.setAll_fecha(false);

		iv_sql = this.getFacRrhh().getHr().getHrprocDatawindow().obtenerSentencia();

		result = this.getFacAsistencia().getAS().getSycommFuncion().FObtenerExtremosMes(new Date(), new Date());
		lv_aux1 = result[0];
		lv_aux2 = result[1];

		lv_dt1 = UFechaHora.obtenerFechaHoraInicioDia(lv_aux1);
		lv_dt2 = UFechaHora.obtenerFechaHoraFinDia(lv_aux2);

		LOGGER.debug("lv_dt1 == " + lv_dt1);
		LOGGER.debug("lv_dt2 == " + lv_dt2);

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		String date = DATE_FORMAT.format(lv_dt1);
		String date1 = DATE_FORMAT.format(lv_dt2);
		lv_dt1 = UFechaHora.convertirCadenaFecha(date, "dd-MM-yyyy");
		lv_dt2 = UFechaHora.convertirCadenaFecha(date1, "dd-MM-yyyy");
		dw_position.setFechadesde(lv_dt1);
		dw_position.setFechahasta(lv_dt2);

		if (str_pass.equals(ConstanteRrhh.TIPO_STR_BR)) {
			cb_agregar = true;
			cb_ver = true;
			cb_modificar = true;
			title = "Listar de requerimientos";
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_AP)) {
			cb_ver = true;
			cb_aprobaroad = false;
			cb_aprobar = true;
			cb_aprobar = true;
			title = "Aprobar requerimientos";

			dw_position.setAll_estado(false);
			dw_position.setEstado("RV");

		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_APOAD)) {
			cb_ver = true;
			cb_aprobar = false;
			cb_aprobaroad = true;
			title = "Enviar Convocatoria al Portal";
			dw_position.setAll_estado(false);
			dw_position.setEstado("AP");
			cb_carta = true;

			if (this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(app, user)) {
				cb_convocatoria = true;
			} else {
				if (this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones(app, "GRUP04",
						"CON001", user) != 0) {
					cb_convocatoria = true;
				}
			}
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_RE)) {
			cb_ver = true;
			cb_revisar = true;
			cb_modificar = false;
			title = "Revisar requerimiento";
			dw_position.setAll_estado(false);
			dw_position.setEstado("RP");
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_ING)) {
			title = "Ingreso de candidatos";
			cb_ver = true;
			cb_modificar = true;
			dw_position.setAll_estado(false);
			dw_position.setEstado("OA");
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_SE)) {
			title = "Evaluación de candidatos";
			cb_ver = true;
			cb_modificar = true;
			dw_position.setAll_estado(false);
			dw_position.setEstado("EV");
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_INS)) {
			cb_ver = true;
			cb_modificar = true;
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_TER)) {
			cb_ver = true;
			cb_terminar = true;
			title = "Cerrar requerimiento";
			dw_position.setAll_estado(false);
			dw_position.setEstado("EV");
		} else if (str_pass.equals(ConstanteRrhh.TIPO_STR_CON)) {
			cb_contratar = true;
			cb_ver = true;
			title = "Contratar a candidatos seleccionados";

			dw_position.setAll_estado(false);
			dw_position.setEstado("EV");
		}

		buscar();
		return null;
	}

	public String wf_imprimir() throws Exception {
		Date lv_fechainicial, lv_fechafinal;
		Date lv_fecha1, lv_fecha2;
		Date lv_aux1, lv_aux2;
		String d1 = "00:00:00";
		String d2 = "23:59:59";
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		lv_aux1 = format.parse(String.valueOf(d1));
		lv_aux2 = format.parse(String.valueOf(d2));

		lv_fechainicial = dw_position.getFechadesde();
		lv_fechafinal = dw_position.getFechahasta();
		lv_fecha1 = lv_fechainicial;
		lv_fecha2 = lv_fechafinal;

		lv_fechainicial = UFechaHora.obtenerFechaCompuesta(lv_fechainicial, lv_aux1);
		lv_fechafinal = UFechaHora.obtenerFechaCompuesta(lv_fechafinal, lv_aux2);

		gstr_pass.getDt()[1] = lv_fechainicial;
		gstr_pass.getDt()[2] = lv_fechafinal;
		gstr_pass.getS()[1] = user;

		// Se obtiene el select

		Integer vendor = CComunSession.syroyal().StrGlobal().getGv_vendor();
		Integer ll_codigopuesto;
		ll_codigopuesto = this.getFacCore().getEmpleadomastServicio().obtenerEmpleadoMast(vendor).getCodigocargo();

		String ls_validacion1;
		String ls_validacion2;
		String ls_validacion3;

		ls_validacion1 = ConstanteRrhh.TIPO_NO;
		ls_validacion2 = ConstanteRrhh.TIPO_NO;
		ls_validacion3 = ConstanteRrhh.TIPO_NO;

		if (iv_modo.equals(ConstanteRrhh.TIPO_STR_SE)) {

		} else if (iv_modo.equals("BROWSE")) {
			if (!this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(app, user)) {
				if (this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones(app, "SYSTEM",
						"VERREQ", user) != 0) {
					ls_validacion2 = ConstanteRrhh.TIPO_SI;
					ls_validacion3 = ConstanteRrhh.TIPO_SI;
				}
			}
		}

		gstr_pass.getLo()[1] = ll_codigopuesto;
		gstr_pass.getS()[3] = ls_validacion1;
		gstr_pass.getS()[4] = ls_validacion2;
		gstr_pass.getLo()[2] = vendor;
		gstr_pass.getS()[5] = ls_validacion3;

		String pathPrincipal;
		pathPrincipal = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext())
				.getRealPath("/");

		Map<String, Object> parametrosReport = new HashMap<String, Object>();

		if (dw_position.isAll_fecha()) {
			parametrosReport.put("p_dinamico", queryJasper);
			parametrosReport.put("par_codigopuesto", codPuesto);
			File archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "rrhh" + File.separator
					+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
					+ File.separator + "requerimiento" + File.separator + File.separator
					+ "ListadoRequerimiento.jasper");
			nombreArchivoPDF = getFacRrhh().getHrEmpleadoasistenciasServicio().ejecutarReporteIReport(archivo.getPath(),
					parametrosReport);
		} else {
			parametrosReport.put("p_fini", fecIni);
			parametrosReport.put("p_ffin", fecFin);
			parametrosReport.put("p_dinamico", queryJasper);
			parametrosReport.put("par_codigopuesto", codPuesto);
			File archivo = new File(pathPrincipal + File.separator + "erp" + File.separator + "rrhh" + File.separator
					+ File.separator + "recursos" + File.separator + File.separator + "reportes" + File.separator
					+ File.separator + "requerimiento" + File.separator + File.separator
					+ "ListadoRequerimiento2.jasper");
			nombreArchivoPDF = getFacRrhh().getHrEmpleadoasistenciasServicio().ejecutarReporteIReport(archivo.getPath(),
					parametrosReport);
		}

		CBindingController.getInstance().setNombreArchivoTemporal(nombreArchivoPDF);

		return "pantallaReporteVistaExterna";

	}

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		LOGGER.debug("Entra a Iniciar Controladora");
		dw_position = new DtoDwHrRequerimientoPosition();
		dw_position.setAll_convocatoria(true);
		dw_position.setAll_concurso(true);
		dw_position.setAll_desierto(true);
		dw_position.setDesierto(ConstanteRrhh.TIPO_SI);
		str_pass = ConstanteRrhh.TIPO_STR_BR;
		gstr_pass = new StrPass();
		open();
		LOGGER.debug(PANTALLA_LISTADO);
		return this.PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		Integer ll_codigopuesto;
		String lv_sql, lv_companyowner, lv_numero, lv_estado, lv_convocatoria, w_desierto = null;
		Integer lv_puesto, lv_posicion, lv_concurso;
		BigDecimal lv_evaluacion;
		Date lv_fechainicial = new Date(), lv_fechafinal = new Date();
		Date lv_fecha1, lv_fecha2;
		Date lv_aux1, lv_aux2;
		lv_sql = iv_sql;
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		String d1 = "00:00:00";
		String d2 = "23:59:59";
		lv_aux1 = format.parse(String.valueOf(d1));
		lv_aux2 = format.parse(String.valueOf(d2));
		queryJasper = "";
		Integer sid = 0;

		// generamos los permisos por áreas, responsables de área y jeraquías
		getFacAsistencia().getAS().getAsmainFuncion()
				.FAsGeneraEmpleadosAutorizados(getUsuarioActual().getUniqueIdInteger(),
						getUsuarioActual().getLoginUsuario().toUpperCase(), getUsuarioActual().getIdPersona(),
						getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(
								getUsuarioActual().getAplicacionCodigo(),
								getUsuarioActual().getLoginUsuario().toUpperCase()));

		sid = getUsuarioActual().getUniqueIdInteger();

		if (!dw_position.isAll_fecha()) {
			lv_sql = lv_sql
					+ " and  HR_Requerimiento.FechaSolicitud >= :p_fini  and  HR_Requerimiento.FechaSolicitud <= :p_ffin ";

			if (!UValidador.esNulo(dw_position)) {
				if (!UValidador.esNulo(dw_position.getFechahasta())
						&& !UValidador.esNulo(dw_position.getFechadesde())) {
					if (dw_position.getFechahasta().before(dw_position.getFechadesde())) {
						setMessageError("La fecha de inicio debe ser menor a la fecha fin.");
						return null;
					}
				}
			}

		}

		if (!dw_position.isAll_companyowner()) {
			if (!UValidador.estaVacio(dw_position.getCompania())) {
				lv_companyowner = dw_position.getCompania();
				lv_sql = lv_sql + " and HR_Requerimiento.CompanyOwner like '%" + lv_companyowner + "%' ";
				queryJasper = queryJasper + " and HR_Requerimiento.CompanyOwner like '%" + lv_companyowner + "%' ";

			}
		}
		if (!dw_position.isAll_convocatoria()) {
			if (!UValidador.estaVacio(dw_position.getConvocatoria())) {
				lv_convocatoria = dw_position.getConvocatoria();
				String dato = dw_position.getConvocatoria();
				String[] obj = new String[dato.length()];
				for (int i = 0; i < dato.length(); i++) {
					obj[i] = dato.substring(i, i + 1);
					if (obj[i].equals("'")) {
						LOGGER.debug("Se encontró un apostrofe");
						return null;
					}
				}
				lv_sql = lv_sql + " and  HR_Requerimiento.convocatoria like '" + lv_convocatoria + "' ";
				queryJasper = queryJasper + " and  HR_Requerimiento.convocatoria like '" + lv_convocatoria + "' ";
			}
		}
		if (!dw_position.isAll_concurso()) {
			if (!UValidador.estaVacio(dw_position.getConcurso())) {
				lv_concurso = dw_position.getConcurso().intValue();
				lv_sql = lv_sql + " and  HR_Requerimiento.Concurso = " + lv_concurso + "";
				queryJasper = queryJasper + " and  HR_Requerimiento.Concurso = " + lv_concurso + "";
			}
		}
		if (!dw_position.isAll_numero()) {
			if (!UValidador.estaVacio(dw_position.getNumero())) {
				lv_numero = dw_position.getNumero();
				lv_sql = lv_sql + " and  HR_Requerimiento.Requerimiento like '" + lv_numero + "' ";
				queryJasper = queryJasper + " and  HR_Requerimiento.Requerimiento like '" + lv_numero + "' ";
			}
		}
		if (!dw_position.isAll_estado()) {
			if (!UValidador.estaVacio(dw_position.getEstado())) {
				lv_estado = dw_position.getEstado();
				if (lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_AE)) {
					lv_sql = lv_sql + " and  HR_Requerimiento.Estado in('AP', 'EV') ";
					queryJasper = queryJasper + " and  HR_Requerimiento.Estado in('AP', 'EV') ";
				} else {
					if (lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_RP)) {
						lv_sql = lv_sql + " and  HR_Requerimiento.Estado in('PR', 'RE') ";
						queryJasper = queryJasper + " and  HR_Requerimiento.Estado in('PR', 'RE') ";
					} else if (lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_EN_EVALUACION)) {
						lv_sql = lv_sql + " and  HR_Requerimiento.Estado in('OA', 'EV') ";
						queryJasper = queryJasper + " and  HR_Requerimiento.Estado in('OA', 'EV') ";
					} else if (lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION)) {
						lv_sql = lv_sql + " and  HR_Requerimiento.Estado in('PR', 'SG') ";
						queryJasper = queryJasper + " and  HR_Requerimiento.Estado in('PR', 'SG') ";
					} else {
						lv_sql = lv_sql + " and  HR_Requerimiento.Estado = '" + lv_estado + "' ";
						queryJasper = queryJasper + " and  HR_Requerimiento.Estado = '" + lv_estado + "' ";
					}
				}
			}
		}
		if (!dw_position.isAll_codigopuesto()) {
			if (!UValidador.estaVacio(dw_position.getCodigopuesto())) {
				lv_puesto = dw_position.getCodigopuesto().getPk().getCodigopuesto();
				lv_sql = lv_sql + " and  HR_Requerimiento.CodigoPuesto = " + lv_puesto + " ";
				queryJasper = queryJasper + " and  HR_Requerimiento.CodigoPuesto = " + lv_puesto + " ";
			}
		}
		if (!dw_position.isAll_area()) {
			if (!UValidador.estaVacio(dw_position.getArea())) {
				lv_posicion = dw_position.getArea().intValue();
				lv_sql = lv_sql + " and  HR_Requerimiento.CodigoPosicionSolicitante= " + lv_posicion + " ";
				queryJasper = queryJasper + " and  HR_Requerimiento.CodigoPosicionSolicitante= " + lv_posicion + " ";
			}
		}
		if (!dw_position.isAll_fecha()) {
			if (!UValidador.estaVacio(dw_position.getFechadesde())
					&& !UValidador.estaVacio(dw_position.getFechahasta())) {
				lv_fechainicial = dw_position.getFechadesde();
				lv_fechafinal = dw_position.getFechahasta();
				lv_fecha1 = lv_fechainicial;
				lv_fecha2 = lv_fechafinal;

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				lv_fechainicial = UFechaHora.obtenerFechaCompuesta(lv_fechainicial, lv_aux1);
				lv_fechafinal = UFechaHora.obtenerFechaCompuesta(lv_fechafinal, lv_aux2);
				// Se le mando de parametro
			}
		}
		if (!dw_position.isAll_desierto()) {
			w_desierto = dw_position.getDesierto();
			if (!UValidador.estaVacio(w_desierto)) {
				if (w_desierto.equals(ConstanteRrhh.TIPO_NO)) {
					lv_sql = lv_sql
							+ " and HR_Requerimiento.flagdesierto is null or HR_Requerimiento.flagdesierto = 'N' ";
					queryJasper = queryJasper
							+ " and HR_Requerimiento.flagdesierto is null or HR_Requerimiento.flagdesierto = 'N' ";
				} else {
					lv_sql = lv_sql + " and HR_Requerimiento.flagdesierto = 'S' ";
					queryJasper = queryJasper + " and HR_Requerimiento.flagdesierto = 'S' ";
				}
			}
		}
		if (iv_modo.equals("SELECT")) {
			if (!this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(app, user)) {
				lv_sql = lv_sql + " and "
						+ this.getFacCore().getEmpleadomastServicio().obtenerPorCodigoUsuario(user).getPk()
								.getEmpleado()
						+ " in (select distinct empleadoevaluador from hr_evalrequerimiento_2 where requerimiento = HR_Requerimiento.requerimiento"
						+ " and companyowner = HR_Requerimiento.companyowner)";
				queryJasper = queryJasper + " and "
						+ this.getFacCore().getEmpleadomastServicio().obtenerPorCodigoUsuario(user).getPk()
								.getEmpleado()
						+ " in (select distinct empleadoevaluador from hr_evalrequerimiento_2 where requerimiento = HR_Requerimiento.requerimiento"
						+ " and companyowner = HR_Requerimiento.companyowner)";
			}
		}
		if (str_pass.equals("CONTRACT")) {
		}

		ll_codigopuesto = this.getFacCore().getEmpleadomastServicio()
				.obtenerEmpleadoMast(CComunSession.syroyal().StrGlobal().getGv_vendor()).getCodigocargo();
		if (UValidador.estaVacio(ll_codigopuesto)) {
			ll_codigopuesto = 0;
		}

		if (iv_modo.equals(ConstanteRrhh.TIPO_STR_SE)) {
		} else if (iv_modo.equals(ConstanteRrhh.TIPO_STR_BR)) {
			if (!this.getFacSeguridad().getSeguridadautorizacionesServicio().tieneAccesoSysAdm(app,
					user.toUpperCase())) {
				if (this.getFacSeguridad().getSeguridadautorizacionesServicio().leerAutorizaciones(app, "SYSTEM",
						"VERREQ", user) != 0) {
				}
			}
		}
		Integer x = this.getFacCore().getEmpleadomastServicio().obtenerPorCodigoUsuario(user.toUpperCase()).getPk()
				.getEmpleado();

		lv_sql = lv_sql + " ORDER BY HR_Requerimiento.Requerimiento ASC ";
		queryJasper = queryJasper + " ORDER BY HR_Requerimiento.Requerimiento ASC ";

		dw_list = this.getFacRrhh().getHr().getHrprocDatawindow().listarRequerimientoWhere(lv_sql, ll_codigopuesto,
				lv_fechainicial, lv_fechafinal, sid, dw_position.isAll_fecha(), getUsuarioActual().getCodigoUsuario());

		dw_listlist = new PwDwHrRequerimientoList(dw_list);

		fecIni = lv_fechainicial;
		fecFin = lv_fechafinal;
		codPuesto = ll_codigopuesto;

		if (UValidador.esListaVacia(dw_list)) {
			iv_row = 1;
			boolImprimir = true;
		} else {
			boolImprimir = false;
		}
		this.getWebControlContext().actualizar("whrrequerimientolist:btnImprimir");

		cb_eliminar = false;
		if ("PR".equals(dw_position.getEstado()) && dw_position.isAll_estado() == false) {
			cb_eliminar = true;
		}
		if (iv_modo.equals(ConstanteRrhh.TIPO_STR_ING) || iv_modo.equals(ConstanteRrhh.TIPO_STR_SE)) {
			cb_desierto = true;
			cb_desierto = true;
		}
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		puedeenviar = false;
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("Action", "AGREGAR");
		map.put("Enviar", puedeenviar);

		CWHrRequerimientoEdit.getInstance().setIvKeyRequerimiento(map);
		return CWHrRequerimientoEdit.getInstance().iniciarControladora();
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		if (UValidador.esNulo(registroseleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}
		String lv_estado = registroseleccionado.getEstado();
		HashMap<String, Object> map = new HashMap<String, Object>();
		String flgEnviado = registroseleccionado.getFlagEnviado();

		if ("S".equals(flgEnviado)) {
			setMessageError("El requerimiento no puede ser modificado por que ya fué enviado.");
			return null;
		}

		/*
		 * CAMBIO SOLICITADO POR SUSANA, el requerimiento se puede agregar
		 * documentos en todos los estados del proceso 28/09/2016
		 */
		if (iv_modo.equals(ConstanteRrhh.TIPO_STR_BR)) {
			if (!lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION)
					&& !lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_REVISADO)
					&& !lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_RE)
					&& !lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION_CAS)) {
				/*
				 * setMessageError(
				 * "No se permiten modificaciones en este estado"); return null;
				 */
				map.put("requerimiento", registroseleccionado.getRequerimiento());
				map.put("companyowner", registroseleccionado.getCompanyowner());
				map.put("Action", "VER");
				map.put("Enviar", false);

				CWHrRequerimientoEdit.getInstance().setIvKeyRequerimiento(map);
				return CWHrRequerimientoEdit.getInstance().iniciarControladora();
			}
		}

		map.put("requerimiento", registroseleccionado.getRequerimiento());
		map.put("companyowner", registroseleccionado.getCompanyowner());
		map.put("Action", ConstanteRrhh.ACCION_MODIFICAR);
		map.put("Enviar", false);

		CWHrRequerimientoEdit.getInstance().setIvKeyRequerimiento(map);
		return CWHrRequerimientoEdit.getInstance().iniciarControladora();

	}

	public String enviar() throws Exception {
		// TODO Auto-generated method stub
		if (UValidador.esNulo(registroseleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}
		String lv_estado = registroseleccionado.getEstado();
		String flgEnviado = registroseleccionado.getFlagEnviado();

		HashMap<String, Object> map = new HashMap<String, Object>();

		/*
		 * CAMBIO SOLICITADO POR SUSANA, el requerimiento se puede agregar
		 * documentos en todos los estados del proceso 28/09/2016
		 */

		if ("S".equals(flgEnviado)) {
			setMessageError("El requerimiento ya fué enviado anteriormente.");
			return null;
		}

		if (iv_modo.equals(ConstanteRrhh.TIPO_STR_BR)) {
			if (!lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION)
					&& !lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_REVISADO)
					&& !lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_RE)
					&& !lv_estado.equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION_CAS)) {
				/*
				 * setMessageError(
				 * "No se permiten modificaciones en este estado"); return null;
				 */
				map.put("requerimiento", registroseleccionado.getRequerimiento());
				map.put("companyowner", registroseleccionado.getCompanyowner());
				map.put("Action", "VER");
				map.put("Enviar", true);

				CWHrRequerimientoEdit.getInstance().setIvKeyRequerimiento(map);
				return CWHrRequerimientoEdit.getInstance().iniciarControladora();
			}
		}

		map.put("requerimiento", registroseleccionado.getRequerimiento());
		map.put("companyowner", registroseleccionado.getCompanyowner());
		map.put("Action", ConstanteRrhh.ACCION_MODIFICAR);
		map.put("Enviar", true);

		CWHrRequerimientoEdit.getInstance().setIvKeyRequerimiento(map);
		return CWHrRequerimientoEdit.getInstance().iniciarControladora();

	}

	@Override
	public String ver() throws Exception {
		puedeenviar = false;

		if (UValidador.esNulo(registroseleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("requerimiento", registroseleccionado.getRequerimiento());
		map.put("companyowner", registroseleccionado.getCompanyowner());
		map.put("Action", "VER");
		map.put("Enviar", puedeenviar);

		CWHrRequerimientoEdit.getInstance().setIvKeyRequerimiento(map);
		return CWHrRequerimientoEdit.getInstance().iniciarControladora();

	}

	@Override
	public String eliminar() throws Exception {

		// TODO Auto-generated method stub
		if (UValidador.esNulo(registroseleccionado)) {
			setMessageError("Debe seleccionar un registro");
			return null;
		}
		if (!registroseleccionado.getEstado().equals(ConstanteRrhh.TIPO_ESTADO_PREPARACION_CAS)) {
			setMessageError("No se puede eliminar el requerimiento en este estado");
			return null;
		}

		// REQUERIMIENTO OBSERVACION
		HrRequerimientoobservacionPk pkdel = new HrRequerimientoobservacionPk();
		pkdel.setCompanyowner(registroseleccionado.getCompanyowner());
		pkdel.setRequerimiento(registroseleccionado.getRequerimiento());

		HrRequerimientoobservacion objdel = (HrRequerimientoobservacion) getFacRrhh()
				.getHrRequerimientoobservacionServicio().obtenerPorId(pkdel);

		if (!UValidador.esNulo(objdel)) {
			getFacRrhh().getHrRequerimientoobservacionServicio().eliminar(objdel);
		}
		//

		// REQUERIMIENTO REEMPLAZO
		getFacRrhh().getHrRequerimientoreemplazoServicio().eliminarRequerimientoReemplazo(
				registroseleccionado.getCompanyowner(), registroseleccionado.getRequerimiento());
		//

		// Eliminar requerimiento FUNCAS
		getFacRrhh().getHrRequerimientofuncasdetServicio().eliminarporCampos(registroseleccionado.getCompanyowner(),
				registroseleccionado.getRequerimiento());

		getFacRrhh().getHrRequerimientofuncasServicio().eliminarporCampos(registroseleccionado.getCompanyowner(),
				registroseleccionado.getRequerimiento());

		// REQUERIMIENTO
		HrRequerimiento reque = new HrRequerimiento();
		reque.getPk().setCompanyowner(registroseleccionado.getCompanyowner());
		reque.getPk().setRequerimiento(registroseleccionado.getRequerimiento());

		reque = (HrRequerimiento) getFacRrhh().getHrRequerimientoServicio().obtenerPorId(reque.getPk());

		if (!UValidador.esNulo(reque)) {
			getFacRrhh().getHrRequerimientoServicio().eliminar(reque);
		}
		//

		setMessageSuccess("Se eliminó el Requerimiento " + registroseleccionado.getRequerimiento() + " correctamente.",
				true);

		buscar();

		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void onRowSelect(SelectEvent event) {
		registroseleccionado = (DtoDwHrRequerimientoList) event.getObject();
		LOGGER.debug("registroseleccionado " + registroseleccionado);
	}

	public String getIv_modo() {
		return iv_modo;
	}

	public void setIv_modo(String iv_modo) {
		this.iv_modo = iv_modo;
	}

	public List<DtoDsHrComparaCursoPuestoPostulante> getIds_comparacurso() {
		return ids_comparacurso;
	}

	public void setIds_comparacurso(List<DtoDsHrComparaCursoPuestoPostulante> ids_comparacurso) {
		this.ids_comparacurso = ids_comparacurso;
	}

	public List<DtoDsHrComparaExpePuestoPostulante> getIds_comparaexperiencia() {
		return ids_comparaexperiencia;
	}

	public void setIds_comparaexperiencia(List<DtoDsHrComparaExpePuestoPostulante> ids_comparaexperiencia) {
		this.ids_comparaexperiencia = ids_comparaexperiencia;
	}

	public List<DtoDsHrComparaFormacadePuestoPostula> getIds_comparaformaacademica() {
		return ids_comparaformaacademica;
	}

	public void setIds_comparaformaacademica(List<DtoDsHrComparaFormacadePuestoPostula> ids_comparaformaacademica) {
		this.ids_comparaformaacademica = ids_comparaformaacademica;
	}

	public List<DtoDsHrComparaIdiomaPuestoPostulante> getIds_comparaformaidiomatica() {
		return ids_comparaformaidiomatica;
	}

	public void setIds_comparaformaidiomatica(List<DtoDsHrComparaIdiomaPuestoPostulante> ids_comparaformaidiomatica) {
		this.ids_comparaformaidiomatica = ids_comparaformaidiomatica;
	}

	public List<DtoDsHrComparaInformaticaPostulante> getIds_comparainformatica() {
		return ids_comparainformatica;
	}

	public void setIds_comparainformatica(List<DtoDsHrComparaInformaticaPostulante> ids_comparainformatica) {
		this.ids_comparainformatica = ids_comparainformatica;
	}

	public DtoDwHrRequerimientoPosition getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwHrRequerimientoPosition dw_position) {
		this.dw_position = dw_position;
	}

	public String getIv_sql() {
		return iv_sql;
	}

	public void setIv_sql(String iv_sql) {
		this.iv_sql = iv_sql;
	}

	public List<DtoDwHrRequerimientoList> getDw_list() {
		return dw_list;
	}

	public void setDw_list(List<DtoDwHrRequerimientoList> dw_list) {
		this.dw_list = dw_list;
	}

	public Integer getIv_row() {
		return iv_row;
	}

	public void setIv_row(Integer iv_row) {
		this.iv_row = iv_row;
	}

	public boolean isCb_agregar() {
		return cb_agregar;
	}

	public void setCb_agregar(boolean cb_agregar) {
		this.cb_agregar = cb_agregar;
	}

	public boolean isCb_ver() {
		return cb_ver;
	}

	public void setCb_ver(boolean cb_ver) {
		this.cb_ver = cb_ver;
	}

	public boolean isCb_modificar() {
		return cb_modificar;
	}

	public void setCb_modificar(boolean cb_modificar) {
		this.cb_modificar = cb_modificar;
	}

	public boolean isCb_aprobaroad() {
		return cb_aprobaroad;
	}

	public void setCb_aprobaroad(boolean cb_aprobaroad) {
		this.cb_aprobaroad = cb_aprobaroad;
	}

	public boolean isCb_aprobar() {
		return cb_aprobar;
	}

	public void setCb_aprobar(boolean cb_aprobar) {
		this.cb_aprobar = cb_aprobar;
	}

	public boolean isCb_carta() {
		return cb_carta;
	}

	public void setCb_carta(boolean cb_carta) {
		this.cb_carta = cb_carta;
	}

	public boolean isCb_convocatoria() {
		return cb_convocatoria;
	}

	public void setCb_convocatoria(boolean cb_convocatoria) {
		this.cb_convocatoria = cb_convocatoria;
	}

	public boolean isCb_revisar() {
		return cb_revisar;
	}

	public void setCb_revisar(boolean cb_revisar) {
		this.cb_revisar = cb_revisar;
	}

	public boolean isCb_contratar() {
		return cb_contratar;
	}

	public void setCb_contratar(boolean cb_contratar) {
		this.cb_contratar = cb_contratar;
	}

	public boolean isCb_terminar() {
		return cb_terminar;
	}

	public void setCb_terminar(boolean cb_terminar) {
		this.cb_terminar = cb_terminar;
	}

	public boolean isCb_eliminar() {
		return cb_eliminar;
	}

	public void setCb_eliminar(boolean cb_eliminar) {
		this.cb_eliminar = cb_eliminar;
	}

	public boolean isCb_desierto() {
		return cb_desierto;
	}

	public void setCb_desierto(boolean cb_desierto) {
		this.cb_desierto = cb_desierto;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public List<HrPuestoempresa> getLst_codigopuesto() {
		return lst_codigopuesto;
	}

	public void setLst_codigopuesto(List<HrPuestoempresa> lst_codigopuesto) {
		this.lst_codigopuesto = lst_codigopuesto;
	}

	public List<DtoDwMaCompanyownerSelect> getLst_entidad() {
		return lst_entidad;
	}

	public void setLst_entidad(List<DtoDwMaCompanyownerSelect> lst_entidad) {
		this.lst_entidad = lst_entidad;
	}

	public String getStr_pass() {
		return str_pass;
	}

	public void setStr_pass(String str_pass) {
		this.str_pass = str_pass;
	}

	public StrPass getGstr_pass() {
		return gstr_pass;
	}

	public void setGstr_pass(StrPass gstr_pass) {
		this.gstr_pass = gstr_pass;
	}

	public String getQueryJasper() {
		return queryJasper;
	}

	public void setQueryJasper(String queryJasper) {
		this.queryJasper = queryJasper;
	}

	public Date getFecIni() {
		return fecIni;
	}

	public void setFecIni(Date fecIni) {
		this.fecIni = fecIni;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

	public Integer getCodPuesto() {
		return codPuesto;
	}

	public void setCodPuesto(Integer codPuesto) {
		this.codPuesto = codPuesto;
	}

	public String getNombreArchivoPDF() {
		return nombreArchivoPDF;
	}

	public void setNombreArchivoPDF(String nombreArchivoPDF) {
		this.nombreArchivoPDF = nombreArchivoPDF;
	}

	/**
	 * @return the dw_listlist
	 */
	public ListDataModel<DtoDwHrRequerimientoList> getDw_listlist() {
		return dw_listlist;
	}

	/**
	 * @param dw_listlist
	 *            the dw_listlist to set
	 */
	public void setDw_listlist(ListDataModel<DtoDwHrRequerimientoList> dw_listlist) {
		this.dw_listlist = dw_listlist;
	}

	public boolean isBoolImprimir() {
		return boolImprimir;
	}

	public void setBoolImprimir(boolean boolImprimir) {
		this.boolImprimir = boolImprimir;
	}

	/**
	 * @return the registroseleccionado
	 */
	public DtoDwHrRequerimientoList getRegistroseleccionado() {
		return registroseleccionado;
	}

	/**
	 * @param registroseleccionado
	 *            the registroseleccionado to set
	 */
	public void setRegistroseleccionado(DtoDwHrRequerimientoList registroseleccionado) {
		this.registroseleccionado = registroseleccionado;
	}

	public Boolean getPuedeenviar() {
		return puedeenviar;
	}

	public void setPuedeenviar(Boolean puedeenviar) {
		this.puedeenviar = puedeenviar;
	}

}
