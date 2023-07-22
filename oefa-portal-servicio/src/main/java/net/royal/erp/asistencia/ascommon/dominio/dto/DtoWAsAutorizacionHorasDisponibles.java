package net.royal.erp.asistencia.ascommon.dominio.dto;

import java.math.BigDecimal;

public class DtoWAsAutorizacionHorasDisponibles {

	private BigDecimal contador;
	private BigDecimal saldoinicial;
	private String compute1;
	
	/**
	 * @return the contador
	 */
	public BigDecimal getContador() {
		return contador;
	}
	/**
	 * @param contador the contador to set
	 */
	public void setContador(BigDecimal contador) {
		this.contador = contador;
	}
	/**
	 * @return the saldoinicial
	 */
	public BigDecimal getSaldoinicial() {
		return saldoinicial;
	}
	/**
	 * @param saldoinicial the saldoinicial to set
	 */
	public void setSaldoinicial(BigDecimal saldoinicial) {
		this.saldoinicial = saldoinicial;
	}
	/**
	 * @return the compute1
	 */
	public String getCompute1() {
		return compute1;
	}
	/**
	 * @param compute1 the compute1 to set
	 */
	public void setCompute1(String compute1) {
		this.compute1 = compute1;
	}
	
}
