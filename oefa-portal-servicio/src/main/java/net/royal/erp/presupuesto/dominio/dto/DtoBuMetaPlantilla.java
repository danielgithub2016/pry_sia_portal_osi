package net.royal.erp.presupuesto.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuMeta
 */
public class DtoBuMetaPlantilla implements java.io.Serializable {

	private BigDecimal secuencia;
	private String item;
	private String ano;
	private Integer meta;
	private String metaaux;
	private String descripcion;
	private BigDecimal cantidad;
	private String estado;
	private String unidad;
	private String unidadnombre;

	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * @param ano
	 *            the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}

	/**
	 * @return the meta
	 */
	public Integer getMeta() {
		return meta;
	}

	/**
	 * @param meta
	 *            the meta to set
	 */
	public void setMeta(Integer meta) {
		this.meta = meta;
	}

	/**
	 * @return the metaaux
	 */
	public String getMetaaux() {
		return metaaux;
	}

	/**
	 * @param metaaux
	 *            the metaaux to set
	 */
	public void setMetaaux(String metaaux) {
		this.metaaux = metaaux;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cantidad
	 */
	public BigDecimal getCantidad() {
		if (UValidador.esNulo(cantidad)) {
			cantidad = BigDecimal.ZERO;
		}
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * @return the unidadnombre
	 */
	public String getUnidadnombre() {
		return unidadnombre;
	}

	/**
	 * @param unidadnombre the unidadnombre to set
	 */
	public void setUnidadnombre(String unidadnombre) {
		this.unidadnombre = unidadnombre;
	}

}
