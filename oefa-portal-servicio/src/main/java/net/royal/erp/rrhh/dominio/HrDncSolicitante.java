package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrDncSolicitante
*/
public class HrDncSolicitante extends DominioGenerico implements java.io.Serializable{

	private HrDncSolicitantePk pk;
	private Integer empleadosolicitante;
	private java.util.Date fechasolicitada;
	private Integer curso;
	private String puesto;
	private String justificacion;
	private String aplicacion;
	private String enfoque;
	private String prioridad;
	private String tipo;
	private String modalidad;
	private java.util.Date desde;
	private java.util.Date hasta;
	private Integer numeroHoras;
	private Integer numeroParticipante;
	private String estado;
	private String flagcursonuevo;
	private String cursonuevo;
	private String area;


	public HrDncSolicitante() {
		pk = new HrDncSolicitantePk();
	}

	public HrDncSolicitantePk getPk() {
		return pk;
	}

	public void setPk(HrDncSolicitantePk pk) {
		this.pk = pk;
	}
	public Integer getEmpleadosolicitante() {
		return empleadosolicitante;
	}

	public void setEmpleadosolicitante(Integer empleadosolicitante) {
		this.empleadosolicitante = empleadosolicitante;
	}
	public java.util.Date getFechasolicitada() {
		return fechasolicitada;
	}

	public void setFechasolicitada(java.util.Date fechasolicitada) {
		this.fechasolicitada = fechasolicitada;
	}
	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}
	public String getEnfoque() {
		return enfoque;
	}

	public void setEnfoque(String enfoque) {
		this.enfoque = enfoque;
	}
	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public java.util.Date getDesde() {
		return desde;
	}

	public void setDesde(java.util.Date desde) {
		this.desde = desde;
	}
	public java.util.Date getHasta() {
		return hasta;
	}

	public void setHasta(java.util.Date hasta) {
		this.hasta = hasta;
	}
	public Integer getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlagcursonuevo() {
		return flagcursonuevo;
	}

	public void setFlagcursonuevo(String flagcursonuevo) {
		this.flagcursonuevo = flagcursonuevo;
	}
	public String getCursonuevo() {
		return cursonuevo;
	}

	public void setCursonuevo(String cursonuevo) {
		this.cursonuevo = cursonuevo;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
