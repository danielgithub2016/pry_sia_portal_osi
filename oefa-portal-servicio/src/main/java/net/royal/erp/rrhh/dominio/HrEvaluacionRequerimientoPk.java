package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

public class HrEvaluacionRequerimientoPk implements Serializable {

	private String requerimiento;
	private String companyowner;
	private Integer evaluacion;
	private String elemento;
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
	public Integer getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	
	
}
