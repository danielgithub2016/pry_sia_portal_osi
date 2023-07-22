package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Seguridadconcepto
*/
public class SeguridadconceptoPk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	
	public SeguridadconceptoPk(){}
	public SeguridadconceptoPk(String aplicacioncodigo, String grupo, String concepto){
		this.aplicacioncodigo=aplicacioncodigo;
		this.grupo=grupo;
		this.concepto=concepto;
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
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

}
