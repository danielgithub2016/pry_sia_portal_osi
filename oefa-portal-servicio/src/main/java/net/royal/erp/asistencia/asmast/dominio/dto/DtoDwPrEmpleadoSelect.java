package net.royal.erp.asistencia.asmast.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder asmast.dw_pr_empleado_select
 */
public class DtoDwPrEmpleadoSelect implements java.io.Serializable {
	private BigDecimal persona;
	private BigDecimal empleado;
	private String nombrecompleto;
	private String tipocontrato;
	private String personaant;
	private String estadoempleado;
	private String estado;
	private String centrocostos;
	private String companiasocio;
	private String tipoplanilla;
	private BigDecimal total;

	@Override
	public String toString() {
		return "DtoDwPrEmpleadoSelect [" + (persona != null ? "persona=" + persona + ", " : "")
				+ (empleado != null ? "empleado=" + empleado + ", " : "")
				+ (nombrecompleto != null ? "nombrecompleto=" + nombrecompleto + ", " : "")
				+ (tipocontrato != null ? "tipocontrato=" + tipocontrato + ", " : "")
				+ (personaant != null ? "personaant=" + personaant + ", " : "")
				+ (estadoempleado != null ? "estadoempleado=" + estadoempleado + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (centrocostos != null ? "centrocostos=" + centrocostos + ", " : "")
				+ (companiasocio != null ? "companiasocio=" + companiasocio + ", " : "")
				+ (tipoplanilla != null ? "tipoplanilla=" + tipoplanilla + ", " : "")
				+ (total != null ? "total=" + total : "") + "]";
	}

	public BigDecimal getPersona() {
		return persona;
	}

	public void setPersona(BigDecimal persona) {
		this.persona = persona;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public String getPersonaant() {
		return personaant;
	}

	public void setPersonaant(String personaant) {
		this.personaant = personaant;
	}

	public String getEstadoempleado() {
		return estadoempleado;
	}

	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
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

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}