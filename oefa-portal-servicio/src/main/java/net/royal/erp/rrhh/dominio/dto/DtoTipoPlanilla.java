package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoTipoPlanilla implements Serializable {
	private String tipoplanilla;
	private String descripcion;
	private String clasepago;

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClasepago() {
		return clasepago;
	}

	public void setClasepago(String clasepago) {
		this.clasepago = clasepago;
	}

}
