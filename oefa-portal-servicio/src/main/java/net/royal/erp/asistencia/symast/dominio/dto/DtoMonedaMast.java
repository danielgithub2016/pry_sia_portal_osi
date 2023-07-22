package net.royal.erp.asistencia.symast.dominio.dto;

import java.util.Date;

public class DtoMonedaMast {
	private String monedacodigo;
	private String descripcioncorta;
	private String sigla;
	private String descripcionextranjera;
	private String estado;
	private Date ultimafechamodif;
	private String ultimousuario;
	private String codigofiscal;
	
	public String getMonedacodigo() {
		return monedacodigo;
	}
	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}
	public String getDescripcioncorta() {
		return descripcioncorta;
	}
	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}
	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	public String getUltimousuario() {
		return ultimousuario;
	}
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public String getCodigofiscal() {
		return codigofiscal;
	}
	public void setCodigofiscal(String codigofiscal) {
		this.codigofiscal = codigofiscal;
	}
	
}
