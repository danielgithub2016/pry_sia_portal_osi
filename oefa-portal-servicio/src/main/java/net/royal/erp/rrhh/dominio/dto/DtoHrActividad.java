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
public class DtoHrActividad implements java.io.Serializable {

	private String actividad;
	private String companyowner;
	private String unidadreplicacion;
	private String archivoparticipantes;
	private String periodo;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private String nombre;
	private String requisitos;
	private BigDecimal costoactividad;
	private BigDecimal costoactividadigv;
	private BigDecimal costoext;
	private BigDecimal costoigvext;
	private BigDecimal presupuesto;
	private BigDecimal saldo;
	private String unidadnegocio;
	private String actdefinicion;
	private Integer numeroparticipantes;
	private String lugar;
	private BigDecimal responsable;
	private String resumen;
	private String resultados;
	private String incidencias;
	private String recomendaciones;
	private String tipoparticipante;
	private String colaboracionexterna;
	private BigDecimal resultadoexcelente;
	private BigDecimal resultadobueno;
	private BigDecimal resultadoregular;
	private BigDecimal resultadomalo;
	private java.util.Date fecharegistro;
	private java.util.Date fechaaprobacion;
	private BigDecimal registradopor;
	private BigDecimal aprobadopor;
	private String propuestopor;
	private String estado;
	private String departamentorespon;
	private BigDecimal codigometa;
	private BigDecimal codigolineaaccion;
	private String codigoestrategia;
	private String objetivo;
	private BigDecimal otrosparticipantes;
	private String tipoactividad;
	private String flagtipoplan;
	private BigDecimal costopresupuesto;
	private BigDecimal costoreal;
	private String situacionactual;
	private String resumenactividad;
	private BigDecimal solicitante;
	private String observacion;
	private String codigoproceso;
	private Integer numeroproceso;
	private String motivoRechazo;
	private BigDecimal nivelaprobacion;
	private BigDecimal costoadicional;
	private java.util.Date fechadesdepublicacion;
	private java.util.Date fechahastapublicacion;
	private String flagpublicacion;
	private String flagapoyosocial;
	private String conceptoapoyosocial;

	private Boolean flagpublicacionBool;
	private String categoria;
	private BigDecimal participantes;
	private Date fechafiltro;
	private BigDecimal participo;

	private BigDecimal monto;
	private String fechaevento;
	private String fechapublicacion;
	private String valor1;

	public String getFechaevento() {
		return fechaevento;
	}

	public void setFechaevento(String fechaevento) {
		this.fechaevento = fechaevento;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public String getArchivoparticipantes() {
		return archivoparticipantes;
	}

	public void setArchivoparticipantes(String archivoparticipantes) {
		this.archivoparticipantes = archivoparticipantes;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public java.util.Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(java.util.Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public java.util.Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(java.util.Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public BigDecimal getCostoactividad() {
		return costoactividad;
	}

	public void setCostoactividad(BigDecimal costoactividad) {
		this.costoactividad = costoactividad;
	}

	public BigDecimal getCostoactividadigv() {
		return costoactividadigv;
	}

	public void setCostoactividadigv(BigDecimal costoactividadigv) {
		this.costoactividadigv = costoactividadigv;
	}

	public BigDecimal getCostoext() {
		return costoext;
	}

	public void setCostoext(BigDecimal costoext) {
		this.costoext = costoext;
	}

	public BigDecimal getCostoigvext() {
		return costoigvext;
	}

	public void setCostoigvext(BigDecimal costoigvext) {
		this.costoigvext = costoigvext;
	}

	public BigDecimal getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(BigDecimal presupuesto) {
		this.presupuesto = presupuesto;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getActdefinicion() {
		return actdefinicion;
	}

	public void setActdefinicion(String actdefinicion) {
		this.actdefinicion = actdefinicion;
	}

	public Integer getNumeroparticipantes() {
		return numeroparticipantes;
	}

	public void setNumeroparticipantes(Integer numeroparticipantes) {
		this.numeroparticipantes = numeroparticipantes;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public BigDecimal getResponsable() {
		return responsable;
	}

	public void setResponsable(BigDecimal responsable) {
		this.responsable = responsable;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public String getTipoparticipante() {
		return tipoparticipante;
	}

	public void setTipoparticipante(String tipoparticipante) {
		this.tipoparticipante = tipoparticipante;
	}

	public String getColaboracionexterna() {
		return colaboracionexterna;
	}

	public void setColaboracionexterna(String colaboracionexterna) {
		this.colaboracionexterna = colaboracionexterna;
	}

	public BigDecimal getResultadoexcelente() {
		return resultadoexcelente;
	}

	public void setResultadoexcelente(BigDecimal resultadoexcelente) {
		this.resultadoexcelente = resultadoexcelente;
	}

	public BigDecimal getResultadobueno() {
		return resultadobueno;
	}

	public void setResultadobueno(BigDecimal resultadobueno) {
		this.resultadobueno = resultadobueno;
	}

	public BigDecimal getResultadoregular() {
		return resultadoregular;
	}

	public void setResultadoregular(BigDecimal resultadoregular) {
		this.resultadoregular = resultadoregular;
	}

	public BigDecimal getResultadomalo() {
		return resultadomalo;
	}

	public void setResultadomalo(BigDecimal resultadomalo) {
		this.resultadomalo = resultadomalo;
	}

	public java.util.Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(java.util.Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}

	public BigDecimal getRegistradopor() {
		return registradopor;
	}

	public void setRegistradopor(BigDecimal registradopor) {
		this.registradopor = registradopor;
	}

	public BigDecimal getAprobadopor() {
		return aprobadopor;
	}

	public void setAprobadopor(BigDecimal aprobadopor) {
		this.aprobadopor = aprobadopor;
	}

	public String getPropuestopor() {
		return propuestopor;
	}

	public void setPropuestopor(String propuestopor) {
		this.propuestopor = propuestopor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDepartamentorespon() {
		return departamentorespon;
	}

	public void setDepartamentorespon(String departamentorespon) {
		this.departamentorespon = departamentorespon;
	}

	public BigDecimal getCodigometa() {
		return codigometa;
	}

	public void setCodigometa(BigDecimal codigometa) {
		this.codigometa = codigometa;
	}

	public BigDecimal getCodigolineaaccion() {
		return codigolineaaccion;
	}

	public void setCodigolineaaccion(BigDecimal codigolineaaccion) {
		this.codigolineaaccion = codigolineaaccion;
	}

	public String getCodigoestrategia() {
		return codigoestrategia;
	}

	public void setCodigoestrategia(String codigoestrategia) {
		this.codigoestrategia = codigoestrategia;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public BigDecimal getOtrosparticipantes() {
		return otrosparticipantes;
	}

	public void setOtrosparticipantes(BigDecimal otrosparticipantes) {
		this.otrosparticipantes = otrosparticipantes;
	}

	public String getTipoactividad() {
		return tipoactividad;
	}

	public void setTipoactividad(String tipoactividad) {
		this.tipoactividad = tipoactividad;
	}

	public String getFlagtipoplan() {
		return flagtipoplan;
	}

	public void setFlagtipoplan(String flagtipoplan) {
		this.flagtipoplan = flagtipoplan;
	}

	public BigDecimal getCostopresupuesto() {
		return costopresupuesto;
	}

	public void setCostopresupuesto(BigDecimal costopresupuesto) {
		this.costopresupuesto = costopresupuesto;
	}

	public BigDecimal getCostoreal() {
		return costoreal;
	}

	public void setCostoreal(BigDecimal costoreal) {
		this.costoreal = costoreal;
	}

	public String getSituacionactual() {
		return situacionactual;
	}

	public void setSituacionactual(String situacionactual) {
		this.situacionactual = situacionactual;
	}

	public String getResumenactividad() {
		return resumenactividad;
	}

	public void setResumenactividad(String resumenactividad) {
		this.resumenactividad = resumenactividad;
	}

	public BigDecimal getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(BigDecimal solicitante) {
		this.solicitante = solicitante;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	public BigDecimal getNivelaprobacion() {
		return nivelaprobacion;
	}

	public void setNivelaprobacion(BigDecimal nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}

	public BigDecimal getCostoadicional() {
		return costoadicional;
	}

	public void setCostoadicional(BigDecimal costoadicional) {
		this.costoadicional = costoadicional;
	}

	public java.util.Date getFechadesdepublicacion() {
		return fechadesdepublicacion;
	}

	public void setFechadesdepublicacion(java.util.Date fechadesdepublicacion) {
		this.fechadesdepublicacion = fechadesdepublicacion;
	}

	public java.util.Date getFechahastapublicacion() {
		return fechahastapublicacion;
	}

	public void setFechahastapublicacion(java.util.Date fechahastapublicacion) {
		this.fechahastapublicacion = fechahastapublicacion;
	}

	public String getFlagpublicacion() {
		return flagpublicacion;
	}

	public void setFlagpublicacion(String flagpublicacion) {
		this.flagpublicacion = flagpublicacion;
	}

	public String getFlagapoyosocial() {
		return flagapoyosocial;
	}

	public void setFlagapoyosocial(String flagapoyosocial) {
		this.flagapoyosocial = flagapoyosocial;
	}

	public String getConceptoapoyosocial() {
		return conceptoapoyosocial;
	}

	public void setConceptoapoyosocial(String conceptoapoyosocial) {
		this.conceptoapoyosocial = conceptoapoyosocial;
	}

	public Boolean getFlagpublicacionBool() {
		return flagpublicacionBool;
	}

	public void setFlagpublicacionBool(Boolean flagpublicacionBool) {
		this.setFlagpublicacion(UValidador.esNulo(flagpublicacionBool) ? "N"
				: flagpublicacionBool ? "S" : "N");
		this.flagpublicacionBool = flagpublicacionBool;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getParticipantes() {
		return participantes;
	}

	public void setParticipantes(BigDecimal participantes) {
		this.participantes = participantes;
	}

	public Date getFechafiltro() {
		return fechafiltro;
	}

	public void setFechafiltro(Date fechafiltro) {
		this.fechafiltro = fechafiltro;
	}

	public BigDecimal getParticipo() {
		return participo;
	}

	public void setParticipo(BigDecimal participo) {
		this.participo = participo;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getFechapublicacion() {
		return fechapublicacion;
	}

	public void setFechapublicacion(String fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

}
