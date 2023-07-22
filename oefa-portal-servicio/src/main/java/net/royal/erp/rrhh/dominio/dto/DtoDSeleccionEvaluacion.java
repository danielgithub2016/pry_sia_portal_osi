package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author nunezh
 * @powerbuilder hrmast.d_seleccion_evaluacion
 * */
public class DtoDSeleccionEvaluacion implements Serializable{
	private String area;
	private String descripcion;
	private BigDecimal valorequerido;
	private BigDecimal valor;
	private BigDecimal valorhasta;
	private String flagcalificacion;
	private BigDecimal factor;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getValorequerido() {
		return valorequerido;
	}

	public void setValorequerido(BigDecimal valorequerido) {
		this.valorequerido = valorequerido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorhasta() {
		return valorhasta;
	}

	public void setValorhasta(BigDecimal valorhasta) {
		this.valorhasta = valorhasta;
	}

	public String getFlagcalificacion() {
		return flagcalificacion;
	}

	public void setFlagcalificacion(String flagcalificacion) {
		this.flagcalificacion = flagcalificacion;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}


}
