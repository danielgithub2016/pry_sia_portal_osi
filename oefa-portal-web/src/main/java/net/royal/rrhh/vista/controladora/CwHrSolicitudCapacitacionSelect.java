package net.royal.rrhh.vista.controladora;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import net.royal.comun.vista.controladora.CBaseBean;
import net.royal.framework.web.controladora.UIMantenimientoController;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeControllerGenerico;

@ManagedBean
@SessionScoped
@SuppressWarnings({ "serial" })
public class CwHrSolicitudCapacitacionSelect extends CBaseBean implements
UIMantenimientoController {
	
	private String solicitudBuscar;

	public static CwHrSolicitudCapacitacionSelect getInstance() {
		return UFaces.evaluateExpressionGet(
				"#{cwHrSolicitudCapacitacionSelect}",
				CwHrSolicitudCapacitacionSelect.class);
	}
	
	@Override
	public String iniciarControladora() throws Exception {
		
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

	public String getSolicitudBuscar() {
		return solicitudBuscar;
	}

	public void setSolicitudBuscar(String solicitudBuscar) {
		this.solicitudBuscar = solicitudBuscar;
	}

}
