package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Obligaciones
 */
public class ObligacionesPk implements java.io.Serializable {

	private BigDecimal proveedor;
	private String tipodocumento;
	private String numerodocumento;

	public ObligacionesPk() {
	}

	public ObligacionesPk(BigDecimal proveedor, String tipodocumento,
			String numerodocumento) {
		this.proveedor=proveedor;
		this.tipodocumento=tipodocumento;
		this.numerodocumento=numerodocumento;
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

	public BigDecimal getProveedor() {
		return proveedor;
	}

	public void setProveedor(BigDecimal proveedor) {
		this.proveedor = proveedor;
	}

}
