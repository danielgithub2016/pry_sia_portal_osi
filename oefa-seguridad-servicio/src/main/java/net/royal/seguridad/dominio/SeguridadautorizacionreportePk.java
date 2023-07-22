package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacionreporte
*/
public class SeguridadautorizacionreportePk implements java.io.Serializable{

	private String usuario;
	private String aplicacioncodigo;
	private String reportecodigo;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getReportecodigo() {
		return reportecodigo;
	}

	public void setReportecodigo(String reportecodigo) {
		this.reportecodigo = reportecodigo;
	}

}
