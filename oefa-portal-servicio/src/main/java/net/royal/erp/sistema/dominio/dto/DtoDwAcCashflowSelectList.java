package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ac_cashflow_select_list
 */
public class DtoDwAcCashflowSelectList implements java.io.Serializable {
	private String tiporegistroflag;
	private String cashflowmajor;
	private String localname;
	private String cashflowgroup;
	private String localname_cg;
	private String cashflowcode;
	private String localname_cm;
	private String tipooperacionflag;
	private String localnamemajor;
	private String localnamegrupo;
	private BigDecimal id;

	private BigDecimal total;
	
	private String nombreTipoRegistroFlag;
	private String nombreTipoOperacionFlag;

	public String getTiporegistroflag() {
		return tiporegistroflag;
	}

	public void setTiporegistroflag(String tiporegistroflag) {
		this.tiporegistroflag = tiporegistroflag;
	}

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

	public String getCashflowgroup() {
		return cashflowgroup;
	}

	public void setCashflowgroup(String cashflowgroup) {
		this.cashflowgroup = cashflowgroup;
	}

	public String getCashflowcode() {
		return cashflowcode;
	}

	public void setCashflowcode(String cashflowcode) {
		this.cashflowcode = cashflowcode;
	}

	public String getTipooperacionflag() {
		return tipooperacionflag;
	}

	public void setTipooperacionflag(String tipooperacionflag) {
		this.tipooperacionflag = tipooperacionflag;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getLocalname_cg() {
		return localname_cg;
	}

	public void setLocalname_cg(String localname_cg) {
		this.localname_cg = localname_cg;
	}

	public String getLocalname_cm() {
		return localname_cm;
	}

	public void setLocalname_cm(String localname_cm) {
		this.localname_cm = localname_cm;
	}

	public String getLocalnamemajor() {
		return localnamemajor;
	}

	public void setLocalnamemajor(String localnamemajor) {
		this.localnamemajor = localnamemajor;
	}

	public String getLocalnamegrupo() {
		return localnamegrupo;
	}

	public void setLocalnamegrupo(String localnamegrupo) {
		this.localnamegrupo = localnamegrupo;
	}

	public String getNombreTipoRegistroFlag() {
		if (tiporegistroflag.equals("1")) {
			nombreTipoRegistroFlag = "Ingreso";
		} else if (tiporegistroflag.equals("2")) {
			nombreTipoRegistroFlag = "Egreso";
		} else if (tiporegistroflag.equals("3")) {
			nombreTipoRegistroFlag = "Transferencia";
		} else {

		}
		return nombreTipoRegistroFlag;
	}

	public void setNombreTipoRegistroFlag(String nombreTipoRegistroFlag) {
		this.nombreTipoRegistroFlag = nombreTipoRegistroFlag;
	}

	public String getNombreTipoOperacionFlag() {
		if (tipooperacionflag.equals("1")) {
			nombreTipoOperacionFlag = "Operación";
		} else if (tipooperacionflag.equals("2")) {
			nombreTipoOperacionFlag = "Inversión";
		} else if (tipooperacionflag.equals("3")) {
			nombreTipoOperacionFlag = "Financiamiento";
		} else {

		}
		return nombreTipoOperacionFlag;
	}

	public void setNombreTipoOperacionFlag(String nombreTipoOperacionFlag) {
		this.nombreTipoOperacionFlag = nombreTipoOperacionFlag;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


}
