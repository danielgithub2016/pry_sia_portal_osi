package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrProfesion
*/
public class HrProfesion extends DominioGenerico implements java.io.Serializable{

	private HrProfesionPk pk;
	private String descripcion;
	private String estado;
	private String unidadreplicacion;
	private String abreviatura;


	public HrProfesion() {
		pk = new HrProfesionPk();
	}

	public HrProfesionPk getPk() {
		return pk;
	}

	public void setPk(HrProfesionPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

}
