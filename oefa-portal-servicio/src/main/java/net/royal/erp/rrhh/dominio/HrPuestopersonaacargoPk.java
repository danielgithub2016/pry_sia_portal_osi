package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestopersonaacargo
*/
public class HrPuestopersonaacargoPk implements java.io.Serializable{

	private Integer codigopuesto;
	private Integer tipopuesto;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getTipopuesto() {
		return tipopuesto;
	}

	public void setTipopuesto(Integer tipopuesto) {
		this.tipopuesto = tipopuesto;
	}

}
