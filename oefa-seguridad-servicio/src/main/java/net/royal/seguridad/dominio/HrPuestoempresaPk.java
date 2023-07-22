package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoempresa
*/
public class HrPuestoempresaPk implements java.io.Serializable{

	private Integer codigopuesto;
	
	public HrPuestoempresaPk(){}
	
	public HrPuestoempresaPk(Integer codigopuesto){
		this.codigopuesto=codigopuesto;
	}

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

}
