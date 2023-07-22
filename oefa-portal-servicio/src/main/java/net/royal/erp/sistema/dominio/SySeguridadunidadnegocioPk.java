package net.royal.erp.sistema.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder sistema.SySeguridadunidadnegocio
*/
public class SySeguridadunidadnegocioPk implements java.io.Serializable{

	private String tipomst;
	private String codigo;
	private String unidadnegocio;

	public String getTipomst() {
		return tipomst;
	}

	public void setTipomst(String tipomst) {
		this.tipomst = tipomst;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

}
