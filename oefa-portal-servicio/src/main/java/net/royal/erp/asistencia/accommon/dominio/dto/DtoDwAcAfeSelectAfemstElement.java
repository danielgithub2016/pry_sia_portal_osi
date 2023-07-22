package net.royal.erp.asistencia.accommon.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder accommon.dw_ac_afe_select_afemst_element
 */
public class DtoDwAcAfeSelectAfemstElement implements java.io.Serializable {
	
	private String element;
	private String localname;
	private String elementgroup;
	private String localname_1;
	private BigDecimal rowkey;
	
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getLocalname() {
		return localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getElementgroup() {
		return elementgroup;
	}
	public void setElementgroup(String elementgroup) {
		this.elementgroup = elementgroup;
	}
	public String getLocalname_1() {
		return localname_1;
	}
	public void setLocalname_1(String localname_1) {
		this.localname_1 = localname_1;
	}
	public BigDecimal getRowkey() {
		return rowkey;
	}
	public void setRowkey(BigDecimal rowkey) {
		this.rowkey = rowkey;
	}

	
}
