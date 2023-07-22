package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DtoHrEvaluacionRequirimiento implements Serializable {
	
	private String requerimiento;
	private String companyowner;
	private BigDecimal evaluacion;
	private String elemento;
	private String descripcion;
	private String flagelemento;
	private String otro;
	public String getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}
	public String getCompanyowner() {
		return companyowner;
	}
	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public BigDecimal getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(BigDecimal evaluacion) {
		this.evaluacion = evaluacion;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFlagelemento() {
		return flagelemento;
	}
	public void setFlagelemento(String flagelemento) {
		this.flagelemento = flagelemento;
	}
	public String getOtro() {
		return otro;
	}
	public void setOtro(String otro) {
		this.otro = otro;
	}


	
	

	



}
