package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_item_stock_direcciondestino
 */
public class DtoDwWhItemStockDirecciondestino implements java.io.Serializable {
	private String direcciondestino;
	private String item;
	private String descripcionlocal;
	private BigDecimal sumcantidad;


	public String getDirecciondestino() {
		return direcciondestino;
	}

	public void setDirecciondestino(String direcciondestino) {
		this.direcciondestino = direcciondestino;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public BigDecimal getSumcantidad() {
		return sumcantidad;
	}

	public void setSumcantidad(BigDecimal sumcantidad) {
		this.sumcantidad = sumcantidad;
	}

}
