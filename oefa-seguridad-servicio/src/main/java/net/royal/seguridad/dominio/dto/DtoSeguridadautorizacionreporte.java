package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacionreporte
*/
public class DtoSeguridadautorizacionreporte implements java.io.Serializable{

	private String usuario;
	private String aplicacioncodigo;
	private String reportecodigo;
	private String disponible;
	private java.util.Date ultimafechamodif;
	private String ultimousuario;
	private String campodata;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getReportecodigo() {
		return reportecodigo;
	}

	public void setReportecodigo(String reportecodigo) {
		this.reportecodigo = reportecodigo;
	}
	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public java.util.Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(java.util.Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public String getCampodata() {
		return campodata;
	}

	public void setCampodata(String campodata) {
		this.campodata = campodata;
	}

}
