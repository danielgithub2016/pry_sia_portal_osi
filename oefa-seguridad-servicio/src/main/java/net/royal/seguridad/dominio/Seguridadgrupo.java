package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadgrupo
*/
public class Seguridadgrupo extends DominioGenerico implements java.io.Serializable{

	private SeguridadgrupoPk pk;
	private String descripcion;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;


	public Seguridadgrupo() {
		pk = new SeguridadgrupoPk();
	}

	public SeguridadgrupoPk getPk() {
		return pk;
	}

	public void setPk(SeguridadgrupoPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public java.util.Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(java.util.Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

}
