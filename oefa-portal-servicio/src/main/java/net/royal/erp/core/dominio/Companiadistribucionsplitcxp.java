package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Companiadistribucionsplitcxp
*/
public class Companiadistribucionsplitcxp extends DominioGenerico implements java.io.Serializable{

	private CompaniadistribucionsplitcxpPk pk;
	private java.math.BigDecimal porcentaje;


	public Companiadistribucionsplitcxp() {
		pk = new CompaniadistribucionsplitcxpPk();
	}

	public CompaniadistribucionsplitcxpPk getPk() {
		return pk;
	}

	public void setPk(CompaniadistribucionsplitcxpPk pk) {
		this.pk = pk;
	}
	public java.math.BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(java.math.BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

}
