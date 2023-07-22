package net.royal.erp.asistencia.ascommon.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder ascommon.dw_ma_pr_tipoplanilla_select
 */
@SuppressWarnings("serial")
public class DtoDwMaPrTipoplanillaSelect implements java.io.Serializable {
	private String tipotrabajador;
	private BigDecimal planillaperfil;

	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
	}

	public BigDecimal getPlanillaperfil() {
		return planillaperfil;
	}

	public void setPlanillaperfil(BigDecimal planillaperfil) {
		this.planillaperfil = planillaperfil;
	}
}
