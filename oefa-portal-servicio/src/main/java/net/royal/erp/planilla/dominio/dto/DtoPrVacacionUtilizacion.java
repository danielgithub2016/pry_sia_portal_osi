package net.royal.erp.planilla.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoPrVacacionUtilizacion {

	private BigDecimal pendientes;
	private BigDecimal nroperiodo;
	private BigDecimal derecho;
	private Date fechainicio;
	private Date fechafin;
	private String utilizacion;
	private String utilizacionNombre;
	private BigDecimal dias;
	private String ultimoUsuario;
	private Date ultimaFecha;

	public BigDecimal getPendientes() {
		if (UValidador.esNulo(pendientes)) {
			pendientes = BigDecimal.ZERO;
		}
		return pendientes;
	}

	public void setPendientes(BigDecimal pendientes) {
		this.pendientes = pendientes;
	}

	public BigDecimal getNroperiodo() {
		if (UValidador.esNulo(nroperiodo)) {
			nroperiodo = BigDecimal.ZERO;
		}
		return nroperiodo;
	}

	public void setNroperiodo(BigDecimal nroperiodo) {
		this.nroperiodo = nroperiodo;
	}

	public BigDecimal getDerecho() {
		return derecho;
	}

	public void setDerecho(BigDecimal derecho) {
		this.derecho = derecho;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getUtilizacion() {
		return utilizacion;
	}

	public void setUtilizacion(String utilizacion) {
		this.utilizacion = utilizacion;
	}

	public String getUtilizacionNombre() {
		return utilizacionNombre;
	}

	public void setUtilizacionNombre(String utilizacionNombre) {
		this.utilizacionNombre = utilizacionNombre;
	}

	public BigDecimal getDias() {
		return dias;
	}

	public void setDias(BigDecimal dias) {
		this.dias = dias;
	}

	public String getUltimoUsuario() {
		return ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	public Date getUltimaFecha() {
		return ultimaFecha;
	}

	public void setUltimaFecha(Date ultimaFecha) {
		this.ultimaFecha = ultimaFecha;
	}

}
