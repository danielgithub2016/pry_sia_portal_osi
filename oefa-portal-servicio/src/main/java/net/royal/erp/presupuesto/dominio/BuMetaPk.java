package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuMeta
*/
public class BuMetaPk implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private Integer meta;

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
	public Integer getMeta() {
		return meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
	}

}
