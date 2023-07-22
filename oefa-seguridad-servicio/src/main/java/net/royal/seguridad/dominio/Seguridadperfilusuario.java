package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadperfilusuario
*/
public class Seguridadperfilusuario extends DominioGenerico implements java.io.Serializable{

	private SeguridadperfilusuarioPk pk;
	private String estado;
	private String ultimousuario;
	private java.util.Date ultimafechamodif;


	public Seguridadperfilusuario() {
		pk = new SeguridadperfilusuarioPk();
	}

	public SeguridadperfilusuarioPk getPk() {
		return pk;
	}

	public void setPk(SeguridadperfilusuarioPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public java.util.Date getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(java.util.Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

}
