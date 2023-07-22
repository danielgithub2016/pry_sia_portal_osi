package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.math.BigDecimal;
import java.util.List;

/**
*
* @author desarrollo
* @powerbuilder hrothers.dw_hr_curso_selector
*/
public class DtoDwHrCursoSelector implements java.io.Serializable{
	private BigDecimal curso;
	private String descripcion;
	private String estado;
	private String tipo;
	private String area;
	private String areadescripcion;
	private String descripcioncompleta;
	private List<DtoDwHrCursoSelector> dw1Detalle;

	public BigDecimal getCurso() {
		return curso;
	}

	public void setCurso(BigDecimal curso) {
		this.curso = curso;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreadescripcion() {
		return areadescripcion;
	}

	public void setAreadescripcion(String areadescripcion) {
		this.areadescripcion = areadescripcion;
	}

	public String getDescripcioncompleta() {
		return descripcioncompleta;
	}

	public void setDescripcioncompleta(String descripcioncompleta) {
		this.descripcioncompleta = descripcioncompleta;
	}

	public List<DtoDwHrCursoSelector> getDw1Detalle() {
		return dw1Detalle;
	}

	public void setDw1Detalle(List<DtoDwHrCursoSelector> dw1Detalle) {
		this.dw1Detalle = dw1Detalle;
	}


}
