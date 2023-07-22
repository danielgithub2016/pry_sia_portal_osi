package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @powerbuilder hrproc.dw_factores_competencia_historial
 * */
@SuppressWarnings("serial")
public class DtoDwFactoresCompetenciaHistorial implements Serializable {
	
	private String companyowner;
	private Integer empleado;
	private Integer factor;
	private String descripcion;
	private BigDecimal secuenciaeval;
	private String periodo;
	private Date fechainicio;
	private Date fechafin;
	private BigDecimal calificacion;
	private BigDecimal valorrequerido;
	private BigDecimal total;
	
	
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getCompanyowner() {
		return companyowner;
	}
	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public Integer getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
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
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public BigDecimal getValorrequerido() {
		return valorrequerido;
	}
	public void setValorrequerido(BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}
	public BigDecimal getSecuenciaeval() {
		return secuenciaeval;
	}
	public void setSecuenciaeval(BigDecimal secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}
	public BigDecimal getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}
	
	
}
