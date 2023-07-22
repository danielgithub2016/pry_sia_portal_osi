package net.royal.seguridad.servicio;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Empleadomast;

public interface EmpleadomastServicio extends GenericoServicio {
	public Empleadomast obtenerPorPersona(Integer persona); 
}
