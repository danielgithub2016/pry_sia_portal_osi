package net.royal.erp.core.dominio;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companyowner
 */
public class CompanyownerPk implements java.io.Serializable {

	private String companyowner;
	
	public CompanyownerPk(){
	}

	public CompanyownerPk(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

}
