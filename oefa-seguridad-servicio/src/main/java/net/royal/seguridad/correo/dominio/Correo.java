package net.royal.seguridad.correo.dominio;

import java.util.ArrayList;
import java.util.List;

import net.royal.framework.web.core.UValidador;

public class Correo {
	private String remitente;
	private String asunto;
	private byte[] cuerpoCorreo;
	private List<CorreoDestino> listaCorreoDestino;
	private List<CorreoAdjunto> listaCorreoAdjunto;

	public Correo() {
		listaCorreoDestino = new ArrayList<CorreoDestino>();
		listaCorreoAdjunto = new ArrayList<CorreoAdjunto>();
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public byte[] getCuerpoCorreo() {
		return cuerpoCorreo;
	}

	public void setCuerpoCorreo(byte[] cuerpoCorreo) {
		this.cuerpoCorreo = cuerpoCorreo;
	}

	public List<CorreoDestino> getListaCorreoDestino() {
		return listaCorreoDestino;
	}

	public void setListaCorreoDestino(List<CorreoDestino> listaCorreoDestino) {
		this.listaCorreoDestino = listaCorreoDestino;
	}

	public List<CorreoAdjunto> getListaCorreoAdjunto() {
		if (UValidador.esListaVacia(listaCorreoAdjunto)) {
			listaCorreoAdjunto = new ArrayList<CorreoAdjunto>();
		}
		return listaCorreoAdjunto;
	}

	public void setListaCorreoAdjunto(List<CorreoAdjunto> listaCorreoAdjunto) {
		this.listaCorreoAdjunto = listaCorreoAdjunto;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

}
