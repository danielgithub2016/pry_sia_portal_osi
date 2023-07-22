package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.Primemst;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PrimemstServicio extends GenericoServicio {

	public List<Primemst> listarCombo(Integer DigitsNumber);
	
}
