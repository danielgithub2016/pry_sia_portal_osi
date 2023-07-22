package net.royal.seguridad.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.seguridad.dominio.Aplicacionesmast;
import net.royal.seguridad.dominio.AplicacionesmastPk;

public interface AplicacionesmastServicio extends GenericoServicio {
	public String obtenerPeriodoContable(String aplicacioncodigo);
}
