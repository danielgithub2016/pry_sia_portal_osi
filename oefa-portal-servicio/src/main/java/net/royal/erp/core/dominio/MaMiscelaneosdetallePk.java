package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaMiscelaneosdetalle
*/
public class MaMiscelaneosdetallePk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String codigotabla;
	private String compania;
	private String codigoelemento;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getCodigotabla() {
		return codigotabla;
	}

	public void setCodigotabla(String codigotabla) {
		this.codigotabla = codigotabla;
	}
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getCodigoelemento() {
		return codigoelemento;
	}

	public void setCodigoelemento(String codigoelemento) {
		this.codigoelemento = codigoelemento;
	}

}
