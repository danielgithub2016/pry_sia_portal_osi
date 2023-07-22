package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestopersonaacargo
*/
public class HrPuestopersonaacargo extends DominioGenerico implements java.io.Serializable{

	private HrPuestopersonaacargoPk pk;
	private Integer cantidad;


	public HrPuestopersonaacargo() {
		pk = new HrPuestopersonaacargoPk();
	}

	public HrPuestopersonaacargoPk getPk() {
		return pk;
	}

	public void setPk(HrPuestopersonaacargoPk pk) {
		this.pk = pk;
	}
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
