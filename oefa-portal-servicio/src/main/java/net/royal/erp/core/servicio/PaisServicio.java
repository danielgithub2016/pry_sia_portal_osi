package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;

import net.royal.erp.core.dominio.Pais;
import net.royal.erp.core.dominio.PaisPk;

public interface PaisServicio extends GenericoServicio {

	public List<Pais> ListarPaisesxEstado();
}
