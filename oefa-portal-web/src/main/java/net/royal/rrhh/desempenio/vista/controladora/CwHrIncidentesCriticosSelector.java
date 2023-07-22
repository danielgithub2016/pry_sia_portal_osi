package net.royal.rrhh.desempenio.vista.controladora;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import org.primefaces.event.SelectEvent;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.core.dominio.MaMiscelaneosdetalle;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@SessionScoped
@ManagedBean
public class CwHrIncidentesCriticosSelector extends CBaseBean implements UIMantenimientoController {

	private DtoDwHrIncidentecriticoList registroSeleccionadoExterno;
	private Date fechaInicio;
	private List<MaMiscelaneosdetalle> lstmeritos;
	private List<MaMiscelaneosdetalle> lstmedidas;
	private Boolean verMerito;
	private String nombreTipo;
	private String tipomerito;
	private Date fechaCalcular;

	public static CwHrIncidentesCriticosSelector getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrIncidentesCriticosSelector}", CwHrIncidentesCriticosSelector.class);
	}

	@Override
	public String iniciarControladora() throws Exception {
		
		inicializarFiltrosListado();

		getWebControlContext().ejecutar("PF('popIncidentesCriticos').show();");
		getWebControlContext().actualizar("dgIncidentesCriticos");
		
		return null;
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

	public void verMeritos(ValueChangeEvent event) {
		tipomerito = (String) event.getNewValue();

		if (tipomerito.equals("M")) {
			lstmeritos = (List<MaMiscelaneosdetalle>) this.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarSelectorVariosMiscelaneos("HR", "999999", "TIPOMERITO");
			verMerito = true;
			nombreTipo = "Tipo de Mérito";
		} else {

			lstmeritos = (List<MaMiscelaneosdetalle>) this.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarSelectorVariosMiscelaneos("HR", "999999", "TIPOFALTA");
			lstmedidas = (List<MaMiscelaneosdetalle>) this.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarSelectorVariosMiscelaneos("HR", "999999", "MEDIDADISC");
			nombreTipo = "Tipo de Falta";
			verMerito = false;
		}

	}

	public void onDateSelectFechaInicio(SelectEvent event) {
		fechaCalcular = registroSeleccionadoExterno.getFechainicio();

	}

	public void onDateSelectFechaFin(SelectEvent event) throws Exception {
		registroSeleccionadoExterno.setDiasSuspension(
				UFechaHora.obtenerDiferenciaDias(fechaCalcular, registroSeleccionadoExterno.getFechafin()));
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
	
	public void validarFechaActual(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		Date fecha = (Date) value;
		Date fechaActual= new Date();
		if(fecha.before(fechaInicio)){
			 FacesMessage message = new FacesMessage("La fecha Ingresada debe estar en el rango de la evaluación");
	            message.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(message);
		}
		
		if(fecha.after(fechaActual)){
			 FacesMessage message = new FacesMessage("La fecha Ingresada debe ser menor o igual a la fecha actual");
	            message.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(message);
		}
		
	}


	public void validarFechaFin(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		Date fechafin = (Date) value;
		Date fechaInic= registroSeleccionadoExterno.getFechainicio();
		
		if(fechaInic.after(fechafin)){
			 FacesMessage message = new FacesMessage("La fecha de Inicio debe ser menor que la fecha fin");
	            message.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(message);
		}
	}
	
	
	@Override
	public String guardar() throws Exception {
		LOGGER.debug("ID USUARIO:." + getUsuarioActual().getIdPersona());

		registroSeleccionadoExterno.setResponsable(new BigDecimal(getUsuarioActual().getIdPersona()));
		getWebControlContext().ejecutar("filtrarTableIncidentes();");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA, "insertIncidentes");
		param.put("registroSeleccionado", registroSeleccionadoExterno);

		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
			String accionEmergente;
			accionEmergente = "PF('" + getNombreVentanaEmergente() + "').hide()";
			getWebControlContext().ejecutar(accionEmergente);
		}

		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);
		CwHrIncidentesCriticos.getInstance().mensaje(mensajeGenerico);

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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarIncidentes")) {

			tipomerito="M";
			registroSeleccionadoExterno = (DtoDwHrIncidentecriticoList) mensajeControllerGenerico.getParametros()
					.get("registroSeleccionado");
			iniciarControladora();
		}

		if (mensajeControllerGenerico.getParametros().get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("editarIncidentes")) {

			registroSeleccionadoExterno = (DtoDwHrIncidentecriticoList) mensajeControllerGenerico.getParametros()
					.get("registroSeleccionado");
			
			if (tipomerito.equals("M")) {
				verMerito = true;
				nombreTipo = "Tipo de Mérito";
			} else {
				nombreTipo = "Tipo de Falta";
				verMerito = false;
			}

			
			iniciarControladora();
		}

		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		if (tipomerito.equals("M")) {
			lstmeritos = (List<MaMiscelaneosdetalle>) this.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarSelectorVariosMiscelaneos("HR", "999999", "TIPOMERITO");
			verMerito = true;
			nombreTipo = "Tipo de Mérito";
		} else {

			lstmeritos = (List<MaMiscelaneosdetalle>) this.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarSelectorVariosMiscelaneos("HR", "999999", "TIPOFALTA");
			lstmedidas = (List<MaMiscelaneosdetalle>) this.getFacCore().getMaMiscelaneosdetalleServicio()
					.listarSelectorVariosMiscelaneos("HR", "999999", "MEDIDADISC");
			nombreTipo = "Tipo de Falta";
			verMerito = false;
		}
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public DtoDwHrIncidentecriticoList getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(DtoDwHrIncidentecriticoList registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<MaMiscelaneosdetalle> getLstmeritos() {
		return lstmeritos;
	}

	public void setLstmeritos(List<MaMiscelaneosdetalle> lstmeritos) {
		this.lstmeritos = lstmeritos;
	}

	public List<MaMiscelaneosdetalle> getLstmedidas() {
		return lstmedidas;
	}

	public void setLstmedidas(List<MaMiscelaneosdetalle> lstmedidas) {
		this.lstmedidas = lstmedidas;
	}

	public Boolean getVerMerito() {
		return verMerito;
	}

	public void setVerMerito(Boolean verMerito) {
		this.verMerito = verMerito;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

}
