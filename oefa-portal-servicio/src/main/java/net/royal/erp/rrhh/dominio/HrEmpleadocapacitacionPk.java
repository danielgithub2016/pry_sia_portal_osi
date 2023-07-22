package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HrEmpleadocapacitacionPk implements Serializable {
	private String capacitacion;
	private Integer empleado;

	public String getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}
}
