package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestofunciones
*/
public class HrPuestofuncionesPk implements java.io.Serializable{

	private Integer codigofuncion;
	private Integer codigopuesto;

	public Integer getCodigofuncion() {
		return codigofuncion;
	}

	public void setCodigofuncion(Integer codigofuncion) {
		this.codigofuncion = codigofuncion;
	}
	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}

}
