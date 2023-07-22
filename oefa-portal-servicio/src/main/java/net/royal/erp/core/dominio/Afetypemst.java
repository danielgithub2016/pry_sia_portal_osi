package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Afetypemst
*/
public class Afetypemst extends DominioGenerico implements java.io.Serializable{

	private AfetypemstPk pk;
	private String localname;
	private String englishname;
	private String status;
	private String lastuser;
	private java.util.Date lastdate;
	private String account;


	public Afetypemst() {
		pk = new AfetypemstPk();
	}

	public AfetypemstPk getPk() {
		return pk;
	}

	public void setPk(AfetypemstPk pk) {
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
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
