package net.royal.erp.asistencia.asrepus.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asrepus.dw_as_proceso_asistencia_diaria_tipohor
 */
public class DtoDwAsProcesoAsistenciaDiariaTipohor implements
		java.io.Serializable {

	private BigDecimal tipohorario;
	private String descripcionlocal;
	private String descripcionextranjera;
	private BigDecimal lunes;
	private BigDecimal martes;
	private BigDecimal miercoles;
	private BigDecimal jueves;
	private BigDecimal viernes;
	private BigDecimal sabado;
	private BigDecimal domingo;
	private String estado;
	private String ultimousuario;
	private Date ultimafechamodif;
	private BigDecimal tipoturno;
	/**
	 * @return the tipohorario
	 */
	public BigDecimal getTipohorario() {
		return tipohorario;
	}
	/**
	 * @param tipohorario the tipohorario to set
	 */
	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}
	/**
	 * @return the descripcionlocal
	 */
	public String getDescripcionlocal() {
		return descripcionlocal;
	}
	/**
	 * @param descripcionlocal the descripcionlocal to set
	 */
	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	/**
	 * @return the descripcionextranjera
	 */
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}
	/**
	 * @param descripcionextranjera the descripcionextranjera to set
	 */
	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	/**
	 * @return the lunes
	 */
	public BigDecimal getLunes() {
		return lunes;
	}
	/**
	 * @param lunes the lunes to set
	 */
	public void setLunes(BigDecimal lunes) {
		this.lunes = lunes;
	}
	/**
	 * @return the martes
	 */
	public BigDecimal getMartes() {
		return martes;
	}
	/**
	 * @param martes the martes to set
	 */
	public void setMartes(BigDecimal martes) {
		this.martes = martes;
	}
	/**
	 * @return the miercoles
	 */
	public BigDecimal getMiercoles() {
		return miercoles;
	}
	/**
	 * @param miercoles the miercoles to set
	 */
	public void setMiercoles(BigDecimal miercoles) {
		this.miercoles = miercoles;
	}
	/**
	 * @return the jueves
	 */
	public BigDecimal getJueves() {
		return jueves;
	}
	/**
	 * @param jueves the jueves to set
	 */
	public void setJueves(BigDecimal jueves) {
		this.jueves = jueves;
	}
	/**
	 * @return the viernes
	 */
	public BigDecimal getViernes() {
		return viernes;
	}
	/**
	 * @param viernes the viernes to set
	 */
	public void setViernes(BigDecimal viernes) {
		this.viernes = viernes;
	}
	/**
	 * @return the sabado
	 */
	public BigDecimal getSabado() {
		if(UValidador.esNulo(sabado)){
			sabado = BigDecimal.ZERO;
		}
		return sabado;
	}
	/**
	 * @param sabado the sabado to set
	 */
	public void setSabado(BigDecimal sabado) {
		this.sabado = sabado;
	}
	/**
	 * @return the domingo
	 */
	public BigDecimal getDomingo() {
		if(UValidador.esNulo(domingo)){
			domingo = BigDecimal.ZERO;
		}
		return domingo;
	}
	/**
	 * @param domingo the domingo to set
	 */
	public void setDomingo(BigDecimal domingo) {
		this.domingo = domingo;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the ultimousuario
	 */
	public String getUltimousuario() {
		return ultimousuario;
	}
	/**
	 * @param ultimousuario the ultimousuario to set
	 */
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	/**
	 * @return the ultimafechamodif
	 */
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}
	/**
	 * @param ultimafechamodif the ultimafechamodif to set
	 */
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	/**
	 * @return the tipoturno
	 */
	public BigDecimal getTipoturno() {
		return tipoturno;
	}
	/**
	 * @param tipoturno the tipoturno to set
	 */
	public void setTipoturno(BigDecimal tipoturno) {
		this.tipoturno = tipoturno;
	}


}
