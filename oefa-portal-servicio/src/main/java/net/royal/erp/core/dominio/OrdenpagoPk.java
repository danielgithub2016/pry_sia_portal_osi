package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Ordenpago
*/
public class OrdenpagoPk implements java.io.Serializable{

	private String sistemafuente;
	private java.math.BigDecimal proveedor;
	private String tipodocumento;
	private String numerodocumento;
	

	public String getSistemafuente() {
		return sistemafuente;
	}

	public void setSistemafuente(String sistemafuente) {
		this.sistemafuente = sistemafuente;
	}
	public java.math.BigDecimal getProveedor() {
		return proveedor;
	}

	public void setProveedor(java.math.BigDecimal proveedor) {
		this.proveedor = proveedor;
	}
	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	

}
