package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_afetype_select
 */
public class DtoDwMaAfetypeSelect implements java.io.Serializable {
	/**
	 * 
	 */

	private String localname;
	private String afetype;
	
	public String getLocalname() {
		return localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getAfetype() {
		return afetype;
	}
	public void setAfetype(String afetype) {
		this.afetype = afetype;
	}
	
	
}
