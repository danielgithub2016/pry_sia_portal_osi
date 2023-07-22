package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

/**
 * The Class HrEvaluacionpostulantePk.
 */
public class HrEvaluacionpostulantePk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String requerimiento;
	private Integer secuencia;
	private Integer secuencia2;
	private String companyowner;
	private String postulante;
	private Integer factor;

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

	public Integer getSecuencia2() {
		return secuencia2;
	}

	public void setSecuencia2(Integer secuencia2) {
		this.secuencia2 = secuencia2;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
