package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizaciones
*/
public class Seguridadautorizaciones extends DominioGenerico implements java.io.Serializable{

	private SeguridadautorizacionesPk pk;
	private String opcionagregarflag;
	private String opcionmodificarflag;
	private String opcionborrarflag;
	private String estado;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;
	private String opcionaprobarflag;


	public Seguridadautorizaciones() {
		pk = new SeguridadautorizacionesPk();
	}

	public SeguridadautorizacionesPk getPk() {
		return pk;
	}

	public void setPk(SeguridadautorizacionesPk pk) {
		this.pk = pk;
	}
	public String getOpcionagregarflag() {
		return opcionagregarflag;
	}

	public void setOpcionagregarflag(String opcionagregarflag) {
		this.opcionagregarflag = opcionagregarflag;
	}
	public String getOpcionmodificarflag() {
		return opcionmodificarflag;
	}

	public void setOpcionmodificarflag(String opcionmodificarflag) {
		this.opcionmodificarflag = opcionmodificarflag;
	}
	public String getOpcionborrarflag() {
		return opcionborrarflag;
	}

	public void setOpcionborrarflag(String opcionborrarflag) {
		this.opcionborrarflag = opcionborrarflag;
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
	public java.util.Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(java.util.Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	public String getOpcionaprobarflag() {
		return opcionaprobarflag;
	}

	public void setOpcionaprobarflag(String opcionaprobarflag) {
		this.opcionaprobarflag = opcionaprobarflag;
	}

}
