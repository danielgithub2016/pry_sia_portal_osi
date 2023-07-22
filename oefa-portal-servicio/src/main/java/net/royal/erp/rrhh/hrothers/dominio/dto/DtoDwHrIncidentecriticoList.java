package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The Class DtoDwHrIncidentecriticoList.
 * 
 * @author nunezh
 * @powerbuilder hrothers.dw_hr_incidentecritico_list
 */
@SuppressWarnings("serial")
public class DtoDwHrIncidentecriticoList implements Serializable {
	private String companyowner;
	private BigDecimal secuencia;
	private BigDecimal empleado;
	private String periodo;
	private String tipo;
	private String descripcion;
	private Date fecha;
	private BigDecimal responsable;
	private Integer diasSuspension;
	private String documento;
	private Date fechafin;
	private Date fechainicio;
	private String medidaDisciplinaria;
	private String unidadnegocio;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String flagsoloenevaluacion;
	private String clasificacion;
	private Boolean mostrarEditar;
	
	private String eliminado;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getResponsable() {
		return responsable;
	}

	public void setResponsable(BigDecimal responsable) {
		this.responsable = responsable;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

	public String getFlagsoloenevaluacion() {
		return flagsoloenevaluacion;
	}

	public void setFlagsoloenevaluacion(String flagsoloenevaluacion) {
		this.flagsoloenevaluacion = flagsoloenevaluacion;
	}

	public Boolean getMostrarEditar() {
		return mostrarEditar;
	}

	public void setMostrarEditar(Boolean mostrarEditar) {
		this.mostrarEditar = mostrarEditar;
	}

	public Integer getDiasSuspension() {
		return diasSuspension;
	}

	public void setDiasSuspension(Integer diasSuspension) {
		this.diasSuspension = diasSuspension;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getMedidaDisciplinaria() {
		return medidaDisciplinaria;
	}

	public void setMedidaDisciplinaria(String medidaDisciplinaria) {
		this.medidaDisciplinaria = medidaDisciplinaria;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
}
