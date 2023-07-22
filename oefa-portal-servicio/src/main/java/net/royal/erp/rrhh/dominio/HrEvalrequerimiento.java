package net.royal.erp.rrhh.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 * The Class HrEvalrequerimiento.
 */
public class HrEvalrequerimiento extends DominioGenerico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HrEvalrequerimientoPk pk;
	private Integer evaluacion;
	private String etapa;
	private String unidadnegocio;
	private String plantillaevaluacion;
	private Integer reclutamientoetapa;
	private Date fechaevaluacion;
	private BigDecimal peso;
	private BigDecimal calificacionmaximo;
	private String lugar;
	private Date fechaevaluaciondesde;
	private Date fechaevaluacionhasta;
	private String flagpublicado;

	public HrEvalrequerimiento() {
		pk = new HrEvalrequerimientoPk();
	}

	public HrEvalrequerimientoPk getPk() {
		return pk;
	}

	public void setPk(HrEvalrequerimientoPk pk) {
		this.pk = pk;
	}

	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getPlantillaevaluacion() {
		return plantillaevaluacion;
	}

	public void setPlantillaevaluacion(String plantillaevaluacion) {
		this.plantillaevaluacion = plantillaevaluacion;
	}

	public Integer getReclutamientoetapa() {
		return reclutamientoetapa;
	}

	public void setReclutamientoetapa(Integer reclutamientoetapa) {
		this.reclutamientoetapa = reclutamientoetapa;
	}

	public Date getFechaevaluacion() {
		return fechaevaluacion;
	}

	public void setFechaevaluacion(Date fechaevaluacion) {
		this.fechaevaluacion = fechaevaluacion;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getCalificacionmaximo() {
		return calificacionmaximo;
	}

	public void setCalificacionmaximo(BigDecimal calificacionmaximo) {
		this.calificacionmaximo = calificacionmaximo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getFechaevaluaciondesde() {
		return fechaevaluaciondesde;
	}

	public void setFechaevaluaciondesde(Date fechaevaluaciondesde) {
		this.fechaevaluaciondesde = fechaevaluaciondesde;
	}

	public Date getFechaevaluacionhasta() {
		return fechaevaluacionhasta;
	}

	public void setFechaevaluacionhasta(Date fechaevaluacionhasta) {
		this.fechaevaluacionhasta = fechaevaluacionhasta;
	}

	public String getFlagpublicado() {
		return flagpublicado;
	}

	public void setFlagpublicado(String flagpublicado) {
		this.flagpublicado = flagpublicado;
	}

}
