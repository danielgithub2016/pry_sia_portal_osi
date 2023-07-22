package net.royal.alfresco.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.oefa.alfresco.gestion.servicio.GestionAlfrescoServicio;

@Path("/alfresco")
public class GestionAlfrescoRest {

	@GET
	@Path("{pNombreArchivo}/{pRutaDestino}/{pUuid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String transferirArchivo(@PathParam("pNombreArchivo") String pNombreArchivo,
			@PathParam("pRutaDestino") String pRutaDestino, @PathParam("pUuid") String pUuid) {

		String rspta = "";
		ApplicationContext context = new ClassPathXmlApplicationContext("comun/ctxPortalWeb.xml");
		GestionAlfrescoServicio servicio = (GestionAlfrescoServicio) context.getBean("BeanServicioSeguridadAlfresco");

		try {
			rspta = servicio.transferirDocumentos(pUuid, pRutaDestino, pNombreArchivo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rspta;
	}
}