package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Pais
*/
public class Pais extends DominioGenerico implements java.io.Serializable{

	private PaisPk pk;
	private String descripcioncorta;
	private String descripcionlarga;
	private String descripcionextranjera;
	private String estado;
	private String nombre;
	private String nacionalidad;
	private String codigortps;


	public Pais() {
		pk = new PaisPk();
	}

	public PaisPk getPk() {
		return pk;
	}

	public void setPk(PaisPk pk) {
		this.pk = pk;
	}
	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}
	public String getDescripcionlarga() {
		return descripcionlarga;
	}

	public void setDescripcionlarga(String descripcionlarga) {
		this.descripcionlarga = descripcionlarga;
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
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getCodigortps() {
		return codigortps;
	}

	public void setCodigortps(String codigortps) {
		this.codigortps = codigortps;
	}

}
