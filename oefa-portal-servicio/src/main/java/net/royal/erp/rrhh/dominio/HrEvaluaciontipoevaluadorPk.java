package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluaciontipoevaluador
*/
public class HrEvaluaciontipoevaluadorPk implements java.io.Serializable{

	private String companyowner;
	private Integer secuenciaeval;
	private String tipoevaluador;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}
	public String getTipoevaluador() {
		return tipoevaluador;
	}

	public void setTipoevaluador(String tipoevaluador) {
		this.tipoevaluador = tipoevaluador;
	}

}
