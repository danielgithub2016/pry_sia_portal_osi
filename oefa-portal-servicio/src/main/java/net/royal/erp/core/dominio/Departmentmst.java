package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Departmentmst
*/
public class Departmentmst extends DominioGenerico implements java.io.Serializable{

	private DepartmentmstPk pk;
	private String description;
	private String accountavailableflag;
	private String warehouseavailableflag;
	private String application;
	private String status;
	private String lastuser;
	private java.util.Date lastdate;
	private String codigosbs;
	private String codigosbsSup;


	public Departmentmst() {
		pk = new DepartmentmstPk();
	}

	public DepartmentmstPk getPk() {
		return pk;
	}

	public void setPk(DepartmentmstPk pk) {
		this.pk = pk;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getAccountavailableflag() {
		return accountavailableflag;
	}

	public void setAccountavailableflag(String accountavailableflag) {
		this.accountavailableflag = accountavailableflag;
	}
	public String getWarehouseavailableflag() {
		return warehouseavailableflag;
	}

	public void setWarehouseavailableflag(String warehouseavailableflag) {
		this.warehouseavailableflag = warehouseavailableflag;
	}
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
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
	public String getCodigosbs() {
		return codigosbs;
	}

	public void setCodigosbs(String codigosbs) {
		this.codigosbs = codigosbs;
	}
	public String getCodigosbsSup() {
		return codigosbsSup;
	}

	public void setCodigosbsSup(String codigosbsSup) {
		this.codigosbsSup = codigosbsSup;
	}

}
