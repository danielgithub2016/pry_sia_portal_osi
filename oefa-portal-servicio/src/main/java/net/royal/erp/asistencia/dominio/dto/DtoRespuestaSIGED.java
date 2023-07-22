package net.royal.erp.asistencia.dominio.dto;

import java.util.List;

public class DtoRespuestaSIGED {
	private String estado;
	private Object mensaje;
	private Object referencia;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Object getMensaje() {
		return mensaje;
	}

	public void setMensaje(Object mensaje) {
		this.mensaje = mensaje;
	}

	public Object getReferencia() {
		return referencia;
	}

	public void setReferencia(Object referencia) {
		this.referencia = referencia;
	}
}
