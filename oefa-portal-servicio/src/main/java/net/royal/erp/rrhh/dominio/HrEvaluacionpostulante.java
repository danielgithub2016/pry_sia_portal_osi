package net.royal.erp.rrhh.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 * The Class HrEvaluacionpostulante.
 */
public class HrEvaluacionpostulante extends DominioGenerico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HrEvaluacionpostulantePk pk;
	private BigDecimal calificativo;
	private String flagaprobacion;
	private String unidadnegocio;
	private Integer calificacion1;
	private Integer calificacion2;
	private Integer calificacion3;
	private Integer calificacion4;
	private Integer calificacion5;
	private Integer calificacion6;
	private Integer calificacion7;
	private Integer calificacion8;
	private Integer calificacion9;
	private Integer calificacion10;
	private Integer factorcompetencia;
	private Integer secuenciacompetencia;
	private BigDecimal puntaje;
	private String comentario;
	private BigDecimal valorcompetencia;
	private BigDecimal valorhastacompetencia;
	private String flagcalificado;
	private String rutadocumento;
	private Integer entrevistador;

	public HrEvaluacionpostulantePk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionpostulantePk pk) {
		this.pk = pk;
	}

	public BigDecimal getCalificativo() {
		return calificativo;
	}

	public void setCalificativo(BigDecimal calificativo) {
		this.calificativo = calificativo;
	}

	public String getFlagaprobacion() {
		return flagaprobacion;
	}

	public void setFlagaprobacion(String flagaprobacion) {
		this.flagaprobacion = flagaprobacion;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}


	public Integer getCalificacion1() {
		return calificacion1;
	}

	public void setCalificacion1(Integer calificacion1) {
		this.calificacion1 = calificacion1;
	}

	public Integer getCalificacion2() {
		return calificacion2;
	}

	public void setCalificacion2(Integer calificacion2) {
		this.calificacion2 = calificacion2;
	}

	public Integer getCalificacion3() {
		return calificacion3;
	}

	public void setCalificacion3(Integer calificacion3) {
		this.calificacion3 = calificacion3;
	}

	public Integer getCalificacion4() {
		return calificacion4;
	}

	public void setCalificacion4(Integer calificacion4) {
		this.calificacion4 = calificacion4;
	}

	public Integer getCalificacion5() {
		return calificacion5;
	}

	public void setCalificacion5(Integer calificacion5) {
		this.calificacion5 = calificacion5;
	}

	public Integer getCalificacion6() {
		return calificacion6;
	}

	public void setCalificacion6(Integer calificacion6) {
		this.calificacion6 = calificacion6;
	}

	public Integer getCalificacion7() {
		return calificacion7;
	}

	public void setCalificacion7(Integer calificacion7) {
		this.calificacion7 = calificacion7;
	}

	public Integer getCalificacion8() {
		return calificacion8;
	}

	public void setCalificacion8(Integer calificacion8) {
		this.calificacion8 = calificacion8;
	}

	public Integer getCalificacion9() {
		return calificacion9;
	}

	public void setCalificacion9(Integer calificacion9) {
		this.calificacion9 = calificacion9;
	}

	public Integer getCalificacion10() {
		return calificacion10;
	}

	public void setCalificacion10(Integer calificacion10) {
		this.calificacion10 = calificacion10;
	}

	public Integer getFactorcompetencia() {
		return factorcompetencia;
	}

	public void setFactorcompetencia(Integer factorcompetencia) {
		this.factorcompetencia = factorcompetencia;
	}

	public Integer getSecuenciacompetencia() {
		return secuenciacompetencia;
	}

	public void setSecuenciacompetencia(Integer secuenciacompetencia) {
		this.secuenciacompetencia = secuenciacompetencia;
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

	public String getFlagcalificado() {
		return flagcalificado;
	}

	public void setFlagcalificado(String flagcalificado) {
		this.flagcalificado = flagcalificado;
	}

	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}

	public Integer getEntrevistador() {
		return entrevistador;
	}

	public void setEntrevistador(Integer entrevistador) {
		this.entrevistador = entrevistador;
	}

}
