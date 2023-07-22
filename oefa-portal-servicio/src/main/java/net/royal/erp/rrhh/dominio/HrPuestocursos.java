package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestocursos
*/
public class HrPuestocursos extends DominioGenerico implements java.io.Serializable{

	private HrPuestocursosPk pk;
	private Integer curso;
	private String tipocurso;
	private Integer centroestudios;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String auspicio;
	private Integer dias;
	private String observaciones;
	private Integer totalhoras;
	private String cursodescripcion;
	private Integer vigencia;
	private String gradocuantitativo;
	private Integer puntosgrado;
	private Integer porcentajegrado;
	private String flagconocimiento;
	
	private String Descripciongradocuantitativo;


	public HrPuestocursos() {
		pk = new HrPuestocursosPk();
	}

	public HrPuestocursosPk getPk() {
		return pk;
	}

	public void setPk(HrPuestocursosPk pk) {
		this.pk = pk;
	}
	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getTipocurso() {
		return tipocurso;
	}

	public void setTipocurso(String tipocurso) {
		this.tipocurso = tipocurso;
	}
	public Integer getCentroestudios() {
		return centroestudios;
	}

	public void setCentroestudios(Integer centroestudios) {
		this.centroestudios = centroestudios;
	}
	public java.util.Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}
	public String getAuspicio() {
		return auspicio;
	}

	public void setAuspicio(String auspicio) {
		this.auspicio = auspicio;
	}
	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getTotalhoras() {
		return totalhoras;
	}

	public void setTotalhoras(Integer totalhoras) {
		this.totalhoras = totalhoras;
	}
	public String getCursodescripcion() {
		return cursodescripcion;
	}

	public void setCursodescripcion(String cursodescripcion) {
		this.cursodescripcion = cursodescripcion;
	}
	public Integer getVigencia() {
		return vigencia;
	}

	public void setVigencia(Integer vigencia) {
		this.vigencia = vigencia;
	}
	public String getGradocuantitativo() {
		return gradocuantitativo;
	}

	public void setGradocuantitativo(String gradocuantitativo) {
		this.gradocuantitativo = gradocuantitativo;
	}
	public Integer getPuntosgrado() {
		return puntosgrado;
	}

	public void setPuntosgrado(Integer puntosgrado) {
		this.puntosgrado = puntosgrado;
	}
	public Integer getPorcentajegrado() {
		return porcentajegrado;
	}

	public void setPorcentajegrado(Integer porcentajegrado) {
		this.porcentajegrado = porcentajegrado;
	}
	public String getFlagconocimiento() {
		return flagconocimiento;
	}

	public void setFlagconocimiento(String flagconocimiento) {
		this.flagconocimiento = flagconocimiento;
	}

	public String getDescripciongradocuantitativo() {
		return Descripciongradocuantitativo;
	}

	public void setDescripciongradocuantitativo(String descripciongradocuantitativo) {
		Descripciongradocuantitativo = descripciongradocuantitativo;
	}

}
