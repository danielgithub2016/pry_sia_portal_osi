package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoreporta
*/
public class HrPuestoreportaPk implements java.io.Serializable{

	private Integer codigopuesto;
	private Integer puestoreporta;

	public Integer getCodigopuesto() {
		return codigopuesto;
	}

	public void setCodigopuesto(Integer codigopuesto) {
		this.codigopuesto = codigopuesto;
	}
	public Integer getPuestoreporta() {
		return puestoreporta;
	}

	public void setPuestoreporta(Integer puestoreporta) {
		this.puestoreporta = puestoreporta;
	}

}
