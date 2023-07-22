package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsAccesosdiarios
 */
public class AsAccesosdiariosPk implements java.io.Serializable {

	private String carnetid;
	private java.util.Date fecha;
	private Integer secuencia;
	private Integer empleado;

	public String getCarnetid() {
		return carnetid;
	}

	public void setCarnetid(String carnetid) {
		this.carnetid = carnetid;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

}
