package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoDwMetasEmpleado implements Serializable {
	private BigDecimal secuencia;
	private String descripcion;
	private BigDecimal factorparticipacion;
	private String estado;
	private String periodo;
	private BigDecimal secuenciaEval;

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(BigDecimal factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public BigDecimal getSecuenciaEval() {
		return secuenciaEval;
	}

	public void setSecuenciaEval(BigDecimal secuenciaEval) {
		this.secuenciaEval = secuenciaEval;
	}

}
