package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyOpcionloghistory
*/
public class SyOpcionloghistoryPk implements java.io.Serializable{

	private String aplicacionlog;
	private String usuariolog;
	private java.util.Date fechalog;

	public String getAplicacionlog() {
		return aplicacionlog;
	}

	public void setAplicacionlog(String aplicacionlog) {
		this.aplicacionlog = aplicacionlog;
	}
	public String getUsuariolog() {
		return usuariolog;
	}

	public void setUsuariolog(String usuariolog) {
		this.usuariolog = usuariolog;
	}
	public java.util.Date getFechalog() {
		return fechalog;
	}

	public void setFechalog(java.util.Date fechalog) {
		this.fechalog = fechalog;
	}

}
