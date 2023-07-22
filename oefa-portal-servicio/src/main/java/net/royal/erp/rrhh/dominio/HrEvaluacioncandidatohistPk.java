package net.royal.erp.rrhh.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacioncandidatohist
*/
public class HrEvaluacioncandidatohistPk implements java.io.Serializable{

	private java.util.Date fecha;
	private String companyowner;
	private String postulante;
	private String requerimiento;
	private Integer secuencia;
	private Integer evaluacion;
	private Integer factor;

	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
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
	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}
	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
