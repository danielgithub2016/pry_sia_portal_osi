package net.royal.erp.asistencia.asmain.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asmain.dw_as_autorizacion_preproceso_tipodia
 */
public class DtoDwAsAutorizacionPreprocesoTipodia implements
		java.io.Serializable {

	private String intervaloacceso;
	private String descripcionconcepto;
	private Integer cantidadhoras;
	private BigDecimal tipodia;
	private Date horainicio;
	private Date horafin;
	private BigDecimal secuencia;
	private String descripciondia;
	private String flagrestriccion;
	private String conceptoaccesorestringido;
	private String conceptoaccesocomplemento;
	private Date tiemporestringido;
	private Integer maxtempran;
	private Integer minsobrett;
	private String flagdiaant;

	/**
	 * @return the intervaloacceso
	 */
	public String getIntervaloacceso() {
		return intervaloacceso;
	}

	/**
	 * @param intervaloacceso
	 *            the intervaloacceso to set
	 */
	public void setIntervaloacceso(String intervaloacceso) {
		this.intervaloacceso = intervaloacceso;
	}

	/**
	 * @return the descripcionconcepto
	 */
	public String getDescripcionconcepto() {
		return descripcionconcepto;
	}

	/**
	 * @param descripcionconcepto
	 *            the descripcionconcepto to set
	 */
	public void setDescripcionconcepto(String descripcionconcepto) {
		this.descripcionconcepto = descripcionconcepto;
	}

	/**
	 * @return the cantidadhoras
	 */
	public Integer getCantidadhoras() {
		return cantidadhoras;
	}

	/**
	 * @param cantidadhoras
	 *            the cantidadhoras to set
	 */
	public void setCantidadhoras(Integer cantidadhoras) {
		this.cantidadhoras = cantidadhoras;
	}

	/**
	 * @return the tipodia
	 */
	public BigDecimal getTipodia() {
		return tipodia;
	}

	/**
	 * @param tipodia
	 *            the tipodia to set
	 */
	public void setTipodia(BigDecimal tipodia) {
		this.tipodia = tipodia;
	}

	/**
	 * @return the horainicio
	 */
	public Date getHorainicio() {
		return horainicio;
	}

	/**
	 * @param horainicio
	 *            the horainicio to set
	 */
	public void setHorainicio(Date horainicio) {
		this.horainicio = horainicio;
	}

	/**
	 * @return the horafin
	 */
	public Date getHorafin() {
		return horafin;
	}

	/**
	 * @param horafin
	 *            the horafin to set
	 */
	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}

	/**
	 * @return the secuencia
	 */
	public BigDecimal getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	/**
	 * @return the descripciondia
	 */
	public String getDescripciondia() {
		return descripciondia;
	}

	/**
	 * @param descripciondia
	 *            the descripciondia to set
	 */
	public void setDescripciondia(String descripciondia) {
		this.descripciondia = descripciondia;
	}

	/**
	 * @return the flagrestriccion
	 */
	public String getFlagrestriccion() {
		return flagrestriccion;
	}

	/**
	 * @param flagrestriccion
	 *            the flagrestriccion to set
	 */
	public void setFlagrestriccion(String flagrestriccion) {
		this.flagrestriccion = flagrestriccion;
	}

	/**
	 * @return the conceptoaccesorestringido
	 */
	public String getConceptoaccesorestringido() {
		return conceptoaccesorestringido;
	}

	/**
	 * @param conceptoaccesorestringido
	 *            the conceptoaccesorestringido to set
	 */
	public void setConceptoaccesorestringido(String conceptoaccesorestringido) {
		this.conceptoaccesorestringido = conceptoaccesorestringido;
	}

	/**
	 * @return the conceptoaccesocomplemento
	 */
	public String getConceptoaccesocomplemento() {
		return conceptoaccesocomplemento;
	}

	/**
	 * @param conceptoaccesocomplemento
	 *            the conceptoaccesocomplemento to set
	 */
	public void setConceptoaccesocomplemento(String conceptoaccesocomplemento) {
		this.conceptoaccesocomplemento = conceptoaccesocomplemento;
	}

	/**
	 * @return the tiemporestringido
	 */
	public Date getTiemporestringido() {
		return tiemporestringido;
	}

	/**
	 * @param tiemporestringido
	 *            the tiemporestringido to set
	 */
	public void setTiemporestringido(Date tiemporestringido) {
		this.tiemporestringido = tiemporestringido;
	}

	/**
	 * @return the maxtempran
	 */
	public Integer getMaxtempran() {
		return maxtempran;
	}

	/**
	 * @param maxtempran
	 *            the maxtempran to set
	 */
	public void setMaxtempran(Integer maxtempran) {
		this.maxtempran = maxtempran;
	}

	/**
	 * @return the minsobrett
	 */
	public Integer getMinsobrett() {
		return minsobrett;
	}

	/**
	 * @param minsobrett
	 *            the minsobrett to set
	 */
	public void setMinsobrett(Integer minsobrett) {
		this.minsobrett = minsobrett;
	}

	/**
	 * @return the flagdiaant
	 */
	public String getFlagdiaant() {
		return flagdiaant;
	}

	/**
	 * @param flagdiaant
	 *            the flagdiaant to set
	 */
	public void setFlagdiaant(String flagdiaant) {
		this.flagdiaant = flagdiaant;
	}

}
