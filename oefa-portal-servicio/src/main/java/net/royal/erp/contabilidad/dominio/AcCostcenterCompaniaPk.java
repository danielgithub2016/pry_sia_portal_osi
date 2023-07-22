package net.royal.erp.contabilidad.dominio;

import java.io.Serializable;

public class AcCostcenterCompaniaPk implements Serializable {
	private String companiasocio;
	private String ano;
	private Integer version;
	private String costcenter;

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

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

}
