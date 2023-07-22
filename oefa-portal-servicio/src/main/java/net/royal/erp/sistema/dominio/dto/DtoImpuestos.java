package net.royal.erp.sistema.dominio.dto;

import java.math.BigDecimal;

public class DtoImpuestos implements java.io.Serializable {
	private BigDecimal factorporcentaje;
	private String signo;
	private String impuesto;
	private String tipoimpuesto;
	private String tiposervicio;

	public BigDecimal getFactorporcentaje() {
		return factorporcentaje;
	}

	public void setFactorporcentaje(BigDecimal factorporcentaje) {
		this.factorporcentaje = factorporcentaje;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}

	public String getTipoimpuesto() {
		return tipoimpuesto;
	}

	public void setTipoimpuesto(String tipoimpuesto) {
		this.tipoimpuesto = tipoimpuesto;
	}

	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}



}
