package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.core.dominio.Afetypemst;
import net.royal.erp.core.dominio.AfetypemstPk;

public interface AfetypemstServicio extends GenericoServicio {

	public List<Afetypemst> listarTipoProyecto();
	
}
