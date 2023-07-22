package net.royal.seguridad.vista.controladora;

import java.util.ArrayList;

import net.royal.framework.web.controladora.UBaseController;
import net.royal.framework.web.controladora.UIMantenimientoController.accion_solicitada;
import net.royal.framework.web.core.UConstante;
import net.royal.framework.web.core.UFaces;
import net.royal.framework.web.dominio.MensajeUsuario;

public class UBaseBean extends UBaseController {

	public UBaseBean() {
		bindingController = UFaces.getControladora(
				UConstante.SESION_BEAN_BINDINGCONTROLLER,UIBindingController.class);
		this.setListaMensajeUsuario(new ArrayList<MensajeUsuario>());
	}

	private UIBindingController bindingController;

	public UIBindingController getBindingController() {
		return bindingController;
	}

	public void setBindingController(UIBindingController bindingController) {
		this.bindingController = bindingController;
	}

	/**
	 * Define el nombre de la accion en la pantalla de mantenimiento se define
	 * en la vista dado que se debe enviar mensaje a la propia controladora del
	 * proceso o mantenimiento y al BINDING para que se pinte a nivel de menu
	 * 
	 * */
	private accion_solicitada accionPantalla;

	/**
	 * Define el nombre de la accion en la pantalla de mantenimiento se define
	 * en la vista dado que se debe enviar mensaje a la propia controladora del
	 * proceso o mantenimiento y al BINDING para que se pinte a nivel de menu
	 * 
	 * */
	public accion_solicitada getAccionPantalla() {
		return accionPantalla;
	}

	/**
	 * Define el nombre de la accion en la pantalla de mantenimiento se define
	 * en la vista dado que se debe enviar mensaje a la propia controladora del
	 * proceso o mantenimiento y al BINDING para que se pinte a nivel de menu
	 * 
	 * */
	public void setAccionPantalla(accion_solicitada accionPantalla) {
		bindingController.setAccionPantalla(accionPantalla);
		this.accionPantalla = accionPantalla;

		if (accionPantalla == null) {
			this.setPantallaTituloAccion("");
			return;
		}

		if (accionPantalla == accion_solicitada.NUEVO) {
			this.setPantallaTituloAccion(UBaseController
					.getMessageProperty("generico_accion_nuevo"));
		}
		if (accionPantalla == accion_solicitada.LISTAR) {
			this.setPantallaTituloAccion(UBaseController
					.getMessageProperty("generico_accion_listar"));
		}
		if (accionPantalla == accion_solicitada.EDITAR) {
			this.setPantallaTituloAccion(UBaseController
					.getMessageProperty("generico_accion_editar"));
		}
		if (accionPantalla == accion_solicitada.VER) {
			this.setPantallaTituloAccion(UBaseController
					.getMessageProperty("generico_accion_ver"));
		}
		this.setSessionValue(UConstante.SESION_FORMULARIO_ACCION_SOLICITADA,
				accionPantalla);

	}

	public void setAccionPantalla(accion_solicitada accionPantalla,
			String tituloAccion) {
		this.setAccionPantalla(accionPantalla);
		this.setPantallaTituloAccion(tituloAccion);
		bindingController.setPantallaTituloAccion(tituloAccion);
	}

}
