package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Obligacionesxcuenta
*/
public class ObligacionesxcuentaPk implements java.io.Serializable{

	private BigDecimal proveedor;
	private String tipodocumento;
	private String numerodocumento;
	private Integer linea;

	
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
	public Integer getLinea() {
		return linea;
	}

	public void setLinea(Integer linea) {
		this.linea = linea;
	}

	public BigDecimal getProveedor() {
		return proveedor;
	}

	public void setProveedor(BigDecimal proveedor) {
		this.proveedor = proveedor;
	}

}
