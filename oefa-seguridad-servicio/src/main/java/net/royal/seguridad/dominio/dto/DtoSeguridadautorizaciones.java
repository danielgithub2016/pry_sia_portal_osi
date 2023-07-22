package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizaciones
*/
public class DtoSeguridadautorizaciones implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	private String usuario;
	private String opcionagregarflag;
	private String opcionmodificarflag;
	private String opcionborrarflag;
	private String estado;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;
	private String opcionaprobarflag;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
