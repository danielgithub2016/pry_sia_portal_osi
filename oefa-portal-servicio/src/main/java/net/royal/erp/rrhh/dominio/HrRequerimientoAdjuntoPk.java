package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

public class HrRequerimientoAdjuntoPk  implements Serializable{
	private String requerimiento;                 
	private String companyowner;                  
	private Integer secuencia ;
	
	public String getRequerimiento() {
		return requerimiento;
	}
	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
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
	
}
