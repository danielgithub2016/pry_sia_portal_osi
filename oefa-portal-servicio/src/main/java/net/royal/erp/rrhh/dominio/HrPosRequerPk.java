package net.royal.erp.rrhh.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPosrequer
*/
@SuppressWarnings("serial")
public class HrPosRequerPk implements java.io.Serializable{

	private String requerimiento;
	private String companyowner;
	private String postulante;

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
	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

}
