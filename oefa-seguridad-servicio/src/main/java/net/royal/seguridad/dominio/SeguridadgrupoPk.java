package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadgrupo
*/
public class SeguridadgrupoPk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	
	public SeguridadgrupoPk(){}
	public SeguridadgrupoPk(String aplicacioncodigo, String grupo){
		this.aplicacioncodigo=aplicacioncodigo;
		this.grupo=grupo;
	}
	
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

}
