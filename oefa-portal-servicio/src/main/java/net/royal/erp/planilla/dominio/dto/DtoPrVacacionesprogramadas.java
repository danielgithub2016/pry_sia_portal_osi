package net.royal.erp.planilla.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrVacacionesprogramadas
 */
public class DtoPrVacacionesprogramadas implements java.io.Serializable {

	private java.math.BigDecimal numeroperiodo;
	private java.math.BigDecimal empleado;
	private Integer secuencia;
	private Integer estadovacacion;
	private String periodo;
	private String periodoasistencia;
	private Integer diaspago;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String observacion;
	private Integer anovacacion;
	private String tipoutilizacion;
	private String estadoutilizacion;
	private String estado;

	private BigDecimal diasutiles;
	private BigDecimal diasutilizacion;

	public java.math.BigDecimal getNumeroperiodo() {
		if (UValidador.esNulo(numeroperiodo)) {
			numeroperiodo = BigDecimal.ZERO;
		}
		return numeroperiodo;
	}

	public void setNumeroperiodo(java.math.BigDecimal numeroperiodo) {
		this.numeroperiodo = numeroperiodo;
	}

	public java.math.BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(java.math.BigDecimal empleado) {
		this.empleado = empleado;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public Integer getEstadovacacion() {
		return estadovacacion;
	}

	public void setEstadovacacion(Integer estadovacacion) {
		this.estadovacacion = estadovacacion;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPeriodoasistencia() {
		return periodoasistencia;
	}

	public void setPeriodoasistencia(String periodoasistencia) {
		this.periodoasistencia = periodoasistencia;
	}

	public Integer getDiaspago() {
		return diaspago;
	}

	public void setDiaspago(Integer diaspago) {
		this.diaspago = diaspago;
	}

	public java.util.Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getAnovacacion() {
		return anovacacion;
	}

	public void setAnovacacion(Integer anovacacion) {
		this.anovacacion = anovacacion;
	}

	public String getTipoutilizacion() {
		return tipoutilizacion;
	}

	public void setTipoutilizacion(String tipoutilizacion) {
		this.tipoutilizacion = tipoutilizacion;
	}

	public String getEstadoutilizacion() {
		return estadoutilizacion;
	}

	public void setEstadoutilizacion(String estadoutilizacion) {
		this.estadoutilizacion = estadoutilizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getDiasutiles() {
		if (UValidador.esNulo(diasutiles)) {
			diasutiles = BigDecimal.ZERO;
		}
		return diasutiles;
	}

	public void setDiasutiles(BigDecimal diasutiles) {
		this.diasutiles = diasutiles;
	}

	public BigDecimal getDiasutilizacion() {
		if (UValidador.esNulo(diasutilizacion)) {
			diasutilizacion = BigDecimal.ZERO;
		}
		return diasutilizacion;
	}

	public void setDiasutilizacion(BigDecimal diasutilizacion) {
		this.diasutilizacion = diasutilizacion;
	}

}
