package net.royal.erp.presupuesto.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuFaseVersion
*/
public class DtoBuFaseVersion implements java.io.Serializable{

	private String companiasocio;
	private String ano;
	private Integer version;
	private String fase;
	private java.util.Date inicio;
	private java.util.Date cierre;
	private String tipo;
	private String estado;
	private String terminal;

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
	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}
	public java.util.Date getInicio() {
		return inicio;
	}

	public void setInicio(java.util.Date inicio) {
		this.inicio = inicio;
	}
	public java.util.Date getCierre() {
		return cierre;
	}

	public void setCierre(java.util.Date cierre) {
		this.cierre = cierre;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

}
