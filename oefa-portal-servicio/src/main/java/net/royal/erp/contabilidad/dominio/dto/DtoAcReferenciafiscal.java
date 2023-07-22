package net.royal.erp.contabilidad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder contabilidad.AcReferenciafiscal
*/
public class DtoAcReferenciafiscal implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private Integer version;
	private String tiporeferenciafiscal;
	private String nivel;
	private String referenciafiscal;
	private String descripcionlocal;
	private String descripcioningles;
	private String referenciafiscalrelacionada;
	private String referenciafiscalanterior;
	private String unidadmedida;
	private String anioinicioejecucion;
	private String aniofinejecucion;
	private String companyowner;
	private String detalle;
	private String estado;
	private String flgrrhh;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getTiporeferenciafiscal() {
		return tiporeferenciafiscal;
	}

	public void setTiporeferenciafiscal(String tiporeferenciafiscal) {
		this.tiporeferenciafiscal = tiporeferenciafiscal;
	}
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getReferenciafiscal() {
		return referenciafiscal;
	}

	public void setReferenciafiscal(String referenciafiscal) {
		this.referenciafiscal = referenciafiscal;
	}
	public String getDescripcionlocal() {
		return descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getReferenciafiscalrelacionada() {
		return referenciafiscalrelacionada;
	}

	public void setReferenciafiscalrelacionada(String referenciafiscalrelacionada) {
		this.referenciafiscalrelacionada = referenciafiscalrelacionada;
	}
	public String getReferenciafiscalanterior() {
		return referenciafiscalanterior;
	}

	public void setReferenciafiscalanterior(String referenciafiscalanterior) {
		this.referenciafiscalanterior = referenciafiscalanterior;
	}
	public String getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}
	public String getAnioinicioejecucion() {
		return anioinicioejecucion;
	}

	public void setAnioinicioejecucion(String anioinicioejecucion) {
		this.anioinicioejecucion = anioinicioejecucion;
	}
	public String getAniofinejecucion() {
		return aniofinejecucion;
	}

	public void setAniofinejecucion(String aniofinejecucion) {
		this.aniofinejecucion = aniofinejecucion;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlgrrhh() {
		return flgrrhh;
	}

	public void setFlgrrhh(String flgrrhh) {
		this.flgrrhh = flgrrhh;
	}

}
