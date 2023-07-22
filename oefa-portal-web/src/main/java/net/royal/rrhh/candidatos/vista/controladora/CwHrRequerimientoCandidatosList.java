package net.royal.rrhh.candidatos.vista.controladora;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CComunSession;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.ParametrosmastPk;
import net.royal.erp.core.dominio.dto.DtoPersonamast;
import net.royal.erp.rrhh.dominio.HrRequerimiento;
import net.royal.erp.rrhh.dominio.dto.DtoTipoPlanilla;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoList;
import net.royal.erp.rrhh.hrproc.dominio.dto.DtoDwHrRequerimientoPosition;
import net.royal.erp.sistema.dominio.dto.DtoDwMaCompanyownerSelect;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.asistencia.vista.conversion.CVTDtoCompania;
import net.royal.rrhh.candidatos.vista.conversion.CVDtoPersonalReclutamiento;
import net.royal.rrhh.candidatos.vista.conversion.CVDtoTipoplanilla;
import net.royal.seguridad.dominio.Seguridadautorizaciones;
import net.royal.seguridad.dominio.Usuario;

/**
 * 
 * @author Jose Torres
 * @codigoapliacion HR
 * @libreria hrproc.pbl
 * @windows w_hr_requerimiento_list
 */
@ManagedBean
@SessionScoped
@SuppressWarnings({ "unused", "unchecked" })
public class CwHrRequerimientoCandidatosList extends CBaseBean implements
		UIMantenimientoController {

	private String eventname;
	private DtoDwHrRequerimientoList registroseleccionado;
	private List<DtoDwHrRequerimientoList> ltsRequerimientosCandidatos;
	private List<DtoTipoPlanilla> lstTipoPlanilla;
	private List<DtoPersonamast> lstPersonaReclutamiento;
	private DtoPersonamast personaReclutamiento;
	private DtoDwHrRequerimientoPosition dw_position;

	private String w_tipoplanilla, p_fechas;
	private DtoTipoPlanilla tipoplanilla;
	private Integer codigo;
	private List<DtoDwMaCompanyownerSelect> lst_entidad;
	Date lv_fechainicial = new Date();
	Date lv_fechafinal = new Date();
	private String ls_validacion1;
	private String ls_validacion2;
	private String ls_validacion3;
	private Boolean cb_publicar;

	private static final long serialVersionUID = 1L;

	@Override
	public String iniciarControladora() throws Exception {
		inicializarFiltrosListado();
		return this.PANTALLA_LISTADO;
	}

	public CwHrRequerimientoCandidatosList() {
		this.PANTALLA_LISTADO = "evaluacion_candidatos_list";
		this.PANTALLA_MANTENIMIENTO = "evaluacion_candidatos_edit";
	}

	public static CwHrRequerimientoCandidatosList getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrRequerimientoCandidatosList}",
				CwHrRequerimientoCandidatosList.class);
	}

	public void prepararTipoPlanilla() {
		String gvDefaTipoplanilla = getFacCore().getParametrosmastServicio()
				.obtenerValorCadena(
						new ParametrosmastPk("PR", "999999", "DFTIPOPLAN"));

		if (lstTipoPlanilla.size() > 0) {
			List<DtoTipoPlanilla> lstPlanilla = getFacRrhh()
					.getHrRequerimientoServicio().listarTipoPlanilla(
							gvDefaTipoplanilla);
			if (lstPlanilla.size() > 0) {
				w_tipoplanilla = lstPlanilla.get(0).getTipoplanilla();
			} else {
				w_tipoplanilla = lstTipoPlanilla.get(0).getTipoplanilla();
			}

		}
	}

	@Override
	public String buscar() throws Exception {
		if (!UValidador.esNulo(dw_position.getFechadesde())
				&& !UValidador.esNulo(dw_position.getFechahasta())) {
			if (dw_position.getFechadesde().after(dw_position.getFechahasta())) {
				setMessageError("La fecha de inicio debe ser menor a la fecha fin.");
			}
		}

		if (UValidador.estaVacio(dw_position.getCompania())) {
			dw_position.setCompania(null);
		}

		if (UValidador.estaVacio(dw_position.getConvocatoria())) {
			dw_position.setConvocatoria(null);
		}

		if (UValidador.estaVacio(dw_position.getConcurso())) {
			dw_position.setConcurso(null);
		}

		if (UValidador.estaVacio(dw_position.getNumero())) {
			dw_position.setNumero(null);
		} else {
			dw_position.setNumero(dw_position.getNumero().toUpperCase());

		}

		if (UValidador.estaVacio(dw_position.getEstado())) {
			dw_position.setEstado(null);
		}

		if (!UValidador.estaVacio(dw_position.getCodigopuesto())) {
			codigo = dw_position.getCodigopuesto().getPk().getCodigopuesto();
		}

		if (UValidador.esNulo(tipoplanilla)) {
			dw_position.setTipoplanilla(null);
		} else {
			dw_position.setTipoplanilla(tipoplanilla.getTipoplanilla());

		}

		if (UValidador.estaVacio(dw_position.getTiporequer())) {
			dw_position.setTiporequer(null);
		}

		if (UValidador.estaVacio(dw_position.getArea())) {
			dw_position.setArea(null);
		}

		if (UValidador.esNulo(personaReclutamiento)) {
			dw_position.setPersona_reclu(null);
		} else {
			dw_position.setPersona_reclu(personaReclutamiento.getPersona());
		}

		if (!UValidador.esNulo(dw_position.getFechadesde())
				&& !UValidador.esNulo(dw_position.getFechahasta())) {
			Date lv_aux1, lv_aux2;
			SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
			String d1 = "00:00:00";
			String d2 = "23:59:59";

			lv_aux1 = format.parse(String.valueOf(d1));
			lv_aux2 = format.parse(String.valueOf(d2));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			lv_fechainicial = UFechaHora.obtenerFechaCompuesta(
					dw_position.getFechadesde(), lv_aux1);
			lv_fechafinal = UFechaHora.obtenerFechaCompuesta(
					dw_position.getFechahasta(), lv_aux2);

			p_fechas = "and  HR_Requerimiento.FechaSolicitud >= :p_fini  and  HR_Requerimiento.FechaSolicitud <= :p_ffin";

		} else {
			p_fechas = null;
		}

		Integer ll_codigopuesto = this
				.getFacCore()
				.getEmpleadomastServicio()
				.obtenerEmpleadoMast(
						CComunSession.syroyal().StrGlobal().getGv_vendor())
				.getCodigocargo();
		if (UValidador.estaVacio(ll_codigopuesto)) {
			ll_codigopuesto = 0;
		}

		Integer lv_usuariosystem;

		/*
		 * if ((!getFacSeguridad() .getSeguridadautorizacionesServicio()
		 * .tieneAccesoSysAdm(getUsuarioActual() .getAplicacionCodigo(),
		 * getUsuarioActual() .getCodigoUsuario()))) {
		 */

		if ((getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(),
						getUsuarioActual().getCodigoUsuario()))) {
			lv_usuariosystem = 1;

		} else {
			lv_usuariosystem = 0;
		}

		StrPass wTemporalPass = new StrPass();
		wTemporalPass = wfValidaPerfil(lv_usuariosystem, getUsuarioActual()
				.getLoginUsuario().toUpperCase());

		if (wTemporalPass.getD()[1] == 0) {
			ls_validacion1 = "S";
		}

		Integer intEmpleado = this
				.getFacCore()
				.getEmpleadomastServicio()
				.obtenerPorCodigoUsuario(
						getUsuarioActual().getLoginUsuario().toUpperCase())
				.getPk().getEmpleado();

		LOGGER.debug(dw_position.getPersona_reclu());
		ltsRequerimientosCandidatos = getFacRrhh().getHrRequerimientoServicio()
				.listarRequerimientos(ll_codigopuesto, codigo,
						dw_position.getConvocatoria(),
						dw_position.getTiporequer(), dw_position.getCompania(),
						dw_position.getConcurso(),
						dw_position.getTipoplanilla(),
						dw_position.getPersona_reclu(), dw_position.getArea(),
						p_fechas, dw_position.getEstado(),
						dw_position.getDesierto(), dw_position.getNumero(),
						lv_fechainicial, lv_fechafinal, intEmpleado,
						ls_validacion1, ls_validacion2);

		return null;
	}

	private StrPass wfValidaPerfil(Integer par_system_user, String usuario) {

		StrPass w_param, wStrPass;

		wStrPass = new StrPass();
		w_param = new StrPass();

		if (par_system_user > 0) {
			w_param.getS()[1] = "S";
			w_param.getS()[2] = "S";
			w_param.getS()[3] = "S";
			w_param.getD()[1] = 100;
		}

		w_param.getD()[1] = 100;

		List<Usuario> perfiles = getFacSeguridad()
				.getSeguridadperfilusuarioServicio().fSqlGetUsuarioxPerfil(
						usuario);

		for (Usuario obj : perfiles) {
			Seguridadautorizaciones auth = getFacSeguridad()
					.getSeguridadautorizacionesServicio()
					.obtenerSeguridadUsuarioporConcepto(
							obj.getPk().getUsuario(), "SYSTEM", "VERREQ", "HR");

			w_param.getS()[1] = UValidador.esNulo(auth) ? "N" : auth
					.getOpcionagregarflag();
			w_param.getS()[2] = UValidador.esNulo(auth) ? "N" : auth
					.getOpcionmodificarflag();
			w_param.getS()[3] = UValidador.esNulo(auth) ? "N" : auth
					.getOpcionborrarflag();

			if (UValidador.esNulo(auth)) {
				w_param.getD()[1] = 0;
				break;
			}
		}

		if (w_param.getD()[1] == 100) {
			Seguridadautorizaciones auth1 = getFacSeguridad()
					.getSeguridadautorizacionesServicio()
					.obtenerSeguridadUsuarioporConcepto(usuario, "SYSTEM",
							"VERREQ", "HR");

			w_param.getS()[1] = UValidador.esNulo(auth1) ? "N" : auth1
					.getOpcionagregarflag();
			w_param.getS()[2] = UValidador.esNulo(auth1) ? "N" : auth1
					.getOpcionmodificarflag();
			w_param.getS()[3] = UValidador.esNulo(auth1) ? "N" : auth1
					.getOpcionborrarflag();
			w_param.getD()[1] = 0;

		}

		return w_param;
	}

	public String evaluar() throws Exception {
		if (UValidador.esNulo(registroseleccionado)) {
			setMessageError("Debe seleccionar un Registro");
			return null;
		}

		HrRequerimiento reque = this
				.getFacRrhh()
				.getHrRequerimientoServicio()
				.obtenerRequerimiento(registroseleccionado.getRequerimiento(),
						registroseleccionado.getCompanyowner());

		if (UValidador.esNulo(reque.getTiporeclutamiento())) {
			reque.setTiporeclutamiento(0);
		}

		Integer existe = this
				.getFacRrhh()
				.getHrPosRequerServicio()
				.obtenerCantidadPostulantes(
						registroseleccionado.getRequerimiento(),
						registroseleccionado.getCompanyowner());
		if (UValidador.esNulo(existe)) {
			existe = 0;
		}

		if (existe == 0) {
			setMessageError("El requerimiento "
					+ registroseleccionado.getRequerimiento()
					+ " no posee ningún postulante agregado, verifique por favor.");
			return null;

		}

		Date fechaServidor = this.getFacRrhh().getHrRequerimientoServicio()
				.obtenerfechahoraServidor();

		if (!UValidador.esNulo(reque.getFechalimite())) {

			if (fechaServidor.before(reque.getFechalimite())) {
				setMessageError("La fecha límite de postulación aún está abierto para el requerimiento.");
				return null;
			}
		}

		if (!UValidador.esNulo(reque.getFlagdesierto())) {
			if (reque.getFlagdesierto().equals("S")) {
				setMessageError("El requerimiento fué declarado como Desierto, verifique el motivo.");
				return null;
			}
		}

		Integer secuencia = this
				.getFacRrhh()
				.getHrPosRequerServicio()
				.obtenerRequerimiento(registroseleccionado.getRequerimiento(),
						registroseleccionado.getCompanyowner());

		String publicado = this
				.getFacRrhh()
				.getHrRequerimientoServicio()
				.obtenerFlgPublicado(registroseleccionado.getRequerimiento(),
						registroseleccionado.getCompanyowner(), secuencia);

		if (UValidador.esNulo(publicado)) {
			publicado = "N";
		}

		if (publicado.equals("N") && secuencia > 1) {
			setMessageError("La etapa aún no fue publicada.");
			return null;
		}

		String fecha = new SimpleDateFormat("yyyymmdd").format(fechaServidor);

		Integer cant = getFacRrhh().getHrRequerimientoServicio()
				.obtenerEvaluacion(registroseleccionado.getRequerimiento(),
						registroseleccionado.getCompanyowner(), secuencia,
						fecha);

		if (UValidador.esNulo(cant)) {
			cant = 0;
		}

		if (cant == 0) {
			setMessageError("La etapa aún no se encuentra en proceso de evaluación.");
			return null;
		}

		Empleadomast empleado = this.getFacCore().getEmpleadomastServicio()
				.obtenerPorCodigoUsuario(getUsuarioActual().getCodigoUsuario());

		Integer evaluador = empleado.getPk().getEmpleado();

		Integer esevaluador = getFacRrhh().getHrRequerimientoServicio()
				.obtenercantidadPost(evaluador,
						registroseleccionado.getRequerimiento(),
						registroseleccionado.getCompanyowner());

		if (UValidador.esNulo(esevaluador)) {
			esevaluador = 0;
		}
		if (esevaluador == 0) {
			setMessageError("No tiene permiso para evaluar.");
			return null;
		}

		CwHrRequerimientoCandidatosEdit.getInstance().setRequerimiento(
				registroseleccionado);
		CwHrRequerimientoCandidatosEdit.getInstance().setAccionLista(
				this.getAccionPantalla());
		this.PANTALLA_MANTENIMIENTO = CwHrRequerimientoCandidatosEdit
				.getInstance().iniciarControladora();

		return this.PANTALLA_MANTENIMIENTO;
	}

	@Override
	public String nuevo() throws Exception {
		return null;
	}

	@Override
	public String editar() throws Exception {
		return null;
	}

	@Override
	public String ver() throws Exception {
		LOGGER.debug("VER");

		if (UValidador.esNulo(registroseleccionado)) {
			setMessageError("Debe seleccionar un Registro");
			return null;
		}

		setAccionPantalla(accion_solicitada.VER);

		CwHrRequerimientoCandidatosEdit.getInstance().setRequerimiento(
				registroseleccionado);
		CwHrRequerimientoCandidatosEdit.getInstance().setAccionLista(
				this.getAccionPantalla());
		this.PANTALLA_MANTENIMIENTO = CwHrRequerimientoCandidatosEdit
				.getInstance().iniciarControladora();

		return this.PANTALLA_MANTENIMIENTO;
	}

	@Override
	public String eliminar() throws Exception {
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		return null;
	}

	@Override
	public String guardar() throws Exception {
		return null;
	}

	@Override
	public String salir() throws Exception {
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosMantenimiento() throws Exception {
		return null;
	}

	@Override
	public String prepararDatosListado() throws Exception {
		return null;
	}

	@Override
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico)
			throws Exception {
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {

		dw_position = new DtoDwHrRequerimientoPosition();
		lstTipoPlanilla = getFacRrhh().getHrRequerimientoServicio()
				.listarTipoPlanilla(null);
		CVDtoTipoplanilla.lista = lstTipoPlanilla;

		lstPersonaReclutamiento = getFacCore().getEmpleadomastServicio()
				.obtenerPersonaReclutamiento();
		CVDtoPersonalReclutamiento.lista = lstPersonaReclutamiento;

		lst_entidad = getFacCore().getCompanyownerServicio()
				.DwMaCompanyownerSelect(
						CComunSession.syroyal().StrGlobal()
								.getGv_companyowner());
		CVTDtoCompania.lista = lst_entidad;
		cb_publicar = true;

		p_fechas = null;

		// condiciones de busqueda iniciales:
		dw_position.setCompania(CComunSession.syroyal().StrGlobal()
				.getGv_companyowner());
		Date fechadesde = UFechaHora.getPrimerDiaDelMes();
		Date fechahasta = UFechaHora.getUltimoDiaDelMes();

		dw_position.setFechadesde(fechadesde);
		dw_position.setFechahasta(fechahasta);
		dw_position.setEstado("EV");

		ls_validacion1 = "N";
		ls_validacion2 = "S";
		ls_validacion3 = "N";

		Integer valor = this
				.getFacSeguridad()
				.getSeguridadautorizacionesServicio()
				.leerAutorizaciones("WH", "GRUP04", "CON003",
						getUsuarioActual().getLoginUsuario().toUpperCase());

		if ((getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAccesoSysAdm(getUsuarioActual().getAplicacionCodigo(),
						getUsuarioActual().getCodigoUsuario()))) {
			cb_publicar = true;

		} else {
			if (valor != 0) {
				cb_publicar = true;
			}
		}

		prepararTipoPlanilla();

		buscar();
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public List<DtoDwHrRequerimientoList> getLtsRequerimientosCandidatos() {
		return ltsRequerimientosCandidatos;
	}

	public void setLtsRequerimientosCandidatos(
			List<DtoDwHrRequerimientoList> ltsRequerimientosCandidatos) {
		this.ltsRequerimientosCandidatos = ltsRequerimientosCandidatos;
	}

	public List<DtoTipoPlanilla> getLstTipoPlanilla() {
		return lstTipoPlanilla;
	}

	public void setLstTipoPlanilla(List<DtoTipoPlanilla> lstTipoPlanilla) {
		this.lstTipoPlanilla = lstTipoPlanilla;
	}

	public List<DtoPersonamast> getLstPersonaReclutamiento() {
		return lstPersonaReclutamiento;
	}

	public void setLstPersonaReclutamiento(
			List<DtoPersonamast> lstPersonaReclutamiento) {
		this.lstPersonaReclutamiento = lstPersonaReclutamiento;
	}

	public DtoDwHrRequerimientoPosition getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwHrRequerimientoPosition dw_position) {
		this.dw_position = dw_position;
	}

	public DtoTipoPlanilla getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(DtoTipoPlanilla tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public DtoPersonamast getPersonaReclutamiento() {
		return personaReclutamiento;
	}

	public void setPersonaReclutamiento(DtoPersonamast personaReclutamiento) {
		this.personaReclutamiento = personaReclutamiento;
	}

	public List<DtoDwMaCompanyownerSelect> getLst_entidad() {
		return lst_entidad;
	}

	public void setLst_entidad(List<DtoDwMaCompanyownerSelect> lst_entidad) {
		this.lst_entidad = lst_entidad;
	}

	public DtoDwHrRequerimientoList getRegistroseleccionado() {
		return registroseleccionado;
	}

	public void setRegistroseleccionado(
			DtoDwHrRequerimientoList registroseleccionado) {
		this.registroseleccionado = registroseleccionado;
	}

	public Boolean getCb_publicar() {
		return cb_publicar;
	}

	public void setCb_publicar(Boolean cb_publicar) {
		this.cb_publicar = cb_publicar;
	}

}
