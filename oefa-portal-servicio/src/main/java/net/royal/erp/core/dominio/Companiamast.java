package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companiamast
*/
public class Companiamast extends DominioGenerico implements java.io.Serializable{

	private CompaniamastPk pk;
	private String descripcioncorta;
	private String descripcionlarga;
	private String direccioncomun;
	private String direccionadicional;
	private java.util.Date fechafundacion;
	private String telefono1;
	private String telefono2;
	private String telefono3;
	private String fax1;
	private String fax2;
	private String documentofiscal;
	private String propietariopordefecto;
	private String descripcionextranjera;
	private String monedapordefecto;
	private String tipocompania;
	private String factorrvalidacion;
	private String afectoigvflag;
	private String creditofiscalfactorflag;
	private String cuentaprovisionsbsflag;
	private String logofile;
	private Integer persona;
	private String estado;
	private String representantelegal;
	private String paginaweb;
	private String afectoretencionigvflag;
	private String grupo;
	private String certificadoinscripcion;
	private String detraccioncuentabancaria;
	private String representantelegaldocumento;
	private String regimenlaboralrtps;
	private String codigoanterior;
	private String plancontable;
	private String pliego;


	public Companiamast() {
		pk = new CompaniamastPk();
	}

	public CompaniamastPk getPk() {
		return pk;
	}

	public void setPk(CompaniamastPk pk) {
		this.pk = pk;
	}
	public String getDescripcioncorta() {
		return descripcioncorta;
	}

	public void setDescripcioncorta(String descripcioncorta) {
		this.descripcioncorta = descripcioncorta;
	}
	public String getDescripcionlarga() {
		return descripcionlarga;
	}

	public void setDescripcionlarga(String descripcionlarga) {
		this.descripcionlarga = descripcionlarga;
	}
	public String getDireccioncomun() {
		return direccioncomun;
	}

	public void setDireccioncomun(String direccioncomun) {
		this.direccioncomun = direccioncomun;
	}
	public String getDireccionadicional() {
		return direccionadicional;
	}

	public void setDireccionadicional(String direccionadicional) {
		this.direccionadicional = direccionadicional;
	}
	public java.util.Date getFechafundacion() {
		return fechafundacion;
	}

	public void setFechafundacion(java.util.Date fechafundacion) {
		this.fechafundacion = fechafundacion;
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
	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}
	public String getPropietariopordefecto() {
		return propietariopordefecto;
	}

	public void setPropietariopordefecto(String propietariopordefecto) {
		this.propietariopordefecto = propietariopordefecto;
	}
	public String getDescripcionextranjera() {
		return descripcionextranjera;
	}

	public void setDescripcionextranjera(String descripcionextranjera) {
		this.descripcionextranjera = descripcionextranjera;
	}
	public String getMonedapordefecto() {
		return monedapordefecto;
	}

	public void setMonedapordefecto(String monedapordefecto) {
		this.monedapordefecto = monedapordefecto;
	}
	public String getTipocompania() {
		return tipocompania;
	}

	public void setTipocompania(String tipocompania) {
		this.tipocompania = tipocompania;
	}
	public String getFactorrvalidacion() {
		return factorrvalidacion;
	}

	public void setFactorrvalidacion(String factorrvalidacion) {
		this.factorrvalidacion = factorrvalidacion;
	}
	public String getAfectoigvflag() {
		return afectoigvflag;
	}

	public void setAfectoigvflag(String afectoigvflag) {
		this.afectoigvflag = afectoigvflag;
	}
	public String getCreditofiscalfactorflag() {
		return creditofiscalfactorflag;
	}

	public void setCreditofiscalfactorflag(String creditofiscalfactorflag) {
		this.creditofiscalfactorflag = creditofiscalfactorflag;
	}
	public String getCuentaprovisionsbsflag() {
		return cuentaprovisionsbsflag;
	}

	public void setCuentaprovisionsbsflag(String cuentaprovisionsbsflag) {
		this.cuentaprovisionsbsflag = cuentaprovisionsbsflag;
	}
	public String getLogofile() {
		return logofile;
	}

	public void setLogofile(String logofile) {
		this.logofile = logofile;
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
	public String getRepresentantelegal() {
		return representantelegal;
	}

	public void setRepresentantelegal(String representantelegal) {
		this.representantelegal = representantelegal;
	}
	public String getPaginaweb() {
		return paginaweb;
	}

	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}
	public String getAfectoretencionigvflag() {
		return afectoretencionigvflag;
	}

	public void setAfectoretencionigvflag(String afectoretencionigvflag) {
		this.afectoretencionigvflag = afectoretencionigvflag;
	}
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCertificadoinscripcion() {
		return certificadoinscripcion;
	}

	public void setCertificadoinscripcion(String certificadoinscripcion) {
		this.certificadoinscripcion = certificadoinscripcion;
	}
	public String getDetraccioncuentabancaria() {
		return detraccioncuentabancaria;
	}

	public void setDetraccioncuentabancaria(String detraccioncuentabancaria) {
		this.detraccioncuentabancaria = detraccioncuentabancaria;
	}
	public String getRepresentantelegaldocumento() {
		return representantelegaldocumento;
	}

	public void setRepresentantelegaldocumento(String representantelegaldocumento) {
		this.representantelegaldocumento = representantelegaldocumento;
	}
	public String getRegimenlaboralrtps() {
		return regimenlaboralrtps;
	}

	public void setRegimenlaboralrtps(String regimenlaboralrtps) {
		this.regimenlaboralrtps = regimenlaboralrtps;
	}
	public String getCodigoanterior() {
		return codigoanterior;
	}

	public void setCodigoanterior(String codigoanterior) {
		this.codigoanterior = codigoanterior;
	}
	public String getPlancontable() {
		return plancontable;
	}

	public void setPlancontable(String plancontable) {
		this.plancontable = plancontable;
	}
	public String getPliego() {
		return pliego;
	}

	public void setPliego(String pliego) {
		this.pliego = pliego;
	}

}
