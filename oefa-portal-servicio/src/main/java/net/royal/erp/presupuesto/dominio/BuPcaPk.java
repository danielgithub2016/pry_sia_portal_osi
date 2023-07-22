package net.royal.erp.presupuesto.dominio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BuPcaPk implements Serializable {
	private String ano;
	private Integer numpca;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Integer getNumpca() {
		return numpca;
	}

	public void setNumpca(Integer numpca) {
		this.numpca = numpca;
	}

}
