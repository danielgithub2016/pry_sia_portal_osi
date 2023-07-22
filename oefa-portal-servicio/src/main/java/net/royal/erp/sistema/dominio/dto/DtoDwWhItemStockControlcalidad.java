package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_item_stock_controlcalidad
 */
public class DtoDwWhItemStockControlcalidad implements java.io.Serializable {
	private String companiasocio;
	private String controlnumero;
	private String areacodigo;
	private String numeroorden;
	private String estado;
	private String estadoDesc;
	private BigDecimal cantidadaceptada;
	private BigDecimal cantidadrecibida;
	private Date fechapreparacion;
	
	private BigDecimal rowkey;
	
	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getControlnumero() {
		return controlnumero;
	}

	public void setControlnumero(String controlnumero) {
		this.controlnumero = controlnumero;
	}

	public String getAreacodigo() {
		return areacodigo;
	}

	public void setAreacodigo(String areacodigo) {
		this.areacodigo = areacodigo;
	}

	public String getNumeroorden() {
		return numeroorden;
	}

	public void setNumeroorden(String numeroorden) {
		this.numeroorden = numeroorden;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getCantidadaceptada() {
		return cantidadaceptada;
	}

	public void setCantidadaceptada(BigDecimal cantidadaceptada) {
		this.cantidadaceptada = cantidadaceptada;
	}

	public BigDecimal getCantidadrecibida() {
		return cantidadrecibida;
	}

	public void setCantidadrecibida(BigDecimal cantidadrecibida) {
		this.cantidadrecibida = cantidadrecibida;
	}

	public Date getFechapreparacion() {
		return fechapreparacion;
	}

	public void setFechapreparacion(Date fechapreparacion) {
		this.fechapreparacion = fechapreparacion;
	}

	public BigDecimal getRowkey() {
		return rowkey;
	}

	public void setRowkey(BigDecimal rowkey) {
		this.rowkey = rowkey;
	}

	public String getEstadoDesc() {
		if (!UValidador.esNulo(estado)) {
			if (estado.equals("PR")) {
				estadoDesc = "cantidadrecibida";
			} else {
				estadoDesc = "cantidadaceptada";
			}
		}
		return estadoDesc;
	}

	public void setEstadoDesc(String estadoDesc) {
		this.estadoDesc = estadoDesc;
	}



}
