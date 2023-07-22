package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_importacion_detail_select
 */
public class DtoDwWhImportacionDetailSelect implements java.io.Serializable {
	private String item;
	private String condicion;
	private String descripcionlocal;
	private BigDecimal cantidad;
	private String unidadcodigo;
	private BigDecimal secuencia;
	private String companiasocio;
	private String numerodocumento;
	private String tipodocumento;
	private String referencianumerodocumento;
	private BigDecimal referenciasecuencia;
	private BigDecimal preciounitario;
	private BigDecimal total;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidadcodigo() {
		return unidadcodigo;
	}

	public void setUnidadcodigo(String unidadcodigo) {
		this.unidadcodigo = unidadcodigo;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getReferencianumerodocumento() {
		return referencianumerodocumento;
	}

	public void setReferencianumerodocumento(String referencianumerodocumento) {
		this.referencianumerodocumento = referencianumerodocumento;
	}

	public BigDecimal getReferenciasecuencia() {
		return referenciasecuencia;
	}

	public void setReferenciasecuencia(BigDecimal referenciasecuencia) {
		this.referenciasecuencia = referenciasecuencia;
	}

	public BigDecimal getPreciounitario() {
		return preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


}
