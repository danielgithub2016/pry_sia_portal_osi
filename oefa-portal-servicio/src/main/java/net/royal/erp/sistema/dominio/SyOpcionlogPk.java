package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SyOpcionlog
*/
public class SyOpcionlogPk implements java.io.Serializable{

	private String aplicacioncodigo;
	private String objetocodigo;

	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}

	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getObjetocodigo() {
		return objetocodigo;
	}

	public void setObjetocodigo(String objetocodigo) {
		this.objetocodigo = objetocodigo;
	}

}
