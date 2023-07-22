package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DtoHrEvaluacion implements Serializable {
	
	private BigDecimal evaluacion;
	private String descripcion;
	private String unidadnegocio;
	private String unidadreplicacion;
	private Integer puntajeminimo;
	private Integer puntajemaximo;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String plantillaevaluacion;
	private String flagempleadomast;
	private String flagperfil;
	private String tipoeval;

	
	
	public BigDecimal getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(BigDecimal evaluacion) {
		this.evaluacion = evaluacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}
	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}
	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public Integer getPuntajeminimo() {
		return puntajeminimo;
	}
	public void setPuntajeminimo(Integer puntajeminimo) {
		this.puntajeminimo = puntajeminimo;
	}
	public Integer getPuntajemaximo() {
		return puntajemaximo;
	}
	public void setPuntajemaximo(Integer puntajemaximo) {
		this.puntajemaximo = puntajemaximo;
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
	public String getPlantillaevaluacion() {
		return plantillaevaluacion;
	}
	public void setPlantillaevaluacion(String plantillaevaluacion) {
		this.plantillaevaluacion = plantillaevaluacion;
	}
	public String getFlagempleadomast() {
		return flagempleadomast;
	}
	public void setFlagempleadomast(String flagempleadomast) {
		this.flagempleadomast = flagempleadomast;
	}
	public String getFlagperfil() {
		return flagperfil;
	}
	public void setFlagperfil(String flagperfil) {
		this.flagperfil = flagperfil;
	}
	public String getTipoeval() {
		return tipoeval;
	}
	public void setTipoeval(String tipoeval) {
		this.tipoeval = tipoeval;
	}

	



}
