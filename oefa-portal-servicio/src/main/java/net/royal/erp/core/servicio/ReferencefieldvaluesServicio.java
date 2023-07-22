package net.royal.erp.core.servicio;

import java.util.List;

import net.royal.erp.core.dominio.Referencefieldvalues;
import net.royal.framework.web.servicio.GenericoServicio;

public interface ReferencefieldvaluesServicio extends GenericoServicio {

	public List<Referencefieldvalues> listaDw1(String ReferenceField);
}
