package net.royal.erp.sistema.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.sistema.dominio.SySeguridadautorizaciones;
import net.royal.erp.sistema.dominio.SySeguridadautorizacionesPk;

public interface SySeguridadautorizacionesServicio extends GenericoServicio {
	/**
	 * f_security
	 */
	public List obtenerSeguridad (String par_option, String par_grupo,
			String par_concepto, String gvSeguridad, String gvEmpresa,
			String gvUserid, String gvApplication);
	
	
}
