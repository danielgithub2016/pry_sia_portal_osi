package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadmoduloopcion
*/
public class SySeguridadmoduloopcion extends DominioGenerico implements java.io.Serializable{

	private SySeguridadmoduloopcionPk pk;
	private String opcionmenu;
	private String estado;
	private String descripcion;


	public SySeguridadmoduloopcion() {
		pk = new SySeguridadmoduloopcionPk();
	}

	public SySeguridadmoduloopcionPk getPk() {
		return pk;
	}

	public void setPk(SySeguridadmoduloopcionPk pk) {
		this.pk = pk;
	}
	public String getOpcionmenu() {
		return opcionmenu;
	}

	public void setOpcionmenu(String opcionmenu) {
		this.opcionmenu = opcionmenu;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
