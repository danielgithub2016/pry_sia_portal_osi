package net.royal.erp.asistencia.dominio.dto;

import java.util.List;

public class DtoAreaSIGED {
	private String estado;
	private Object mensaje;
	private Object referencia;
	private List<DtoAreaDetalleSIGED> areas;
	
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
	public List<DtoAreaDetalleSIGED> getAreas() {
		return areas;
	}
	public void setAreas(List<DtoAreaDetalleSIGED> areas) {
		this.areas = areas;
	}
}
