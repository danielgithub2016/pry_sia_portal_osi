package net.royal.erp.presupuesto.dominio.dto;

import java.math.BigDecimal;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuMeta
 */
public class DtoBuMeta implements java.io.Serializable {

	private String companiasocio;
	private String ano;
	private Integer meta;
	private String metaaux;
	private String descripcion;
	private String estado;
	private String ubicacion;
	private String flgdecimal;
	private BigDecimal meta2;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getMeta() {
		return meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
	}

	public String getMetaaux() {
		return metaaux;
	}

	public void setMetaaux(String metaaux) {
		this.metaaux = metaaux;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getFlgdecimal() {
		return flgdecimal;
	}

	public void setFlgdecimal(String flgdecimal) {
		this.flgdecimal = flgdecimal;
	}

	/**
	 * @return the meta2
	 */
	public BigDecimal getMeta2() {
		return meta2;
	}

	/**
	 * @param meta2 the meta2 to set
	 */
	public void setMeta2(BigDecimal meta2) {
		this.meta2 = meta2;
	}
	
}
