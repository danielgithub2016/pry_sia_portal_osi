package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadconceptodetalle
*/
public class DtoSeguridadconceptodetalle implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	private String conceptocodigo;
	private String descripcion;
	private String nombredwselect;
	private String campodata;
	private String campovista;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;

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
	public String getConceptocodigo() {
		return conceptocodigo;
	}

	public void setConceptocodigo(String conceptocodigo) {
		this.conceptocodigo = conceptocodigo;
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
