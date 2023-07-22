package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyPreferences
*/
public class SyPreferences extends DominioGenerico implements java.io.Serializable{

	private SyPreferencesPk pk;
	private String tipovalor;
	private String valorstring;
	private Integer valornumero;
	private java.util.Date valorfecha;


	public SyPreferences() {
		pk = new SyPreferencesPk();
	}

	public SyPreferencesPk getPk() {
		return pk;
	}

	public void setPk(SyPreferencesPk pk) {
		this.pk = pk;
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
