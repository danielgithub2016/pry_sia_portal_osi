package net.royal.erp.asistencia.dominio.dto;

import java.util.Date;

public class DtoAsPeriodo {
	private Date fechadesde;
	private Date fechahasta;
	private String periodoplanilla;
	
	public String getPeriodoplanilla() {
		return periodoplanilla;
	}
	public void setPeriodoplanilla(String periodoplanilla) {
		this.periodoplanilla = periodoplanilla;
	}
	public Date getFechadesde() {
		return fechadesde;
	}
	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}
	public Date getFechahasta() {
		return fechahasta;
	}
	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
	}
}
