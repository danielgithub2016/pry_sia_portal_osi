package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoDwFuncionesXEmpleado implements Serializable {
	private BigDecimal codigofuncion;
	private String comentarios;
	private String funcion;
	private BigDecimal factorparticipacion;
	private String estado;
	private String periodo;
	private BigDecimal secuenciaEval;

	public BigDecimal getCodigofuncion() {
		return codigofuncion;
	}

	public void setCodigofuncion(BigDecimal codigofuncion) {
		this.codigofuncion = codigofuncion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
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
