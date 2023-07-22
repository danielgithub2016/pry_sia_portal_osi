package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuesta
*/
public class HrEncuesta extends DominioGenerico implements java.io.Serializable{

	private HrEncuestaPk pk;
	private Integer responsable;
	private String observaciones;
	private String unidadnegocio;
	private String departamento;
	private Integer muestra;
	private java.util.Date fecha;
	private String centrocostos;
	private String titulo;
	private String flagdocente;
	private Integer foco;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String capacitacion;
	private String estado;
	private String tipoencuesta;
	private String codigoproceso;
	private Integer numeroproceso;
	private Integer nivelaprobacion;
	private String motivoRechazo;
	private String actividad;


	public HrEncuesta() {
		pk = new HrEncuestaPk();
	}

	public HrEncuestaPk getPk() {
		return pk;
	}

	public void setPk(HrEncuestaPk pk) {
		this.pk = pk;
	}
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public Integer getMuestra() {
		return muestra;
	}

	public void setMuestra(Integer muestra) {
		this.muestra = muestra;
	}
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFlagdocente() {
		return flagdocente;
	}

	public void setFlagdocente(String flagdocente) {
		this.flagdocente = flagdocente;
	}
	public Integer getFoco() {
		return foco;
	}

	public void setFoco(Integer foco) {
		this.foco = foco;
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
	public String getCapacitacion() {
		return capacitacion;
	}

	public void setCapacitacion(String capacitacion) {
		this.capacitacion = capacitacion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}
	public String getCodigoproceso() {
		return codigoproceso;
	}

	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}
	public Integer getNumeroproceso() {
		return numeroproceso;
	}

	public void setNumeroproceso(Integer numeroproceso) {
		this.numeroproceso = numeroproceso;
	}
	public Integer getNivelaprobacion() {
		return nivelaprobacion;
	}

	public void setNivelaprobacion(Integer nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

}
