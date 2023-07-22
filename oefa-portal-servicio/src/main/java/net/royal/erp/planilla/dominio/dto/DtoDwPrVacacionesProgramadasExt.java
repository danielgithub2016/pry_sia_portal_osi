package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;

public class DtoDwPrVacacionesProgramadasExt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empleado;
	private String nombrecompleto;
	private String cargo;
	private Date fechaingreso;
	private Date fecharecalculada;
	private Integer nrocarga;
	private Date fechainicio;
	private Date fechafin;
	private String tipoplanilla;
	private Date fechainicio2;
	private Date fechafin2;
	private Integer totaldias;
	private Integer totaldias2;

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Object empleado) {
		if (!UValidador.esNulo(empleado)) {
			if (empleado instanceof Integer)
				this.empleado = Integer.parseInt(empleado.toString());
			else if (empleado instanceof BigDecimal)
				this.empleado = new BigDecimal(empleado.toString()).intValue();
		}
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFecharecalculada() {
		return fecharecalculada;
	}

	public void setFecharecalculada(Date fecharecalculada) {
		this.fecharecalculada = fecharecalculada;
	}

	public Integer getNrocarga() {
		return nrocarga;
	}

	public void setNrocarga(Object nrocarga) {
		if (!UValidador.esNulo(nrocarga)) {
			if (nrocarga instanceof Integer)
				this.nrocarga = Integer.parseInt(nrocarga.toString());
			else if (nrocarga instanceof BigDecimal)
				this.nrocarga = new BigDecimal(nrocarga.toString()).intValue();
		}
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public Date getFechainicio2() {
		return fechainicio2;
	}

	public void setFechainicio2(Date fechainicio2) {
		this.fechainicio2 = fechainicio2;
	}

	public Date getFechafin2() {
		return fechafin2;
	}

	public void setFechafin2(Date fechafin2) {
		this.fechafin2 = fechafin2;
	}

	@Override
	public String toString() {
		return "DtoDwPrVacacionesProgramadasExt [" + (empleado != null ? "empleado=" + empleado + ", " : "")
				+ (nombrecompleto != null ? "nombrecompleto=" + nombrecompleto + ", " : "")
				+ (cargo != null ? "cargo=" + cargo + ", " : "")
				+ (fechaingreso != null ? "fechaingreso=" + fechaingreso + ", " : "")
				+ (fecharecalculada != null ? "fecharecalculada=" + fecharecalculada + ", " : "")
				+ (nrocarga != null ? "nrocarga=" + nrocarga + ", " : "")
				+ (fechainicio != null ? "fechainicio=" + fechainicio + ", " : "")
				+ (fechafin != null ? "fechafin=" + fechafin + ", " : "")
				+ (tipoplanilla != null ? "tipoplanilla=" + tipoplanilla + ", " : "")
				+ (fechainicio2 != null ? "fechainicio2=" + fechainicio2 + ", " : "")
				+ (fechafin2 != null ? "fechafin2=" + fechafin2 : "") + "]";
	}

	public Integer getTotaldias() {
		totaldias = UFechaHora.obtenerDiasTranscurridos(fechafin2, fechainicio2);
		return totaldias;
	}

	public void setTotaldias(Integer totaldias) {
		this.totaldias = totaldias;
	}

	public Integer getTotaldias2() {
		totaldias2 = UFechaHora.obtenerDiasTranscurridos(fechafin, fechainicio);
		return totaldias2;
	}

	public void setTotaldias2(Integer totaldias2) {
		this.totaldias2 = totaldias2;
	}

}
