package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoHrEvaluacionCapacValor implements Serializable {

	private BigDecimal evaluacion;
	private BigDecimal secuencia;
	private BigDecimal valor;
	private String descripcion;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String flagaprobado;

	private BigDecimal total;
	private boolean boolflagaprobado;

	public BigDecimal getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(BigDecimal evaluacion) {
		this.evaluacion = evaluacion;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getFlagaprobado() {
		return flagaprobado;
	}

	public void setFlagaprobado(String flagaprobado) {
		this.flagaprobado = flagaprobado;
	}

	public boolean isBoolflagaprobado() {
		if(!UValidador.estaVacio(flagaprobado)){
			if(flagaprobado.equals("S")){
				boolflagaprobado=true;
			}else {
				boolflagaprobado=false;
			}
		}else {
			boolflagaprobado=false;
		}
		
		return boolflagaprobado;
	}

	public void setBoolflagaprobado(boolean boolflagaprobado) {
		this.boolflagaprobado = boolflagaprobado;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
