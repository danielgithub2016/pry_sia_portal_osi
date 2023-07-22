package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoDwHrCompetenciasList implements Serializable  {
	private Date fecha;
	private String tipo;
	private BigDecimal secuencia;
	private String companyowner;
	private BigDecimal empleado;
	private String nombreeval;
	private String nombrecompleto;
	
	public Date getFecha() {
		return fecha;
	}
	public String getTipo() {
		return tipo;
	}

	public String getCompanyowner() {
		return companyowner;
	}
	public String getNombreeval() {
		return nombreeval;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public void setNombreeval(String nombreeval) {
		this.nombreeval = nombreeval;
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
	public BigDecimal getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}




}
