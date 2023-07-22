package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Unidadesmast
*/
public class Unidadesmast extends DominioGenerico implements java.io.Serializable{

	private UnidadesmastPk pk;
	private String descripcioncorta;
	private String descripcionextranjera;
	private String unidadtipo;
	private Integer numerodecimales;
	private String estado;
	private String codigofiscal;


	public Unidadesmast() {
		pk = new UnidadesmastPk();
	}

	public UnidadesmastPk getPk() {
		return pk;
	}

	public void setPk(UnidadesmastPk pk) {
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
	public String getUnidadtipo() {
		return unidadtipo;
	}

	public void setUnidadtipo(String unidadtipo) {
		this.unidadtipo = unidadtipo;
	}
	public Integer getNumerodecimales() {
		return numerodecimales;
	}

	public void setNumerodecimales(Integer numerodecimales) {
		this.numerodecimales = numerodecimales;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigofiscal() {
		return codigofiscal;
	}

	public void setCodigofiscal(String codigofiscal) {
		this.codigofiscal = codigofiscal;
	}

}
