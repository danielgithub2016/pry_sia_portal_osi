package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.MaUnidadnegocio
*/
public class MaUnidadnegocioPk implements java.io.Serializable{

	private String unidadnegocio;
	
	public MaUnidadnegocioPk(String unidadnegocio){
		this.unidadnegocio=unidadnegocio;
	}
	
	public MaUnidadnegocioPk(){}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

}
