package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;

public class DtoHrEmpleadoReclutamientoSelect {
	private BigDecimal persona;
	private String nombrecompleto;
	/**
	 * @return the persona
	 */
	public BigDecimal getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(BigDecimal persona) {
		this.persona = persona;
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
	
}
