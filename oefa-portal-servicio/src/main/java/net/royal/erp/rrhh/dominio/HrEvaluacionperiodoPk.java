package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionperiodo
*/
public class HrEvaluacionperiodoPk implements java.io.Serializable{

	private String companyowner;
	private Integer secuenciaeval;
	
	
	public HrEvaluacionperiodoPk() {
		// TODO Auto-generated constructor stub
	}
	

	public HrEvaluacionperiodoPk(String companyowner, Integer secuenciaeval) {
		this.companyowner = companyowner;
		this.secuenciaeval = secuenciaeval;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

}
