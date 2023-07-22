package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.util.List;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuesta
 */
@SuppressWarnings("serial")
public class DtoHrEntrCasPostEval implements java.io.Serializable {

	private BigDecimal secuencia;
	private String requerimiento;
	private String postulante;
	private String estado;
	private String n_estado;
	private String puntaje;
	private String valor_s;
	private String valor_n;
	private String idaptitud;
	private String aptitud;
	private String flg_nsp;
	private String next_po;
	private String convocatoria;
	private String puesto;
	private String unidad;
	private String nompostulante;
	private String ptipo_sg;
	private String ptipo_au;
	private String ptipo_rh;
	private String ptipo_oa;
	private String ptipo_pd;
	private String tipo_sg;
	private String tipo_au;
	private String tipo_rh;
	private String tipo_oa;
	private String tipo_pd;
	private String nombre_tipo_sg;
	private String nombre_tipo_au;
	private String nombre_tipo_rh;
	private String nombre_tipo_oa;
	private String nombre_tipo_pd;
	private String fecha;
	private String hora;
	private String visible;
	private String sumtipo_sg;
	private String sumtipo_au;
	private String sumtipo_rh;
	private String sumtipo_oa;
	private String sumtipo_pd;
	private String promedio;
	private String flagtipopuesto;
	private String nombreevaluadores;
	private List<DtoHrEntrCasPostEval> lstConductas;
	private String idconducta;
	private String conducta;
	private BigDecimal peso;
	private BigDecimal puntajemaximo;
	private String valor_c;
	
	private String ingresoexamen;
	private String salidaexamen;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public String getNompostulante() {
		return nompostulante;
	}

	public void setNompostulante(String nompostulante) {
		this.nompostulante = nompostulante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getN_estado() {
		return n_estado;
	}

	public void setN_estado(String n_estado) {
		this.n_estado = n_estado;
	}

	public String getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}

	public String getValor_s() {
		return valor_s;
	}

	public void setValor_s(String valor_s) {
		this.valor_s = valor_s;
	}

	public String getValor_n() {
		return valor_n;
	}

	public void setValor_n(String valor_n) {
		this.valor_n = valor_n;
	}

	public String getAptitud() {
		return aptitud;
	}

	public void setAptitud(String aptitud) {
		this.aptitud = aptitud;
	}

	public String getIdaptitud() {
		return idaptitud;
	}

	public void setIdaptitud(String idaptitud) {
		this.idaptitud = idaptitud;
	}

	public String getFlg_nsp() {
		return flg_nsp;
	}

	public void setFlg_nsp(String flg_nsp) {
		this.flg_nsp = flg_nsp;
	}

	public String getNext_po() {
		return next_po;
	}

	public void setNext_po(String next_po) {
		this.next_po = next_po;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getPtipo_sg() {
		return ptipo_sg;
	}

	public void setPtipo_sg(String ptipo_sg) {
		this.ptipo_sg = ptipo_sg;
	}

	public String getPtipo_au() {
		return ptipo_au;
	}

	public void setPtipo_au(String ptipo_au) {
		this.ptipo_au = ptipo_au;
	}

	public String getPtipo_rh() {
		return ptipo_rh;
	}

	public void setPtipo_rh(String ptipo_rh) {
		this.ptipo_rh = ptipo_rh;
	}

	public String getPtipo_oa() {
		return ptipo_oa;
	}

	public void setPtipo_oa(String ptipo_oa) {
		this.ptipo_oa = ptipo_oa;
	}

	public String getPtipo_pd() {
		return ptipo_pd;
	}

	public void setPtipo_pd(String ptipo_pd) {
		this.ptipo_pd = ptipo_pd;
	}

	public String getTipo_sg() {
		return tipo_sg;
	}

	public void setTipo_sg(String tipo_sg) {
		this.tipo_sg = tipo_sg;
	}

	public String getTipo_au() {
		return tipo_au;
	}

	public void setTipo_au(String tipo_au) {
		this.tipo_au = tipo_au;
	}

	public String getTipo_rh() {
		return tipo_rh;
	}

	public void setTipo_rh(String tipo_rh) {
		this.tipo_rh = tipo_rh;
	}

	public String getTipo_oa() {
		return tipo_oa;
	}

	public void setTipo_oa(String tipo_oa) {
		this.tipo_oa = tipo_oa;
	}

	public String getTipo_pd() {
		return tipo_pd;
	}

	public void setTipo_pd(String tipo_pd) {
		this.tipo_pd = tipo_pd;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSumtipo_sg() {
		return sumtipo_sg;
	}

	public void setSumtipo_sg(String sumtipo_sg) {
		this.sumtipo_sg = sumtipo_sg;
	}

	public String getSumtipo_pd() {
		return sumtipo_pd;
	}

	public void setSumtipo_pd(String sumtipo_pd) {
		this.sumtipo_pd = sumtipo_pd;
	}

	public String getSumtipo_oa() {
		return sumtipo_oa;
	}

	public void setSumtipo_oa(String sumtipo_oa) {
		this.sumtipo_oa = sumtipo_oa;
	}

	public String getSumtipo_au() {
		return sumtipo_au;
	}

	public void setSumtipo_au(String sumtipo_au) {
		this.sumtipo_au = sumtipo_au;
	}

	public String getSumtipo_rh() {
		return sumtipo_rh;
	}

	public void setSumtipo_rh(String sumtipo_rh) {
		this.sumtipo_rh = sumtipo_rh;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

	public String getFlagtipopuesto() {
		return flagtipopuesto;
	}

	public void setFlagtipopuesto(String flagtipopuesto) {
		this.flagtipopuesto = flagtipopuesto;
	}

	public String getNombre_tipo_sg() {
		return nombre_tipo_sg;
	}

	public void setNombre_tipo_sg(String nombre_tipo_sg) {
		this.nombre_tipo_sg = nombre_tipo_sg;
	}

	public String getNombre_tipo_au() {
		return nombre_tipo_au;
	}

	public void setNombre_tipo_au(String nombre_tipo_au) {
		this.nombre_tipo_au = nombre_tipo_au;
	}

	public String getNombre_tipo_rh() {
		return nombre_tipo_rh;
	}

	public void setNombre_tipo_rh(String nombre_tipo_rh) {
		this.nombre_tipo_rh = nombre_tipo_rh;
	}

	public String getNombre_tipo_oa() {
		return nombre_tipo_oa;
	}

	public void setNombre_tipo_oa(String nombre_tipo_oa) {
		this.nombre_tipo_oa = nombre_tipo_oa;
	}

	public String getNombre_tipo_pd() {
		return nombre_tipo_pd;
	}

	public void setNombre_tipo_pd(String nombre_tipo_pd) {
		this.nombre_tipo_pd = nombre_tipo_pd;
	}

	public String getNombreevaluadores() {
		return nombreevaluadores;
	}

	public void setNombreevaluadores(String nombreevaluadores) {
		this.nombreevaluadores = nombreevaluadores;
	}

	public List<DtoHrEntrCasPostEval> getLstConductas() {
		return lstConductas;
	}

	public void setLstConductas(List<DtoHrEntrCasPostEval> lstConductas) {
		this.lstConductas = lstConductas;
	}

	public String getIdconducta() {
		return idconducta;
	}

	public void setIdconducta(String idconducta) {
		this.idconducta = idconducta;
	}

	public String getConducta() {
		return conducta;
	}

	public void setConducta(String conducta) {
		this.conducta = conducta;
	}

	public BigDecimal getPeso() {
		if(UValidador.esNulo(peso)){
			peso = BigDecimal.ZERO;
		}
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getValor_c() {
		return valor_c;
	}

	public void setValor_c(String valor_c) {
		this.valor_c = valor_c;
	}

	public BigDecimal getPuntajemaximo() {
		if(UValidador.esNulo(puntajemaximo)){
			puntajemaximo = BigDecimal.ZERO;
		}
		return puntajemaximo;
	}

	public void setPuntajemaximo(BigDecimal puntajemaximo) {
		this.puntajemaximo = puntajemaximo;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getIngresoexamen() {
		return ingresoexamen;
	}

	public void setIngresoexamen(String ingresoexamen) {
		this.ingresoexamen = ingresoexamen;
	}

	public String getSalidaexamen() {
		return salidaexamen;
	}

	public void setSalidaexamen(String salidaexamen) {
		this.salidaexamen = salidaexamen;
	}
	
}
