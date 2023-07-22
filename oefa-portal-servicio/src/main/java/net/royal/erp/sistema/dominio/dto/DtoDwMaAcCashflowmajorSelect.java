package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_cashflowmajor_select
 */
public class DtoDwMaAcCashflowmajorSelect implements java.io.Serializable {
	private String cashflowmajor;
	private String localname;
	

	public String getCashflowmajor() {
		return cashflowmajor;
	}

	public void setCashflowmajor(String cashflowmajor) {
		this.cashflowmajor = cashflowmajor;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

}
