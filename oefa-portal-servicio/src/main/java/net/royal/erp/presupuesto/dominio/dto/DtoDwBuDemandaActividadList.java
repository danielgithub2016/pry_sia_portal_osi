package net.royal.erp.presupuesto.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwBuDemandaActividadList implements Serializable {
	private String referenciafiscal;
	private String tipodemanda;
	private String costcenter;
	private String actividaddescripcion;

	private String tipodemandadescripcion;

	public String getReferenciafiscal() {
		return referenciafiscal;
	}

	public void setReferenciafiscal(String referenciafiscal) {
		this.referenciafiscal = referenciafiscal;
	}

	public String getTipodemanda() {
		return tipodemanda;
	}

	public void setTipodemanda(String tipodemanda) {
		this.tipodemanda = tipodemanda;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getActividaddescripcion() {
		return actividaddescripcion;
	}

	public void setActividaddescripcion(String actividaddescripcion) {
		this.actividaddescripcion = actividaddescripcion;
	}

	public String getTipodemandadescripcion() {
		if (!UValidador.esNulo(tipodemanda)) {
			switch (tipodemanda) {
			case "DR":
				tipodemandadescripcion = "RECURRENTE";
				break;
			case "DA":
				tipodemandadescripcion = "ADICIONAL";
				break;
			case "DN":
				tipodemandadescripcion = "NO PROGRAMADA";
				break;
			}
		}
		return tipodemandadescripcion;
	}

	public void setTipodemandadescripcion(String tipodemandadescripcion) {
		this.tipodemandadescripcion = tipodemandadescripcion;
	}

}
