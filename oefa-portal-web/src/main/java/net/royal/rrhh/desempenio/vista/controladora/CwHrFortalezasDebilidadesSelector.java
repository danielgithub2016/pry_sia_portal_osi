package net.royal.rrhh.desempenio.vista.controladora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.asistencia.symast.dominio.dto.DtoDwMaMiscelaneosdetalleSelect;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@ManagedBean
@SessionScoped
public class CwHrFortalezasDebilidadesSelector extends CBaseBean implements UIMantenimientoController {
	private HrEmpleadodesempeno registroSeleccionadoExterno;
	private DtoDwMaMiscelaneosdetalleSelect dtoMiscelaneos = new DtoDwMaMiscelaneosdetalleSelect();
	private List<DtoDwMaMiscelaneosdetalleSelect> lstTipo = new ArrayList<DtoDwMaMiscelaneosdetalleSelect>();
	private String estado;
	
	public static CwHrFortalezasDebilidadesSelector getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrFortalezasDebilidadesSelector}",
				CwHrFortalezasDebilidadesSelector.class);
	}
	
	public void cargarTipo() {
		for (DtoDwMaMiscelaneosdetalleSelect foda : lstTipo) {
			if (foda.getCodigoelemento().equals(registroSeleccionadoExterno.getTipo())) {
				registroSeleccionadoExterno.setDescripcionFoda(foda.getDescripcionlocal());
			}
		}
	}
	
	@Override
	public String iniciarControladora() throws Exception {
		getWebControlContext().ejecutar("PF('popFortalezasDebilidades').show();");
		getWebControlContext().actualizar("dgFortalezasDebilidades");
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
		
		if(UValidador.estaVacio(registroSeleccionadoExterno.getTipo())){
			setMessageError("Es obligatorio seleccionar el Tipo");
			return null;
		}
		
		getWebControlContext().ejecutar("filtrarTable();");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,	"insertFortalezas");
		param.put("registroSeleccionado", registroSeleccionadoExterno);
		param.put("estado", estado);
		
		if (!UValidador.esNulo(nombreContenedorRefrescar))
			this.getWebControlContext().actualizar(nombreContenedorRefrescar);

		if (!UValidador.esNulo(getNombreVentanaEmergente())) {
			String accionEmergente;
			accionEmergente = "PF('" + getNombreVentanaEmergente()
					+ "').hide()";
			getWebControlContext().ejecutar(accionEmergente);
		}
		
		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setParametros(param);
		CwHrFortalezasDebilidades.getInstance().mensaje(mensajeGenerico);
		return null;
	}

	public void validarTipo(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		String dato = (String)value;
		
		if(UValidador.esNulo(dato) && UValidador.estaVacio(dato)){
			FacesMessage message = new FacesMessage("Es obligatorio seleccionar el Tipo");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
		}
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
		
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarFortalezas")) {
			
			registroSeleccionadoExterno =   (HrEmpleadodesempeno) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			mostrarListaFoda();
			iniciarControladora();
		}
		
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("editarFortalezas")) {
			
			registroSeleccionadoExterno = (HrEmpleadodesempeno) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			mostrarListaFoda();
			iniciarControladora();
		}
		
		return null;
	}
	
	private void mostrarListaFoda(){
		dtoMiscelaneos=null;
		for (DtoDwMaMiscelaneosdetalleSelect foda : lstTipo) {
			if (foda.getCodigoelemento().equals(registroSeleccionadoExterno.getTipo())) {
				dtoMiscelaneos=foda;
			}
		}
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		return null;
	}

	public HrEmpleadodesempeno getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}

	public void setRegistroSeleccionadoExterno(
			HrEmpleadodesempeno registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

	public DtoDwMaMiscelaneosdetalleSelect getDtoMiscelaneos() {
		return dtoMiscelaneos;
	}

	public void setDtoMiscelaneos(DtoDwMaMiscelaneosdetalleSelect dtoMiscelaneos) {
		this.dtoMiscelaneos = dtoMiscelaneos;
	}

	public List<DtoDwMaMiscelaneosdetalleSelect> getLstTipo() {
		return lstTipo;
	}

	public void setLstTipo(List<DtoDwMaMiscelaneosdetalleSelect> lstTipo) {
		this.lstTipo = lstTipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
