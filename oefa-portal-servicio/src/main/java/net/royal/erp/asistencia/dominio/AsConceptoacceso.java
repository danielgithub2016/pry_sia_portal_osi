package net.royal.erp.asistencia.dominio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsConceptoacceso
 */
public class AsConceptoacceso extends DominioGenerico implements java.io.Serializable {

	private AsConceptoaccesoPk pk;
	private String descripcionlocal;
	private String descripcionextranjera;
	private String conceptoaccesosistema;
	private String tipoconceptoacceso;
	private String conceptoplanilla;
	private String expresadoen;
	private String estado;
	private String flagparasustitucion;
	private String mandatorio;
	private String pagarrefrigerio;
	private String flagcompensa;
	private String flagotrospermisos;
	private String nivelesaprobacion;
	private Integer nroniveles;
	private String posicionesresp;
	private Integer ordenflujo;
	private String flagsobret;
	private String flagcompen;
	private String flag25;
	private String flag35;
	private String flag100;
	private String conceptortps;
	private String gruporeporte01;
	private String flagtopedias;
	private String flagfechainferior;
	private String flagarchivo;
	private String flagtieneresolucion;
	private Integer cantidadtopedias;
	private String flagtienetopediasfi;
	private Integer cantidadtopediasfi;
	private String flagtienetopediasap;
	private Integer cantidadtopediasap;

	// Campos nuevos
	private String flagnumerosrestriccion;
	private BigDecimal cantidadmesesrestriccion;
	private BigDecimal numerohorasmesesrestriccion;
	private Date fechainiciorestriccion;
	private String flagUnDia;
	private BigDecimal cantidadminutosminimo;
	private String flagAprobacionURH;
	private String flagaprobacionsst;

	private String flagdiasanticipacion;
	private BigDecimal diasanticipacion;

	private String flagcorreocopiaaprob;
	private String correocopiaaprob;
	private String flagticket;

	public AsConceptoacceso() {
		pk = new AsConceptoaccesoPk();
	}

	public AsConceptoaccesoPk getPk() {
		return pk;
	}

	public void setPk(AsConceptoaccesoPk pk) {
		this.pk = pk;
	}

	public String getDescripcionlocal() {
		if (UValidador.esNulo(descripcionlocal)) {
			descripcionlocal = "";
		}
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}

	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}

	public String getConceptoaccesosistema() {
		return conceptoaccesosistema;
	}

	public void setConceptoaccesosistema(String conceptoaccesosistema) {
		this.conceptoaccesosistema = conceptoaccesosistema;
	}

	public String getTipoconceptoacceso() {
		return tipoconceptoacceso;
	}

	public void setTipoconceptoacceso(String tipoconceptoacceso) {
		this.tipoconceptoacceso = tipoconceptoacceso;
	}

	public String getConceptoplanilla() {
		return conceptoplanilla;
	}

	public void setConceptoplanilla(String conceptoplanilla) {
		this.conceptoplanilla = conceptoplanilla;
	}

	public String getExpresadoen() {
		return expresadoen;
	}

	public void setExpresadoen(String expresadoen) {
		this.expresadoen = expresadoen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlagparasustitucion() {
		return flagparasustitucion;
	}

	public void setFlagparasustitucion(String flagparasustitucion) {
		this.flagparasustitucion = flagparasustitucion;
	}

	public String getMandatorio() {
		return mandatorio;
	}

	public void setMandatorio(String mandatorio) {
		this.mandatorio = mandatorio;
	}

	public String getPagarrefrigerio() {
		return pagarrefrigerio;
	}

	public void setPagarrefrigerio(String pagarrefrigerio) {
		this.pagarrefrigerio = pagarrefrigerio;
	}

	public String getFlagcompensa() {
		return flagcompensa;
	}

	public void setFlagcompensa(String flagcompensa) {
		this.flagcompensa = flagcompensa;
	}

	public String getFlagotrospermisos() {
		return flagotrospermisos;
	}

	public void setFlagotrospermisos(String flagotrospermisos) {
		this.flagotrospermisos = flagotrospermisos;
	}

	public String getNivelesaprobacion() {
		return nivelesaprobacion;
	}

	public void setNivelesaprobacion(String nivelesaprobacion) {
		this.nivelesaprobacion = nivelesaprobacion;
	}

	public Integer getNroniveles() {
		return nroniveles;
	}

	public void setNroniveles(Integer nroniveles) {
		this.nroniveles = nroniveles;
	}

	public String getPosicionesresp() {
		return posicionesresp;
	}

	public void setPosicionesresp(String posicionesresp) {
		this.posicionesresp = posicionesresp;
	}

	public Integer getOrdenflujo() {
		return ordenflujo;
	}

	public void setOrdenflujo(Integer ordenflujo) {
		this.ordenflujo = ordenflujo;
	}

	public String getFlagsobret() {
		return flagsobret;
	}

	public void setFlagsobret(String flagsobret) {
		this.flagsobret = flagsobret;
	}

	public String getFlagcompen() {
		return flagcompen;
	}

	public void setFlagcompen(String flagcompen) {
		this.flagcompen = flagcompen;
	}

	public String getFlag25() {
		return flag25;
	}

	public void setFlag25(String flag25) {
		this.flag25 = flag25;
	}

	public String getFlag35() {
		return flag35;
	}

	public void setFlag35(String flag35) {
		this.flag35 = flag35;
	}

	public String getFlag100() {
		return flag100;
	}

	public void setFlag100(String flag100) {
		this.flag100 = flag100;
	}

	public String getConceptortps() {
		return conceptortps;
	}

	public void setConceptortps(String conceptortps) {
		this.conceptortps = conceptortps;
	}

	public String getGruporeporte01() {
		return gruporeporte01;
	}

	public void setGruporeporte01(String gruporeporte01) {
		this.gruporeporte01 = gruporeporte01;
	}

	/**
	 * @return the flagtopedias
	 */
	public String getFlagtopedias() {
		if (UValidador.estaVacio(flagtopedias)) {
			flagtopedias = "";
		}
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
	 * @return the flagfechainferior
	 */
	public String getFlagfechainferior() {
		if (UValidador.estaVacio(flagfechainferior)) {
			flagfechainferior = "";
		}

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
	 * @return the flagarchivo
	 */
	public String getFlagarchivo() {
		if (UValidador.estaVacio(flagarchivo)) {
			flagarchivo = "N";
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

	/**
	 * @return the cantidadtopedias
	 */
	public Integer getCantidadtopedias() {
		return cantidadtopedias;
	}

	/**
	 * @param cantidadtopedias
	 *            the cantidadtopedias to set
	 */
	public void setCantidadtopedias(Integer cantidadtopedias) {
		this.cantidadtopedias = cantidadtopedias;
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

	public Integer getCantidadtopediasfi() {
		if (UValidador.esNulo(cantidadtopediasfi)) {
			cantidadtopediasfi = 0;
		}
		return cantidadtopediasfi;
	}

	public void setCantidadtopediasfi(Integer cantidadtopediasfi) {
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

	public Integer getCantidadtopediasap() {
		if (UValidador.esNulo(cantidadtopediasap)) {
			cantidadtopediasap = 0;
		}
		return cantidadtopediasap;
	}

	public void setCantidadtopediasap(Integer cantidadtopediasap) {
		this.cantidadtopediasap = cantidadtopediasap;
	}

	public String getFlagnumerosrestriccion() {
		return flagnumerosrestriccion;
	}

	public void setFlagnumerosrestriccion(String flagnumerosrestriccion) {
		this.flagnumerosrestriccion = flagnumerosrestriccion;
	}

	public BigDecimal getCantidadmesesrestriccion() {
		return cantidadmesesrestriccion;
	}

	public void setCantidadmesesrestriccion(BigDecimal cantidadmesesrestriccion) {
		this.cantidadmesesrestriccion = cantidadmesesrestriccion;
	}

	public BigDecimal getNumerohorasmesesrestriccion() {
		return numerohorasmesesrestriccion;
	}

	public void setNumerohorasmesesrestriccion(BigDecimal numerohorasmesesrestriccion) {
		this.numerohorasmesesrestriccion = numerohorasmesesrestriccion;
	}

	public Date getFechainiciorestriccion() {
		return fechainiciorestriccion;
	}

	public void setFechainiciorestriccion(Date fechainiciorestriccion) {
		this.fechainiciorestriccion = fechainiciorestriccion;
	}

	public String getFlagUnDia() {
		return flagUnDia;
	}

	public void setFlagUnDia(String flagUnDia) {
		this.flagUnDia = flagUnDia;
	}

	public BigDecimal getCantidadminutosminimo() {
		return cantidadminutosminimo;
	}

	public void setCantidadminutosminimo(BigDecimal cantidadminutosminimo) {
		this.cantidadminutosminimo = cantidadminutosminimo;
	}

	public String getFlagAprobacionURH() {
		return flagAprobacionURH;
	}

	public void setFlagAprobacionURH(String flagAprobacionURH) {
		this.flagAprobacionURH = flagAprobacionURH;
	}

	public String getFlagdiasanticipacion() {
		return flagdiasanticipacion;
	}

	public void setFlagdiasanticipacion(String flagdiasanticipacion) {
		this.flagdiasanticipacion = flagdiasanticipacion;
	}

	public BigDecimal getDiasanticipacion() {
		return diasanticipacion;
	}

	public void setDiasanticipacion(BigDecimal diasanticipacion) {
		this.diasanticipacion = diasanticipacion;
	}

	public String getFlagcorreocopiaaprob() {
		return flagcorreocopiaaprob;
	}

	public void setFlagcorreocopiaaprob(String flagcorreocopiaaprob) {
		this.flagcorreocopiaaprob = flagcorreocopiaaprob;
	}

	public String getCorreocopiaaprob() {
		return correocopiaaprob;
	}

	public void setCorreocopiaaprob(String correocopiaaprob) {
		this.correocopiaaprob = correocopiaaprob;
	}

	public String getFlagticket() {
		return flagticket;
	}

	public void setFlagticket(String flagticket) {
		this.flagticket = flagticket;
	}

	public String getFlagaprobacionsst() {
		return flagaprobacionsst;
	}

	public void setFlagaprobacionsst(String flagaprobacionsst) {
		this.flagaprobacionsst = flagaprobacionsst;
	}

}
