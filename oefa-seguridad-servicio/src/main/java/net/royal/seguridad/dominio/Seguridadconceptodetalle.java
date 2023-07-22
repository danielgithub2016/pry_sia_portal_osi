package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadconceptodetalle
*/
public class Seguridadconceptodetalle extends DominioGenerico implements java.io.Serializable{

	private SeguridadconceptodetallePk pk;
	private String descripcion;
	private String nombredwselect;
	private String campodata;
	private String campovista;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;


	public Seguridadconceptodetalle() {
		pk = new SeguridadconceptodetallePk();
	}

	public SeguridadconceptodetallePk getPk() {
		return pk;
	}

	public void setPk(SeguridadconceptodetallePk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombredwselect() {
		return nombredwselect;
	}

	public void setNombredwselect(String nombredwselect) {
		this.nombredwselect = nombredwselect;
	}
	public String getCampodata() {
		return campodata;
	}

	public void setCampodata(String campodata) {
		this.campodata = campodata;
	}
	public String getCampovista() {
		return campovista;
	}

	public void setCampovista(String campovista) {
		this.campovista = campovista;
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
