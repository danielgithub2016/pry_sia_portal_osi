package net.royal.rrhh.vista.opciones;

import net.royal.framework.web.core.UValidador;

public class OWHrRequerimientoEdit {

	private Boolean ismostrartabfuncionescas;
	private Boolean ismostrartabfuncionesprac;
	private Boolean ismostrartabreqadicionales;
	private Boolean ismostrartabadicionales;
	private Boolean ismostrartabevaluaciones;
	private Boolean ismostrartabcandidatos;
	private Boolean ismostrartabcomparativo;
	private Boolean ismostrartabaprobacion;

	private Boolean ishabilitartabfuncionescas;
	private Boolean ishabilitartabfuncionesprac;
	private Boolean ishabilitartabreqadicionales;
	private Boolean ishabilitartabadicionales;
	private Boolean ishabilitartabevaluaciones;
	private Boolean ishabilitartabcandidatos;
	private Boolean ishabilitartabcomparativo;
	private Boolean ishabilitartabaprobacion;

	private Boolean ishabilitarcbver1;
	private Boolean ishabilitarcbver2;
	private Boolean ishabilitarmotivorechazo;

	private Boolean ishabilitarfechadesde;
	private Boolean ishabilitarfechahasta;

	private Boolean ismostrartiporeclutamiento;

	private Boolean ishabilitarempleadoresponsable;
	private Boolean ishabilitardwadicionales;

	private Boolean ishabilitardesnuevocurso;

	private Boolean ishabilitarcompania;

	private Boolean ishabilitarbpuesto;
	private Boolean ishabilitarbempsolicitante;
	private Boolean ishabilitarbcodigojefe;

	private Boolean ishabilitardwfuncionescas;
	private Boolean ishabilitardwfuncionescasdet;
	private Boolean ishabilitardwfuncionesprac;
	private Boolean ishabilitarcbagregarfuncas;
	private Boolean ishabilitarcbeliminarfuncas;
	private Boolean ishabilitarcbagregarfuncasdet;
	private Boolean ishabilitarcbeliminarfuncasdet;
	private Boolean ishabilitarcbescoger;
	private Boolean ishabilitarcbcopiar;

	private Boolean ismostrarcbagregarfuncas;
	private Boolean ismostrarcbeliminarfuncas;
	private Boolean ismostrarcbagregarfuncasdet;
	private Boolean ismostrarcbeliminarfuncasdet;
	private Boolean ismostrarcbescoger;

	private Boolean ishabilitarremuneracionreferencialbruto;
	private Boolean ishabilitarremuneracionreferencialneto;
	private Boolean ishabilitarcorreoelectronico;
	private Boolean ishabilitarflagtarjetapersonal;
	private Boolean ishabilitargrupocorreoelectronico;
	private Boolean ishabilitarflagaccesointernet;
	private Boolean ishailitarperfiladicional;
	private Boolean ishabilitarperfiladicional;

	private Boolean ishabilitarcodigopuesto;
	private Boolean ishabilitarbnivelservicio;

	private Boolean ishabilitartiporeclutamiento;
	private Boolean ishabilitardwrequerimiento;

	private Boolean ismostrarver;
	private Boolean ishabilitarrutadocumento;
	private Boolean ishabilitarnumerosolicitud;

	private Boolean ismostrarcbeditarfuncas;

	private Boolean ishabilitarmesesprueba;

	public OWHrRequerimientoEdit() {
		ismostrartabreqadicionales = true;
		ismostrartabfuncionescas = false;
		ismostrartabfuncionesprac = false;
		ishabilitarrutadocumento = true;
		ishabilitarnumerosolicitud = true;
		ismostrarcbagregarfuncas = true;
		ismostrarcbeliminarfuncas = true;
		ismostrarcbagregarfuncasdet = true;
		ismostrarcbeliminarfuncasdet = true;
		ishabilitardwfuncionesprac = true;
		ishabilitardwfuncionescas = true;
		ishabilitardwfuncionescasdet = true;
		ismostrarcbeditarfuncas = true;
	}

	/**
	 * @return the ismostrartabfuncionescas
	 */
	public Boolean getIsmostrartabfuncionescas() {
		return ismostrartabfuncionescas;
	}

	/**
	 * @param ismostrartabfuncionescas
	 *            the ismostrartabfuncionescas to set
	 */
	public void setIsmostrartabfuncionescas(Boolean ismostrartabfuncionescas) {
		this.ismostrartabfuncionescas = ismostrartabfuncionescas;
	}

	/**
	 * @return the ismostrartabfuncionesprac
	 */
	public Boolean getIsmostrartabfuncionesprac() {
		return ismostrartabfuncionesprac;
	}

	/**
	 * @param ismostrartabfuncionesprac
	 *            the ismostrartabfuncionesprac to set
	 */
	public void setIsmostrartabfuncionesprac(Boolean ismostrartabfuncionesprac) {
		this.ismostrartabfuncionesprac = ismostrartabfuncionesprac;
	}

	/**
	 * @return the ismostrartabreqadicionales
	 */
	public Boolean getIsmostrartabreqadicionales() {
		return ismostrartabreqadicionales;
	}

	/**
	 * @param ismostrartabreqadicionales
	 *            the ismostrartabreqadicionales to set
	 */
	public void setIsmostrartabreqadicionales(Boolean ismostrartabreqadicionales) {
		this.ismostrartabreqadicionales = ismostrartabreqadicionales;
	}

	/**
	 * @return the ismostrartabadicionales
	 */
	public Boolean getIsmostrartabadicionales() {
		return ismostrartabadicionales;
	}

	/**
	 * @param ismostrartabadicionales
	 *            the ismostrartabadicionales to set
	 */
	public void setIsmostrartabadicionales(Boolean ismostrartabadicionales) {
		this.ismostrartabadicionales = ismostrartabadicionales;
	}

	/**
	 * @return the ismostrartabevaluaciones
	 */
	public Boolean getIsmostrartabevaluaciones() {
		return ismostrartabevaluaciones;
	}

	/**
	 * @param ismostrartabevaluaciones
	 *            the ismostrartabevaluaciones to set
	 */
	public void setIsmostrartabevaluaciones(Boolean ismostrartabevaluaciones) {
		this.ismostrartabevaluaciones = ismostrartabevaluaciones;
	}

	/**
	 * @return the ismostrartabcandidatos
	 */
	public Boolean getIsmostrartabcandidatos() {
		return ismostrartabcandidatos;
	}

	/**
	 * @param ismostrartabcandidatos
	 *            the ismostrartabcandidatos to set
	 */
	public void setIsmostrartabcandidatos(Boolean ismostrartabcandidatos) {
		this.ismostrartabcandidatos = ismostrartabcandidatos;
	}

	/**
	 * @return the ismostrartabcomparativo
	 */
	public Boolean getIsmostrartabcomparativo() {
		return ismostrartabcomparativo;
	}

	/**
	 * @param ismostrartabcomparativo
	 *            the ismostrartabcomparativo to set
	 */
	public void setIsmostrartabcomparativo(Boolean ismostrartabcomparativo) {
		this.ismostrartabcomparativo = ismostrartabcomparativo;
	}

	/**
	 * @return the ismostrartabaprobacion
	 */
	public Boolean getIsmostrartabaprobacion() {
		return ismostrartabaprobacion;
	}

	/**
	 * @param ismostrartabaprobacion
	 *            the ismostrartabaprobacion to set
	 */
	public void setIsmostrartabaprobacion(Boolean ismostrartabaprobacion) {
		this.ismostrartabaprobacion = ismostrartabaprobacion;
	}

	/**
	 * @return the ishabilitartabfuncionescas
	 */
	public Boolean getIshabilitartabfuncionescas() {
		if (UValidador.esNulo(ishabilitartabfuncionescas)) {
			ishabilitartabfuncionescas = false;
		}
		return ishabilitartabfuncionescas;
	}

	/**
	 * @param ishabilitartabfuncionescas
	 *            the ishabilitartabfuncionescas to set
	 */
	public void setIshabilitartabfuncionescas(Boolean ishabilitartabfuncionescas) {
		this.ishabilitartabfuncionescas = ishabilitartabfuncionescas;
	}

	/**
	 * @return the ishabilitartabfuncionesprac
	 */
	public Boolean getIshabilitartabfuncionesprac() {
		if (UValidador.esNulo(ishabilitartabfuncionesprac)) {
			ishabilitartabfuncionesprac = false;
		}
		return ishabilitartabfuncionesprac;
	}

	/**
	 * @param ishabilitartabfuncionesprac
	 *            the ishabilitartabfuncionesprac to set
	 */
	public void setIshabilitartabfuncionesprac(
			Boolean ishabilitartabfuncionesprac) {
		this.ishabilitartabfuncionesprac = ishabilitartabfuncionesprac;
	}

	/**
	 * @return the ishabilitartabreqadicionales
	 */
	public Boolean getIshabilitartabreqadicionales() {
		return ishabilitartabreqadicionales;
	}

	/**
	 * @param ishabilitartabreqadicionales
	 *            the ishabilitartabreqadicionales to set
	 */
	public void setIshabilitartabreqadicionales(
			Boolean ishabilitartabreqadicionales) {
		this.ishabilitartabreqadicionales = ishabilitartabreqadicionales;
	}

	/**
	 * @return the ishabilitartabadicionales
	 */
	public Boolean getIshabilitartabadicionales() {
		return ishabilitartabadicionales;
	}

	/**
	 * @param ishabilitartabadicionales
	 *            the ishabilitartabadicionales to set
	 */
	public void setIshabilitartabadicionales(Boolean ishabilitartabadicionales) {
		this.ishabilitartabadicionales = ishabilitartabadicionales;
	}

	/**
	 * @return the ishabilitartabevaluaciones
	 */
	public Boolean getIshabilitartabevaluaciones() {
		return ishabilitartabevaluaciones;
	}

	/**
	 * @param ishabilitartabevaluaciones
	 *            the ishabilitartabevaluaciones to set
	 */
	public void setIshabilitartabevaluaciones(Boolean ishabilitartabevaluaciones) {
		this.ishabilitartabevaluaciones = ishabilitartabevaluaciones;
	}

	/**
	 * @return the ishabilitartabcandidatos
	 */
	public Boolean getIshabilitartabcandidatos() {
		return ishabilitartabcandidatos;
	}

	/**
	 * @param ishabilitartabcandidatos
	 *            the ishabilitartabcandidatos to set
	 */
	public void setIshabilitartabcandidatos(Boolean ishabilitartabcandidatos) {
		this.ishabilitartabcandidatos = ishabilitartabcandidatos;
	}

	/**
	 * @return the ishabilitartabcomparativo
	 */
	public Boolean getIshabilitartabcomparativo() {
		return ishabilitartabcomparativo;
	}

	/**
	 * @param ishabilitartabcomparativo
	 *            the ishabilitartabcomparativo to set
	 */
	public void setIshabilitartabcomparativo(Boolean ishabilitartabcomparativo) {
		this.ishabilitartabcomparativo = ishabilitartabcomparativo;
	}

	/**
	 * @return the ishabilitartabaprobacion
	 */
	public Boolean getIshabilitartabaprobacion() {
		return ishabilitartabaprobacion;
	}

	/**
	 * @param ishabilitartabaprobacion
	 *            the ishabilitartabaprobacion to set
	 */
	public void setIshabilitartabaprobacion(Boolean ishabilitartabaprobacion) {
		this.ishabilitartabaprobacion = ishabilitartabaprobacion;
	}

	/**
	 * @return the ishabilitarcbver1
	 */
	public Boolean getIshabilitarcbver1() {
		return ishabilitarcbver1;
	}

	/**
	 * @param ishabilitarcbver1
	 *            the ishabilitarcbver1 to set
	 */
	public void setIshabilitarcbver1(Boolean ishabilitarcbver1) {
		this.ishabilitarcbver1 = ishabilitarcbver1;
	}

	/**
	 * @return the ishabilitarcbver2
	 */
	public Boolean getIshabilitarcbver2() {
		return ishabilitarcbver2;
	}

	/**
	 * @param ishabilitarcbver2
	 *            the ishabilitarcbver2 to set
	 */
	public void setIshabilitarcbver2(Boolean ishabilitarcbver2) {
		this.ishabilitarcbver2 = ishabilitarcbver2;
	}

	/**
	 * @return the ishabilitarmotivorechazo
	 */
	public Boolean getIshabilitarmotivorechazo() {
		return ishabilitarmotivorechazo;
	}

	/**
	 * @param ishabilitarmotivorechazo
	 *            the ishabilitarmotivorechazo to set
	 */
	public void setIshabilitarmotivorechazo(Boolean ishabilitarmotivorechazo) {
		this.ishabilitarmotivorechazo = ishabilitarmotivorechazo;
	}

	/**
	 * @return the ishabilitarfechadesde
	 */
	public Boolean getIshabilitarfechadesde() {
		return ishabilitarfechadesde;
	}

	/**
	 * @param ishabilitarfechadesde
	 *            the ishabilitarfechadesde to set
	 */
	public void setIshabilitarfechadesde(Boolean ishabilitarfechadesde) {
		this.ishabilitarfechadesde = ishabilitarfechadesde;
	}

	/**
	 * @return the ishabilitarfechahasta
	 */
	public Boolean getIshabilitarfechahasta() {
		return ishabilitarfechahasta;
	}

	/**
	 * @param ishabilitarfechahasta
	 *            the ishabilitarfechahasta to set
	 */
	public void setIshabilitarfechahasta(Boolean ishabilitarfechahasta) {
		this.ishabilitarfechahasta = ishabilitarfechahasta;
	}

	/**
	 * @return the ismostrartiporeclutamiento
	 */
	public Boolean getIsmostrartiporeclutamiento() {
		return ismostrartiporeclutamiento;
	}

	/**
	 * @param ismostrartiporeclutamiento
	 *            the ismostrartiporeclutamiento to set
	 */
	public void setIsmostrartiporeclutamiento(Boolean ismostrartiporeclutamiento) {
		this.ismostrartiporeclutamiento = ismostrartiporeclutamiento;
	}

	/**
	 * @return the ishabilitarempleadoresponsable
	 */
	public Boolean getIshabilitarempleadoresponsable() {
		return ishabilitarempleadoresponsable;
	}

	/**
	 * @param ishabilitarempleadoresponsable
	 *            the ishabilitarempleadoresponsable to set
	 */
	public void setIshabilitarempleadoresponsable(
			Boolean ishabilitarempleadoresponsable) {
		this.ishabilitarempleadoresponsable = ishabilitarempleadoresponsable;
	}

	/**
	 * @return the ishabilitardwadicionales
	 */
	public Boolean getIshabilitardwadicionales() {
		return ishabilitardwadicionales;
	}

	/**
	 * @param ishabilitardwadicionales
	 *            the ishabilitardwadicionales to set
	 */
	public void setIshabilitardwadicionales(Boolean ishabilitardwadicionales) {
		this.ishabilitardwadicionales = ishabilitardwadicionales;
	}

	/**
	 * @return the ishabilitardesnuevocurso
	 */
	public Boolean getIshabilitardesnuevocurso() {
		return ishabilitardesnuevocurso;
	}

	/**
	 * @param ishabilitardesnuevocurso
	 *            the ishabilitardesnuevocurso to set
	 */
	public void setIshabilitardesnuevocurso(Boolean ishabilitardesnuevocurso) {
		this.ishabilitardesnuevocurso = ishabilitardesnuevocurso;
	}

	/**
	 * @return the ishabilitarcompania
	 */
	public Boolean getIshabilitarcompania() {
		return ishabilitarcompania;
	}

	/**
	 * @param ishabilitarcompania
	 *            the ishabilitarcompania to set
	 */
	public void setIshabilitarcompania(Boolean ishabilitarcompania) {
		this.ishabilitarcompania = ishabilitarcompania;
	}

	/**
	 * @return the ishabilitarbpuesto
	 */
	public Boolean getIshabilitarbpuesto() {
		return ishabilitarbpuesto;
	}

	/**
	 * @param ishabilitarbpuesto
	 *            the ishabilitarbpuesto to set
	 */
	public void setIshabilitarbpuesto(Boolean ishabilitarbpuesto) {
		this.ishabilitarbpuesto = ishabilitarbpuesto;
	}

	/**
	 * @return the ishabilitarbempsolicitante
	 */
	public Boolean getIshabilitarbempsolicitante() {
		return ishabilitarbempsolicitante;
	}

	/**
	 * @param ishabilitarbempsolicitante
	 *            the ishabilitarbempsolicitante to set
	 */
	public void setIshabilitarbempsolicitante(Boolean ishabilitarbempsolicitante) {
		this.ishabilitarbempsolicitante = ishabilitarbempsolicitante;
	}

	/**
	 * @return the ishabilitarbcodigojefe
	 */
	public Boolean getIshabilitarbcodigojefe() {
		return ishabilitarbcodigojefe;
	}

	/**
	 * @param ishabilitarbcodigojefe
	 *            the ishabilitarbcodigojefe to set
	 */
	public void setIshabilitarbcodigojefe(Boolean ishabilitarbcodigojefe) {
		this.ishabilitarbcodigojefe = ishabilitarbcodigojefe;
	}

	/**
	 * @return the ishabilitardwfuncionescas
	 */
	public Boolean getIshabilitardwfuncionescas() {
		return ishabilitardwfuncionescas;
	}

	/**
	 * @param ishabilitardwfuncionescas
	 *            the ishabilitardwfuncionescas to set
	 */
	public void setIshabilitardwfuncionescas(Boolean ishabilitardwfuncionescas) {
		this.ishabilitardwfuncionescas = ishabilitardwfuncionescas;
	}

	/**
	 * @return the ishabilitardwfuncionescasdet
	 */
	public Boolean getIshabilitardwfuncionescasdet() {
		return ishabilitardwfuncionescasdet;
	}

	/**
	 * @param ishabilitardwfuncionescasdet
	 *            the ishabilitardwfuncionescasdet to set
	 */
	public void setIshabilitardwfuncionescasdet(
			Boolean ishabilitardwfuncionescasdet) {
		this.ishabilitardwfuncionescasdet = ishabilitardwfuncionescasdet;
	}

	/**
	 * @return the ishabilitardwfuncionesprac
	 */
	public Boolean getIshabilitardwfuncionesprac() {
		return ishabilitardwfuncionesprac;
	}

	/**
	 * @param ishabilitardwfuncionesprac
	 *            the ishabilitardwfuncionesprac to set
	 */
	public void setIshabilitardwfuncionesprac(Boolean ishabilitardwfuncionesprac) {
		this.ishabilitardwfuncionesprac = ishabilitardwfuncionesprac;
	}

	/**
	 * @return the ishabilitarcbagregarfuncas
	 */
	public Boolean getIshabilitarcbagregarfuncas() {
		return ishabilitarcbagregarfuncas;
	}

	/**
	 * @param ishabilitarcbagregarfuncas
	 *            the ishabilitarcbagregarfuncas to set
	 */
	public void setIshabilitarcbagregarfuncas(Boolean ishabilitarcbagregarfuncas) {
		this.ishabilitarcbagregarfuncas = ishabilitarcbagregarfuncas;
	}

	/**
	 * @return the ishabilitarcbeliminarfuncas
	 */
	public Boolean getIshabilitarcbeliminarfuncas() {
		return ishabilitarcbeliminarfuncas;
	}

	/**
	 * @param ishabilitarcbeliminarfuncas
	 *            the ishabilitarcbeliminarfuncas to set
	 */
	public void setIshabilitarcbeliminarfuncas(
			Boolean ishabilitarcbeliminarfuncas) {
		this.ishabilitarcbeliminarfuncas = ishabilitarcbeliminarfuncas;
	}

	/**
	 * @return the ishabilitarcbagregarfuncasdet
	 */
	public Boolean getIshabilitarcbagregarfuncasdet() {
		return ishabilitarcbagregarfuncasdet;
	}

	/**
	 * @param ishabilitarcbagregarfuncasdet
	 *            the ishabilitarcbagregarfuncasdet to set
	 */
	public void setIshabilitarcbagregarfuncasdet(
			Boolean ishabilitarcbagregarfuncasdet) {
		this.ishabilitarcbagregarfuncasdet = ishabilitarcbagregarfuncasdet;
	}

	/**
	 * @return the ishabilitarcbeliminarfuncasdet
	 */
	public Boolean getIshabilitarcbeliminarfuncasdet() {
		return ishabilitarcbeliminarfuncasdet;
	}

	/**
	 * @param ishabilitarcbeliminarfuncasdet
	 *            the ishabilitarcbeliminarfuncasdet to set
	 */
	public void setIshabilitarcbeliminarfuncasdet(
			Boolean ishabilitarcbeliminarfuncasdet) {
		this.ishabilitarcbeliminarfuncasdet = ishabilitarcbeliminarfuncasdet;
	}

	/**
	 * @return the ishabilitarcbescoger
	 */
	public Boolean getIshabilitarcbescoger() {
		return ishabilitarcbescoger;
	}

	/**
	 * @param ishabilitarcbescoger
	 *            the ishabilitarcbescoger to set
	 */
	public void setIshabilitarcbescoger(Boolean ishabilitarcbescoger) {
		this.ishabilitarcbescoger = ishabilitarcbescoger;
	}

	/**
	 * @return the ishabilitarcbcopiar
	 */
	public Boolean getIshabilitarcbcopiar() {
		return ishabilitarcbcopiar;
	}

	/**
	 * @param ishabilitarcbcopiar
	 *            the ishabilitarcbcopiar to set
	 */
	public void setIshabilitarcbcopiar(Boolean ishabilitarcbcopiar) {
		this.ishabilitarcbcopiar = ishabilitarcbcopiar;
	}

	/**
	 * @return the ismostrarcbagregarfuncas
	 */
	public Boolean getIsmostrarcbagregarfuncas() {
		return ismostrarcbagregarfuncas;
	}

	/**
	 * @param ismostrarcbagregarfuncas
	 *            the ismostrarcbagregarfuncas to set
	 */
	public void setIsmostrarcbagregarfuncas(Boolean ismostrarcbagregarfuncas) {
		this.ismostrarcbagregarfuncas = ismostrarcbagregarfuncas;
	}

	/**
	 * @return the ismostrarcbeliminarfuncas
	 */
	public Boolean getIsmostrarcbeliminarfuncas() {
		return ismostrarcbeliminarfuncas;
	}

	/**
	 * @param ismostrarcbeliminarfuncas
	 *            the ismostrarcbeliminarfuncas to set
	 */
	public void setIsmostrarcbeliminarfuncas(Boolean ismostrarcbeliminarfuncas) {
		this.ismostrarcbeliminarfuncas = ismostrarcbeliminarfuncas;
	}

	/**
	 * @return the ismostrarcbagregarfuncasdet
	 */
	public Boolean getIsmostrarcbagregarfuncasdet() {
		return ismostrarcbagregarfuncasdet;
	}

	/**
	 * @param ismostrarcbagregarfuncasdet
	 *            the ismostrarcbagregarfuncasdet to set
	 */
	public void setIsmostrarcbagregarfuncasdet(
			Boolean ismostrarcbagregarfuncasdet) {
		this.ismostrarcbagregarfuncasdet = ismostrarcbagregarfuncasdet;
	}

	/**
	 * @return the ismostrarcbeliminarfuncasdet
	 */
	public Boolean getIsmostrarcbeliminarfuncasdet() {
		return ismostrarcbeliminarfuncasdet;
	}

	/**
	 * @param ismostrarcbeliminarfuncasdet
	 *            the ismostrarcbeliminarfuncasdet to set
	 */
	public void setIsmostrarcbeliminarfuncasdet(
			Boolean ismostrarcbeliminarfuncasdet) {
		this.ismostrarcbeliminarfuncasdet = ismostrarcbeliminarfuncasdet;
	}

	/**
	 * @return the ismostrarcbescoger
	 */
	public Boolean getIsmostrarcbescoger() {
		return ismostrarcbescoger;
	}

	/**
	 * @param ismostrarcbescoger
	 *            the ismostrarcbescoger to set
	 */
	public void setIsmostrarcbescoger(Boolean ismostrarcbescoger) {
		this.ismostrarcbescoger = ismostrarcbescoger;
	}

	/**
	 * @return the ishabilitarremuneracionreferencialbruto
	 */
	public Boolean getIshabilitarremuneracionreferencialbruto() {
		return ishabilitarremuneracionreferencialbruto;
	}

	/**
	 * @param ishabilitarremuneracionreferencialbruto
	 *            the ishabilitarremuneracionreferencialbruto to set
	 */
	public void setIshabilitarremuneracionreferencialbruto(
			Boolean ishabilitarremuneracionreferencialbruto) {
		this.ishabilitarremuneracionreferencialbruto = ishabilitarremuneracionreferencialbruto;
	}

	/**
	 * @return the ishabilitarremuneracionreferencialneto
	 */
	public Boolean getIshabilitarremuneracionreferencialneto() {
		return ishabilitarremuneracionreferencialneto;
	}

	/**
	 * @param ishabilitarremuneracionreferencialneto
	 *            the ishabilitarremuneracionreferencialneto to set
	 */
	public void setIshabilitarremuneracionreferencialneto(
			Boolean ishabilitarremuneracionreferencialneto) {
		this.ishabilitarremuneracionreferencialneto = ishabilitarremuneracionreferencialneto;
	}

	/**
	 * @return the ishabilitarcorreoelectronico
	 */
	public Boolean getIshabilitarcorreoelectronico() {
		return ishabilitarcorreoelectronico;
	}

	/**
	 * @param ishabilitarcorreoelectronico
	 *            the ishabilitarcorreoelectronico to set
	 */
	public void setIshabilitarcorreoelectronico(
			Boolean ishabilitarcorreoelectronico) {
		this.ishabilitarcorreoelectronico = ishabilitarcorreoelectronico;
	}

	/**
	 * @return the ishabilitarflagtarjetapersonal
	 */
	public Boolean getIshabilitarflagtarjetapersonal() {
		return ishabilitarflagtarjetapersonal;
	}

	/**
	 * @param ishabilitarflagtarjetapersonal
	 *            the ishabilitarflagtarjetapersonal to set
	 */
	public void setIshabilitarflagtarjetapersonal(
			Boolean ishabilitarflagtarjetapersonal) {
		this.ishabilitarflagtarjetapersonal = ishabilitarflagtarjetapersonal;
	}

	/**
	 * @return the ishabilitargrupocorreoelectronico
	 */
	public Boolean getIshabilitargrupocorreoelectronico() {
		return ishabilitargrupocorreoelectronico;
	}

	/**
	 * @param ishabilitargrupocorreoelectronico
	 *            the ishabilitargrupocorreoelectronico to set
	 */
	public void setIshabilitargrupocorreoelectronico(
			Boolean ishabilitargrupocorreoelectronico) {
		this.ishabilitargrupocorreoelectronico = ishabilitargrupocorreoelectronico;
	}

	/**
	 * @return the ishabilitarflagaccesointernet
	 */
	public Boolean getIshabilitarflagaccesointernet() {
		return ishabilitarflagaccesointernet;
	}

	/**
	 * @param ishabilitarflagaccesointernet
	 *            the ishabilitarflagaccesointernet to set
	 */
	public void setIshabilitarflagaccesointernet(
			Boolean ishabilitarflagaccesointernet) {
		this.ishabilitarflagaccesointernet = ishabilitarflagaccesointernet;
	}

	/**
	 * @return the ishailitarperfiladicional
	 */
	public Boolean getIshailitarperfiladicional() {
		return ishailitarperfiladicional;
	}

	/**
	 * @param ishailitarperfiladicional
	 *            the ishailitarperfiladicional to set
	 */
	public void setIshailitarperfiladicional(Boolean ishailitarperfiladicional) {
		this.ishailitarperfiladicional = ishailitarperfiladicional;
	}

	/**
	 * @return the ishabilitarperfiladicional
	 */
	public Boolean getIshabilitarperfiladicional() {
		return ishabilitarperfiladicional;
	}

	/**
	 * @param ishabilitarperfiladicional
	 *            the ishabilitarperfiladicional to set
	 */
	public void setIshabilitarperfiladicional(Boolean ishabilitarperfiladicional) {
		this.ishabilitarperfiladicional = ishabilitarperfiladicional;
	}

	/**
	 * @return the ishabilitarcodigopuesto
	 */
	public Boolean getIshabilitarcodigopuesto() {
		return ishabilitarcodigopuesto;
	}

	/**
	 * @param ishabilitarcodigopuesto
	 *            the ishabilitarcodigopuesto to set
	 */
	public void setIshabilitarcodigopuesto(Boolean ishabilitarcodigopuesto) {
		this.ishabilitarcodigopuesto = ishabilitarcodigopuesto;
	}

	/**
	 * @return the ishabilitarbnivelservicio
	 */
	public Boolean getIshabilitarbnivelservicio() {
		return ishabilitarbnivelservicio;
	}

	/**
	 * @param ishabilitarbnivelservicio
	 *            the ishabilitarbnivelservicio to set
	 */
	public void setIshabilitarbnivelservicio(Boolean ishabilitarbnivelservicio) {
		this.ishabilitarbnivelservicio = ishabilitarbnivelservicio;
	}

	/**
	 * @return the ishabilitartiporeclutamiento
	 */
	public Boolean getIshabilitartiporeclutamiento() {
		return ishabilitartiporeclutamiento;
	}

	/**
	 * @param ishabilitartiporeclutamiento
	 *            the ishabilitartiporeclutamiento to set
	 */
	public void setIshabilitartiporeclutamiento(
			Boolean ishabilitartiporeclutamiento) {
		this.ishabilitartiporeclutamiento = ishabilitartiporeclutamiento;
	}

	/**
	 * @return the ishabilitardwrequerimiento
	 */
	public Boolean getIshabilitardwrequerimiento() {
		return ishabilitardwrequerimiento;
	}

	/**
	 * @param ishabilitardwrequerimiento
	 *            the ishabilitardwrequerimiento to set
	 */
	public void setIshabilitardwrequerimiento(Boolean ishabilitardwrequerimiento) {
		this.ishabilitardwrequerimiento = ishabilitardwrequerimiento;
	}

	/**
	 * @return the ismostrarver
	 */
	public Boolean getIsmostrarver() {
		return ismostrarver;
	}

	/**
	 * @param ismostrarver
	 *            the ismostrarver to set
	 */
	public void setIsmostrarver(Boolean ismostrarver) {
		this.ismostrarver = ismostrarver;
	}

	/**
	 * @return the ishabilitarrutadocumento
	 */
	public Boolean getIshabilitarrutadocumento() {
		return ishabilitarrutadocumento;
	}

	/**
	 * @param ishabilitarrutadocumento
	 *            the ishabilitarrutadocumento to set
	 */
	public void setIshabilitarrutadocumento(Boolean ishabilitarrutadocumento) {
		this.ishabilitarrutadocumento = ishabilitarrutadocumento;
	}

	/**
	 * @return the ishabilitarnumerosolicitud
	 */
	public Boolean getIshabilitarnumerosolicitud() {
		return ishabilitarnumerosolicitud;
	}

	/**
	 * @param ishabilitarnumerosolicitud
	 *            the ishabilitarnumerosolicitud to set
	 */
	public void setIshabilitarnumerosolicitud(Boolean ishabilitarnumerosolicitud) {
		this.ishabilitarnumerosolicitud = ishabilitarnumerosolicitud;
	}

	/**
	 * @return the ismostrarcbeditarfuncas
	 */
	public Boolean getIsmostrarcbeditarfuncas() {
		return ismostrarcbeditarfuncas;
	}

	/**
	 * @param ismostrarcbeditarfuncas
	 *            the ismostrarcbeditarfuncas to set
	 */
	public void setIsmostrarcbeditarfuncas(Boolean ismostrarcbeditarfuncas) {
		this.ismostrarcbeditarfuncas = ismostrarcbeditarfuncas;
	}

	public Boolean getIshabilitarmesesprueba() {
		return ishabilitarmesesprueba;
	}

	public void setIshabilitarmesesprueba(Boolean ishabilitarmesesprueba) {
		this.ishabilitarmesesprueba = ishabilitarmesesprueba;
	}

}
