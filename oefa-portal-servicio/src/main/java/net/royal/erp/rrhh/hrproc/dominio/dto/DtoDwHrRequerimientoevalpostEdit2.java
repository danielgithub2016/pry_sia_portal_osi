package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

public class DtoDwHrRequerimientoevalpostEdit2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer secuencia;
	private String postulante;
	private Integer secuencia2;
	private BigDecimal calificacionsum;
	private Integer calificacioncount;
	private String descripcioneval;
	private String descripcioncargo;
	private String descripcionvalor;
	private String flagcalificacion;
	private String estado;
	private Integer cfrow1;
	private Integer cfrow2;
	
	/**
	 * The <strong>ocultar.</strong><br>
	 * 
	 * Se usa para emular el método filter() en PB. Para evitar removerlo de una
	 * lista, ya que se utilizaran todos los items
	 */
	private boolean ocultar;

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

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
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

	public BigDecimal getCalificacionsum() {
		return calificacionsum;
	}

	public void setCalificacionsum(BigDecimal calificacionsum) {
		this.calificacionsum = calificacionsum;
	}

	public Integer getCalificacioncount() {
		return calificacioncount;
	}

	public void setCalificacioncount(Object calificacioncount) {
		if (!UValidador.esNulo(calificacioncount)) {
			if (calificacioncount instanceof BigDecimal)
				this.calificacioncount = new BigDecimal(calificacioncount.toString()).intValue();
			else if (calificacioncount instanceof Integer)
				this.calificacioncount = Integer.parseInt(calificacioncount.toString());
		}
	}

	public String getDescripcioneval() {
		return descripcioneval;
	}

	public void setDescripcioneval(String descripcioneval) {
		this.descripcioneval = descripcioneval;
	}

	public String getDescripcioncargo() {
		return descripcioncargo;
	}

	public void setDescripcioncargo(String descripcioncargo) {
		this.descripcioncargo = descripcioncargo;
	}

	public String getDescripcionvalor() {
		return descripcionvalor;
	}

	public void setDescripcionvalor(String descripcionvalor) {
		this.descripcionvalor = descripcionvalor;
	}

	public String getFlagcalificacion() {
		return flagcalificacion;
	}

	public void setFlagcalificacion(String flagcalificacion) {
		this.flagcalificacion = flagcalificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCfrow1() {
		return cfrow1;
	}

	public void setCfrow1(Object cfrow1) {
		if (!UValidador.esNulo(cfrow1)) {
			if (cfrow1 instanceof BigDecimal)
				this.cfrow1 = new BigDecimal(cfrow1.toString()).intValue();
			else if (cfrow1 instanceof Integer)
				this.cfrow1 = Integer.parseInt(cfrow1.toString());
		}
	}

	public Integer getCfrow2() {
		return cfrow2;
	}

	public void setCfrow2(Object cfrow2) {
		if (!UValidador.esNulo(cfrow2)) {
			if (cfrow2 instanceof BigDecimal)
				this.cfrow2 = new BigDecimal(cfrow2.toString()).intValue();
			else if (cfrow2 instanceof Integer)
				this.cfrow2 = Integer.parseInt(cfrow2.toString());
		}
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}

}
