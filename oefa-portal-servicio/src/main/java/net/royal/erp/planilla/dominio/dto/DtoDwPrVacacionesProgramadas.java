package net.royal.erp.planilla.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwPrVacacionesProgramadas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empleado;
	private String nombre;
	private String cargo;
	private String unidadorganica;
	private Date fechaingreso;
	private Date fecharecalculada;
	private Integer nrocarga;
	private Date fechainicio;
	private Date fechafin;
	private String tipoplanilla;
	private String tipoutilizacion;

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Object empleado) {
		if (!UValidador.esNulo(empleado)) {
			if (empleado instanceof BigDecimal)
				this.empleado = new BigDecimal(empleado.toString()).intValue();
			else if (empleado instanceof Integer)
				this.empleado = Integer.parseInt(empleado.toString());
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUnidadorganica() {
		return unidadorganica;
	}

	public void setUnidadorganica(String unidadorganica) {
		this.unidadorganica = unidadorganica;
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
			if (nrocarga instanceof BigDecimal)
				this.nrocarga = new BigDecimal(nrocarga.toString()).intValue();
			else if (nrocarga instanceof Integer)
				this.nrocarga = Integer.parseInt(nrocarga.toString());
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

	public String getTipoutilizacion() {
		return tipoutilizacion;
	}

	public void setTipoutilizacion(String tipoutilizacion) {
		this.tipoutilizacion = tipoutilizacion;
	}

}
