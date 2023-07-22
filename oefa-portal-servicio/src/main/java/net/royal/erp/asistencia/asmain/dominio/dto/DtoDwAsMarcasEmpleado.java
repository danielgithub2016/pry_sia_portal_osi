package net.royal.erp.asistencia.asmain.dominio.dto;

import java.util.Date;


/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_marcas_empleado
 */
public class DtoDwAsMarcasEmpleado implements java.io.Serializable {

	private Date hora;
	private Date fecha;
	/**
	 * @return the hora
	 */
	public Date getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(Date hora) {
		this.hora = hora;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
