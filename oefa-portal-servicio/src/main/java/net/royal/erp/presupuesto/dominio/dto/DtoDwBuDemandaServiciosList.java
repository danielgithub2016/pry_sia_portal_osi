package net.royal.erp.presupuesto.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

public class DtoDwBuDemandaServiciosList implements Serializable {
	private String referenciafiscal;
	private String tipoinsumo;
	private String clasificador;
	private BigDecimal valorreferencial;
	private String insumo;
	private String descripcion;
	private String tipoinsumodescripcion;
	private BigDecimal cantidaddemandada;
	private BigDecimal cantidadaprobada;

	public String getReferenciafiscal() {
		return referenciafiscal;
	}

	public void setReferenciafiscal(String referenciafiscal) {
		this.referenciafiscal = referenciafiscal;
	}

	public String getTipoinsumo() {
		return tipoinsumo;
	}

	public void setTipoinsumo(String tipoinsumo) {
		this.tipoinsumo = tipoinsumo;
	}

	public String getClasificador() {
		return clasificador;
	}

	public void setClasificador(String clasificador) {
		this.clasificador = clasificador;
	}

	public BigDecimal getValorreferencial() {
		return valorreferencial;
	}

	public void setValorreferencial(BigDecimal valorreferencial) {
		this.valorreferencial = valorreferencial;
	}

	public String getInsumo() {
		return insumo;
	}

	public void setInsumo(String insumo) {
		this.insumo = insumo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoinsumodescripcion() {
		if (!UValidador.estaVacio(tipoinsumo)) {
			switch (tipoinsumo) {
			case "CO":
				tipoinsumodescripcion = "SERVICIO";
				break;
			case "SU":
				tipoinsumodescripcion = "ITEM";
				break;
			}
		}
		return tipoinsumodescripcion;
	}

	public void setTipoinsumodescripcion(String tipoinsumodescripcion) {
		this.tipoinsumodescripcion = tipoinsumodescripcion;
	}

	public BigDecimal getCantidaddemandada() {
		return cantidaddemandada;
	}

	public void setCantidaddemandada(BigDecimal cantidaddemandada) {
		this.cantidaddemandada = cantidaddemandada;
	}

	public BigDecimal getCantidadaprobada() {
		return cantidadaprobada;
	}

	public void setCantidadaprobada(BigDecimal cantidadaprobada) {
		this.cantidadaprobada = cantidadaprobada;
	}

}
