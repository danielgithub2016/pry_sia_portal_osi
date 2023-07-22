package net.royal.erp.asistencia.asmast.dominio.dto;

import java.math.BigDecimal;


/**
 *
 * @author desarrollo
 * @powerbuilder asmast.dddw_as_empleadosmast_select_carnets
 */
public class DtoDddwAsEmpleadosmastSelectCarnets implements
		java.io.Serializable {
	
	private BigDecimal persona;
	private String nombrecompleto;
	private String companiasocio;
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
	/**
	 * @return the companiasocio
	 */
	public String getCompaniasocio() {
		return companiasocio;
	}
	/**
	 * @param companiasocio the companiasocio to set
	 */
	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	
}
