package net.royal.erp.asistencia.sylock.dominio.dto;

/**
 *
 * @author desarrollo
 * @powerbuilder sylock.dw_ma_companyowner_select
 */
@SuppressWarnings("serial")
public class DtoDwMaCompanyownerSelect implements java.io.Serializable {
	private String description;
	private String companyowner;
	private String usuario;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
