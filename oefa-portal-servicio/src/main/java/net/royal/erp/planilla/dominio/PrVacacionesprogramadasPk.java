package net.royal.erp.planilla.dominio;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrVacacionesprogramadas
 */
public class PrVacacionesprogramadasPk implements java.io.Serializable {

	private java.math.BigDecimal numeroperiodo;
	private java.math.BigDecimal empleado;
	private BigDecimal secuencia;
	private BigDecimal estadovacacion;
	private String periodo;

	public java.math.BigDecimal getNumeroperiodo() {
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

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public BigDecimal getEstadovacacion() {
		return estadovacacion;
	}

	public void setEstadovacacion(BigDecimal estadovacacion) {
		this.estadovacacion = estadovacacion;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
