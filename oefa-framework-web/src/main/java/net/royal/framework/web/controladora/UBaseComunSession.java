package net.royal.framework.web.controladora;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.context.FacesContext;

import net.royal.framework.web.dominio.MensajeControllerGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UBaseComunSession implements Serializable {

	private static final Log LOGGER = LogFactory
			.getLog(UBaseComunSession.class);
	private String idSeguridadConceptoActual;
	private Locale regionLocal = new Locale("es", "PE");
	private MensajeControllerGenerico mensaje;

	public UBaseComunSession() {
		iWebControlContext = new UWebControlContextPrimefaces();
		FacesContext.getCurrentInstance().getViewRoot().setLocale(regionLocal);
	}

	public String getIdSeguridadConceptoActual() {
		return idSeguridadConceptoActual;
	}

	public void setIdSeguridadConceptoActual(String idSeguridadConceptoActual) {
		this.idSeguridadConceptoActual = idSeguridadConceptoActual;
	}

	public Locale getRegionLocal() {
		return regionLocal;
	}

	public void setRegionLocal(Locale regionLocal) {
		this.regionLocal = regionLocal;
	}

	public MensajeControllerGenerico getMensaje() {
		return mensaje;
	}

	public void setMensaje(MensajeControllerGenerico mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * interface de contexto controles. metedos basicos de la suite de controles
	 * ajax
	 *
	 * @return the context del conjunto de librarias graficas que se utilizan en
	 *         las pantallas
	 * 
	 *         ejemplo: org.primefaces.context.RequestContext.getCurrentInstance
	 */
	private UIWebControlContext iWebControlContext;

	/**
	 * interface de contexto controles. metedos basicos de la suite de controles
	 * ajax
	 *
	 * @return the context del conjunto de librarias graficas que se utilizan en
	 *         las pantallas
	 * 
	 *         ejemplo: org.primefaces.context.RequestContext.getCurrentInstance
	 */
	public UIWebControlContext getWebControlContext() {
		return iWebControlContext;
	}
}
