package net.royal.framework.correo.dominio;

import javax.mail.Session;

import net.royal.framework.web.core.UValidador;

public class ConfiguracionCorreo {
	private Session sessionCorreo;

	private String flgCorreoPrueba;
	private String correoPrueba;
	private String correoTipoConfiguracion;

	private String emailCuenta;
	private String emailClave;
	private String emailFrom;
	private String emailPerfil;
	private Boolean flgResultadoEnvioCorreo;
	private Exception exceptionRetorno;
	private String rutaRaizAdjuntos;

	public String getEmailCuenta() {
		return emailCuenta;
	}

	public void setEmailCuenta(String emailCuenta) {
		this.emailCuenta = emailCuenta;
	}

	public String getEmailClave() {
		return emailClave;
	}

	public void setEmailClave(String emailClave) {
		this.emailClave = emailClave;
	}

	public String getFlgCorreoPrueba() {
		return flgCorreoPrueba;
	}

	public void setFlgCorreoPrueba(String flgCorreoPrueba) {
		this.flgCorreoPrueba = flgCorreoPrueba;
	}

	public String getCorreoPrueba() {
		return correoPrueba;
	}

	public void setCorreoPrueba(String correoPrueba) {
		this.correoPrueba = correoPrueba;
	}

	public String getCorreoTipoConfiguracion() {
		return correoTipoConfiguracion;
	}

	public void setCorreoTipoConfiguracion(String correoTipoConfiguracion) {
		this.correoTipoConfiguracion = correoTipoConfiguracion;
	}

	public Session getSessionCorreo() {
		return sessionCorreo;
	}

	public void setSessionCorreo(Session sessionCorreo) {
		this.sessionCorreo = sessionCorreo;
	}

	public Boolean getFlgResultadoEnvioCorreo() {
		return flgResultadoEnvioCorreo;
	}

	public void setFlgResultadoEnvioCorreo(Boolean flgResultadoEnvioCorreo) {
		this.flgResultadoEnvioCorreo = flgResultadoEnvioCorreo;
	}

	public Exception getExceptionRetorno() {
		return exceptionRetorno;
	}

	public void setExceptionRetorno(Exception exceptionRetorno) {
		this.exceptionRetorno = exceptionRetorno;
	}

	public String getRutaRaizAdjuntos() {
		return rutaRaizAdjuntos;
	}

	public void setRutaRaizAdjuntos(String rutaRaizAdjuntos) {
		this.rutaRaizAdjuntos = rutaRaizAdjuntos;
	}

	public String getEmailPerfil() {
		if (UValidador.esNulo(emailPerfil)) {
			emailPerfil = "";
		}
		return emailPerfil;
	}

	public void setEmailPerfil(String emailPerfil) {
		this.emailPerfil = emailPerfil;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	
}
