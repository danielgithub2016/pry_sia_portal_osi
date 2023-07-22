package net.royal.framework.correo.dominio;

import net.royal.framework.correo.constante.ConstanteCorreo.tipo_destino;

public class CorreoDestinoCore {

	private tipo_destino destino;

	private String correoDestino;

	public CorreoDestinoCore() {
	}

	public CorreoDestinoCore(String correoDestino) {
		this.correoDestino = correoDestino;
	}

	public CorreoDestinoCore(String correoDestino, tipo_destino destino) {
		this.correoDestino = correoDestino;
		this.destino = destino;
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
