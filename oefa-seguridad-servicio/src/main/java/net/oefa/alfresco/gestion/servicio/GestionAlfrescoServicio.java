package net.oefa.alfresco.gestion.servicio;

import net.royal.framework.web.servicio.GenericoServicio;

public interface GestionAlfrescoServicio extends GenericoServicio {

	public String transferirDocumentos(String uiddalfresoc, String carpetadestino, String nombrearchivo)
			throws Exception;
}
