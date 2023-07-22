package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuDemandaCfpPpr
*/
public class BuDemandaCfpPprPk implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private Integer version;
	private String demanda;
	private String referenciafiscal;
	private String tipoDemanda;

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
	public String getDemanda() {
		return demanda;
	}

	public void setDemanda(String demanda) {
		this.demanda = demanda;
	}
	public String getReferenciafiscal() {
		return referenciafiscal;
	}

	public void setReferenciafiscal(String referenciafiscal) {
		this.referenciafiscal = referenciafiscal;
	}
	public String getTipoDemanda() {
		return tipoDemanda;
	}

	public void setTipoDemanda(String tipoDemanda) {
		this.tipoDemanda = tipoDemanda;
	}

}
