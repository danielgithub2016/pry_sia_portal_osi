package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacionreporte
*/
public class Seguridadautorizacionreporte extends DominioGenerico implements java.io.Serializable{

	private SeguridadautorizacionreportePk pk;
	private String disponible;
	private java.util.Date ultimafechamodif;
	private String ultimousuario;
	private String campodata;


	public Seguridadautorizacionreporte() {
		pk = new SeguridadautorizacionreportePk();
	}

	public SeguridadautorizacionreportePk getPk() {
		return pk;
	}

	public void setPk(SeguridadautorizacionreportePk pk) {
		this.pk = pk;
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
