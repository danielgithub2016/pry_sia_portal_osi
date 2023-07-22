package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_cp_ordenpago_retrieve
 */
public class DtoDwCpOrdenpagoRetrieve implements java.io.Serializable {
	private String sistemafuente;
	private BigDecimal proveedor;
	private String tipodocumento;
	private String numerodocumento;
	private String pagara;
	private String companiacodigo;
	private String cuentabancaria;
	private String tipopago;
	private String chequeindividual;
	private Date fechavencimiento;
	private String monedadocumento;
	private String monedapago;
	private BigDecimal montomoneda;
	private BigDecimal tipodecambio;
	private BigDecimal batchnumber;
	private Date fechatransferencia;
	private String estado;
	private String flujodecaja;
	private String cuentacontable;
	private BigDecimal registronumero;
	private String voucher;
	private String centrocostodestino;
	private Date fechadocumento;
	private String voucherdocumento;
	private String suspensionflag;
	private String pagodiferidoflag;
	private String cuentabancariadestino;
	private String unidadreplicacion;
	private String unidadnegocio;
	
	public String getSistemafuente() {
		return sistemafuente;
	}
	public void setSistemafuente(String sistemafuente) {
		this.sistemafuente = sistemafuente;
	}
	public BigDecimal getProveedor() {
		return proveedor;
	}
	public void setProveedor(BigDecimal proveedor) {
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
	public String getPagara() {
		return pagara;
	}
	public void setPagara(String pagara) {
		this.pagara = pagara;
	}
	public String getCompaniacodigo() {
		return companiacodigo;
	}
	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}
	public String getCuentabancaria() {
		return cuentabancaria;
	}
	public void setCuentabancaria(String cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}
	public String getTipopago() {
		return tipopago;
	}
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public String getChequeindividual() {
		return chequeindividual;
	}
	public void setChequeindividual(String chequeindividual) {
		this.chequeindividual = chequeindividual;
	}
	public Date getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public String getMonedadocumento() {
		return monedadocumento;
	}
	public void setMonedadocumento(String monedadocumento) {
		this.monedadocumento = monedadocumento;
	}
	public String getMonedapago() {
		return monedapago;
	}
	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
	}
	public BigDecimal getMontomoneda() {
		return montomoneda;
	}
	public void setMontomoneda(BigDecimal montomoneda) {
		this.montomoneda = montomoneda;
	}
	public BigDecimal getTipodecambio() {
		return tipodecambio;
	}
	public void setTipodecambio(BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
	}
	public BigDecimal getBatchnumber() {
		return batchnumber;
	}
	public void setBatchnumber(BigDecimal batchnumber) {
		this.batchnumber = batchnumber;
	}
	public Date getFechatransferencia() {
		return fechatransferencia;
	}
	public void setFechatransferencia(Date fechatransferencia) {
		this.fechatransferencia = fechatransferencia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFlujodecaja() {
		return flujodecaja;
	}
	public void setFlujodecaja(String flujodecaja) {
		this.flujodecaja = flujodecaja;
	}
	public String getCuentacontable() {
		return cuentacontable;
	}
	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public BigDecimal getRegistronumero() {
		return registronumero;
	}
	public void setRegistronumero(BigDecimal registronumero) {
		this.registronumero = registronumero;
	}
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public String getCentrocostodestino() {
		return centrocostodestino;
	}
	public void setCentrocostodestino(String centrocostodestino) {
		this.centrocostodestino = centrocostodestino;
	}
	public Date getFechadocumento() {
		return fechadocumento;
	}
	public void setFechadocumento(Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}
	public String getVoucherdocumento() {
		return voucherdocumento;
	}
	public void setVoucherdocumento(String voucherdocumento) {
		this.voucherdocumento = voucherdocumento;
	}
	public String getSuspensionflag() {
		return suspensionflag;
	}
	public void setSuspensionflag(String suspensionflag) {
		this.suspensionflag = suspensionflag;
	}
	public String getPagodiferidoflag() {
		return pagodiferidoflag;
	}
	public void setPagodiferidoflag(String pagodiferidoflag) {
		this.pagodiferidoflag = pagodiferidoflag;
	}
	public String getCuentabancariadestino() {
		return cuentabancariadestino;
	}
	public void setCuentabancariadestino(String cuentabancariadestino) {
		this.cuentabancariadestino = cuentabancariadestino;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}
	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}
	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	
	
}
