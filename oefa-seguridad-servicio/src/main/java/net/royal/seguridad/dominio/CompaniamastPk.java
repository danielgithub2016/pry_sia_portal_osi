package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companiamast
*/
public class CompaniamastPk implements java.io.Serializable{

	private String companiacodigo;
	private String monedapordefecto;

	public String getCompaniacodigo() {
		return companiacodigo;
	}

	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}
	public String getMonedapordefecto() {
		return monedapordefecto;
	}

	public void setMonedapordefecto(String monedapordefecto) {
		this.monedapordefecto = monedapordefecto;
	}

}
