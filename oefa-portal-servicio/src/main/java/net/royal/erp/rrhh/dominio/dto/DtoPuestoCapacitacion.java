package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;

public class DtoPuestoCapacitacion {
    private BigDecimal puesto;
    private String compania;
    private BigDecimal secuencia;
    
	
	/**
	 * @return the compania
	 */
	public String getCompania() {
		return compania;
	}
	/**
	 * @param compania the compania to set
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}
	
	/**
	 * @return the puesto
	 */
	public BigDecimal getPuesto() {
		return puesto;
	}
	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(BigDecimal puesto) {
		this.puesto = puesto;
	}
	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}
	/**
	 * @param secuencia the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

}
