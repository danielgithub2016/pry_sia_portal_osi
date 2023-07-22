package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ac_afe_select_list
 */
public class DtoDwAcAfeSelectList implements java.io.Serializable {
	private String localname;
	private String status;
	private String afe;
	private String afetype;
	private String internalnumber;
	private BigDecimal rowkey;

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

	public String getAfetype() {
		return afetype;
	}

	public void setAfetype(String afetype) {
		this.afetype = afetype;
	}

	public String getInternalnumber() {
		return internalnumber;
	}

	public void setInternalnumber(String internalnumber) {
		this.internalnumber = internalnumber;
	}

	public BigDecimal getRowkey() {
		return rowkey;
	}

	public void setRowkey(BigDecimal rowkey) {
		this.rowkey = rowkey;
	}



}
