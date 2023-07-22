package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_ac_voucher_validation_feeder
 */
public class DtoDwAcVoucherValidationFeeder implements java.io.Serializable {
	private String companyowner;
	private String account;
	private String proyecto;
	private String costcenter;
	private String costcenterdestination;
	private String sucursal;
	private String camporeferencia;
	private String checknumber;
	private String responsablecodigo;
	private String referenciafiscal01;
	private String referenciafiscal02;
	private String referenciafiscal03;
	private Integer persona;
	private String unidadnegocio;
	public String getCompanyowner() {
		return companyowner;
	}
	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getCostcenter() {
		return costcenter;
	}
	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}
	public String getCostcenterdestination() {
		return costcenterdestination;
	}
	public void setCostcenterdestination(String costcenterdestination) {
		this.costcenterdestination = costcenterdestination;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getCamporeferencia() {
		return camporeferencia;
	}
	public void setCamporeferencia(String camporeferencia) {
		this.camporeferencia = camporeferencia;
	}
	public String getChecknumber() {
		return checknumber;
	}
	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}
	public String getResponsablecodigo() {
		return responsablecodigo;
	}
	public void setResponsablecodigo(String responsablecodigo) {
		this.responsablecodigo = responsablecodigo;
	}
	public String getReferenciafiscal01() {
		return referenciafiscal01;
	}
	public void setReferenciafiscal01(String referenciafiscal01) {
		this.referenciafiscal01 = referenciafiscal01;
	}
	public String getReferenciafiscal02() {
		return referenciafiscal02;
	}
	public void setReferenciafiscal02(String referenciafiscal02) {
		this.referenciafiscal02 = referenciafiscal02;
	}
	public String getReferenciafiscal03() {
		return referenciafiscal03;
	}
	public void setReferenciafiscal03(String referenciafiscal03) {
		this.referenciafiscal03 = referenciafiscal03;
	}
	
	public String getUnidadnegocio() {
		return unidadnegocio;
	}
	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public Integer getPersona() {
		return persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	

}
