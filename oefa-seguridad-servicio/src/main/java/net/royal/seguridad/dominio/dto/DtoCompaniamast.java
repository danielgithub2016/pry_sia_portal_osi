package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companiamast
*/
public class DtoCompaniamast implements java.io.Serializable{

	private String companiaCodigo;
	private String descripcionCorta;
	private String descripcionLarga;
	private String direccionComun;
	private String direccionAdicional;
	private java.util.Date fechafFndacion;
	private String telefono1;
	private String telefono2;
	private String telefono3;
	private String fax1;
	private String fax2;
	private String documentoFiscal;
	private String propietarioPorDefecto;
	private String descripcionExtranjera;
	private String monedaPorDefecto;
	private String tipoCompania;
	private String factorrValidacion;
	private String afectoIgvFlag;
	private String creditoFiscalFactorFlag;
	private String cuentaProvisionSbsFlag;
	private String logoFile;
	private Integer persona;
	private String estado;
	private String ultimoUsuario;
	private java.util.Date ultimaFechaModif;
	private String representanteLegal;
	private String paginawWeb;
	private String afectoRetencionIgvFlag;
	private String grupo;
	private String certificadoInscripcion;
	private String detraccionCuentaBancaria;
	private String representanteLegalDocumento;
	private String regimenLaboralRtps;
	private String codigoAnterior;
	private String planContable;
	private String pliego;
	public String getCompaniaCodigo() {
		return companiaCodigo;
	}
	public void setCompaniaCodigo(String companiaCodigo) {
		this.companiaCodigo = companiaCodigo;
	}
	public String getDescripcionCorta() {
		return descripcionCorta;
	}
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}
	public String getDescripcionLarga() {
		return descripcionLarga;
	}
	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}
	public String getDireccionComun() {
		return direccionComun;
	}
	public void setDireccionComun(String direccionComun) {
		this.direccionComun = direccionComun;
	}
	public String getDireccionAdicional() {
		return direccionAdicional;
	}
	public void setDireccionAdicional(String direccionAdicional) {
		this.direccionAdicional = direccionAdicional;
	}
	public java.util.Date getFechafFndacion() {
		return fechafFndacion;
	}
	public void setFechafFndacion(java.util.Date fechafFndacion) {
		this.fechafFndacion = fechafFndacion;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getTelefono3() {
		return telefono3;
	}
	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}
	public String getFax1() {
		return fax1;
	}
	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}
	public String getFax2() {
		return fax2;
	}
	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}
	public String getDocumentoFiscal() {
		return documentoFiscal;
	}
	public void setDocumentoFiscal(String documentoFiscal) {
		this.documentoFiscal = documentoFiscal;
	}
	public String getPropietarioPorDefecto() {
		return propietarioPorDefecto;
	}
	public void setPropietarioPorDefecto(String propietarioPorDefecto) {
		this.propietarioPorDefecto = propietarioPorDefecto;
	}
	public String getDescripcionExtranjera() {
		return descripcionExtranjera;
	}
	public void setDescripcionExtranjera(String descripcionExtranjera) {
		this.descripcionExtranjera = descripcionExtranjera;
	}
	public String getMonedaPorDefecto() {
		return monedaPorDefecto;
	}
	public void setMonedaPorDefecto(String monedaPorDefecto) {
		this.monedaPorDefecto = monedaPorDefecto;
	}
	public String getTipoCompania() {
		return tipoCompania;
	}
	public void setTipoCompania(String tipoCompania) {
		this.tipoCompania = tipoCompania;
	}
	public String getFactorrValidacion() {
		return factorrValidacion;
	}
	public void setFactorrValidacion(String factorrValidacion) {
		this.factorrValidacion = factorrValidacion;
	}
	public String getAfectoIgvFlag() {
		return afectoIgvFlag;
	}
	public void setAfectoIgvFlag(String afectoIgvFlag) {
		this.afectoIgvFlag = afectoIgvFlag;
	}
	public String getCreditoFiscalFactorFlag() {
		return creditoFiscalFactorFlag;
	}
	public void setCreditoFiscalFactorFlag(String creditoFiscalFactorFlag) {
		this.creditoFiscalFactorFlag = creditoFiscalFactorFlag;
	}
	public String getCuentaProvisionSbsFlag() {
		return cuentaProvisionSbsFlag;
	}
	public void setCuentaProvisionSbsFlag(String cuentaProvisionSbsFlag) {
		this.cuentaProvisionSbsFlag = cuentaProvisionSbsFlag;
	}
	public String getLogoFile() {
		return logoFile;
	}
	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}
	public Integer getPersona() {
		return persona;
	}
	public void setPersona(Integer persona) {
		this.persona = persona;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUltimoUsuario() {
		return ultimoUsuario;
	}
	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}
	public java.util.Date getUltimaFechaModif() {
		return ultimaFechaModif;
	}
	public void setUltimaFechaModif(java.util.Date ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}
	public String getRepresentanteLegal() {
		return representanteLegal;
	}
	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}
	public String getPaginawWeb() {
		return paginawWeb;
	}
	public void setPaginawWeb(String paginawWeb) {
		this.paginawWeb = paginawWeb;
	}
	public String getAfectoRetencionIgvFlag() {
		return afectoRetencionIgvFlag;
	}
	public void setAfectoRetencionIgvFlag(String afectoRetencionIgvFlag) {
		this.afectoRetencionIgvFlag = afectoRetencionIgvFlag;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCertificadoInscripcion() {
		return certificadoInscripcion;
	}
	public void setCertificadoInscripcion(String certificadoInscripcion) {
		this.certificadoInscripcion = certificadoInscripcion;
	}
	public String getDetraccionCuentaBancaria() {
		return detraccionCuentaBancaria;
	}
	public void setDetraccionCuentaBancaria(String detraccionCuentaBancaria) {
		this.detraccionCuentaBancaria = detraccionCuentaBancaria;
	}
	public String getRepresentanteLegalDocumento() {
		return representanteLegalDocumento;
	}
	public void setRepresentanteLegalDocumento(String representanteLegalDocumento) {
		this.representanteLegalDocumento = representanteLegalDocumento;
	}
	public String getRegimenLaboralRtps() {
		return regimenLaboralRtps;
	}
	public void setRegimenLaboralRtps(String regimenLaboralRtps) {
		this.regimenLaboralRtps = regimenLaboralRtps;
	}
	public String getCodigoAnterior() {
		return codigoAnterior;
	}
	public void setCodigoAnterior(String codigoAnterior) {
		this.codigoAnterior = codigoAnterior;
	}
	public String getPlanContable() {
		return planContable;
	}
	public void setPlanContable(String planContable) {
		this.planContable = planContable;
	}
	public String getPliego() {
		return pliego;
	}
	public void setPliego(String pliego) {
		this.pliego = pliego;
	}

	

}
