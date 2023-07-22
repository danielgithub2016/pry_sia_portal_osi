package net.royal.erp.rrhh.hrproc.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 * The Class DtoDwHrRequerimientoevalentrevistaEditB.
 */
public class DtoDwHrRequerimientoevalentrevistaEditB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String requerimiento;
	private Integer secuencia;
	private Integer secuencia2;
	private String companyowner;
	private String postulante;
	private Integer factor;
	private String flagaprobacion;
	private String ultimousuario;
	private Date ultimafechamodif;
	private BigDecimal calificativo;
	private String unidadnegocio;
	private String etapa;
	private String descevaluacion;
	private String descripcioneval;
	private Integer ponderacion;
	private String descripcion;
	private String explicacion;
	private String descripcionfactor2;
	private Integer ordenplantilla;
	private BigDecimal valorrequerido;
	private String flagcalificacion;
	private Integer factorcompetencia;
	private Integer secuenciacompetencia;
	private BigDecimal puntaje;
	private String comentario;
	private String rutadocumento;
	private BigDecimal valorhastacompetencia;
	private BigDecimal valorcompetencia;
	private BigDecimal cfmedio;
	private String cfvalortextofactor;
	private String tipoeval;
	private String flagcalificado;
	private Integer entrevistador;
	
	/**
	 * The <strong>ocultar.</strong><br>
	 * 
	 * Se usa para emular el método filter() en PB. Para evitar removerlo de una
	 * lista, ya que se utilizaran todos los items
	 */
	private boolean ocultar;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Object secuencia) {
		if (!UValidador.esNulo(secuencia)) {
			if (secuencia instanceof BigDecimal)
				this.secuencia = new BigDecimal(secuencia.toString()).intValue();
			else if (secuencia instanceof Integer)
				this.secuencia = Integer.parseInt(secuencia.toString());
		}
	}

	public Integer getSecuencia2() {
		return secuencia2;
	}

	public void setSecuencia2(Object secuencia2) {
		if (!UValidador.esNulo(secuencia2)) {
			if (secuencia2 instanceof BigDecimal)
				this.secuencia2 = new BigDecimal(secuencia2.toString()).intValue();
			else if (secuencia2 instanceof Integer)
				this.secuencia2 = Integer.parseInt(secuencia2.toString());
		}
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getPostulante() {
		return postulante;
	}

	public void setPostulante(String postulante) {
		this.postulante = postulante;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Object factor) {
		if (!UValidador.esNulo(factor)) {
			if (factor instanceof BigDecimal)
				this.factor = new BigDecimal(factor.toString()).intValue();
			else if (factor instanceof Integer)
				this.factor = Integer.parseInt(factor.toString());
		}
	}

	public String getFlagaprobacion() {
		return flagaprobacion;
	}

	public void setFlagaprobacion(String flagaprobacion) {
		this.flagaprobacion = flagaprobacion;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public BigDecimal getCalificativo() {
		return calificativo;
	}

	public void setCalificativo(BigDecimal calificativo) {
		this.calificativo = calificativo;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getDescevaluacion() {
		return descevaluacion;
	}

	public void setDescevaluacion(String descevaluacion) {
		this.descevaluacion = descevaluacion;
	}

	public String getDescripcioneval() {
		return descripcioneval;
	}

	public void setDescripcioneval(String descripcioneval) {
		this.descripcioneval = descripcioneval;
	}

	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Object ponderacion) {
		if (!UValidador.esNulo(ponderacion)) {
			if (ponderacion instanceof BigDecimal)
				this.ponderacion = new BigDecimal(ponderacion.toString()).intValue();
			else if (ponderacion instanceof Integer)
				this.ponderacion = Integer.parseInt(ponderacion.toString());
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public String getDescripcionfactor2() {
		return descripcionfactor2;
	}

	public void setDescripcionfactor2(String descripcionfactor2) {
		this.descripcionfactor2 = descripcionfactor2;
	}

	public Integer getOrdenplantilla() {
		return ordenplantilla;
	}

	public void setOrdenplantilla(Object ordenplantilla) {
		if (!UValidador.esNulo(ordenplantilla)) {
			if (ordenplantilla instanceof BigDecimal)
				this.ordenplantilla = new BigDecimal(ordenplantilla.toString()).intValue();
			else if (ordenplantilla instanceof Integer)
				this.ordenplantilla = Integer.parseInt(ordenplantilla.toString());
		}
	}

	public BigDecimal getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}

	public String getFlagcalificacion() {
		return flagcalificacion;
	}

	public void setFlagcalificacion(String flagcalificacion) {
		this.flagcalificacion = flagcalificacion;
	}

	public Integer getFactorcompetencia() {
		return factorcompetencia;
	}

	public void setFactorcompetencia(Object factorcompetencia) {
		if (!UValidador.esNulo(factorcompetencia)) {
			if (factorcompetencia instanceof BigDecimal)
				this.factorcompetencia = new BigDecimal(factorcompetencia.toString()).intValue();
			else if (factorcompetencia instanceof Integer)
				this.factorcompetencia = Integer.parseInt(factorcompetencia.toString());
		}
	}

	public Integer getSecuenciacompetencia() {
		return secuenciacompetencia;
	}

	public void setSecuenciacompetencia(Object secuenciacompetencia) {
		if (!UValidador.esNulo(secuenciacompetencia)) {
			if (secuenciacompetencia instanceof BigDecimal)
				this.secuenciacompetencia = new BigDecimal(secuenciacompetencia.toString()).intValue();
			else if (secuenciacompetencia instanceof Integer)
				this.secuenciacompetencia = Integer.parseInt(secuenciacompetencia.toString());
		}
	}

	public BigDecimal getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(BigDecimal puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}

	public BigDecimal getValorhastacompetencia() {
		return valorhastacompetencia;
	}

	public void setValorhastacompetencia(BigDecimal valorhastacompetencia) {
		this.valorhastacompetencia = valorhastacompetencia;
	}

	public BigDecimal getValorcompetencia() {
		return valorcompetencia;
	}

	public void setValorcompetencia(BigDecimal valorcompetencia) {
		this.valorcompetencia = valorcompetencia;
	}

	public BigDecimal getCfmedio() {
		return cfmedio;
	}

	public void setCfmedio(BigDecimal cfmedio) {
		this.cfmedio = cfmedio;
	}

	public String getCfvalortextofactor() {
		return cfvalortextofactor;
	}

	public void setCfvalortextofactor(String cfvalortextofactor) {
		this.cfvalortextofactor = cfvalortextofactor;
	}

	public String getTipoeval() {
		return tipoeval;
	}

	public void setTipoeval(String tipoeval) {
		this.tipoeval = tipoeval;
	}

	public String getFlagcalificado() {
		return flagcalificado;
	}

	public void setFlagcalificado(String flagcalificado) {
		this.flagcalificado = flagcalificado;
	}

	public Integer getEntrevistador() {
		return entrevistador;
	}
	
	public void setEntrevistador(Object entrevistador) {
		if (!UValidador.esNulo(entrevistador)) {
			if (entrevistador instanceof BigDecimal)
				this.entrevistador = new BigDecimal(entrevistador.toString()).intValue();
			else if (entrevistador instanceof Integer)
				this.entrevistador = Integer.parseInt(entrevistador.toString());
		}
	}

	public boolean isOcultar() {
		return ocultar;
	}

	public void setOcultar(boolean ocultar) {
		this.ocultar = ocultar;
	}

}
