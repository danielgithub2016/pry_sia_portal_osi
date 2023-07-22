package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Aplicacionesmast
*/
public class AplicacionesmastPk implements java.io.Serializable{

	private String aplicacioncodigo;
	
	public AplicacionesmastPk(){}
	public AplicacionesmastPk(String aplicacioncodigo){
		this.aplicacioncodigo=aplicacioncodigo;
	}

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}

}
