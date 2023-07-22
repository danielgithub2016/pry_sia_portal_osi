package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividad
 */
@SuppressWarnings("serial")
public class DtoHrRequerimientoSeguimiento implements java.io.Serializable {

	private String compania;
	private String requerimiento;
	private BigDecimal secuencial;
	private BigDecimal responsable;
	private String nombrecompleto;
	private BigDecimal indicadorAprobacion;
	private Date fechaaprobacion;
	private String comentario;
	private String estado;

	private String flagTipopuesto;
	private BigDecimal secuencia;

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public BigDecimal getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(BigDecimal secuencial) {
		this.secuencial = secuencial;
	}

	public BigDecimal getResponsable() {
		return responsable;
	}

	public void setResponsable(BigDecimal responsable) {
		this.responsable = responsable;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public BigDecimal getIndicadorAprobacion() {
		return indicadorAprobacion;
	}

	public void setIndicadorAprobacion(BigDecimal indicadorAprobacion) {
		this.indicadorAprobacion = indicadorAprobacion;
	}

	public Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlagTipopuesto() {
		return flagTipopuesto;
	}

	public void setFlagTipopuesto(String flagTipopuesto) {
		this.flagTipopuesto = flagTipopuesto;
	}

	public BigDecimal getSecuencia() {
		if (UValidador.esNulo(secuencia)) {
			secuencia = BigDecimal.ZERO;
		}
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

}
