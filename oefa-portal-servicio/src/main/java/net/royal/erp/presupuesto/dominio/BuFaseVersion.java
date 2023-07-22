package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuFaseVersion
*/
public class BuFaseVersion extends DominioGenerico implements java.io.Serializable{

	private BuFaseVersionPk pk;
	private java.util.Date inicio;
	private java.util.Date cierre;
	private String tipo;
	private String estado;
	private String terminal;


	public BuFaseVersion() {
		pk = new BuFaseVersionPk();
	}

	public BuFaseVersionPk getPk() {
		return pk;
	}

	public void setPk(BuFaseVersionPk pk) {
		this.pk = pk;
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
