package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaPersonacentrocostoautorizac
*/
public class MaPersonacentrocostoautorizacPk implements java.io.Serializable{

	private String aplicacioncodigo;
	private Integer persona;
	private String centrocostos;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}
	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

}
