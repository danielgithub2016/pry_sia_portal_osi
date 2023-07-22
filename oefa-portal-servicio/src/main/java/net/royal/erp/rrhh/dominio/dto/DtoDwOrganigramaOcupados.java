package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;

public class DtoDwOrganigramaOcupados {

	private BigDecimal codigoempleado;
	private String nombrecompleto;
	private BigDecimal cantidad;
	/**
	 * @return the codigoempleado
	 */
	public BigDecimal getCodigoempleado() {
		return codigoempleado;
	}
	/**
	 * @param codigoempleado the codigoempleado to set
	 */
	public void setCodigoempleado(BigDecimal codigoempleado) {
		this.codigoempleado = codigoempleado;
	}
	/**
	 * @return the nombrecompleto
	 */
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	/**
	 * @param nombrecompleto the nombrecompleto to set
	 */
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

}
