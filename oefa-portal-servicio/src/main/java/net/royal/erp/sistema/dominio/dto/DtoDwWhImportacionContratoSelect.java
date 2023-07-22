package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_importacion_contrato_select
 */
public class DtoDwWhImportacionContratoSelect implements java.io.Serializable {
	private String numerocontrato;
	private String descripcion;
	private String monedadocumento;
	private BigDecimal montototal;
	private BigDecimal proveedor;
	private Date fechaaprobacion;
	private String contratoresponsable;

	public String getNumerocontrato() {
		return numerocontrato;
	}

	public void setNumerocontrato(String numerocontrato) {
		this.numerocontrato = numerocontrato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMonedadocumento() {
		return monedadocumento;
	}

	public void setMonedadocumento(String monedadocumento) {
		this.monedadocumento = monedadocumento;
	}

	public BigDecimal getMontototal() {
		return montototal;
	}

	public void setMontototal(BigDecimal montototal) {
		this.montototal = montototal;
	}

	public BigDecimal getProveedor() {
		return proveedor;
	}

	public void setProveedor(BigDecimal proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	public String getContratoresponsable() {
		return contratoresponsable;
	}

	public void setContratoresponsable(String contratoresponsable) {
		this.contratoresponsable = contratoresponsable;
	}


}
