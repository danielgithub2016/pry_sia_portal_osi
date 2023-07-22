package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadorevision
*/
public class HrEmpleadorevision extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadorevisionPk pk;
	private String descripcion;
	private String periodo;
	private String observacion;
	private String eliminado;


	public HrEmpleadorevision() {
		pk = new HrEmpleadorevisionPk();
	}

	public HrEmpleadorevisionPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadorevisionPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

}
