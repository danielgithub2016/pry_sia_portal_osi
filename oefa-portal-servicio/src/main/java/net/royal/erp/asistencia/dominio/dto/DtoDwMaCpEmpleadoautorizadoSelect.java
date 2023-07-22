package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;

public class DtoDwMaCpEmpleadoautorizadoSelect implements java.io.Serializable {

	private String busqueda;
	private BigDecimal empleado;

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

}