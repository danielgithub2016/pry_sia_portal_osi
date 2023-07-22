package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsAutorizacionfecha
*/
public class AsAutorizacionfechaPk implements java.io.Serializable{

	private Integer empleado;
	private java.util.Date fecha;
	private java.util.Date fechasolicitud;
	private java.util.Date desde;

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
	public java.util.Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(java.util.Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public java.util.Date getDesde() {
		return desde;
	}

	public void setDesde(java.util.Date desde) {
		this.desde = desde;
	}

}
