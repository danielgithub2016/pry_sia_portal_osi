package net.royal.erp.asistencia.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DtoAsTipodiamovimiento {
	private BigDecimal secuencia;
	private String intervaloacceso;
	private Date Horafin;
	private Date Horainicio;
	private String flagdiaant;
	private String flgteletrabajo;

	public Date getHorainicio() {
		return Horainicio;
	}

	public void setHorainicio(Date horainicio) {
		Horainicio = horainicio;
	}

	public String getFlagdiaant() {
		return flagdiaant;
	}

	public void setFlagdiaant(String flagdiaant) {
		this.flagdiaant = flagdiaant;
	}

	public Date getHorafin() {
		return Horafin;
	}

	public void setHorafin(Date horafin) {
		Horafin = horafin;
	}

	public String getIntervaloacceso() {
		return intervaloacceso;
	}

	public void setIntervaloacceso(String intervaloacceso) {
		this.intervaloacceso = intervaloacceso;
	}

	public String getFlgteletrabajo() {
		return flgteletrabajo;
	}

	public void setFlgteletrabajo(String flgteletrabajo) {
		this.flgteletrabajo = flgteletrabajo;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

}
