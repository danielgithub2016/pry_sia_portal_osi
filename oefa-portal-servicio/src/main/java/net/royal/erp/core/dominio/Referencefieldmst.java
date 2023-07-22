package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Referencefieldmst
*/
public class Referencefieldmst extends DominioGenerico implements java.io.Serializable{

	private ReferencefieldmstPk pk;
	private String localname;
	private String englishname;
	private String screentitle;
	private Integer length;
	private String internalcodeflag;
	private String internalcode;
	private String tablevalidatedflag;
	private String availableflag;
	private String status;
	private String lastuser;
	private java.util.Date lastdate;


	public Referencefieldmst() {
		pk = new ReferencefieldmstPk();
	}

	public ReferencefieldmstPk getPk() {
		return pk;
	}

	public void setPk(ReferencefieldmstPk pk) {
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
	public String getScreentitle() {
		return screentitle;
	}

	public void setScreentitle(String screentitle) {
		this.screentitle = screentitle;
	}
	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	public String getInternalcodeflag() {
		return internalcodeflag;
	}

	public void setInternalcodeflag(String internalcodeflag) {
		this.internalcodeflag = internalcodeflag;
	}
	public String getInternalcode() {
		return internalcode;
	}

	public void setInternalcode(String internalcode) {
		this.internalcode = internalcode;
	}
	public String getTablevalidatedflag() {
		return tablevalidatedflag;
	}

	public void setTablevalidatedflag(String tablevalidatedflag) {
		this.tablevalidatedflag = tablevalidatedflag;
	}
	public String getAvailableflag() {
		return availableflag;
	}

	public void setAvailableflag(String availableflag) {
		this.availableflag = availableflag;
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

}
