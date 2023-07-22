package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividad
*/
public class HrActividad extends DominioGenerico implements java.io.Serializable{

	private HrActividadPk pk;
	private String unidadreplicacion;
	private String archivoparticipantes;
	private String periodo;
	private java.util.Date fechadesde;
	private java.util.Date fechahasta;
	private String nombre;
	private String requisitos;
	private Integer costoactividad;
	private Integer costoactividadigv;
	private Integer costoext;
	private Integer costoigvext;
	private Integer presupuesto;
	private Integer saldo;
	private String unidadnegocio;
	private String actdefinicion;
	private Integer numeroparticipantes;
	private String lugar;
	private Integer responsable;
	private String resumen;
	private String resultados;
	private String incidencias;
	private String recomendaciones;
	private String tipoparticipante;
	private String colaboracionexterna;
	private Integer resultadoexcelente;
	private Integer resultadobueno;
	private Integer resultadoregular;
	private Integer resultadomalo;
	private java.util.Date fecharegistro;
	private java.util.Date fechaaprobacion;
	private Integer registradopor;
	private Integer aprobadopor;
	private String propuestopor;
	private String estado;
	private String departamentorespon;
	private Integer codigometa;
	private Integer codigolineaaccion;
	private String codigoestrategia;
	private String objetivo;
	private Integer otrosparticipantes;
	private String tipoactividad;
	private String flagtipoplan;
	private Integer costopresupuesto;
	private Integer costoreal;
	private String situacionactual;
	private String resumenactividad;
	private Integer solicitante;
	private String observacion;
	private String codigoproceso;
	private Integer numeroproceso;
	private String motivoRechazo;
	private Integer nivelaprobacion;
	private Integer costoadicional;
	private java.util.Date fechadesdepublicacion;
	private java.util.Date fechahastapublicacion;
	private String flagpublicacion;
	private String flagapoyosocial;
	private String conceptoapoyosocial;
	
	


	public HrActividad() {
		pk = new HrActividadPk();
	}

	public HrActividadPk getPk() {
		return pk;
	}

	public void setPk(HrActividadPk pk) {
		this.pk = pk;
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
	public Integer getCostoactividad() {
		return costoactividad;
	}

	public void setCostoactividad(Integer costoactividad) {
		this.costoactividad = costoactividad;
	}
	public Integer getCostoactividadigv() {
		return costoactividadigv;
	}

	public void setCostoactividadigv(Integer costoactividadigv) {
		this.costoactividadigv = costoactividadigv;
	}
	public Integer getCostoext() {
		return costoext;
	}

	public void setCostoext(Integer costoext) {
		this.costoext = costoext;
	}
	public Integer getCostoigvext() {
		return costoigvext;
	}

	public void setCostoigvext(Integer costoigvext) {
		this.costoigvext = costoigvext;
	}
	public Integer getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}
	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
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
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
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
	public Integer getResultadoexcelente() {
		return resultadoexcelente;
	}

	public void setResultadoexcelente(Integer resultadoexcelente) {
		this.resultadoexcelente = resultadoexcelente;
	}
	public Integer getResultadobueno() {
		return resultadobueno;
	}

	public void setResultadobueno(Integer resultadobueno) {
		this.resultadobueno = resultadobueno;
	}
	public Integer getResultadoregular() {
		return resultadoregular;
	}

	public void setResultadoregular(Integer resultadoregular) {
		this.resultadoregular = resultadoregular;
	}
	public Integer getResultadomalo() {
		return resultadomalo;
	}

	public void setResultadomalo(Integer resultadomalo) {
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
	public Integer getRegistradopor() {
		return registradopor;
	}

	public void setRegistradopor(Integer registradopor) {
		this.registradopor = registradopor;
	}
	public Integer getAprobadopor() {
		return aprobadopor;
	}

	public void setAprobadopor(Integer aprobadopor) {
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
	public Integer getCodigometa() {
		return codigometa;
	}

	public void setCodigometa(Integer codigometa) {
		this.codigometa = codigometa;
	}
	public Integer getCodigolineaaccion() {
		return codigolineaaccion;
	}

	public void setCodigolineaaccion(Integer codigolineaaccion) {
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
	public Integer getOtrosparticipantes() {
		return otrosparticipantes;
	}

	public void setOtrosparticipantes(Integer otrosparticipantes) {
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
	public Integer getCostopresupuesto() {
		return costopresupuesto;
	}

	public void setCostopresupuesto(Integer costopresupuesto) {
		this.costopresupuesto = costopresupuesto;
	}
	public Integer getCostoreal() {
		return costoreal;
	}

	public void setCostoreal(Integer costoreal) {
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
	public Integer getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Integer solicitante) {
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
	public Integer getNivelaprobacion() {
		return nivelaprobacion;
	}

	public void setNivelaprobacion(Integer nivelaprobacion) {
		this.nivelaprobacion = nivelaprobacion;
	}
	public Integer getCostoadicional() {
		return costoadicional;
	}

	public void setCostoadicional(Integer costoadicional) {
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

}
