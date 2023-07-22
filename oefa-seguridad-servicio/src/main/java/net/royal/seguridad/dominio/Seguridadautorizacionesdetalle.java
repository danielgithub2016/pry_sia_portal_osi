package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacionesdetalle
*/
public class Seguridadautorizacionesdetalle extends DominioGenerico implements java.io.Serializable{

	private SeguridadautorizacionesdetallePk pk;
	private String conceptocodigo;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;


	public Seguridadautorizacionesdetalle() {
		pk = new SeguridadautorizacionesdetallePk();
	}

	public SeguridadautorizacionesdetallePk getPk() {
		return pk;
	}

	public void setPk(SeguridadautorizacionesdetallePk pk) {
		this.pk = pk;
	}
	public String getConceptocodigo() {
		return conceptocodigo;
	}

	public void setConceptocodigo(String conceptocodigo) {
		this.conceptocodigo = conceptocodigo;
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
