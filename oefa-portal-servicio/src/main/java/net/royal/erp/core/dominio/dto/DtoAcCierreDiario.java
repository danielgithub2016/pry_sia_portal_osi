package net.royal.erp.core.dominio.dto;

import java.util.Date;

public class DtoAcCierreDiario {
	private String companiasocio;
	private Date fecha;
	private String fechastring;
	public String getCompaniasocio() {
		return companiasocio;
	}
	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getFechastring() {
		return fechastring;
	}
	public void setFechastring(String fechastring) {
		this.fechastring = fechastring;
	}
	
}
