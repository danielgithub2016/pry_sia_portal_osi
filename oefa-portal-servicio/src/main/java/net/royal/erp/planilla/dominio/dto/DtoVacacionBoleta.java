package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoVacacionBoleta implements Serializable {

	private Date fechainicio;
	private Date fechafin;
	private String aniominimo;
	private String aniomaximo;

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getAniominimo() {
		return aniominimo;
	}

	public void setAniominimo(String aniominimo) {
		this.aniominimo = aniominimo;
	}

	public String getAniomaximo() {
		return aniomaximo;
	}

	public void setAniomaximo(String aniomaximo) {
		this.aniomaximo = aniomaximo;
	}

}
