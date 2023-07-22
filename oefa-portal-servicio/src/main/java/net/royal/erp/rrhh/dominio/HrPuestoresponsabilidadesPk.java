package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoresponsabilidades
*/
public class HrPuestoresponsabilidadesPk implements java.io.Serializable{

	private Integer codigopuesto;
	private Integer codigoreponsabilidad;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getCodigoreponsabilidad() {
		return codigoreponsabilidad;
	}

	public void setCodigoreponsabilidad(Integer codigoreponsabilidad) {
		this.codigoreponsabilidad = codigoreponsabilidad;
	}

}
