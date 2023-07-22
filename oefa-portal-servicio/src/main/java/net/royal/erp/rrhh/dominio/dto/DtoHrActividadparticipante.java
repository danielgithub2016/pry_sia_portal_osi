package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadparticipante
*/
public class DtoHrActividadparticipante implements java.io.Serializable{

	private String actividad;
	private String companyowner;
	private Integer secuencia;
	private Integer empleado;
	private String flagparticipo;
	private String tipoactividad;
	private String flagbeneficio;
	private String flagasistencia;
	private Integer monto;

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}
	public String getFlagparticipo() {
		return flagparticipo;
	}

	public void setFlagparticipo(String flagparticipo) {
		this.flagparticipo = flagparticipo;
	}
	public String getTipoactividad() {
		return tipoactividad;
	}

	public void setTipoactividad(String tipoactividad) {
		this.tipoactividad = tipoactividad;
	}
	public String getFlagbeneficio() {
		return flagbeneficio;
	}

	public void setFlagbeneficio(String flagbeneficio) {
		this.flagbeneficio = flagbeneficio;
	}
	public String getFlagasistencia() {
		return flagasistencia;
	}

	public void setFlagasistencia(String flagasistencia) {
		this.flagasistencia = flagasistencia;
	}
	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

}
