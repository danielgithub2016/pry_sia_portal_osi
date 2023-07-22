package net.royal.erp.planilla.dominio;

import java.io.Serializable;

public class PrFuentefinanciamientoPk implements Serializable {

	private String ano;
	private String companiasocio;
	private String fuentefinanciamiento;

	public PrFuentefinanciamientoPk(String ano, String companiasocio, String fuentefinanciamiento) {
		this.ano = ano;
		this.companiasocio = companiasocio;
		this.fuentefinanciamiento = fuentefinanciamiento;
	}

	public PrFuentefinanciamientoPk() {
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getFuentefinanciamiento() {
		return fuentefinanciamiento;
	}

	public void setFuentefinanciamiento(String fuentefinanciamiento) {
		this.fuentefinanciamiento = fuentefinanciamiento;
	}

}
