package net.royal.rrhh.desempenio.vista.controladora;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.comun.vista.controladora.CBindingController;
import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.dominio.CompanyownerPk;
import net.royal.erp.core.dominio.Empleadomast;
import net.royal.erp.core.dominio.Personamast;
import net.royal.erp.core.dominio.PersonamastPk;
import net.royal.erp.rrhh.constante.ConstanteRrhh;
import net.royal.erp.rrhh.dominio.dto.DtoDwHrEvaluacionperiodoCabecera;
import net.royal.erp.rrhh.dominio.dto.DtoDwHrEvaluacionperiodoListEvaluar;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UAplicacion;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;
import net.royal.rrhh.desempenio.vista.opciones.OwHrEvaluacionperiodoListEvaluar;
import net.royal.seguridad.dominio.Seguridadautorizaciones;
import net.sf.jasperreports.engine.JRException;

/**
 * Controller CWHrEvaluacionperiodoListEvaluar.
 * 
 * @author nunezh
 * @powerbuilder w_hr_evaluacionperiodo_list_evaluar
 */
@SuppressWarnings("serial")
@SessionScoped
@ManagedBean
public class CWHrEvaluacionperiodoListEvaluar extends CBaseBean implements
		UIMantenimientoController {

	private String eventname;
	private StrPass strpass;
	private DtoDwHrEvaluacionperiodoCabecera dw_position;
	private Personamast dw_evaluador;
	private List<DtoDwHrEvaluacionperiodoListEvaluar> dw_list;
	private DtoDwHrEvaluacionperiodoListEvaluar registroSeleccionado;
	private OwHrEvaluacionperiodoListEvaluar opciones;

	private String is_TipoCodigo;
	private boolean ib_begin;
	private Date fechacierrereal;
	private Date fechaevalfin; 
	

	public CWHrEvaluacionperiodoListEvaluar() {
		this.PANTALLA_LISTADO = "whrevaluacionperiodolistevaluar";
		this.PANTALLA_MANTENIMIENTO = "whrevaluacionempleadoedit";
	}

	public static CWHrEvaluacionperiodoListEvaluar getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cWHrEvaluacionperiodoListEvaluar}",
				CWHrEvaluacionperiodoListEvaluar.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		opciones = new OwHrEvaluacionperiodoListEvaluar();
		this.inicializarFiltrosListado();
		return inicializarAcciones();
	}

	/**
	 * @powerbuilder ObjectStartEvent.
	 *
	 * @return navigation case
	 * @throws Exception
	 */
	public String inicializarAcciones() throws Exception {
		LOGGER.debug("INICIAR EVENTO " + eventname);

		switch (eventname) {
		case "opened":
			wfOpen();
			return this.PANTALLA_LISTADO;
		case "cb_nuevo_clicked":
			wfNextScreen("AGREGAR");
			break;
		case "cb_eliminar_clicked":
			wfNextScreen("ELIMINAR");
			break;
		case "cb_modificar_clicked":
			wfNextScreen("MODIFICAR");
			break;
		case "cb_ver_clicked":
			wfNextScreen("VER");
			break;
		case "cb_buscar_clicked":
			wfRetrieve();
			break;
		case "cb_desaprobar_clicked":

			if (!UValidador.esNulo(registroSeleccionado)) {
				if (registroSeleccionado.getEstado().equals(
						ConstanteRrhh.TIPO_ESTADO_APROBADA)) {
					this.getWebControlContext().ejecutar(
							"PF('dgConfirmaDesaprobar').show();");
				} else {
					this.setMessageError("Sólo puede desprobar evaluaciones aprobadas");
				}
			}
			break;

		case "cb_empleado_clicked":
			// Abrir w_pr_empleado_select
			break;

		case "cb_responsable_clicked":
			// Abrir w_pr_empleado_select
			break;
		}
		return null;
	}

	public String desaprobar() {
		this.getFacRrhh()
				.getHrEvaluacionempleadoServicio()
				.actualizaEvaluacionEmpleado(
						registroSeleccionado.getEmpleado().intValue(),
						registroSeleccionado.getSecuenciaeval().intValue());
		return null;
	}

	private void wfRetrieve() {
		String lvCompania;
		Integer ivSecuenciaeval;
		// Disenio

		opciones.setCbempleado_visible(false);
		opciones.setCbresponsable_visible(false);

		// iv_mode = '1' // Para no seleccionar evaluado
		lvCompania = strpass.getS()[1];
		ivSecuenciaeval = strpass.getD()[1];

		dw_list = this
				.getFacRrhh()
				.getHr()
				.getHrmastDatawindow()
				.dwHrEvaluacionperiodoListEvaluar(lvCompania,
						new BigDecimal(ivSecuenciaeval),
						new BigDecimal(getUsuarioActual().getIdPersona()));

	}

	public String preMostrarReporte() {
		if (!UValidador.esNulo(registroSeleccionado)) {
			this.getWebControlContext()
					.ejecutar(
							"document.getElementById('frmEvaluacionDesempeno:lnkVerCedula').click()");
		}

		return null;
	}

	public String verificarReporte() throws Exception {
		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe Seleccionar un Registro");
			return null;
		}

		Integer cant = this
				.getFacRrhh()
				.getHr()
				.getHrOracleDatawindows()
				.obtenerCantReporteCedula(
						registroSeleccionado.getCompanyowner(),
						registroSeleccionado.getSecuenciaeval(),
						registroSeleccionado.getEmpleado(),
						registroSeleccionado.getEmpleadoevaluador());

		if (cant > 0) {
			this.getWebControlContext()
					.ejecutar(
							"document.getElementById('frmEvaluacionDesempeno:lnkVerCedula').click();");
		} else {
			setMessageError("No existen datos para este Reporte");
		}

		return null;
	}

	public String mostrarReporte() throws Exception {
		Map<String, Object> mapaReporte = new HashMap<String, Object>();

		String pathPrincipal = UAplicacion.getRealPath();
		try {

			mapaReporte.put("PAR_COMPANIA",
					registroSeleccionado.getCompanyowner());
			mapaReporte.put("PAR_SECUENCIA", registroSeleccionado
					.getSecuenciaeval().intValue());
			mapaReporte.put("PAR_EVALUADO", registroSeleccionado.getEmpleado()
					.intValue());
			mapaReporte.put("PAR_EVALUADOR", registroSeleccionado
					.getEmpleadoevaluador().intValue());
			mapaReporte.put("CABECERA", pathPrincipal + File.separator
					+ "comun" + File.separator + "recursos" + File.separator
					+ "imagenes" + File.separator + "sistema" + File.separator
					+ "oefa-logo-header.png");
			mapaReporte.put(
					"par_nombreEvaluado",
					getFacCore().getPersonamastServicio().obtenerNombrePersona(
							registroSeleccionado.getEmpleado()));
			mapaReporte.put(
					"par_nombreEvaluador",
					getFacCore().getPersonamastServicio().obtenerNombrePersona(
							registroSeleccionado.getEmpleadoevaluador()));

			File archivo = new File(pathPrincipal + File.separator + "erp"
					+ File.separator + "rrhh" + File.separator + File.separator
					+ "recursos" + File.separator + "reportes" + File.separator
					+ "desempenio" + File.separator + "cedula_evaluacion"
					+ File.separator + "dw_hr_rep_desempeno_cedula.jasper");
			
			System.gc();

			String reporteArchivoPDF = getFacAsistencia()
					.getAsAutorizacionServicio().ejecutarReporteIReport(
							archivo.getPath(), mapaReporte);

			CBindingController.getInstance().setNombreArchivoTemporal(
					reporteArchivoPDF);
			
			System.gc();
		} catch (JRException ex) {
			ex.printStackTrace();
		}

		return "pantallaReporteVistaExterna";

	}

	private void wfOpen() throws Exception {

		strpass = this.getFacRrhh().getHrEvaluacionperiodoServicio()
				.FEvaluacionPeriodoCabecera(strpass);
		dw_position.setCompanyowner(strpass.getS()[1]);

		CompanyownerPk pk = new CompanyownerPk();
		pk.setCompanyowner(strpass.getS()[1]);
		dw_position.setCompanyownerdesc(((Companyowner) this.getFacCore()
				.getCompanyownerServicio().obtenerPorId(pk)).getDescription());
		dw_position.setPeriodo(strpass.getS()[2]);
		dw_position.setDescripcion(strpass.getS()[3]);
		dw_position.setEstadoproceso(strpass.getS()[4]);
		dw_position.setFechainicio(strpass.getDt()[1]);
		dw_position.setFechafin(strpass.getDt()[2]);
		dw_position.setFechaplaninicio(strpass.getDt()[3]);
		dw_position.setFechaplanfin(strpass.getDt()[4]);
		dw_position.setFecharealinicio(strpass.getDt()[5]);
		dw_position.setFecharealfin(strpass.getDt()[6]);

		if (!"EV".equals(strpass.getS()[4])) {
			this.setMessageError("El proceso no esta en estado de Evaluación");
			return;
		}

		is_TipoCodigo = strpass.getS()[5];
		ib_begin = true;

		wfRetrieveEvaluador();

		eventname = "cb_buscar_clicked";
		inicializarAcciones();
	}

	public void doubleclicked(SelectEvent e) throws Exception {
		LOGGER.debug("CWHrEvaluacionperiodoListEvaluar.doubleclicked()");
		registroSeleccionado = (DtoDwHrEvaluacionperiodoListEvaluar) e
				.getObject();
		eventname = "cb_ver_clicked";
		inicializarAcciones();
	}

	public void selectRow(SelectEvent e) {
		LOGGER.debug("CWHrEvaluacionperiodoListEvaluar.selectRow()");
		registroSeleccionado = (DtoDwHrEvaluacionperiodoListEvaluar) e
				.getObject();
	}

	private void wfRetrieveEvaluador() {
		PersonamastPk pk = new PersonamastPk();
		pk.setPersona(getUsuarioActual().getIdPersona());
		dw_evaluador = (Personamast) this.getFacCore().getPersonamastServicio()
				.obtenerPorId(pk);
	}

	private String wfNextScreen(String par_action) throws Exception {
		StrPass lvPass = new StrPass(), wTemporalPass = new StrPass();
		Integer lvEvaluador, lvSecuenciaEval;
		String lvEstado;

		lvPass.getS()[1] = par_action;
		lvPass.getPo()[1] = dw_list;
		lvPass.getS()[2] = dw_position.getCompanyowner();
		lvPass.getS()[3] = "1";// iv_mode
		lvPass.getS()[4] = is_TipoCodigo;

		if (!UValidador.esNulo(registroSeleccionado))
			lvPass.getD()[1] = registroSeleccionado.getEmpleado().intValue();

		switch (par_action) {
		case "MODIFICAR":
			if (UValidador.esNulo(registroSeleccionado))
				return null;

			lvEvaluador = registroSeleccionado.getEmpleadoevaluador()
					.intValue();
			lvEstado = registroSeleccionado.getEstado();
			
			if(new Date().after(fechacierrereal)){
				setMessageError("El Registro no se encuentra en el periodo de Evaluación");
				return null;
			}
			

			if (lvEstado.equals(ConstanteRrhh.TIPO_ESTADO_TERMINADO)) {
				this.setMessageError("El empleado ya fue evaluado.");
				return null;
			}

			wTemporalPass = wfValidaPerfil(getUsuarioActual().getLoginUsuario().toUpperCase());
			
			if (wTemporalPass.getD()[1] == 0) {
				if (wTemporalPass.getS()[2].equals("N")) {
					Empleadomast emp = getFacCore().getEmpleadomastServicio()
							.obtenerPorCodigoUsuario(
									this.getUsuarioActual().getCodigoUsuario());
					LOGGER.debug(lvEvaluador);
					LOGGER.debug(emp);
					if (!lvEvaluador.equals(emp.getPk().getEmpleado())) {
						this.setMessageError("Evaluador no autorizado a Modificar");
						return null;
					}
				}
			}

			lvSecuenciaEval = registroSeleccionado.getSecuenciaeval()
					.intValue();

			lvPass.getD()[3] = lvSecuenciaEval;
			lvPass.getD()[4] = lvEvaluador;
			lvPass.getS()[5] = registroSeleccionado.getEstado();
			lvPass.getS()[6] = registroSeleccionado.getTipoevaluador();

			CwHrEvaluacionempleadoEdit.getInstance().setStrpass(lvPass);
			CwHrEvaluacionempleadoEdit.getInstance().setEventname("opened");
			CwHrEvaluacionempleadoEdit.getInstance().setFormOrigen(
					this.PANTALLA_LISTADO);
			CwHrEvaluacionempleadoEdit.getInstance()
					.setRegistroSeleccionadoExterno(
							new DtoDwHrEvaluacionperiodoListEvaluar());
			CwHrEvaluacionempleadoEdit.getInstance() 
					.setRegistroSeleccionadoExterno(registroSeleccionado);
			CwHrEvaluacionempleadoEdit.getInstance().setFechaevalfin(fechaevalfin);
			CwHrEvaluacionempleadoEdit.getInstance().iniciarControladora();

			// para enviar el nombre de la evaluacion y el centro costo y
			// despues usarla en el reporte
			CwHrDetalleEvaluacion.getInstance().setDescripcionEvaluacion(
					dw_position.getDescripcion());
			CwHrDetalleEvaluacion.getInstance().setIvCentroCosto(
					registroSeleccionado.getCentrocostos());

			// Forzando navegacion
			this.getWebControlContext()
					.ejecutar(
							"document.getElementById('frmEvaluacionDesempeno:lnkEdicion').click();");
			break;

		case "VER":
			lvEvaluador = registroSeleccionado.getEmpleadoevaluador()
					.intValue();
			lvSecuenciaEval = registroSeleccionado.getSecuenciaeval()
					.intValue();
			lvPass.getD()[3] = lvSecuenciaEval;
			lvPass.getD()[4] = lvEvaluador;
			lvPass.getS()[5] = registroSeleccionado.getEstado();
			lvPass.getS()[6] = registroSeleccionado.getTipoevaluador();

			// Abrir w_hr_evaluacionempleado_edit con params
			CwHrEvaluacionempleadoEdit.getInstance().setStrpass(lvPass);
			CwHrEvaluacionempleadoEdit.getInstance().setEventname("opened");
			CwHrEvaluacionempleadoEdit.getInstance()
					.setRegistroSeleccionadoExterno(registroSeleccionado);
			CwHrEvaluacionempleadoEdit.getInstance().iniciarControladora();

			// para enviar el nombre de la evaluacion y el centro costo y
			// despues usarla en el reporte
			CwHrDetalleEvaluacion.getInstance().setDescripcionEvaluacion(
					dw_position.getDescripcion());
			CwHrDetalleEvaluacion.getInstance().setIvCentroCosto(
					registroSeleccionado.getCentrocostos());

			// Forzando navegacion
			this.getWebControlContext()
					.ejecutar(
							"document.getElementById('frmEvaluacionDesempeno:lnkEdicion').click();");
		}
		return null;

	}

	private StrPass wfValidaPerfil(String usuario) {
		StrPass wRetorno, wPass;

		wPass = new StrPass();
		wRetorno = new StrPass();
		wRetorno.getS()[1] = "N";
		wRetorno.getS()[2] = "N";
		wRetorno.getS()[3] = "N";
		wRetorno.getD()[1] = 100;

		wPass.getS()[1] = getFacSeguridad().getSeguridadperfilusuarioServicio()
				.obtenerUsuarioPorPerfil(usuario).getPk().getUsuario();

		Seguridadautorizaciones auth = getFacSeguridad()
				.getSeguridadautorizacionesServicio()
				.obtenerSeguridadUsuarioporConcepto(wPass.getS()[1], "GRUP06",
						"CON021", "HR");

		wRetorno.getS()[1] = UValidador.esNulo(auth) ? "N" : auth
				.getOpcionagregarflag();
		wRetorno.getS()[2] = UValidador.esNulo(auth) ? "N" : auth
				.getOpcionmodificarflag();
		wRetorno.getS()[3] = UValidador.esNulo(auth) ? "N" : auth
				.getOpcionborrarflag();
		wRetorno.getD()[1] = 0;

		return wRetorno;
	}

	@Override
	public String buscar() throws Exception {
		return null;
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

		return null;
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

		return "whrevaluacionperiodolist";
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
		dw_position = new DtoDwHrEvaluacionperiodoCabecera();
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

	public StrPass getStrpass() {
		return strpass;
	}

	public void setStrpass(StrPass strpass) {
		this.strpass = strpass;
	}

	public DtoDwHrEvaluacionperiodoCabecera getDw_position() {
		return dw_position;
	}

	public void setDw_position(DtoDwHrEvaluacionperiodoCabecera dw_position) {
		this.dw_position = dw_position;
	}

	public Personamast getDw_evaluador() {
		return dw_evaluador;
	}

	public void setDw_evaluador(Personamast dw_evaluador) {
		this.dw_evaluador = dw_evaluador;
	}

	public List<DtoDwHrEvaluacionperiodoListEvaluar> getDw_list() {
		return dw_list;
	}

	public void setDw_list(List<DtoDwHrEvaluacionperiodoListEvaluar> dw_list) {
		this.dw_list = dw_list;
	}

	public DtoDwHrEvaluacionperiodoListEvaluar getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoDwHrEvaluacionperiodoListEvaluar registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public OwHrEvaluacionperiodoListEvaluar getOpciones() {
		return opciones;
	}

	public void setOpciones(OwHrEvaluacionperiodoListEvaluar opciones) {
		this.opciones = opciones;
	}

	public Date getFechacierrereal() {
		return fechacierrereal;
	}

	public void setFechacierrereal(Date fechacierrereal) {
		this.fechacierrereal = fechacierrereal;
	}

	public Date getFechaevalfin() {
		return fechaevalfin;
	}

	public void setFechaevalfin(Date fechaevalfin) {
		this.fechaevalfin = fechaevalfin;
	}

}
