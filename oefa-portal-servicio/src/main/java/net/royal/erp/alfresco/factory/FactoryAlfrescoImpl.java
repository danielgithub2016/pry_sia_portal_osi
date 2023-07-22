package net.royal.erp.alfresco.factory;

import net.royal.erp.alfresco.servicio.GestionAlfrescoServicio;

public class FactoryAlfrescoImpl implements FactoryAlfresco {

	private GestionAlfrescoServicio gestionAlfrescoServicio;

	public GestionAlfrescoServicio getGestionAlfrescoServicio() {
		return gestionAlfrescoServicio;
	}

	public void setGestionAlfrescoServicio(GestionAlfrescoServicio gestionAlfrescoServicio) {
		this.gestionAlfrescoServicio = gestionAlfrescoServicio;
	}
	
}
