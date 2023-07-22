package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientodocaprobacion
*/
public class HrRequerimientodocaprobacionPk implements java.io.Serializable{

	private String requerimiento;
	private String compania;
	private Integer secuencial;

	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}
	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}
	public Integer getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(Integer secuencial) {
		this.secuencial = secuencial;
	}

}
