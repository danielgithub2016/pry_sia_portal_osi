package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrDetalleevaluacion
*/
public class HrDetalleevaluacion extends DominioGenerico implements java.io.Serializable{
	private HrDetalleevaluacionPk pk;
	private BigDecimal factor;
	private BigDecimal factorsecuencia;
	private BigDecimal factorponderacion;
	private BigDecimal factorparticipacion;
	private BigDecimal ordenfactor;
	private BigDecimal secuenciacompetencia;
	private BigDecimal valorcompetencia;
	private BigDecimal valorhastacompetencia;
	private BigDecimal factorcompetencia;
	
	private String descripcion;
	private java.math.BigDecimal calificacion;
	private String unidadnegocio;
	private String plantilla;
	private Integer areaponderacion;
	private String comentarios;
	
	private String respaldaobjetivos;
	private java.util.Date ejecuciondesde;
	private java.util.Date ejecucionhasta;
	private Integer cursosdesarrollo;
	private java.math.BigDecimal calificacionponderada;
	private java.math.BigDecimal valorrequerido;
	private java.math.BigDecimal brecha;
	private java.math.BigDecimal percentil;
	private String flagcapacitacion;
	
	
	private String comentario;
	
	private String eliminado;
	


	public HrDetalleevaluacion() {
		pk = new HrDetalleevaluacionPk();
	}

	public HrDetalleevaluacionPk getPk() {
		return pk;
	}

	public void setPk(HrDetalleevaluacionPk pk) {
		this.pk = pk;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public BigDecimal getFactorsecuencia() {
		return factorsecuencia;
	}

	public void setFactorsecuencia(BigDecimal factorsecuencia) {
		this.factorsecuencia = factorsecuencia;
	}

	public BigDecimal getFactorponderacion() {
		return factorponderacion;
	}

	public void setFactorponderacion(BigDecimal factorponderacion) {
		this.factorponderacion = factorponderacion;
	}

	public BigDecimal getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(BigDecimal factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}

	public BigDecimal getOrdenfactor() {
		return ordenfactor;
	}

	public void setOrdenfactor(BigDecimal ordenfactor) {
		this.ordenfactor = ordenfactor;
	}

	public BigDecimal getSecuenciacompetencia() {
		return secuenciacompetencia;
	}

	public void setSecuenciacompetencia(BigDecimal secuenciacompetencia) {
		this.secuenciacompetencia = secuenciacompetencia;
	}

	public BigDecimal getValorcompetencia() {
		return valorcompetencia;
	}

	public void setValorcompetencia(BigDecimal valorcompetencia) {
		this.valorcompetencia = valorcompetencia;
	}

	public BigDecimal getValorhastacompetencia() {
		return valorhastacompetencia;
	}

	public void setValorhastacompetencia(BigDecimal valorhastacompetencia) {
		this.valorhastacompetencia = valorhastacompetencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public java.math.BigDecimal getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(java.math.BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	public Integer getAreaponderacion() {
		return areaponderacion;
	}

	public void setAreaponderacion(Integer areaponderacion) {
		this.areaponderacion = areaponderacion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getRespaldaobjetivos() {
		return respaldaobjetivos;
	}

	public void setRespaldaobjetivos(String respaldaobjetivos) {
		this.respaldaobjetivos = respaldaobjetivos;
	}

	public java.util.Date getEjecuciondesde() {
		return ejecuciondesde;
	}

	public void setEjecuciondesde(java.util.Date ejecuciondesde) {
		this.ejecuciondesde = ejecuciondesde;
	}

	public java.util.Date getEjecucionhasta() {
		return ejecucionhasta;
	}

	public void setEjecucionhasta(java.util.Date ejecucionhasta) {
		this.ejecucionhasta = ejecucionhasta;
	}

	public Integer getCursosdesarrollo() {
		return cursosdesarrollo;
	}

	public void setCursosdesarrollo(Integer cursosdesarrollo) {
		this.cursosdesarrollo = cursosdesarrollo;
	}

	public java.math.BigDecimal getCalificacionponderada() {
		return calificacionponderada;
	}

	public void setCalificacionponderada(java.math.BigDecimal calificacionponderada) {
		this.calificacionponderada = calificacionponderada;
	}

	public java.math.BigDecimal getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(java.math.BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}

	public java.math.BigDecimal getBrecha() {
		return brecha;
	}

	public void setBrecha(java.math.BigDecimal brecha) {
		this.brecha = brecha;
	}

	public java.math.BigDecimal getPercentil() {
		return percentil;
	}

	public void setPercentil(java.math.BigDecimal percentil) {
		this.percentil = percentil;
	}

	public String getFlagcapacitacion() {
		return flagcapacitacion;
	}

	public void setFlagcapacitacion(String flagcapacitacion) {
		this.flagcapacitacion = flagcapacitacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public BigDecimal getFactorcompetencia() {
		return factorcompetencia;
	}

	public void setFactorcompetencia(BigDecimal factorcompetencia) {
		this.factorcompetencia = factorcompetencia;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}
}
