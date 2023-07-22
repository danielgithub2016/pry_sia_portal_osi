package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadautorizaciones
*/
public class SySeguridadautorizaciones extends DominioGenerico implements java.io.Serializable{

	private SySeguridadautorizacionesPk pk;
	private String masterbrowseflag;
	private String masterupdateflag;
	private String estado;
	private String masterapproveflag;


	public SySeguridadautorizaciones() {
		pk = new SySeguridadautorizacionesPk();
	}

	public SySeguridadautorizacionesPk getPk() {
		return pk;
	}

	public void setPk(SySeguridadautorizacionesPk pk) {
		this.pk = pk;
	}
	public String getMasterbrowseflag() {
		return masterbrowseflag;
	}

	public void setMasterbrowseflag(String masterbrowseflag) {
		this.masterbrowseflag = masterbrowseflag;
	}
	public String getMasterupdateflag() {
		return masterupdateflag;
	}

	public void setMasterupdateflag(String masterupdateflag) {
		this.masterupdateflag = masterupdateflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMasterapproveflag() {
		return masterapproveflag;
	}

	public void setMasterapproveflag(String masterapproveflag) {
		this.masterapproveflag = masterapproveflag;
	}

}
