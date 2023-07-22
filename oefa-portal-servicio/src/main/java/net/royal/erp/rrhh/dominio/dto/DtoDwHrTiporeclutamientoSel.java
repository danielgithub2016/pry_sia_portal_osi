package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoDwHrTiporeclutamientoSel implements Serializable {
	private BigDecimal tiporeclutamiento;
	private String descripcion;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;

	public BigDecimal getTiporeclutamiento() {
		return tiporeclutamiento;
	}

	public void setTiporeclutamiento(BigDecimal tiporeclutamiento) {
		this.tiporeclutamiento = tiporeclutamiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

}
