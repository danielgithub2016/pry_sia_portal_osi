package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrDetalleevaluacionmejora
*/
public class HrDetalleevaluacionmejora extends DominioGenerico implements java.io.Serializable{

	private HrDetalleevaluacionmejoraPk pk;
	private Integer factor;
	private String descripcion;
	private java.math.BigDecimal calificacion;
	private java.math.BigDecimal valorrequerido;
	private String comentarios;


	public HrDetalleevaluacionmejora() {
		pk = new HrDetalleevaluacionmejoraPk();
	}

	public HrDetalleevaluacionmejoraPk getPk() {
		return pk;
	}

	public void setPk(HrDetalleevaluacionmejoraPk pk) {
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
	public java.math.BigDecimal getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(java.math.BigDecimal calificacion) {
		this.calificacion = calificacion;
	}
	public java.math.BigDecimal getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(java.math.BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
