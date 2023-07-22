package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadrango
*/
public class SySeguridadrango extends DominioGenerico implements java.io.Serializable{

	private SySeguridadrangoPk pk;
	private String descripcion;
	private java.util.Date fecharegistrod;
	private java.util.Date fecharegistroh;
	private java.util.Date fechaaprobaciond;
	private java.util.Date fechaaprobacionh;


	public SySeguridadrango() {
		pk = new SySeguridadrangoPk();
	}

	public SySeguridadrangoPk getPk() {
		return pk;
	}

	public void setPk(SySeguridadrangoPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public java.util.Date getFecharegistrod() {
		return fecharegistrod;
	}

	public void setFecharegistrod(java.util.Date fecharegistrod) {
		this.fecharegistrod = fecharegistrod;
	}
	public java.util.Date getFecharegistroh() {
		return fecharegistroh;
	}

	public void setFecharegistroh(java.util.Date fecharegistroh) {
		this.fecharegistroh = fecharegistroh;
	}
	public java.util.Date getFechaaprobaciond() {
		return fechaaprobaciond;
	}

	public void setFechaaprobaciond(java.util.Date fechaaprobaciond) {
		this.fechaaprobaciond = fechaaprobaciond;
	}
	public java.util.Date getFechaaprobacionh() {
		return fechaaprobacionh;
	}

	public void setFechaaprobacionh(java.util.Date fechaaprobacionh) {
		this.fechaaprobacionh = fechaaprobacionh;
	}

}
