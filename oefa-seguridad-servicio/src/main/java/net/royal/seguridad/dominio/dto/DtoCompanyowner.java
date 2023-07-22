package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companyowner
*/
public class DtoCompanyowner implements java.io.Serializable{

	private String companyowner;
	private String description;
	private String englishdescription;
	private java.math.BigDecimal percentage;
	private String company;
	private String owner;
	private java.math.BigDecimal changerate;
	private String lastuser;
	private java.util.Date lastdate;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnglishdescription() {
		return englishdescription;
	}

	public void setEnglishdescription(String englishdescription) {
		this.englishdescription = englishdescription;
	}
	public java.math.BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(java.math.BigDecimal percentage) {
		this.percentage = percentage;
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	public java.math.BigDecimal getChangerate() {
		return changerate;
	}

	public void setChangerate(java.math.BigDecimal changerate) {
		this.changerate = changerate;
	}
	public String getLastuser() {
		return lastuser;
	}

	public void setLastuser(String lastuser) {
		this.lastuser = lastuser;
	}
	public java.util.Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(java.util.Date lastdate) {
		this.lastdate = lastdate;
	}

}
