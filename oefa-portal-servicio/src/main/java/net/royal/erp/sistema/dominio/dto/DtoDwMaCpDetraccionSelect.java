package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ma_cp_detraccion_select
 */
public class DtoDwMaCpDetraccionSelect implements java.io.Serializable {
	private String detraccioncodigo;
	private String descripcion;
	private BigDecimal porcentaje;

	public String getDetraccioncodigo() {
		return detraccioncodigo;
	}

	public void setDetraccioncodigo(String detraccioncodigo) {
		this.detraccioncodigo = detraccioncodigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}



}
