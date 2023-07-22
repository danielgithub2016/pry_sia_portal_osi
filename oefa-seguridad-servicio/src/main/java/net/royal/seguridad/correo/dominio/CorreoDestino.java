package net.royal.seguridad.correo.dominio;

import net.royal.seguridad.correo.constante.ConstanteCorreo.tipo_destino;

public class CorreoDestino {
	
	private tipo_destino destino;
	
	private String correoDestino;

	public CorreoDestino() {
	}
	public CorreoDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}

	public String getCorreoDestino() {
		return correoDestino;
	}

	public void setCorreoDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}
	public tipo_destino getDestino() {
		return destino;
	}
	public void setDestino(tipo_destino destino) {
		this.destino = destino;
	}
}
