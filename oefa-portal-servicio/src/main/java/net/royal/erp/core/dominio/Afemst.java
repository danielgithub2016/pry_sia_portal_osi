package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Afemst
*/
public class Afemst extends DominioGenerico implements java.io.Serializable{

	private AfemstPk pk;
	private String companyowner;
	private String localname;
	private String englishname;
	private java.util.Date approveddate;
	private java.util.Date startdate;
	private java.util.Date completeddate;
	private String responsible;
	private java.math.BigDecimal appropriationamount;
	private String account;
	private String accountclearing;
	private String afetype;
	private String afegroup;
	private String elementdefault;
	private String costcenter;
	private String group01;
	private String group02;
	private String group03;
	private String group04;
	private String status;
	private String lastuser;
	private java.util.Date lastdate;
	private String appropriationcurrency;
	private String userstatus;
	private String internalnumber;
	private String group05;
	private String group06;
	private String prime;
	private String codigosnip;
	private String codigodnpp;


	public Afemst() {
		pk = new AfemstPk();
	}

	public AfemstPk getPk() {
		return pk;
	}

	public void setPk(AfemstPk pk) {
		this.pk = pk;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
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
	public java.util.Date getApproveddate() {
		return approveddate;
	}

	public void setApproveddate(java.util.Date approveddate) {
		this.approveddate = approveddate;
	}
	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}
	public java.util.Date getCompleteddate() {
		return completeddate;
	}

	public void setCompleteddate(java.util.Date completeddate) {
		this.completeddate = completeddate;
	}
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public java.math.BigDecimal getAppropriationamount() {
		return appropriationamount;
	}

	public void setAppropriationamount(java.math.BigDecimal appropriationamount) {
		this.appropriationamount = appropriationamount;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountclearing() {
		return accountclearing;
	}

	public void setAccountclearing(String accountclearing) {
		this.accountclearing = accountclearing;
	}
	public String getAfetype() {
		return afetype;
	}

	public void setAfetype(String afetype) {
		this.afetype = afetype;
	}
	public String getAfegroup() {
		return afegroup;
	}

	public void setAfegroup(String afegroup) {
		this.afegroup = afegroup;
	}
	public String getElementdefault() {
		return elementdefault;
	}

	public void setElementdefault(String elementdefault) {
		this.elementdefault = elementdefault;
	}
	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}
	public String getGroup01() {
		return group01;
	}

	public void setGroup01(String group01) {
		this.group01 = group01;
	}
	public String getGroup02() {
		return group02;
	}

	public void setGroup02(String group02) {
		this.group02 = group02;
	}
	public String getGroup03() {
		return group03;
	}

	public void setGroup03(String group03) {
		this.group03 = group03;
	}
	public String getGroup04() {
		return group04;
	}

	public void setGroup04(String group04) {
		this.group04 = group04;
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
	public String getAppropriationcurrency() {
		return appropriationcurrency;
	}

	public void setAppropriationcurrency(String appropriationcurrency) {
		this.appropriationcurrency = appropriationcurrency;
	}
	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	public String getInternalnumber() {
		return internalnumber;
	}

	public void setInternalnumber(String internalnumber) {
		this.internalnumber = internalnumber;
	}
	public String getGroup05() {
		return group05;
	}

	public void setGroup05(String group05) {
		this.group05 = group05;
	}
	public String getGroup06() {
		return group06;
	}

	public void setGroup06(String group06) {
		this.group06 = group06;
	}
	public String getPrime() {
		return prime;
	}

	public void setPrime(String prime) {
		this.prime = prime;
	}
	public String getCodigosnip() {
		return codigosnip;
	}

	public void setCodigosnip(String codigosnip) {
		this.codigosnip = codigosnip;
	}
	public String getCodigodnpp() {
		return codigodnpp;
	}

	public void setCodigodnpp(String codigodnpp) {
		this.codigodnpp = codigodnpp;
	}

}
