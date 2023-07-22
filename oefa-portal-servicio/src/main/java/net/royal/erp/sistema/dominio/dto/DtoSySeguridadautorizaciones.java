package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadautorizaciones
*/
public class DtoSySeguridadautorizaciones implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	private String usuario;
	private String masterbrowseflag;
	private String masterupdateflag;
	private String estado;
	private String masterapproveflag;

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
	public String getMasterbrowseflag() {
		return masterbrowseflag;
	}

	public void setMasterbrowseflag(String masterbrowseflag) {
		this.masterbrowseflag = masterbrowseflag;
	}
	public String getMasterupdateflag() {
		return masterupdateflag;
	}

	public void setMasterupdateflag(String masterupdateflag) {
		this.masterupdateflag = masterupdateflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMasterapproveflag() {
		return masterapproveflag;
	}

	public void setMasterapproveflag(String masterapproveflag) {
		this.masterapproveflag = masterapproveflag;
	}

}
