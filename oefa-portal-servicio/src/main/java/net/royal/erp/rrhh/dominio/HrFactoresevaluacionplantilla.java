package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrFactoresevaluacionplantilla
*/
public class HrFactoresevaluacionplantilla extends DominioGenerico implements java.io.Serializable{

	private HrFactoresevaluacionplantillaPk pk;
	private String descripcion;
	private String tipoplantilla;
	private String estado;
	private String flagponderar;
	private String companyowner;
	private Integer secuenciaeval;
	private Integer formato;
	private Integer codigopuesto;


	public HrFactoresevaluacionplantilla() {
		pk = new HrFactoresevaluacionplantillaPk();
	}

	public HrFactoresevaluacionplantillaPk getPk() {
		return pk;
	}

	public void setPk(HrFactoresevaluacionplantillaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoplantilla() {
		return tipoplantilla;
	}

	public void setTipoplantilla(String tipoplantilla) {
		this.tipoplantilla = tipoplantilla;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlagponderar() {
		return flagponderar;
	}

	public void setFlagponderar(String flagponderar) {
		this.flagponderar = flagponderar;
	}
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
	public Integer getFormato() {
		return formato;
	}

	public void setFormato(Integer formato) {
		this.formato = formato;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

}
