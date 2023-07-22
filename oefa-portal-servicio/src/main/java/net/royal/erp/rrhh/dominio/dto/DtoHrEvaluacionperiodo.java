package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;

import net.royal.framework.web.core.UValidador;

public class DtoHrEvaluacionperiodo {
	private String companyowner;
	private BigDecimal secuenciaeval;
	private String periodo;
	private String descripcion;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String estado;
	private String flagevaluacionintegral;
	private String flagdesempeno;
	private String flagmetas;
	private String flagnecesidadcapacita;
	private String flagrevisionmetas;
	private String flagpotencial;
	private String flagrevisionpotencial;
	private Integer secuenciaevalant;
	private String flagconceptual;
	private String flagincidentescriticos;
	private String flagdesempenio;
	private String flagfunciones;
	private String tipoevaluacion;
	private String flagdesempeno2;
	private String claseperiodo;
	private String tipoeval;
	private String plantillaeval;
	private String flagdespersonal;
	private String flagmedicion;
	private String flagnecesidadcapacita2;
	private String estadoproceso;
	private java.util.Date fechaplaninicio;
	private java.util.Date fechaplanfin;
	private java.util.Date fecharealinicio;
	private java.util.Date fecharealfin;
	private String tipocodigo;
	private String plantillaevaluacion;
	private String flagdecampo;
	private String flagrevision;
	private java.util.Date fechaevalinicio;
	private java.util.Date fechaevalfin;
	private java.util.Date fechacierrereal;

	public java.util.Date getFechacierrereal() {
		return fechacierrereal;
	}

	public void setFechacierrereal(java.util.Date fechacierrereal) {
		this.fechacierrereal = fechacierrereal;
	}

	private String estadonombre;
	private String companyNombre;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;
	

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlagevaluacionintegral() {
		return flagevaluacionintegral;
	}

	public void setFlagevaluacionintegral(String flagevaluacionintegral) {
		this.flagevaluacionintegral = flagevaluacionintegral;
	}

	public String getFlagdesempeno() {
		return flagdesempeno;
	}

	public void setFlagdesempeno(String flagdesempeno) {
		this.flagdesempeno = flagdesempeno;
	}

	public String getFlagmetas() {
		return flagmetas;
	}

	public void setFlagmetas(String flagmetas) {
		this.flagmetas = flagmetas;
	}

	public String getFlagnecesidadcapacita() {
		return flagnecesidadcapacita;
	}

	public void setFlagnecesidadcapacita(String flagnecesidadcapacita) {
		this.flagnecesidadcapacita = flagnecesidadcapacita;
	}

	public String getFlagrevisionmetas() {
		return flagrevisionmetas;
	}

	public void setFlagrevisionmetas(String flagrevisionmetas) {
		this.flagrevisionmetas = flagrevisionmetas;
	}

	public String getFlagpotencial() {
		return flagpotencial;
	}

	public void setFlagpotencial(String flagpotencial) {
		this.flagpotencial = flagpotencial;
	}

	public String getFlagrevisionpotencial() {
		return flagrevisionpotencial;
	}

	public void setFlagrevisionpotencial(String flagrevisionpotencial) {
		this.flagrevisionpotencial = flagrevisionpotencial;
	}

	public Integer getSecuenciaevalant() {
		return secuenciaevalant;
	}

	public void setSecuenciaevalant(Integer secuenciaevalant) {
		this.secuenciaevalant = secuenciaevalant;
	}

	public String getFlagconceptual() {
		return flagconceptual;
	}

	public void setFlagconceptual(String flagconceptual) {
		this.flagconceptual = flagconceptual;
	}

	public String getFlagincidentescriticos() {
		return flagincidentescriticos;
	}

	public void setFlagincidentescriticos(String flagincidentescriticos) {
		this.flagincidentescriticos = flagincidentescriticos;
	}

	public String getFlagdesempenio() {
		return flagdesempenio;
	}

	public void setFlagdesempenio(String flagdesempenio) {
		this.flagdesempenio = flagdesempenio;
	}

	public String getFlagfunciones() {
		return flagfunciones;
	}

	public void setFlagfunciones(String flagfunciones) {
		this.flagfunciones = flagfunciones;
	}

	public String getTipoevaluacion() {
		return tipoevaluacion;
	}

	public void setTipoevaluacion(String tipoevaluacion) {
		this.tipoevaluacion = tipoevaluacion;
	}

	public String getFlagdesempeno2() {
		return flagdesempeno2;
	}

	public void setFlagdesempeno2(String flagdesempeno2) {
		this.flagdesempeno2 = flagdesempeno2;
	}

	public String getClaseperiodo() {
		return claseperiodo;
	}

	public void setClaseperiodo(String claseperiodo) {
		this.claseperiodo = claseperiodo;
	}

	public String getTipoeval() {
		return tipoeval;
	}

	public void setTipoeval(String tipoeval) {
		this.tipoeval = tipoeval;
	}

	public String getPlantillaeval() {
		return plantillaeval;
	}

	public void setPlantillaeval(String plantillaeval) {
		this.plantillaeval = plantillaeval;
	}

	public String getFlagdespersonal() {
		return flagdespersonal;
	}

	public void setFlagdespersonal(String flagdespersonal) {
		this.flagdespersonal = flagdespersonal;
	}

	public String getFlagmedicion() {
		return flagmedicion;
	}

	public void setFlagmedicion(String flagmedicion) {
		this.flagmedicion = flagmedicion;
	}

	public String getFlagnecesidadcapacita2() {
		return flagnecesidadcapacita2;
	}

	public void setFlagnecesidadcapacita2(String flagnecesidadcapacita2) {
		this.flagnecesidadcapacita2 = flagnecesidadcapacita2;
	}

	public String getEstadoproceso() {
		return estadoproceso;
	}

	public void setEstadoproceso(String estadoproceso) {
		this.estadoproceso = estadoproceso;
	}

	public java.util.Date getFechaplaninicio() {
		return fechaplaninicio;
	}

	public void setFechaplaninicio(java.util.Date fechaplaninicio) {
		this.fechaplaninicio = fechaplaninicio;
	}

	public java.util.Date getFechaplanfin() {
		return fechaplanfin;
	}

	public void setFechaplanfin(java.util.Date fechaplanfin) {
		this.fechaplanfin = fechaplanfin;
	}

	public java.util.Date getFecharealinicio() {
		return fecharealinicio;
	}

	public void setFecharealinicio(java.util.Date fecharealinicio) {
		this.fecharealinicio = fecharealinicio;
	}

	public java.util.Date getFecharealfin() {
		return fecharealfin;
	}

	public void setFecharealfin(java.util.Date fecharealfin) {
		this.fecharealfin = fecharealfin;
	}

	public String getTipocodigo() {
		return tipocodigo;
	}

	public void setTipocodigo(String tipocodigo) {
		this.tipocodigo = tipocodigo;
	}

	public String getPlantillaevaluacion() {
		return plantillaevaluacion;
	}

	public void setPlantillaevaluacion(String plantillaevaluacion) {
		this.plantillaevaluacion = plantillaevaluacion;
	}

	public String getFlagdecampo() {
		return flagdecampo;
	}

	public void setFlagdecampo(String flagdecampo) {
		this.flagdecampo = flagdecampo;
	}

	public String getFlagrevision() {
		return flagrevision;
	}

	public void setFlagrevision(String flagrevision) {
		this.flagrevision = flagrevision;
	}

	public java.util.Date getFechaevalinicio() {
		return fechaevalinicio;
	}

	public void setFechaevalinicio(java.util.Date fechaevalinicio) {
		this.fechaevalinicio = fechaevalinicio;
	}

	public java.util.Date getFechaevalfin() {
		return fechaevalfin;
	}

	public void setFechaevalfin(java.util.Date fechaevalfin) {
		this.fechaevalfin = fechaevalfin;
	}

	public String getEstadonombre() {
		if (!UValidador.esNulo(estadoproceso)) {
			switch (estadoproceso) {
			case "PR":
				estadonombre = "PREPARACIÓN";
				break;
			case "EV":
				estadonombre = "EVALUACIÓN";
				break;
			case "CE":
				estadonombre = "CERRADO";
				break;
			case "PE":
				estadonombre = "PENDIENTE DE EVALUACIÓN";
				break;

			default:
				break;
			}

		}
		return estadonombre;
	}

	public void setEstadonombre(String estadonombre) {
		this.estadonombre = estadonombre;
	}

	public String getCompanyNombre() {
		return companyNombre;
	}

	public void setCompanyNombre(String companyNombre) {
		this.companyNombre = companyNombre;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public BigDecimal getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(BigDecimal secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public java.util.Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(java.util.Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

}
