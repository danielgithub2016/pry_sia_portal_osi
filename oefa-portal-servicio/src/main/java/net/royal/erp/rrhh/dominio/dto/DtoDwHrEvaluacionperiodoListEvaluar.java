package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Data Transfer Object DtoDwHrEvaluacionperiodoListEvaluar.
 * 
 * @powerbuilder dw_hr_evaluacionperiodo_list_evaluar
 * @author nunezh
 */
@SuppressWarnings("serial")
public class DtoDwHrEvaluacionperiodoListEvaluar implements Serializable {
	private BigDecimal empleado;
	private String nombrecompleto;
	private BigDecimal secuenciaeval;
	private String periodo;
	private BigDecimal totalpuntos;
	private String companyowner;
	private Date fechaevaluacion;
	private String estado;
	private String centrocostos;
	private String localname;
	private String personaant;
	private BigDecimal contador;
	private BigDecimal empleadoevaluador;
	private String tipo;
	private String tipoevaluador;

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public BigDecimal getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(BigDecimal secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public BigDecimal getTotalpuntos() {
		return totalpuntos;
	}

	public void setTotalpuntos(BigDecimal totalpuntos) {
		this.totalpuntos = totalpuntos;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public Date getFechaevaluacion() {
		return fechaevaluacion;
	}

	public void setFechaevaluacion(Date fechaevaluacion) {
		this.fechaevaluacion = fechaevaluacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getPersonaant() {
		return personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}

	public BigDecimal getContador() {
		return contador;
	}

	public void setContador(BigDecimal contador) {
		this.contador = contador;
	}

	public BigDecimal getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(BigDecimal empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoevaluador() {
		return tipoevaluador;
	}

	public void setTipoevaluador(String tipoevaluador) {
		this.tipoevaluador = tipoevaluador;
	}

}
