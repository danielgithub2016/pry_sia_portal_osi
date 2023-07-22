package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuControlpresupuestalDistrib
 */
public class BuControlpresupuestalDistribPk implements java.io.Serializable {

	private String companiasocio;
	private String tipodocumento;
	private String numerodocumento;
	private Integer proveedor;
	private Integer secuencia;

	public BuControlpresupuestalDistribPk() {

	}

	public BuControlpresupuestalDistribPk(String companiasocio,String tipodocumento,String numerodocumento,Integer proveedor,Integer secuencia) {
		  companiasocio=this.companiasocio;
		  tipodocumento=this.tipodocumento;
		  numerodocumento=this.numerodocumento;
		  proveedor=this.proveedor;
		  secuencia=this.secuencia;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
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

	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

}
