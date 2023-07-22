package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class DtoDwHrEvaluacionperiodoCabecera implements Serializable {
	private String companyowner;
	private String companyownerdesc;
	private String periodo;
	private String descripcion;
	private String estadoproceso;
	private Date fechainicio;
	private Date fechafin;
	private Date fechaplaninicio;
	private Date fechaplanfin;
	private Date fecharealinicio;
	private Date fecharealfin;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoproceso() {
		return estadoproceso;
	}

	public void setEstadoproceso(String estadoproceso) {
		this.estadoproceso = estadoproceso;
	}

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

	public Date getFechaplaninicio() {
		return fechaplaninicio;
	}

	public void setFechaplaninicio(Date fechaplaninicio) {
		this.fechaplaninicio = fechaplaninicio;
	}

	public Date getFechaplanfin() {
		return fechaplanfin;
	}

	public void setFechaplanfin(Date fechaplanfin) {
		this.fechaplanfin = fechaplanfin;
	}

	public Date getFecharealinicio() {
		return fecharealinicio;
	}

	public void setFecharealinicio(Date fecharealinicio) {
		this.fecharealinicio = fecharealinicio;
	}

	public Date getFecharealfin() {
		return fecharealfin;
	}

	public void setFecharealfin(Date fechrealfin) {
		this.fecharealfin = fechrealfin;
	}

	public String getCompanyownerdesc() {
		return companyownerdesc;
	}

	public void setCompanyownerdesc(String companyownerdesc) {
		this.companyownerdesc = companyownerdesc;
	}

}
