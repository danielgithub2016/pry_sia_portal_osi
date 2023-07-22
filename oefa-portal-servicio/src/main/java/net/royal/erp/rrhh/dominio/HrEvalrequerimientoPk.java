package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

/**
 * The Class HrEvalrequerimientoPk.
 */
public class HrEvalrequerimientoPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String requerimiento;
	private Integer secuencia;
	private String companyowner;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

}
