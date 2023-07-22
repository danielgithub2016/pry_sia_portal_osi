package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadoexcepcion
 */
public class AsEmpleadoexcepcionPk implements java.io.Serializable {

	private Integer empleado;
	private java.util.Date fecha;
	private java.util.Date fechahasta;

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public java.util.Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(java.util.Date fechahasta) {
		this.fechahasta = fechahasta;
	}

}
