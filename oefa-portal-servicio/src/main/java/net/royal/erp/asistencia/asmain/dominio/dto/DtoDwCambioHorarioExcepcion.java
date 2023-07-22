package net.royal.erp.asistencia.asmain.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwCambioHorarioExcepcion {

	private Integer secuencia;
	private Date fecha;
	private BigDecimal tipodia;
	private String descripcion;
	private Integer empleado;
	private Date fechasolicitud;
	private Date fechahasta;
	private String intervaloacceso;
	private String estado;
	private String ultimousuario;
	private Date ultimafecha;

	private BigDecimal horas;
	private BigDecimal horasrefrigerio;
	private String horasdescripcion;
	private String horasrefrigeriodescripcion;

	private String dianombre;

	private Date horainicio;
	private Date horafin;

	/**
	 * @return the secuencia
	 */
	public Integer getSecuencia() {
		return secuencia;
	}

	/**
	 * @param secuencia
	 *            the secuencia to set
	 */
	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

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
	 * @return the horas
	 */
	public BigDecimal getHoras() {
		if (UValidador.esNulo(horas)) {
			horas = BigDecimal.ZERO;
		}
		return horas;
	}

	/**
	 * @param horas
	 *            the horas to set
	 */
	public void setHoras(BigDecimal horas) {
		this.horas = horas;
	}

	/**
	 * @return the horasdescripcion
	 */
	public String getHorasdescripcion() {
		return horasdescripcion;
	}

	/**
	 * @param horasdescripcion
	 *            the horasdescripcion to set
	 */
	public void setHorasdescripcion(String horasdescripcion) {
		this.horasdescripcion = horasdescripcion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		if (UValidador.estaVacio(descripcion)) {
			descripcion = "";
		}
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
	 * @return the empleado
	 */
	public Integer getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado
	 *            the empleado to set
	 */
	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the fechasolicitud
	 */
	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	/**
	 * @param fechasolicitud
	 *            the fechasolicitud to set
	 */
	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	/**
	 * @return the fechahasta
	 */
	public Date getFechahasta() {
		return fechahasta;
	}

	/**
	 * @param fechahasta
	 *            the fechahasta to set
	 */
	public void setFechahasta(Date fechahasta) {
		this.fechahasta = fechahasta;
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

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
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
	 * @param ultimousuario
	 *            the ultimousuario to set
	 */
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	/**
	 * @return the ultimafecha
	 */
	public Date getUltimafecha() {
		return ultimafecha;
	}

	/**
	 * @param ultimafecha
	 *            the ultimafecha to set
	 */
	public void setUltimafecha(Date ultimafecha) {
		this.ultimafecha = ultimafecha;
	}

	/**
	 * @return the dianombre
	 */
	public String getDianombre() {
		return dianombre;
	}

	/**
	 * @param dianombre
	 *            the dianombre to set
	 */
	public void setDianombre(String dianombre) {
		this.dianombre = dianombre;
	}

	/**
	 * @return the horasrefrigerio
	 */
	public BigDecimal getHorasrefrigerio() {
		if (UValidador.esNulo(horasrefrigerio)) {
			horasrefrigerio = BigDecimal.ZERO;
		}
		return horasrefrigerio;
	}

	/**
	 * @param horasrefrigerio
	 *            the horasrefrigerio to set
	 */
	public void setHorasrefrigerio(BigDecimal horasrefrigerio) {
		this.horasrefrigerio = horasrefrigerio;
	}

	/**
	 * @return the horasrefrigeriodescripcion
	 */
	public String getHorasrefrigeriodescripcion() {
		return horasrefrigeriodescripcion;
	}

	/**
	 * @param horasrefrigeriodescripcion
	 *            the horasrefrigeriodescripcion to set
	 */
	public void setHorasrefrigeriodescripcion(String horasrefrigeriodescripcion) {
		this.horasrefrigeriodescripcion = horasrefrigeriodescripcion;
	}

	/**
	 * @return the horainicio
	 */
	public Date getHorainicio() {
		return horainicio;
	}

	/**
	 * @param horainicio the horainicio to set
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
	 * @param horafin the horafin to set
	 */
	public void setHorafin(Date horafin) {
		this.horafin = horafin;
	}
	

}
