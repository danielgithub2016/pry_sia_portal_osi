/*
 * 
 */
package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 * The Class DtoDwRequerimientoevaletapasEdit.
 * 
 * @powerbuilder dw_hr_requerimientoevaletapas_edit
 */
public class DtoDwRequerimientoevaletapasEdit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String requerimiento;
	private Integer secuencia;
	private Integer secuencia2;
	private String companyowner;
	private String postulante;
	private String estado;
	private String flagincorporacion;
	private String descripcioneval;
	private String descripcionpuesto;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String observaciones;
	private String observacionfinetapa;

	/**
	 * The <strong>ocultar.</strong><br>
	 * 
	 * Se usa para emular el método filter() en PB. Para evitar removerlo de una
	 * lista, ya que se utilizaran todos los items
	 */
	private boolean ocultar;

	private String auxestado;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Object secuencia) {
		if (!UValidador.esNulo(secuencia)) {
			if (secuencia instanceof BigDecimal)
				this.secuencia = new BigDecimal(secuencia.toString()).intValue();
			else if (secuencia instanceof Integer)
				this.secuencia = Integer.parseInt(secuencia.toString());
		}
	}

	public Integer getSecuencia2() {
		return secuencia2;
	}

	public void setSecuencia2(Object secuencia2) {
		if (!UValidador.esNulo(secuencia2)) {
			if (secuencia2 instanceof BigDecimal)
				this.secuencia2 = new BigDecimal(secuencia2.toString()).intValue();
			else if (secuencia2 instanceof Integer)
				this.secuencia2 = Integer.parseInt(secuencia2.toString());
		}
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlagincorporacion() {
		return flagincorporacion;
	}

	public void setFlagincorporacion(String flagincorporacion) {
		this.flagincorporacion = flagincorporacion;
	}

	public String getDescripcioneval() {
		return descripcioneval;
	}

	public void setDescripcioneval(String descripcioneval) {
		this.descripcioneval = descripcioneval;
	}

	public String getDescripcionpuesto() {
		return descripcionpuesto;
	}

	public void setDescripcionpuesto(String descripcionpuesto) {
		this.descripcionpuesto = descripcionpuesto;
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

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservacionfinetapa() {
		return observacionfinetapa;
	}

	public void setObservacionfinetapa(String observacionfinetapa) {
		this.observacionfinetapa = observacionfinetapa;
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}

	public String getAuxestado() {
		if (!UValidador.esNulo(estado)) {
			switch (estado) {
			case "P":
				auxestado = "En Proceso";
				break;
			case "E":
				auxestado = "No Califica";
				break;
			case "A":
				auxestado = "Califica";
				break;
			}
		}
		return auxestado;
	}

	public void setAuxestado(String auxestado) {
		this.auxestado = auxestado;
	}

}
