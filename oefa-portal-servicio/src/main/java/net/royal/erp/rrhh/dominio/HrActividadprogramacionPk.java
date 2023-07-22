package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadprogramacion
*/
public class HrActividadprogramacionPk implements java.io.Serializable{

	private String actividad;
	private String companyowner;
	private String tipoactividad;
	private Integer secuencia;

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
	public String getTipoactividad() {
		return tipoactividad;
	}

	public void setTipoactividad(String tipoactividad) {
		this.tipoactividad = tipoactividad;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
