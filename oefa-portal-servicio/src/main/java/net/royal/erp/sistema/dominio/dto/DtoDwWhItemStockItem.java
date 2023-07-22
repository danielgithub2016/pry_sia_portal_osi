package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_item_stock_item
 */
public class DtoDwWhItemStockItem implements java.io.Serializable {
	private String item;
	private String linea;
	private String familia;
	private String subfamilia;
	private String subfamiliainferior;
	private String descripcionlocal;
	private String descripcioningles;
	private String descripcioncompleta;
	private String marcacodigo;
	private String codigointerno;
	private String unidadcodigo;
	private String modelo;
	private String itemtipo;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getSubfamilia() {
		return subfamilia;
	}

	public void setSubfamilia(String subfamilia) {
		this.subfamilia = subfamilia;
	}

	public String getSubfamiliainferior() {
		return subfamiliainferior;
	}

	public void setSubfamiliainferior(String subfamiliainferior) {
		this.subfamiliainferior = subfamiliainferior;
	}

	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}

	public String getDescripcioncompleta() {
		return descripcioncompleta;
	}

	public void setDescripcioncompleta(String descripcioncompleta) {
		this.descripcioncompleta = descripcioncompleta;
	}

	public String getMarcacodigo() {
		return marcacodigo;
	}

	public void setMarcacodigo(String marcacodigo) {
		this.marcacodigo = marcacodigo;
	}

	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

	public String getUnidadcodigo() {
		return unidadcodigo;
	}

	public void setUnidadcodigo(String unidadcodigo) {
		this.unidadcodigo = unidadcodigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getItemtipo() {
		return itemtipo;
	}

	public void setItemtipo(String itemtipo) {
		this.itemtipo = itemtipo;
	}



}
