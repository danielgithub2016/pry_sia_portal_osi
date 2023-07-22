package net.royal.rrhh.desempenio.vista.controladora;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.MensajeControllerGenerico;


@SessionScoped
@ManagedBean
public class CwHrRevisionAvanceSelector  extends CBaseBean implements UIMantenimientoController{
	private HrEmpleadorevision registroSeleccionadoExterno;
	
	
	public static CwHrRevisionAvanceSelector getInstance() {
		return UFaces.evaluateExpressionGet("#{cwHrRevisionAvanceSelector}",
				CwHrRevisionAvanceSelector.class);
	}
	
	@Override
	public String iniciarControladora() throws Exception {
		getWebControlContext().ejecutar("PF('popRevisionAvanceCompMejora').show();");
		getWebControlContext().actualizar("dgRevisionAvanceCompMejora");
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
		getWebControlContext().ejecutar("filterTable();");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA,	"insertAvances");
		param.put("registroSeleccionado", registroSeleccionadoExterno);
		
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
		CwHrRevisionAvanceCompromisoMejora.getInstance().mensaje(mensajeGenerico);
		
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
		
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("agregarAvances")) {
			
			registroSeleccionadoExterno =  (HrEmpleadorevision) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			iniciarControladora();
		}
		
		if (mensajeControllerGenerico.getParametros()
				.get(UConstante.CONSTANTE_KEY_NOMBRETIPOBUSQUEDA)
				.equals("editarAvances")) {
			
			registroSeleccionadoExterno =  (HrEmpleadorevision) mensajeControllerGenerico
					.getParametros().get("registroSeleccionado");
			iniciarControladora();
		}
		
		
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

	public void setRegistroSeleccionadoExterno(
			HrEmpleadorevision registroSeleccionadoExterno) {
		this.registroSeleccionadoExterno = registroSeleccionadoExterno;
	}

	public HrEmpleadorevision getRegistroSeleccionadoExterno() {
		return registroSeleccionadoExterno;
	}


}
