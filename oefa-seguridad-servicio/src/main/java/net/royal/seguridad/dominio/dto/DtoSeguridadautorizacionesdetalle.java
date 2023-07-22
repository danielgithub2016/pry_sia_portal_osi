package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacionesdetalle
*/
public class DtoSeguridadautorizacionesdetalle implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	private String detallecodigo;
	private String usuario;
	private String conceptocodigo;
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
	public String getDetallecodigo() {
		return detallecodigo;
	}

	public void setDetallecodigo(String detallecodigo) {
		this.detallecodigo = detallecodigo;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
