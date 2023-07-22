package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestofunciones
*/
public class HrPuestofunciones extends DominioGenerico implements java.io.Serializable{

	private HrPuestofuncionesPk pk;
	private String funcion;
	private String descripcion;
	private String descripcioningles;
	private String comentarios;
	private String estado;
	private String unidadreplicacion;
	private Integer factorparticipacion;

private String auxFuncion;

	public HrPuestofunciones() {
		pk = new HrPuestofuncionesPk();
	}

	public HrPuestofuncionesPk getPk() {
		return pk;
	}

	public void setPk(HrPuestofuncionesPk pk) {
		this.pk = pk;
	}
	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
	public Integer getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(Integer factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}

	public String getAuxFuncion() {
		return auxFuncion;
	}

	public void setAuxFuncion(String auxFuncion) {
		this.auxFuncion = auxFuncion;
	}

}
