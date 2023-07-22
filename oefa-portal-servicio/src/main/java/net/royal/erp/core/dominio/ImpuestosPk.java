package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Impuestos
*/
public class ImpuestosPk implements java.io.Serializable{

	private String impuesto;
	
	public ImpuestosPk(){}
	
	public ImpuestosPk(String impuesto){
		this.impuesto=impuesto;
	}

	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}

}
