package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;

import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;

@SuppressWarnings("serial")
public class DtoDwHrEmpleadonecesidadcapacitaEdit implements Serializable {
	private HrEmpleadonecesidadcapacita bean;
	private String cursonombre;
	private String eliminado;

	public HrEmpleadonecesidadcapacita getBean() {
		return bean;
	}

	public void setBean(HrEmpleadonecesidadcapacita bean) {
		this.bean = bean;
	}

	public String getCursonombre() {
		return cursonombre;
	}

	public void setCursonombre(String cursonombre) {
		this.cursonombre = cursonombre;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

	
}
