package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_costcenter_select_master
 */
public class DtoDwMaAcCostcenterSelectMaster implements java.io.Serializable {
	private String costcenter;
	private String localname;
	private String expensefinanceflag;
	private String expenseadministrativeflag;
	private String expensesalesflag;
	private String expenseproductionflag;
	private String preparacionflag;
	private String revisionflag;
	private String aprobacionflag;

	// Variables que no estan en el query pero seran usadas para ser
	// reemplazados por checkbox
	private Boolean expensefinanceflagBoolean;
	private Boolean expenseadministrativeflagBoolean;
	private Boolean expensesalesflagBoolean;
	private Boolean expenseproductionBoolean;
	private Boolean preparacionflagBoolean;
	private Boolean revisionflagBoolean;
	private Boolean aprobacionflagBoolean;

	// key para la paginacion
	private BigDecimal rowkey;

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
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

	public Boolean getExpensefinanceflagBoolean() {
		return expensefinanceflagBoolean;
	}

	public void setExpensefinanceflagBoolean(Boolean expensefinanceflagBoolean) {
		this.expensefinanceflagBoolean = expensefinanceflagBoolean;
	}

	public Boolean getExpenseadministrativeflagBoolean() {

		if (!UValidador.esNulo(expenseadministrativeflag)) {
			if (expenseadministrativeflag.equals("N")) {
				expenseadministrativeflagBoolean = false;
			} else {
				expenseadministrativeflagBoolean = true;
			}
		}
		return expenseadministrativeflagBoolean;
	}

	public void setExpenseadministrativeflagBoolean(
			Boolean expenseadministrativeflagBoolean) {
		this.expenseadministrativeflagBoolean = expenseadministrativeflagBoolean;
	}

	public Boolean getExpensesalesflagBoolean() {
		if (!UValidador.esNulo(expensesalesflag)) {
			if (expensesalesflag.equals("N")) {
				expensesalesflagBoolean = false;
			} else {
				expensesalesflagBoolean = true;
			}
		}
		return expensesalesflagBoolean;
	}

	public void setExpensesalesflagBoolean(Boolean expensesalesflagBoolean) {
		this.expensesalesflagBoolean = expensesalesflagBoolean;
	}

	public Boolean getExpenseproductionBoolean() {
		if (!UValidador.esNulo(expenseproductionflag)) {
			if (expenseproductionflag.equals("N")) {
				expenseproductionBoolean = false;
			} else {
				expenseproductionBoolean = true;
			}
		}
		return expenseproductionBoolean;
	}

	public void setExpenseproductionBoolean(Boolean expenseproductionBoolean) {
		this.expenseproductionBoolean = expenseproductionBoolean;
	}

	public BigDecimal getRowkey() {
		return rowkey;
	}

	public void setRowkey(BigDecimal rowkey) {
		this.rowkey = rowkey;
	}

	public String getPreparacionflag() {

		return preparacionflag;
	}

	public void setPreparacionflag(String preparacionflag) {
		this.preparacionflag = preparacionflag;
	}

	public String getRevisionflag() {
		return revisionflag;
	}

	public void setRevisionflag(String revisionflag) {
		this.revisionflag = revisionflag;
	}

	public String getAprobacionflag() {
		return aprobacionflag;
	}

	public void setAprobacionflag(String aprobacionflag) {
		this.aprobacionflag = aprobacionflag;
	}

	public Boolean getPreparacionflagBoolean() {
		if (!UValidador.esNulo(preparacionflag)) {
			if (preparacionflag.equals("N")) {
				preparacionflagBoolean = false;
			} else {
				preparacionflagBoolean = true;
			}
		}

		return preparacionflagBoolean;
	}

	public void setPreparacionflagBoolean(Boolean preparacionflagBoolean) {
		this.preparacionflagBoolean = preparacionflagBoolean;
	}

	public Boolean getRevisionflagBoolean() {

		if (!UValidador.esNulo(revisionflag)) {
			if (revisionflag.equals("N")) {
				revisionflagBoolean = false;
			} else {
				revisionflagBoolean = true;
			}
		}

		return revisionflagBoolean;
	}

	public void setRevisionflagBoolean(Boolean revisionflagBoolean) {
		this.revisionflagBoolean = revisionflagBoolean;
	}

	public Boolean getAprobacionflagBoolean() {
		if (!UValidador.esNulo(aprobacionflag)) {
			if (aprobacionflag.equals("N")) {
				aprobacionflagBoolean = false;
			} else {
				aprobacionflagBoolean = true;
			}
		}

		return aprobacionflagBoolean;
	}

	public void setAprobacionflagBoolean(Boolean aprobacionflagBoolean) {
		this.aprobacionflagBoolean = aprobacionflagBoolean;
	}

}
