package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

public class DtoTablaNuevaBandeja {
	private BigDecimal idAreaSIA;
	private BigDecimal idCargoSIA;
	private String nombreCargoSIA;
	private String nombreAreaSIA;
	private BigDecimal idAreaSIGED;
	private BigDecimal idCargoSIGED;
	private String esJefe;
	private String estadoempleado;
	private BigDecimal secuencia;

	public BigDecimal getIdAreaSIA() {
		return idAreaSIA;
	}

	public void setIdAreaSIA(BigDecimal idAreaSIA) {
		this.idAreaSIA = idAreaSIA;
	}

	public BigDecimal getIdCargoSIA() {
		return idCargoSIA;
	}

	public void setIdCargoSIA(BigDecimal idCargoSIA) {
		this.idCargoSIA = idCargoSIA;
	}

	public String getNombreCargoSIA() {
		return nombreCargoSIA;
	}

	public void setNombreCargoSIA(String nombreCargoSIA) {
		this.nombreCargoSIA = nombreCargoSIA;
	}

	public String getNombreAreaSIA() {
		return nombreAreaSIA;
	}

	public void setNombreAreaSIA(String nombreAreaSIA) {
		this.nombreAreaSIA = nombreAreaSIA;
	}

	public BigDecimal getIdAreaSIGED() {
		return idAreaSIGED;
	}

	public void setIdAreaSIGED(BigDecimal idAreaSIGED) {
		this.idAreaSIGED = idAreaSIGED;
	}

	public BigDecimal getIdCargoSIGED() {
		if (UValidador.esNulo(idCargoSIGED)) {
			idCargoSIGED = BigDecimal.ZERO;
		}
		return idCargoSIGED;
	}

	public void setIdCargoSIGED(BigDecimal idCargoSIGED) {
		this.idCargoSIGED = idCargoSIGED;
	}

	public String getEsJefe() {
		return esJefe;
	}

	public void setEsJefe(String esJefe) {
		this.esJefe = esJefe;
	}

	public String getEstadoempleado() {
		return estadoempleado;
	}

	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

}
