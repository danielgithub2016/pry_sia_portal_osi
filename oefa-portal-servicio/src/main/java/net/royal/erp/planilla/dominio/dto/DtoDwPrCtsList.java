package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwPrCtsList implements Serializable {

	private BigDecimal empleado;
	private String personaant;
	private String nombrecompleto;
	private String companiaowner;
	private String estadoempleado;
	private String documento;
	
	private String unidadnegocio;
	private String estado;	
	private String descripcion;
	private String descripcionposicion;


	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getEstado() {
		if (UValidador.esNulo(estado)) {
			estado = "";
		}
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCompaniaowner() {
		return companiaowner;
	}

	public void setCompaniaowner(String companiaowner) {
		this.companiaowner = companiaowner;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionposicion() {
		return descripcionposicion;
	}

	public void setDescripcionposicion(String descripcionposicion) {
		this.descripcionposicion = descripcionposicion;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	
}
