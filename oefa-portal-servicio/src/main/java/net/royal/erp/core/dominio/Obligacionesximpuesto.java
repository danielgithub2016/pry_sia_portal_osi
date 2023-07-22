package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Obligacionesximpuesto
*/
public class Obligacionesximpuesto extends DominioGenerico implements java.io.Serializable{

	private ObligacionesximpuestoPk pk;
	private java.math.BigDecimal factor;
	private BigDecimal montoimpuesto;


	public Obligacionesximpuesto() {
		pk = new ObligacionesximpuestoPk();
	}

	public ObligacionesximpuestoPk getPk() {
		return pk;
	}

	public void setPk(ObligacionesximpuestoPk pk) {
		this.pk = pk;
	}
	public java.math.BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(java.math.BigDecimal factor) {
		this.factor = factor;
	}

	public BigDecimal getMontoimpuesto() {
		return montoimpuesto;
	}

	public void setMontoimpuesto(BigDecimal montoimpuesto) {
		this.montoimpuesto = montoimpuesto;
	}

}
