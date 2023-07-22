package net.royal.seguridad.vista.controladora;

import net.royal.framework.web.dominio.MensajeControllerGenerico;

public interface UIComunSession {

	public MensajeControllerGenerico getMensaje();
	
	public void parametroAgregar(String pfield, Object pvalue);
}
