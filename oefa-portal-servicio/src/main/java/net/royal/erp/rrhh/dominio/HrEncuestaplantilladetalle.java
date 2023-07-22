package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestaplantilladetalle
*/
public class HrEncuestaplantilladetalle extends DominioGenerico implements java.io.Serializable{

	private HrEncuestaplantilladetallePk pk;
	private String tipoencuesta;
	private Integer orden;


	public HrEncuestaplantilladetalle() {
		pk = new HrEncuestaplantilladetallePk();
	}

	public HrEncuestaplantilladetallePk getPk() {
		return pk;
	}

	public void setPk(HrEncuestaplantilladetallePk pk) {
		this.pk = pk;
	}
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
