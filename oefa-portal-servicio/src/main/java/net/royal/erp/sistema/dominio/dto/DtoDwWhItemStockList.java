package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_item_stock_list
 */
public class DtoDwWhItemStockList implements java.io.Serializable {
	private String almacencodigo;
	private String lote;
	private BigDecimal stockactual;
	private String descripcionlocal;
	private String condicion;
	private String item;
	private BigDecimal stockactualdoble;
	private Date fechaingreso;
	private Date fechavencimiento;
	private String loteequivalente;
	private String almacenregion;
	private String tipoalmacen;
	private String almacenventaflag;
	private String almacenproduccionflag;
	private String almacenconsignacionflag;
	private String unidadnegocio;
	private BigDecimal rowkey;

	
	// Variables que no estan en el query pero seran usadas para ser
	// reemplazados por checkbox
	private Boolean almacenventaflagBoolean;
	private Boolean almacenproduccionflagBoolean;
	private Boolean almacenconsignacionflagBoolean;

	
	public String getAlmacencodigo() {
		return almacencodigo;
	}

	public void setAlmacencodigo(String almacencodigo) {
		this.almacencodigo = almacencodigo;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public BigDecimal getStockactual() {
		return stockactual;
	}

	public void setStockactual(BigDecimal stockactual) {
		this.stockactual = stockactual;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getStockactualdoble() {
		return stockactualdoble;
	}

	public void setStockactualdoble(BigDecimal stockactualdoble) {
		this.stockactualdoble = stockactualdoble;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public String getLoteequivalente() {
		return loteequivalente;
	}

	public void setLoteequivalente(String loteequivalente) {
		this.loteequivalente = loteequivalente;
	}

	public String getAlmacenregion() {
		return almacenregion;
	}

	public void setAlmacenregion(String almacenregion) {
		this.almacenregion = almacenregion;
	}

	public String getTipoalmacen() {
		return tipoalmacen;
	}

	public void setTipoalmacen(String tipoalmacen) {
		this.tipoalmacen = tipoalmacen;
	}

	public String getAlmacenventaflag() {
		return almacenventaflag;
	}

	public void setAlmacenventaflag(String almacenventaflag) {
		this.almacenventaflag = almacenventaflag;
	}

	public String getAlmacenproduccionflag() {
		return almacenproduccionflag;
	}

	public void setAlmacenproduccionflag(String almacenproduccionflag) {
		this.almacenproduccionflag = almacenproduccionflag;
	}

	public String getAlmacenconsignacionflag() {
		return almacenconsignacionflag;
	}

	public void setAlmacenconsignacionflag(String almacenconsignacionflag) {
		this.almacenconsignacionflag = almacenconsignacionflag;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public BigDecimal getRowkey() {
		return rowkey;
	}

	public void setRowkey(BigDecimal rowkey) {
		this.rowkey = rowkey;
	}

	public Boolean getAlmacenventaflagBoolean() {
		if (!UValidador.esNulo(almacenventaflag)) {
			if (almacenventaflag.equals("N")) {
				almacenventaflagBoolean = false;
			} else {
				almacenventaflagBoolean = true;
			}
		}
		return almacenventaflagBoolean;
	}

	public void setAlmacenventaflagBoolean(Boolean almacenventaflagBoolean) {
		this.almacenventaflagBoolean = almacenventaflagBoolean;
	}

	public Boolean getAlmacenproduccionflagBoolean() {
		if (!UValidador.esNulo(almacenproduccionflag)) {
			if (almacenproduccionflag.equals("N")) {
				almacenproduccionflagBoolean = false;
			} else {
				almacenproduccionflagBoolean = true;
			}
		}
		return almacenproduccionflagBoolean;
	}

	public void setAlmacenproduccionflagBoolean(Boolean almacenproduccionflagBoolean) {
		this.almacenproduccionflagBoolean = almacenproduccionflagBoolean;
	}

	public Boolean getAlmacenconsignacionflagBoolean() {
		if (!UValidador.esNulo(almacenconsignacionflag)) {
			if (almacenconsignacionflag.equals("N")) {
				almacenconsignacionflagBoolean = false;
			} else {
				almacenconsignacionflagBoolean = true;
			}
		}
		return almacenconsignacionflagBoolean;
	}

	public void setAlmacenconsignacionflagBoolean(
			Boolean almacenconsignacionflagBoolean) {
		this.almacenconsignacionflagBoolean = almacenconsignacionflagBoolean;
	}

}
