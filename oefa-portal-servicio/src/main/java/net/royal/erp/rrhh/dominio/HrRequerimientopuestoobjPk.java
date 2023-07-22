package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestoobj
*/
public class HrRequerimientopuestoobjPk implements java.io.Serializable{

	private String companyowner;
	private String requerimiento;
	private Integer codigopuesto;
	private Integer secuencia;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
