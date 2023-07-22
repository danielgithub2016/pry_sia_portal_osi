package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Tipocambiomast
*/
public class TipocambiomastPk implements java.io.Serializable{

	private String monedacodigo;
	private String monedacambiocodigo;
	private java.util.Date fechacambio;

	public String getMonedacodigo() {
		return monedacodigo;
	}

	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}
	public String getMonedacambiocodigo() {
		return monedacambiocodigo;
	}

	public void setMonedacambiocodigo(String monedacambiocodigo) {
		this.monedacambiocodigo = monedacambiocodigo;
	}
	public java.util.Date getFechacambio() {
		return fechacambio;
	}

	public void setFechacambio(java.util.Date fechacambio) {
		this.fechacambio = fechacambio;
	}

}
