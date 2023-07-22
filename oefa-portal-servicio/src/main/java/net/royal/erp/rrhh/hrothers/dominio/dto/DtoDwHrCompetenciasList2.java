package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoDwHrCompetenciasList2 implements Serializable {
	private String requerimiento;
	private BigDecimal secuencia;
	private String companyowner;
	private BigDecimal evaluacion;
	private BigDecimal valorrequerido;
	private BigDecimal valorminimoesperado;
	private BigDecimal valor;
	private String descripcionarea;
	private String area;
	private String descripcionfactor;
	private BigDecimal factor;
	private BigDecimal ordenplanillafactor;
	private String tipocompetenciafactor;
	private String nombreeval;
	private String tipo;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public BigDecimal getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(BigDecimal evaluacion) {
		this.evaluacion = evaluacion;
	}

	public BigDecimal getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}

	public BigDecimal getValorminimoesperado() {
		return valorminimoesperado;
	}

	public void setValorminimoesperado(BigDecimal valorminimoesperado) {
		this.valorminimoesperado = valorminimoesperado;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescripcionarea() {
		return descripcionarea;
	}

	public void setDescripcionarea(String descripcionarea) {
		this.descripcionarea = descripcionarea;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescripcionfactor() {
		return descripcionfactor;
	}

	public void setDescripcionfactor(String descripcionfactor) {
		this.descripcionfactor = descripcionfactor;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public BigDecimal getOrdenplanillafactor() {
		return ordenplanillafactor;
	}

	public void setOrdenplanillafactor(BigDecimal ordenplanillafactor) {
		this.ordenplanillafactor = ordenplanillafactor;
	}

	public String getTipocompetenciafactor() {
		return tipocompetenciafactor;
	}

	public void setTipocompetenciafactor(String tipocompetenciafactor) {
		this.tipocompetenciafactor = tipocompetenciafactor;
	}

	public String getNombreeval() {
		return nombreeval;
	}

	public void setNombreeval(String nombreeval) {
		this.nombreeval = nombreeval;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



}
