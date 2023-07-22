package net.royal.erp.presupuesto.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuControlpresupuestalDistrib
*/
public class DtoBuControlpresupuestalDistrib implements java.io.Serializable{

	private String companiasocio;
	private String tipodocumento;
	private String numerodocumento;
	private Integer proveedor;
	private Integer secuencia;
	private String centrocosto;
	private String centrocostodestino;
	private String cuentacontable;
	private String partidapresupuestal;
	private String proyecto;
	private String camporeferencia;
	private Integer monto;
	private String sucursal;
	private String referenciafiscal01;
	private String referenciafiscal02;
	private String referenciafiscal03;
	private Integer montodolares;

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
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getCentrocostodestino() {
		return centrocostodestino;
	}

	public void setCentrocostodestino(String centrocostodestino) {
		this.centrocostodestino = centrocostodestino;
	}
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public String getPartidapresupuestal() {
		return partidapresupuestal;
	}

	public void setPartidapresupuestal(String partidapresupuestal) {
		this.partidapresupuestal = partidapresupuestal;
	}
	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getCamporeferencia() {
		return camporeferencia;
	}

	public void setCamporeferencia(String camporeferencia) {
		this.camporeferencia = camporeferencia;
	}
	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getReferenciafiscal01() {
		return referenciafiscal01;
	}

	public void setReferenciafiscal01(String referenciafiscal01) {
		this.referenciafiscal01 = referenciafiscal01;
	}
	public String getReferenciafiscal02() {
		return referenciafiscal02;
	}

	public void setReferenciafiscal02(String referenciafiscal02) {
		this.referenciafiscal02 = referenciafiscal02;
	}
	public String getReferenciafiscal03() {
		return referenciafiscal03;
	}

	public void setReferenciafiscal03(String referenciafiscal03) {
		this.referenciafiscal03 = referenciafiscal03;
	}
	public Integer getMontodolares() {
		return montodolares;
	}

	public void setMontodolares(Integer montodolares) {
		this.montodolares = montodolares;
	}

}
