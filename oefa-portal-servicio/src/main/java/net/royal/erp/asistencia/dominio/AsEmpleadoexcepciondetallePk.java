package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadoexcepciondetalle
 */
public class AsEmpleadoexcepciondetallePk implements java.io.Serializable {

	private Integer empleado;
	private String intervaloacceso;
	private java.util.Date fecha;
	private Integer secuencia;

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public String getIntervaloacceso() {
		return intervaloacceso;
	}

	public void setIntervaloacceso(String intervaloacceso) {
		this.intervaloacceso = intervaloacceso;
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

}
