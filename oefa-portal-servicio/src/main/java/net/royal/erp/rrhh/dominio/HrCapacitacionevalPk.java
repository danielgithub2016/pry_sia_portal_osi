package net.royal.erp.rrhh.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCapacitacioneval
*/
public class HrCapacitacionevalPk implements java.io.Serializable{

	private String companyowner;
	private String capacitacion;
	private Integer evaluacion;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}
	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}

}
