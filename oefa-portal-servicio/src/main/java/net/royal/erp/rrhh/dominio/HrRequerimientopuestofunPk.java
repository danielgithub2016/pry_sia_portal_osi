package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestofun
*/
public class HrRequerimientopuestofunPk implements java.io.Serializable{

	private String companyowner;
	private String requerimiento;
	private Integer codigopuesto;
	private Integer codigofuncion;

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
	public Integer getCodigofuncion() {
		return codigofuncion;
	}

	public void setCodigofuncion(Integer codigofuncion) {
		this.codigofuncion = codigofuncion;
	}

}
