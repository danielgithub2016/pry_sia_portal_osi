package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrOrganigrama
*/
public class HrOrganigramaPk implements java.io.Serializable{

	private String companyowner;
	private Integer codigoorg;
	private Integer ano;
	private String tipoplanilla;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	public Integer getCodigoorg() {
		return codigoorg;
	}

	public void setCodigoorg(Integer codigoorg) {
		this.codigoorg = codigoorg;
	}
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

}
