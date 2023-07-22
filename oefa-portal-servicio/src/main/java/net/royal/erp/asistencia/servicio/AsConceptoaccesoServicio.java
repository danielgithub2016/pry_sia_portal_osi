package net.royal.erp.asistencia.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

public interface AsConceptoaccesoServicio extends GenericoServicio {

	public List obtenerExpresadoen(String conceptoacceso);

	public List obtenerConceptosAccesos(String usuario, String isadmin);
	
	public List obtenerConceptosAccesosSIGED(String usuario, String isadmin);
}
