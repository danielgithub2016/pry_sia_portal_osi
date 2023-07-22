package net.royal.erp.asistencia.asrepus.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

/**
 *
 * @author desarrollo
 * @powerbuilder asrepus.dw_as_autorizacion_preproceso_excepcion
 */
public class DtoDwAsAutorizacionPreprocesoExcepcion implements
		java.io.Serializable {

	private Date fecha;
	private BigDecimal empleado;
	private String intervaloacceso;
	private BigDecimal tipohorario;
	private BigDecimal cantidadhoras;
	private Date horainicio;
	private Date horafin;
	private BigDecimal secuencia;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String sabado;
	private String domingo;
	private String flagrestriccion;
	private String conceptoaccesorestringido;
	private String conceptoaccesocomplemento;
	private Date tiemporestringido;
	private BigDecimal tipodia;

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the empleado
	 */
	public BigDecimal getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado
	 *            the empleado to set
	 */
	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

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

	public BigDecimal getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	/**
	 * @return the cantidadhoras
	 */
	public BigDecimal getCantidadhoras() {
		if (UValidador.esNulo(cantidadhoras)) {
			cantidadhoras = BigDecimal.valueOf(0);
		}
		return cantidadhoras;
	}

	/**
	 * @param cantidadhoras
	 *            the cantidadhoras to set
	 */
	public void setCantidadhoras(BigDecimal cantidadhoras) {
		this.cantidadhoras = cantidadhoras;
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
	 * @return the lunes
	 */
	public String getLunes() {
		if (UValidador.estaVacio(lunes)) {
			lunes = "";
		}
		return lunes;
	}

	/**
	 * @param lunes
	 *            the lunes to set
	 */
	public void setLunes(String lunes) {
		this.lunes = lunes;
	}

	/**
	 * @return the martes
	 */
	public String getMartes() {
		if (UValidador.estaVacio(martes)) {
			martes = "";
		}
		return martes;
	}

	/**
	 * @param martes
	 *            the martes to set
	 */
	public void setMartes(String martes) {
		this.martes = martes;
	}

	/**
	 * @return the miercoles
	 */
	public String getMiercoles() {
		if (UValidador.estaVacio(miercoles)) {
			miercoles = "";
		}
		return miercoles;
	}

	/**
	 * @param miercoles
	 *            the miercoles to set
	 */
	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}

	/**
	 * @return the jueves
	 */
	public String getJueves() {
		if (UValidador.estaVacio(jueves)) {
			jueves = "";
		}
		return jueves;
	}

	/**
	 * @param jueves
	 *            the jueves to set
	 */
	public void setJueves(String jueves) {
		this.jueves = jueves;
	}

	/**
	 * @return the viernes
	 */
	public String getViernes() {
		if (UValidador.estaVacio(viernes)) {
			viernes = "";
		}
		return viernes;
	}

	/**
	 * @param viernes
	 *            the viernes to set
	 */
	public void setViernes(String viernes) {
		this.viernes = viernes;
	}

	/**
	 * @return the sabado
	 */
	public String getSabado() {
		if (UValidador.estaVacio(sabado)) {
			sabado = "";
		}
		return sabado;
	}

	/**
	 * @param sabado
	 *            the sabado to set
	 */
	public void setSabado(String sabado) {
		this.sabado = sabado;
	}

	/**
	 * @return the domingo
	 */
	public String getDomingo() {
		if (UValidador.estaVacio(domingo)) {
			domingo = "";
		}
		return domingo;
	}

	/**
	 * @param domingo
	 *            the domingo to set
	 */
	public void setDomingo(String domingo) {
		this.domingo = domingo;
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
	 * @return the tipodia
	 */
	public BigDecimal getTipodia() {
		if (UValidador.esNulo(tipodia)) {
			tipodia = BigDecimal.valueOf(0);
		}
		return tipodia;
	}

	/**
	 * @param tipodia
	 *            the tipodia to set
	 */
	public void setTipodia(BigDecimal tipodia) {
		this.tipodia = tipodia;
	}

}
