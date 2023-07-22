package net.royal.erp.planilla.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

public class DtoPrVacacionPeriodo {

	private BigDecimal pendientes;
	private BigDecimal pendientesadelanto;
	private BigDecimal nroperiodo;
	private BigDecimal derecho;
	private String flgperiodovalido;
	private String anoTexto;
	private String ano;
	private BigDecimal programados;
	private BigDecimal utilizados;
	private BigDecimal solicitados;
	private BigDecimal adelantos;
	private BigDecimal fraccionadosdias;
	private BigDecimal fraccionadoshoras;

	public BigDecimal getPendientes() {
		if (UValidador.esNulo(pendientes)) {
			pendientes = BigDecimal.ZERO;
		}
		return pendientes;
	}

	public void setPendientes(BigDecimal pendientes) {
		this.pendientes = pendientes;
	}

	public BigDecimal getNroperiodo() {
		if (UValidador.esNulo(nroperiodo)) {
			nroperiodo = BigDecimal.ZERO;
		}
		return nroperiodo;
	}

	public void setNroperiodo(BigDecimal nroperiodo) {
		this.nroperiodo = nroperiodo;
	}

	public BigDecimal getDerecho() {
		return derecho;
	}

	public void setDerecho(BigDecimal derecho) {
		this.derecho = derecho;
	}

	public String getAnoTexto() {
		return anoTexto;
	}

	public void setAnoTexto(String anoTexto) {
		this.anoTexto = anoTexto;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal getPendientesadelanto() {
		return pendientesadelanto;
	}

	public void setPendientesadelanto(BigDecimal pendientesadelanto) {
		this.pendientesadelanto = pendientesadelanto;
	}

	public String getFlgperiodovalido() {
		return flgperiodovalido;
	}

	public void setFlgperiodovalido(String flgperiodovalido) {
		this.flgperiodovalido = flgperiodovalido;
	}

	public BigDecimal getProgramados() {
		if (UValidador.esNulo(programados)) {
			programados = BigDecimal.ZERO;
		}
		return programados;
	}

	public void setProgramados(BigDecimal programados) {
		this.programados = programados;
	}

	public BigDecimal getUtilizados() {
		if (UValidador.esNulo(utilizados)) {
			utilizados = BigDecimal.ZERO;
		}
		return utilizados;
	}

	public void setUtilizados(BigDecimal utilizados) {
		this.utilizados = utilizados;
	}

	public BigDecimal getSolicitados() {
		if (UValidador.esNulo(solicitados)) {
			solicitados = BigDecimal.ZERO;
		}
		return solicitados;
	}

	public void setSolicitados(BigDecimal solicitados) {
		this.solicitados = solicitados;
	}

	public BigDecimal getAdelantos() {
		if (UValidador.esNulo(adelantos)) {
			adelantos = BigDecimal.ZERO;
		}
		return adelantos;
	}

	public void setAdelantos(BigDecimal adelantos) {
		this.adelantos = adelantos;
	}

	public BigDecimal getFraccionadosdias() {
		if (UValidador.esNulo(fraccionadosdias)) {
			fraccionadosdias = BigDecimal.ZERO;
		}
		return fraccionadosdias;
	}

	public void setFraccionadosdias(BigDecimal fraccionadosdias) {
		this.fraccionadosdias = fraccionadosdias;
	}

	public BigDecimal getFraccionadoshoras() {
		if (UValidador.esNulo(fraccionadoshoras)) {
			fraccionadoshoras = BigDecimal.ZERO;
		}
		return fraccionadoshoras;
	}

	public void setFraccionadoshoras(BigDecimal fraccionadoshoras) {
		this.fraccionadoshoras = fraccionadoshoras;
	}

}
