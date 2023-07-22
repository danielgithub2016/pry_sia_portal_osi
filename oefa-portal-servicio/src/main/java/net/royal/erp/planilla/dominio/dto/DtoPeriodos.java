package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoPeriodos implements Serializable {

	private BigDecimal numerocts;
	private String regimen;
	private String descripcion;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private java.util.Date fechapago;
	private String estado;
	private String estadocts;
	private String periodoplanilla;
	private java.math.BigDecimal tasaefectivaanual;
	
	public BigDecimal getNumerocts() {
		return numerocts;
	}
	public void setNumerocts(BigDecimal numerocts) {
		this.numerocts = numerocts;
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public java.util.Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public java.util.Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}
	public java.util.Date getFechapago() {
		return fechapago;
	}
	public void setFechapago(java.util.Date fechapago) {
		this.fechapago = fechapago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadocts() {
		return estadocts;
	}
	public void setEstadocts(String estadocts) {
		this.estadocts = estadocts;
	}
	public String getPeriodoplanilla() {
		return periodoplanilla;
	}
	public void setPeriodoplanilla(String periodoplanilla) {
		this.periodoplanilla = periodoplanilla;
	}
	public java.math.BigDecimal getTasaefectivaanual() {
		return tasaefectivaanual;
	}
	public void setTasaefectivaanual(java.math.BigDecimal tasaefectivaanual) {
		this.tasaefectivaanual = tasaefectivaanual;
	}


	

	
}
