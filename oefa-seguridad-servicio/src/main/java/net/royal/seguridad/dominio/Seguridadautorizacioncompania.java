package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacioncompania
*/
public class Seguridadautorizacioncompania extends DominioGenerico implements java.io.Serializable{

	private SeguridadautorizacioncompaniaPk pk;
	private String estado;
	private java.util.Date ultimafechamodif;
	private String ultimousuario;
	private String campodata;


	public Seguridadautorizacioncompania() {
		pk = new SeguridadautorizacioncompaniaPk();
	}

	public SeguridadautorizacioncompaniaPk getPk() {
		return pk;
	}

	public void setPk(SeguridadautorizacioncompaniaPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
