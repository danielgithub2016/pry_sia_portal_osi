package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_ac_referenciafiscal_edit_detail
 */
public class DtoDwMaAcReferenciafiscalEditDetail implements
		java.io.Serializable {
	
	private String anio;
	private String tiporeferenciafiscal;
	private String nivel;
	private String referenciafiscal;
	private String metapresupuestal;
	private BigDecimal porcentaje;

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getTiporeferenciafiscal() {
		return tiporeferenciafiscal;
	}

	public void setTiporeferenciafiscal(String tiporeferenciafiscal) {
		this.tiporeferenciafiscal = tiporeferenciafiscal;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getReferenciafiscal() {
		return referenciafiscal;
	}

	public void setReferenciafiscal(String referenciafiscal) {
		this.referenciafiscal = referenciafiscal;
	}

	public String getMetapresupuestal() {
		return metapresupuestal;
	}

	public void setMetapresupuestal(String metapresupuestal) {
		this.metapresupuestal = metapresupuestal;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}



}
