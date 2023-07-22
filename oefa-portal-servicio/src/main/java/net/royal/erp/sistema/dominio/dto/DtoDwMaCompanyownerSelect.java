package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder symast01.dw_ma_companyowner_select
 */
public class DtoDwMaCompanyownerSelect implements java.io.Serializable {
	private String companyowner;
	private String description;
	private String tipocompania;
	private String descripcioncorta;
	private String descripcionlarga;
	private String documentofiscal;
	private String telefono1;
	private String fax1;
	private String direccioncomun;
	private String englishdescription;
	private String logofile;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTipocompania() {
		return tipocompania;
	}

	public void setTipocompania(String tipocompania) {
		this.tipocompania = tipocompania;
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

	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public String getDireccioncomun() {
		return direccioncomun;
	}

	public void setDireccioncomun(String direccioncomun) {
		this.direccioncomun = direccioncomun;
	}

	public String getEnglishdescription() {
		return englishdescription;
	}

	public void setEnglishdescription(String englishdescription) {
		this.englishdescription = englishdescription;
	}

	public String getLogofile() {
		return logofile;
	}

	public void setLogofile(String logofile) {
		this.logofile = logofile;
	}



}
