package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwPrVacacionesResumenReporte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String companiasocio;
	private Integer persona;
	private String codigoanterior;
	private String nombrecompleto;
	private String tipoplanilla;
	private Date fechaingreso;
	private Date fechacese;
	private BigDecimal derecho;
	private BigDecimal diasgozados;
	private BigDecimal diastrabajados;
	private BigDecimal diasinterrumpidos;
	private BigDecimal diasprescritos;
	private BigDecimal totalutilizados;
	private BigDecimal pendientes;
	private BigDecimal pendientessintruncos;
	private BigDecimal pagados;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Object persona) {
		if (!UValidador.esNulo(persona)) {
			if (persona instanceof BigDecimal)
				this.persona = new BigDecimal(persona.toString()).intValue();
			else if (persona instanceof Integer)
				this.persona = Integer.parseInt(persona.toString());
		}
	}

	public String getCodigoanterior() {
		return codigoanterior;
	}

	public void setCodigoanterior(String codigoanterior) {
		this.codigoanterior = codigoanterior;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechacese() {
		return fechacese;
	}

	public void setFechacese(Date fechacese) {
		this.fechacese = fechacese;
	}

	public BigDecimal getDerecho() {
		return derecho;
	}

	public void setDerecho(BigDecimal derecho) {
		this.derecho = derecho;
	}

	public BigDecimal getDiasgozados() {
		return diasgozados;
	}

	public void setDiasgozados(BigDecimal diasgozados) {
		this.diasgozados = diasgozados;
	}

	public BigDecimal getDiastrabajados() {
		return diastrabajados;
	}

	public void setDiastrabajados(BigDecimal diastrabajados) {
		this.diastrabajados = diastrabajados;
	}

	public BigDecimal getDiasinterrumpidos() {
		return diasinterrumpidos;
	}

	public void setDiasinterrumpidos(BigDecimal diasinterrumpidos) {
		this.diasinterrumpidos = diasinterrumpidos;
	}

	public BigDecimal getDiasprescritos() {
		return diasprescritos;
	}

	public void setDiasprescritos(BigDecimal diasprescritos) {
		this.diasprescritos = diasprescritos;
	}

	public BigDecimal getTotalutilizados() {
		return totalutilizados;
	}

	public void setTotalutilizados(BigDecimal totalutilizados) {
		this.totalutilizados = totalutilizados;
	}

	public BigDecimal getPendientes() {
		return pendientes;
	}

	public void setPendientes(BigDecimal pendientes) {
		this.pendientes = pendientes;
	}

	public BigDecimal getPendientessintruncos() {
		return pendientessintruncos;
	}

	public void setPendientessintruncos(BigDecimal pendientessintruncos) {
		this.pendientessintruncos = pendientessintruncos;
	}

	public BigDecimal getPagados() {
		return pagados;
	}

	public void setPagados(BigDecimal pagados) {
		this.pagados = pagados;
	}

}
