package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DtoDwHrPuestoFuncionesList implements Serializable {
	private BigDecimal codigofuncion;
	private BigDecimal codigopuesto;
	private String puesto;
	private String descripcion;
	private String descripcioningles;
	private String comentarios;
	private String estado;
	private String ultimousuario;
	private Date ultimofechamodif;
	private String unidadreplicacion;
	private BigDecimal factorparticipacion;

	public BigDecimal getCodigofuncion() {
		return codigofuncion;
	}

	public void setCodigofuncion(BigDecimal codigofuncion) {
		this.codigofuncion = codigofuncion;
	}

	public BigDecimal getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(BigDecimal codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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

	public Date getUltimofechamodif() {
		return ultimofechamodif;
	}

	public void setUltimofechamodif(Date ultimofechamodif) {
		this.ultimofechamodif = ultimofechamodif;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public BigDecimal getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(BigDecimal factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}


}
