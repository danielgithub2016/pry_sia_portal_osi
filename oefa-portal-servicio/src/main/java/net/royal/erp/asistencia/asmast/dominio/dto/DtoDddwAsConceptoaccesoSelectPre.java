package net.royal.erp.asistencia.asmast.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asmast.dddw_as_conceptoacceso_select_pre
 */
public class DtoDddwAsConceptoaccesoSelectPre implements java.io.Serializable {

	private Date fechaLimite;
	private String conceptoacceso;
	private String descripcionlocal;
	private String conceptoaccesosistema;
	private String descripcion;
	private String flagcompensa;
	private BigDecimal diascompensa;
	private String expresadoen;
	private String flagotrospermisos;
	private String flagarchivo;
	private String flaghorasmaximo;
	private String flaghorasmaximoanio;
	private String flaghorasminimo;
	private String flagdiasmaximo;
	private String flagtopedias;
	private BigDecimal cantidadtopedias;
	private BigDecimal cantidadhorasmaximo;
	private BigDecimal cantidadhorasmaximoanio;
	private BigDecimal cantidadhorasminimo;
	private BigDecimal cantidaddiasmaximo;
	private String flagnorechazaaprobado;
	private String flagfechainferior;
	private String flagtieneresolucion;

	private String flagtienetopediasfi;
	private BigDecimal cantidadtopediasfi;
	private String flagtienetopediasap;
	private BigDecimal cantidadtopediasap;

	private String flagminutosminimo;
	private BigDecimal cantidadminutosminimo;
	private BigDecimal numerohorasmesesrestriccion;
	private BigDecimal flagnumerosrestriccion;
	private Date fechainiciorestriccion;
	private BigDecimal cantmaxanio;
	private String flagvacaciones;
	private BigDecimal anolimite;

	/**
	 * @return the conceptoacceso
	 */
	public String getConceptoacceso() {
		return conceptoacceso;
	}

	/**
	 * @param conceptoacceso
	 *            the conceptoacceso to set
	 */
	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

	/**
	 * @return the descripcionlocal
	 */
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	/**
	 * @param descripcionlocal
	 *            the descripcionlocal to set
	 */
	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	/**
	 * @return the conceptoaccesosistema
	 */
	public String getConceptoaccesosistema() {
		return conceptoaccesosistema;
	}

	/**
	 * @param conceptoaccesosistema
	 *            the conceptoaccesosistema to set
	 */
	public void setConceptoaccesosistema(String conceptoaccesosistema) {
		this.conceptoaccesosistema = conceptoaccesosistema;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the flagcompensa
	 */
	public String getFlagcompensa() {
		return flagcompensa;
	}

	/**
	 * @param flagcompensa
	 *            the flagcompensa to set
	 */
	public void setFlagcompensa(String flagcompensa) {
		this.flagcompensa = flagcompensa;
	}

	/**
	 * @return the expresadoen
	 */
	public String getExpresadoen() {
		return expresadoen;
	}

	/**
	 * @param expresadoen
	 *            the expresadoen to set
	 */
	public void setExpresadoen(String expresadoen) {
		this.expresadoen = expresadoen;
	}

	/**
	 * @return the flagotrospermisos
	 */
	public String getFlagotrospermisos() {
		return flagotrospermisos;
	}

	/**
	 * @param flagotrospermisos
	 *            the flagotrospermisos to set
	 */
	public void setFlagotrospermisos(String flagotrospermisos) {
		this.flagotrospermisos = flagotrospermisos;
	}

	/**
	 * @return the flagarchivo
	 */
	public String getFlagarchivo() {
		if (UValidador.estaVacio(flagarchivo)) {
			flagarchivo = "";
		}
		return flagarchivo;
	}

	/**
	 * @param flagarchivo
	 *            the flagarchivo to set
	 */
	public void setFlagarchivo(String flagarchivo) {
		this.flagarchivo = flagarchivo;
	}

	/**
	 * @return the flaghorasmaximo
	 */
	public String getFlaghorasmaximo() {
		return flaghorasmaximo;
	}

	/**
	 * @param flaghorasmaximo
	 *            the flaghorasmaximo to set
	 */
	public void setFlaghorasmaximo(String flaghorasmaximo) {
		this.flaghorasmaximo = flaghorasmaximo;
	}

	/**
	 * @return the flagtopedias
	 */
	public String getFlagtopedias() {
		return flagtopedias;
	}

	/**
	 * @param flagtopedias
	 *            the flagtopedias to set
	 */
	public void setFlagtopedias(String flagtopedias) {
		this.flagtopedias = flagtopedias;
	}

	/**
	 * @return the cantidadtopedias
	 */
	public BigDecimal getCantidadtopedias() {
		if (UValidador.esNulo(cantidadtopedias)) {
			cantidadtopedias = BigDecimal.valueOf(0);
		}
		return cantidadtopedias;
	}

	/**
	 * @param cantidadtopedias
	 *            the cantidadtopedias to set
	 */
	public void setCantidadtopedias(BigDecimal cantidadtopedias) {
		this.cantidadtopedias = cantidadtopedias;
	}

	/**
	 * @return the cantidadhorasmaximo
	 */
	public BigDecimal getCantidadhorasmaximo() {
		if (UValidador.esNulo(cantidadhorasmaximo)) {
			cantidadhorasmaximo = BigDecimal.valueOf(0);
		}
		return cantidadhorasmaximo;
	}

	/**
	 * @param cantidadhorasmaximo
	 *            the cantidadhorasmaximo to set
	 */
	public void setCantidadhorasmaximo(BigDecimal cantidadhorasmaximo) {
		this.cantidadhorasmaximo = cantidadhorasmaximo;
	}

	/**
	 * @return the flagnorechazaaprobado
	 */
	public String getFlagnorechazaaprobado() {
		if (UValidador.estaVacio(flagnorechazaaprobado)) {
			flagnorechazaaprobado = "";
		}
		return flagnorechazaaprobado;
	}

	/**
	 * @param flagnorechazaaprobado
	 *            the flagnorechazaaprobado to set
	 */
	public void setFlagnorechazaaprobado(String flagnorechazaaprobado) {
		this.flagnorechazaaprobado = flagnorechazaaprobado;
	}

	/**
	 * @return the flagfechainferior
	 */
	public String getFlagfechainferior() {
		return flagfechainferior;
	}

	/**
	 * @param flagfechainferior
	 *            the flagfechainferior to set
	 */
	public void setFlagfechainferior(String flagfechainferior) {
		this.flagfechainferior = flagfechainferior;
	}

	/**
	 * @return the flagtieneresolucion
	 */
	public String getFlagtieneresolucion() {
		if (UValidador.estaVacio(flagtieneresolucion)) {
			flagtieneresolucion = "N";
		}
		return flagtieneresolucion;
	}

	/**
	 * @param flagtieneresolucion
	 *            the flagtieneresolucion to set
	 */
	public void setFlagtieneresolucion(String flagtieneresolucion) {
		this.flagtieneresolucion = flagtieneresolucion;
	}

	public String getFlagtienetopediasfi() {
		if (UValidador.estaVacio(flagtienetopediasfi)) {
			flagtienetopediasfi = "";
		}
		return flagtienetopediasfi;
	}

	public void setFlagtienetopediasfi(String flagtienetopediasfi) {
		this.flagtienetopediasfi = flagtienetopediasfi;
	}

	public BigDecimal getCantidadtopediasfi() {
		if (UValidador.esNulo(cantidadtopediasfi)) {
			cantidadtopediasfi = BigDecimal.ZERO;
		}
		return cantidadtopediasfi;
	}

	public void setCantidadtopediasfi(BigDecimal cantidadtopediasfi) {
		this.cantidadtopediasfi = cantidadtopediasfi;
	}

	public String getFlagtienetopediasap() {
		if (UValidador.estaVacio(flagtienetopediasap)) {
			flagtienetopediasap = "";
		}
		return flagtienetopediasap;
	}

	public void setFlagtienetopediasap(String flagtienetopediasap) {
		this.flagtienetopediasap = flagtienetopediasap;
	}

	public BigDecimal getCantidadtopediasap() {
		if (UValidador.esNulo(cantidadtopediasap)) {
			cantidadtopediasap = BigDecimal.ZERO;
		}
		return cantidadtopediasap;
	}

	public void setCantidadtopediasap(BigDecimal cantidadtopediasap) {
		this.cantidadtopediasap = cantidadtopediasap;
	}

	public String getFlagminutosminimo() {
		return flagminutosminimo;
	}

	public void setFlagminutosminimo(String flagminutosminimo) {
		this.flagminutosminimo = flagminutosminimo;
	}

	public BigDecimal getCantidadminutosminimo() {
		return cantidadminutosminimo;
	}

	public void setCantidadminutosminimo(BigDecimal cantidadminutosminimo) {
		this.cantidadminutosminimo = cantidadminutosminimo;
	}

	public BigDecimal getNumerohorasmesesrestriccion() {
		return numerohorasmesesrestriccion;
	}

	public void setNumerohorasmesesrestriccion(BigDecimal numerohorasmesesrestriccion) {
		this.numerohorasmesesrestriccion = numerohorasmesesrestriccion;
	}

	public BigDecimal getFlagnumerosrestriccion() {
		return flagnumerosrestriccion;
	}

	public void setFlagnumerosrestriccion(BigDecimal flagnumerosrestriccion) {
		this.flagnumerosrestriccion = flagnumerosrestriccion;
	}

	public Date getFechainiciorestriccion() {
		return fechainiciorestriccion;
	}

	public void setFechainiciorestriccion(Date fechainiciorestriccion) {
		this.fechainiciorestriccion = fechainiciorestriccion;
	}

	public BigDecimal getCantmaxanio() {
		if (UValidador.esNulo(cantmaxanio)) {
			cantmaxanio = BigDecimal.ZERO;
		}
		return cantmaxanio;
	}

	public void setCantmaxanio(BigDecimal cantmaxanio) {
		this.cantmaxanio = cantmaxanio;
	}

	public String getFlagdiasmaximo() {
		return flagdiasmaximo;
	}

	public void setFlagdiasmaximo(String flagdiasmaximo) {
		this.flagdiasmaximo = flagdiasmaximo;
	}

	public BigDecimal getCantidaddiasmaximo() {
		if (UValidador.esNulo(cantidaddiasmaximo)) {
			cantidaddiasmaximo = BigDecimal.ZERO;
		}
		return cantidaddiasmaximo;
	}

	public void setCantidaddiasmaximo(BigDecimal cantidaddiasmaximo) {
		this.cantidaddiasmaximo = cantidaddiasmaximo;
	}

	public String getFlagvacaciones() {
		if (UValidador.estaVacio(flagvacaciones)) {
			flagvacaciones = "";
		}
		return flagvacaciones;
	}

	public void setFlagvacaciones(String flagvacaciones) {
		this.flagvacaciones = flagvacaciones;
	}

	public BigDecimal getAnolimite() {
		if (anolimite == null) {
			anolimite = BigDecimal.ZERO;
		}
		return anolimite;
	}

	public void setAnolimite(BigDecimal anolimite) {
		this.anolimite = anolimite;
	}

	public String getFlaghorasminimo() {
		return flaghorasminimo;
	}

	public void setFlaghorasminimo(String flaghorasminimo) {
		this.flaghorasminimo = flaghorasminimo;
	}

	public BigDecimal getCantidadhorasminimo() {
		return cantidadhorasminimo;
	}

	public void setCantidadhorasminimo(BigDecimal cantidadhorasminimo) {
		this.cantidadhorasminimo = cantidadhorasminimo;
	}

	public String getFlaghorasmaximoanio() {
		return flaghorasmaximoanio;
	}

	public void setFlaghorasmaximoanio(String flaghorasmaximoanio) {
		this.flaghorasmaximoanio = flaghorasmaximoanio;
	}

	public BigDecimal getCantidadhorasmaximoanio() {
		return cantidadhorasmaximoanio;
	}

	public void setCantidadhorasmaximoanio(BigDecimal cantidadhorasmaximoanio) {
		this.cantidadhorasmaximoanio = cantidadhorasmaximoanio;
	}

	public BigDecimal getDiascompensa() {
		return diascompensa;
	}

	public void setDiascompensa(BigDecimal diascompensa) {
		this.diascompensa = diascompensa;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	
}
