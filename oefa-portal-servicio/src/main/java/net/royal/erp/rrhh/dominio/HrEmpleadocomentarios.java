package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadocomentarios
*/
public class HrEmpleadocomentarios extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadocomentariosPk pk;
	private Integer factor;
	private String descripcion;
	private String comentarios;


	public HrEmpleadocomentarios() {
		pk = new HrEmpleadocomentariosPk();
	}

	public HrEmpleadocomentariosPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadocomentariosPk pk) {
		this.pk = pk;
	}
	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
