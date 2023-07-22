package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Responsiblemst
*/
public class Responsiblemst extends DominioGenerico implements java.io.Serializable{

	private ResponsiblemstPk pk;
	private String nextresponsible;
	private String localname;
	private String englishname;
	private Integer vendor;
	private Integer responsabilitylevel;
	private String status;
	private String lastuser;
	private java.util.Date lastdate;
	private Integer authorizedamount;
	private Integer amountinvoices;
	private Integer amountrequisitions;
	private Integer amountadvances;
	private Integer amountothers01;
	private Integer amountothers02;
	private Integer amountothers03;


	public Responsiblemst() {
		pk = new ResponsiblemstPk();
	}

	public ResponsiblemstPk getPk() {
		return pk;
	}

	public void setPk(ResponsiblemstPk pk) {
		this.pk = pk;
	}
	public String getNextresponsible() {
		return nextresponsible;
	}

	public void setNextresponsible(String nextresponsible) {
		this.nextresponsible = nextresponsible;
	}
	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}
	public Integer getVendor() {
		return vendor;
	}

	public void setVendor(Integer vendor) {
		this.vendor = vendor;
	}
	public Integer getResponsabilitylevel() {
		return responsabilitylevel;
	}

	public void setResponsabilitylevel(Integer responsabilitylevel) {
		this.responsabilitylevel = responsabilitylevel;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	public Integer getAuthorizedamount() {
		return authorizedamount;
	}

	public void setAuthorizedamount(Integer authorizedamount) {
		this.authorizedamount = authorizedamount;
	}
	public Integer getAmountinvoices() {
		return amountinvoices;
	}

	public void setAmountinvoices(Integer amountinvoices) {
		this.amountinvoices = amountinvoices;
	}
	public Integer getAmountrequisitions() {
		return amountrequisitions;
	}

	public void setAmountrequisitions(Integer amountrequisitions) {
		this.amountrequisitions = amountrequisitions;
	}
	public Integer getAmountadvances() {
		return amountadvances;
	}

	public void setAmountadvances(Integer amountadvances) {
		this.amountadvances = amountadvances;
	}
	public Integer getAmountothers01() {
		return amountothers01;
	}

	public void setAmountothers01(Integer amountothers01) {
		this.amountothers01 = amountothers01;
	}
	public Integer getAmountothers02() {
		return amountothers02;
	}

	public void setAmountothers02(Integer amountothers02) {
		this.amountothers02 = amountothers02;
	}
	public Integer getAmountothers03() {
		return amountothers03;
	}

	public void setAmountothers03(Integer amountothers03) {
		this.amountothers03 = amountothers03;
	}

}
