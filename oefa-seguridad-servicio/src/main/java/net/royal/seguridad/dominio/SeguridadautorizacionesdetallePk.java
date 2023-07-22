package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadautorizacionesdetalle
*/
public class SeguridadautorizacionesdetallePk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	private String detallecodigo;
	private String usuario;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getDetallecodigo() {
		return detallecodigo;
	}

	public void setDetallecodigo(String detallecodigo) {
		this.detallecodigo = detallecodigo;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
