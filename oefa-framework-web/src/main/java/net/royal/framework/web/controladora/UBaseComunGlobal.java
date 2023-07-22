package net.royal.framework.web.controladora;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UBaseComunGlobal implements Serializable {

	private static final Log LOGGER = LogFactory.getLog(UBaseComunGlobal.class);
	
	private String codigoAplicacion;
	
	private Boolean verListaCompanias;
	private Boolean verListaCliente;
	private Boolean verListaPeriodo;
	
	/**
	 * nombre de la aplicacion que se muestra en las pantallas del sistena
	 */
	private String nombreAplicacion;

	private String nombreAplicacionLinea1;

	private String nombreAplicacionLinea2;
	
	private String urlPostulante;
	private String convocatoriaPublicCaptchaKey;
	private String convocatoriaPrivateCaptchaKey;
	
	
	
	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}

	public void setCodigoAplicacion(String codigoAplicacion) {
		this.codigoAplicacion = codigoAplicacion;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getNombreAplicacionLinea1() {
		return nombreAplicacionLinea1;
	}

	public void setNombreAplicacionLinea1(String nombreAplicacionLinea1) {
		this.nombreAplicacionLinea1 = nombreAplicacionLinea1;
	}

	public String getNombreAplicacionLinea2() {
		return nombreAplicacionLinea2;
	}

	public void setNombreAplicacionLinea2(String nombreAplicacionLinea2) {
		this.nombreAplicacionLinea2 = nombreAplicacionLinea2;
	}

	public Boolean getVerListaCompanias() {
		return verListaCompanias;
	}

	public void setVerListaCompanias(Boolean verListaCompanias) {
		this.verListaCompanias = verListaCompanias;
	}

	public Boolean getVerListaCliente() {
		return verListaCliente;
	}

	public void setVerListaCliente(Boolean verListaCliente) {
		this.verListaCliente = verListaCliente;
	}

	public Boolean getVerListaPeriodo() {
		return verListaPeriodo;
	}

	public void setVerListaPeriodo(Boolean verListaPeriodo) {
		this.verListaPeriodo = verListaPeriodo;
	}

	public String getUrlPostulante() {
		return urlPostulante;
	}

	public void setUrlPostulante(String urlPostulante) {
		this.urlPostulante = urlPostulante;
	}

	public String getConvocatoriaPublicCaptchaKey() {
		return convocatoriaPublicCaptchaKey;
	}

	public void setConvocatoriaPublicCaptchaKey(String convocatoriaPublicCaptchaKey) {
		this.convocatoriaPublicCaptchaKey = convocatoriaPublicCaptchaKey;
	}

	public String getConvocatoriaPrivateCaptchaKey() {
		return convocatoriaPrivateCaptchaKey;
	}

	public void setConvocatoriaPrivateCaptchaKey(
			String convocatoriaPrivateCaptchaKey) {
		this.convocatoriaPrivateCaptchaKey = convocatoriaPrivateCaptchaKey;
	}

	
}
