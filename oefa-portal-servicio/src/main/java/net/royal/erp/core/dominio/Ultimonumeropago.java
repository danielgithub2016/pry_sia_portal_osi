package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Ultimonumeropago
*/
public class Ultimonumeropago extends DominioGenerico implements java.io.Serializable{

	private UltimonumeropagoPk pk;
	private Integer ultimonumeropago;
	private Integer numeropagodesde;
	private Integer numeropagohasta;


	public Ultimonumeropago() {
		pk = new UltimonumeropagoPk();
	}

	public UltimonumeropagoPk getPk() {
		return pk;
	}

	public void setPk(UltimonumeropagoPk pk) {
		this.pk = pk;
	}
	public Integer getUltimonumeropago() {
		return ultimonumeropago;
	}

	public void setUltimonumeropago(Integer ultimonumeropago) {
		this.ultimonumeropago = ultimonumeropago;
	}
	public Integer getNumeropagodesde() {
		return numeropagodesde;
	}

	public void setNumeropagodesde(Integer numeropagodesde) {
		this.numeropagodesde = numeropagodesde;
	}
	public Integer getNumeropagohasta() {
		return numeropagohasta;
	}

	public void setNumeropagohasta(Integer numeropagohasta) {
		this.numeropagohasta = numeropagohasta;
	}

}
