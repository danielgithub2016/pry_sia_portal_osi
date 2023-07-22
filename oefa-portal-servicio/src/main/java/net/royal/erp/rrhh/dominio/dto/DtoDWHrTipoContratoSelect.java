package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoDWHrTipoContratoSelect implements Serializable {
	private String tipocontrato;
	private String descripcion;
	private String tieneperiodoprueba;

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTieneperiodoprueba() {
		return tieneperiodoprueba;
	}

	public void setTieneperiodoprueba(String tieneperiodoprueba) {
		this.tieneperiodoprueba = tieneperiodoprueba;
	}

}
