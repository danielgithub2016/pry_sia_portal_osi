package net.royal.erp.contabilidad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder contabilidad.AcCostcentermst
*/
public class AcCostcentermst extends DominioGenerico implements java.io.Serializable{

	private AcCostcentermstPk pk;
	private String localname;
	private String englishname;
	private String costcenterclasification;
	private String costcentergroup;
	private String costcentersubgroup;
	private String costcenterrelation;
	private String responsible;
	private String expensefinanceflag;
	private String expenseadministrativeflag;
	private String expensesalesflag;
	private String expenseproductionflag;
	private String costcenternext;
	private Integer vendor;
	private Integer amountinvoices;
	private Integer amountrequisitions;
	private Integer amountadvances;
	private Integer amountothers01;
	private Integer amountothers02;
	private Integer amountothers03;
	private String vendorsignfile;
	private String account;
	private String status;
	private String lastuser;
	private java.util.Date lastdate;
	private String costproductionlevel;
	private String accountdestination;
	private String costcentertype;
	private String incomeflag;
	private String accountinflation;
	private String expensefixedflag;
	private String expensedirectflag;
	private String sucursal;
	private String internalnumber;
	private String racionperfil;
	private String racionperfilmantenimiento;
	private String address;
	private String cpautomaticinvoflag;
	private String cpautomaticrequflag;
	private String multicompanyflag;
	private String companyowner;
	private String referenciafiscal02;


	public AcCostcentermst() {
		pk = new AcCostcentermstPk();
	}

	public AcCostcentermstPk getPk() {
		return pk;
	}

	public void setPk(AcCostcentermstPk pk) {
		this.pk = pk;
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
	public String getCostcenterclasification() {
		return costcenterclasification;
	}

	public void setCostcenterclasification(String costcenterclasification) {
		this.costcenterclasification = costcenterclasification;
	}
	public String getCostcentergroup() {
		return costcentergroup;
	}

	public void setCostcentergroup(String costcentergroup) {
		this.costcentergroup = costcentergroup;
	}
	public String getCostcentersubgroup() {
		return costcentersubgroup;
	}

	public void setCostcentersubgroup(String costcentersubgroup) {
		this.costcentersubgroup = costcentersubgroup;
	}
	public String getCostcenterrelation() {
		return costcenterrelation;
	}

	public void setCostcenterrelation(String costcenterrelation) {
		this.costcenterrelation = costcenterrelation;
	}
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getExpensefinanceflag() {
		return expensefinanceflag;
	}

	public void setExpensefinanceflag(String expensefinanceflag) {
		this.expensefinanceflag = expensefinanceflag;
	}
	public String getExpenseadministrativeflag() {
		return expenseadministrativeflag;
	}

	public void setExpenseadministrativeflag(String expenseadministrativeflag) {
		this.expenseadministrativeflag = expenseadministrativeflag;
	}
	public String getExpensesalesflag() {
		return expensesalesflag;
	}

	public void setExpensesalesflag(String expensesalesflag) {
		this.expensesalesflag = expensesalesflag;
	}
	public String getExpenseproductionflag() {
		return expenseproductionflag;
	}

	public void setExpenseproductionflag(String expenseproductionflag) {
		this.expenseproductionflag = expenseproductionflag;
	}
	public String getCostcenternext() {
		return costcenternext;
	}

	public void setCostcenternext(String costcenternext) {
		this.costcenternext = costcenternext;
	}
	public Integer getVendor() {
		return vendor;
	}

	public void setVendor(Integer vendor) {
		this.vendor = vendor;
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
	public String getVendorsignfile() {
		return vendorsignfile;
	}

	public void setVendorsignfile(String vendorsignfile) {
		this.vendorsignfile = vendorsignfile;
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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
	public String getCostproductionlevel() {
		return costproductionlevel;
	}

	public void setCostproductionlevel(String costproductionlevel) {
		this.costproductionlevel = costproductionlevel;
	}
	public String getAccountdestination() {
		return accountdestination;
	}

	public void setAccountdestination(String accountdestination) {
		this.accountdestination = accountdestination;
	}
	public String getCostcentertype() {
		return costcentertype;
	}

	public void setCostcentertype(String costcentertype) {
		this.costcentertype = costcentertype;
	}
	public String getIncomeflag() {
		return incomeflag;
	}

	public void setIncomeflag(String incomeflag) {
		this.incomeflag = incomeflag;
	}
	public String getAccountinflation() {
		return accountinflation;
	}

	public void setAccountinflation(String accountinflation) {
		this.accountinflation = accountinflation;
	}
	public String getExpensefixedflag() {
		return expensefixedflag;
	}

	public void setExpensefixedflag(String expensefixedflag) {
		this.expensefixedflag = expensefixedflag;
	}
	public String getExpensedirectflag() {
		return expensedirectflag;
	}

	public void setExpensedirectflag(String expensedirectflag) {
		this.expensedirectflag = expensedirectflag;
	}
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getInternalnumber() {
		return internalnumber;
	}

	public void setInternalnumber(String internalnumber) {
		this.internalnumber = internalnumber;
	}
	public String getRacionperfil() {
		return racionperfil;
	}

	public void setRacionperfil(String racionperfil) {
		this.racionperfil = racionperfil;
	}
	public String getRacionperfilmantenimiento() {
		return racionperfilmantenimiento;
	}

	public void setRacionperfilmantenimiento(String racionperfilmantenimiento) {
		this.racionperfilmantenimiento = racionperfilmantenimiento;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getCpautomaticinvoflag() {
		return cpautomaticinvoflag;
	}

	public void setCpautomaticinvoflag(String cpautomaticinvoflag) {
		this.cpautomaticinvoflag = cpautomaticinvoflag;
	}
	public String getCpautomaticrequflag() {
		return cpautomaticrequflag;
	}

	public void setCpautomaticrequflag(String cpautomaticrequflag) {
		this.cpautomaticrequflag = cpautomaticrequflag;
	}
	public String getMulticompanyflag() {
		return multicompanyflag;
	}

	public void setMulticompanyflag(String multicompanyflag) {
		this.multicompanyflag = multicompanyflag;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getReferenciafiscal02() {
		return referenciafiscal02;
	}

	public void setReferenciafiscal02(String referenciafiscal02) {
		this.referenciafiscal02 = referenciafiscal02;
	}

}
