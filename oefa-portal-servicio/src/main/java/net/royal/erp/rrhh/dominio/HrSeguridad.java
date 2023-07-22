package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrSeguridad
*/
public class HrSeguridad extends DominioGenerico implements java.io.Serializable{

	private HrSeguridadPk pk;
	private String valortexto;
	private java.math.BigDecimal valornumero;
	private java.util.Date valorfecha;


	public HrSeguridad() {
		pk = new HrSeguridadPk();
	}

	public HrSeguridadPk getPk() {
		return pk;
	}

	public void setPk(HrSeguridadPk pk) {
		this.pk = pk;
	}
	public String getValortexto() {
		return valortexto;
	}

	public void setValortexto(String valortexto) {
		this.valortexto = valortexto;
	}
	public java.math.BigDecimal getValornumero() {
		return valornumero;
	}

	public void setValornumero(java.math.BigDecimal valornumero) {
		this.valornumero = valornumero;
	}
	public java.util.Date getValorfecha() {
		return valorfecha;
	}

	public void setValorfecha(java.util.Date valorfecha) {
		this.valorfecha = valorfecha;
	}

}
