package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPosicionempresa
*/
public class HrPosicionempresaPk implements java.io.Serializable{

	private String companyowner;
	private Integer codigoposicion;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public Integer getCodigoposicion() {
		return codigoposicion;
	}

	public void setCodigoposicion(Integer codigoposicion) {
		this.codigoposicion = codigoposicion;
	}

}
