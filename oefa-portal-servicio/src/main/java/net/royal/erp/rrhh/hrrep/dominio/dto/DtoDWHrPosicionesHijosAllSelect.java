package net.royal.erp.rrhh.hrrep.dominio.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoDWHrPosicionesHijosAllSelect implements Serializable {
	private Integer codigoposicion;
	private String descripcion;
	private String centrocostos;
	private String localname;

	public Integer getCodigoposicion() {
		return codigoposicion;
	}

	public void setCodigoposicion(Integer codigoposicion) {
		this.codigoposicion = codigoposicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

}
