package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Colormast
*/
public class Colormast extends DominioGenerico implements java.io.Serializable{

	private ColormastPk pk;
	private String descripcioncorta;
	private String descripcionextranjera;
	private String estado;


	public Colormast() {
		pk = new ColormastPk();
	}

	public ColormastPk getPk() {
		return pk;
	}

	public void setPk(ColormastPk pk) {
		this.pk = pk;
	}
	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
