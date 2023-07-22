package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestadetalle
*/
public class HrEncuestadetalle extends DominioGenerico implements java.io.Serializable{

	private HrEncuestadetallePk pk;
	private Integer orden;


	public HrEncuestadetalle() {
		pk = new HrEncuestadetallePk();
	}

	public HrEncuestadetallePk getPk() {
		return pk;
	}

	public void setPk(HrEncuestadetallePk pk) {
		this.pk = pk;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
