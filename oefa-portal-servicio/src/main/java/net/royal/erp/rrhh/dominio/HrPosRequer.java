package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPosrequer
*/
@SuppressWarnings("serial")
public class HrPosRequer extends DominioGenerico implements java.io.Serializable{

	private HrPosRequerPk pk;
	private String estado;
	private String etapa;
	private String tipopostulante;
	private String unidadnegocio;
	private Integer puntaje;
	private String observaciones;
	private java.util.Date fechapostulante;
	private BigDecimal variaberemunerativa;
	private Integer secuencia;
	private String condvarrem;
	private String observacionesfinales;
	private Integer secuencia2;
	private String flagFormacion;
	private Integer otrosestudios;
	private String flagOtrosestudios;
	private Integer experiencia;
	private String flagExperiencia;
	private String flagganador;


	public HrPosRequer() {
		pk = new HrPosRequerPk();
	}

	public HrPosRequerPk getPk() {
		return pk;
	}

	public void setPk(HrPosRequerPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getTipopostulante() {
		return tipopostulante;
	}

	public void setTipopostulante(String tipopostulante) {
		this.tipopostulante = tipopostulante;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public java.util.Date getFechapostulante() {
		return fechapostulante;
	}

	public void setFechapostulante(java.util.Date fechapostulante) {
		this.fechapostulante = fechapostulante;
	}
	public BigDecimal getVariaberemunerativa() {
		return variaberemunerativa;
	}

	public void setVariaberemunerativa(BigDecimal variaberemunerativa) {
		this.variaberemunerativa = variaberemunerativa;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getCondvarrem() {
		return condvarrem;
	}

	public void setCondvarrem(String condvarrem) {
		this.condvarrem = condvarrem;
	}
	public String getObservacionesfinales() {
		return observacionesfinales;
	}

	public void setObservacionesfinales(String observacionesfinales) {
		this.observacionesfinales = observacionesfinales;
	}
	public Integer getSecuencia2() {
		return secuencia2;
	}

	public void setSecuencia2(Integer secuencia2) {
		this.secuencia2 = secuencia2;
	}
	public String getFlagFormacion() {
		return flagFormacion;
	}

	public void setFlagFormacion(String flagFormacion) {
		this.flagFormacion = flagFormacion;
	}
	public Integer getOtrosestudios() {
		return otrosestudios;
	}

	public void setOtrosestudios(Integer otrosestudios) {
		this.otrosestudios = otrosestudios;
	}
	public String getFlagOtrosestudios() {
		return flagOtrosestudios;
	}

	public void setFlagOtrosestudios(String flagOtrosestudios) {
		this.flagOtrosestudios = flagOtrosestudios;
	}
	public Integer getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}
	public String getFlagExperiencia() {
		return flagExperiencia;
	}

	public void setFlagExperiencia(String flagExperiencia) {
		this.flagExperiencia = flagExperiencia;
	}
	public String getFlagganador() {
		return flagganador;
	}

	public void setFlagganador(String flagganador) {
		this.flagganador = flagganador;
	}

}
