package net.royal.rrhh.desempenio.vista.controladora;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionperiodo;
import net.royal.seguridad.dominio.Seguridadconcepto;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

/**
 * 
 * @author Jose Torres
 * @codigoapliacion HR
 * @libreria hrmast.pbl
 * @windows w_hr_evaluacionperiodo_list
 */
@ManagedBean
@SessionScoped
public class CwHrEvaluacionPeriodoList extends CBaseBean implements
		UIMantenimientoController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String eventname, textoBusqueda;
	private Boolean mostrarBoton;
	private List<Seguridadconcepto> lstdw_opciones;
	private Seguridadconcepto dw_opciones;
	private List<DtoHrEvaluacionperiodo> dw2;
	private DtoHrEvaluacionperiodo registroSeleccionado;
	private Boolean verEvaluar;

	// RichardG 2009-01-05
	String iv_opciones[], iv_windows[];

	public static CwHrEvaluacionPeriodoList getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrEvaluacionPeriodoList}",
				CwHrEvaluacionPeriodoList.class);
	}

	/*
	 * objectstartevent
	 */
	public void inicializarAcciones() throws Exception {
		
		if (eventname.equals("opened")) {
			lstdw_opciones = getFacSeguridad().getSeguridadconceptoServicio()
					.ListarentreConceptos("HR", "GRUP05", "CON210", "CON300");
			if (!UValidador.esListaVacia(lstdw_opciones)) {
				for (Seguridadconcepto lstopciones : lstdw_opciones) {
					if (lstopciones.getPk().getConcepto().equals("CON240")) {
						dw_opciones = lstopciones;
					}
				}
			}

			buscar();
		}
	}

	@Override
	public String iniciarControladora() throws Exception {

		verEvaluar = getFacSeguridad().getSeguridadautorizacionesServicio()
				.tieneAcceso("HR", "GRUP05", "CON240",
						getUsuarioActual().getCodigoUsuario());

		inicializarAcciones();
		return "whrevaluacionperiodolist";
	}

	@Override
	public String buscar() throws Exception {

		dw2 = getFacRrhh().getHrEvaluacionperiodoServicio()
				.obtenerListadeEvauluaciones();
		return null;
	}

	public void mostrarRegistroSeleccioando() {

		for (DtoHrEvaluacionperiodo lstevaluaciones : dw2) {
			if (lstevaluaciones.getDescripcion().toUpperCase()
					.startsWith(textoBusqueda.toUpperCase())) {
				registroSeleccionado = lstevaluaciones;
			}
		}
	}

	public String evaluar() throws Exception {

		if (UValidador.esNulo(registroSeleccionado)) {
			setMessageError("Debe seleccionar un Registro");
			return null;
		}
		
		if (!"EV".equals(registroSeleccionado.getEstadoproceso())) {
			this.setMessageError("El proceso no esta en estado de Evaluación");
			return null;
		}

		StrPass str = new StrPass();
		str.getS()[1] = registroSeleccionado.getCompanyowner();
		str.getD()[1] = registroSeleccionado.getSecuenciaeval().intValue();
		
		CWHrEvaluacionperiodoListEvaluar.getInstance().setFechacierrereal(registroSeleccionado.getFechacierrereal());
		CWHrEvaluacionperiodoListEvaluar.getInstance().setFechaevalfin(registroSeleccionado.getFechaevalfin());
		CWHrEvaluacionperiodoListEvaluar.getInstance().setStrpass(str);
		CWHrEvaluacionperiodoListEvaluar.getInstance().setEventname("opened");
		CWHrEvaluacionperiodoListEvaluar.getInstance().iniciarControladora();

		return "whrevaluacionperiodolistevaluar";
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

	public Boolean getMostrarBoton() {
		return mostrarBoton;
	}

	public void setMostrarBoton(Boolean mostrarBoton) {
		this.mostrarBoton = mostrarBoton;
	}

	public Seguridadconcepto getDw_opciones() {
		return dw_opciones;
	}

	public void setDw_opciones(Seguridadconcepto dw_opciones) {
		this.dw_opciones = dw_opciones;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public DtoHrEvaluacionperiodo getRegistroSeleccionado() {
		return registroSeleccionado;
	}

	public void setRegistroSeleccionado(
			DtoHrEvaluacionperiodo registroSeleccionado) {
		this.registroSeleccionado = registroSeleccionado;
	}

	public List<DtoHrEvaluacionperiodo> getDw2() {
		return dw2;
	}

	public Boolean getVerEvaluar() {
		return verEvaluar;
	}

	public void setVerEvaluar(Boolean verEvaluar) {
		this.verEvaluar = verEvaluar;
	}

}
