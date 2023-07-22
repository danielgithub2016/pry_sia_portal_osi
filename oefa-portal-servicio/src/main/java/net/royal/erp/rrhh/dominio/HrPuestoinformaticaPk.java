package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoinformatica
*/
public class HrPuestoinformaticaPk implements java.io.Serializable{

	private Integer codigopuesto;
	private String informatica;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public String getInformatica() {
		return informatica;
	}

	public void setInformatica(String informatica) {
		this.informatica = informatica;
	}

}
