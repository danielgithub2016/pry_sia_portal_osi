package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.core.dominio.Unidadesmast;
import net.royal.erp.core.dominio.UnidadesmastPk;

public interface UnidadesmastServicio extends GenericoServicio {
	public List DwMaUnidadesmastSelect();
}
