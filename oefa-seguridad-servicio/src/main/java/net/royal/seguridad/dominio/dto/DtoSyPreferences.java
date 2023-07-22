package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyPreferences
*/
public class DtoSyPreferences implements java.io.Serializable{

	private String usuario;
	private String preference;
	private String aplicacioncodigo;
	private String tipovalor;
	private String valorstring;
	private Integer valornumero;
	private java.util.Date valorfecha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getTipovalor() {
		return tipovalor;
	}

	public void setTipovalor(String tipovalor) {
		this.tipovalor = tipovalor;
	}
	public String getValorstring() {
		return valorstring;
	}

	public void setValorstring(String valorstring) {
		this.valorstring = valorstring;
	}
	public Integer getValornumero() {
		return valornumero;
	}

	public void setValornumero(Integer valornumero) {
		this.valornumero = valornumero;
	}
	public java.util.Date getValorfecha() {
		return valorfecha;
	}

	public void setValorfecha(java.util.Date valorfecha) {
		this.valorfecha = valorfecha;
	}

}
