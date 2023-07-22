package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

/**
 * 
 * The Class HrEmpleadocapaDocumentoPk.
 * 
 * @author nunezh
 */
public class HrEmpleadocapaDocumentoPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String capacitacion;
	private Integer empleado;
	private Integer secuencia;

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

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
