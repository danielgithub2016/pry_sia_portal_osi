package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Ordenpago
*/
public class Ordenpago extends DominioGenerico implements java.io.Serializable{

	private OrdenpagoPk pk;
	private String pagara;
	private String companiacodigo;
	private String cuentabancaria;
	private String chequeindividual;
	private java.util.Date fechavencimiento;
	private String monedadocumento;
	private String monedapago;
	private Integer montomoneda;
	private java.math.BigDecimal tipodecambio;
	private java.math.BigDecimal letraproveedor;
	private java.math.BigDecimal letrasecuencia;
	private java.math.BigDecimal batchnumber;
	private java.util.Date fechatransferencia;
	private String cuentacontable;
	private String flujodecaja;
	private String centrocostodestino;
	private java.math.BigDecimal registronumero;
	private String voucher;
	private java.util.Date fechadocumento;
	private String estado;
	private String voucherdocumento;
	private String suspensionflag;
	private String pagodiferidoflag;
	private String unidadnegocio;
	private String proveedorinterfase;
	private String interfaseflag;
	private String unidadreplicacion;
	private String prioridad;
	private String conceptogasto;
	private String observacion;
	private String cuentabancariadestino;
	private String tipopago;

	public Ordenpago() {
		pk = new OrdenpagoPk();
	}

	public OrdenpagoPk getPk() {
		return pk;
	}

	public void setPk(OrdenpagoPk pk) {
		this.pk = pk;
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
	public String getChequeindividual() {
		return chequeindividual;
	}

	public void setChequeindividual(String chequeindividual) {
		this.chequeindividual = chequeindividual;
	}
	public java.util.Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(java.util.Date fechavencimiento) {
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
	public Integer getMontomoneda() {
		return montomoneda;
	}

	public void setMontomoneda(Integer montomoneda) {
		this.montomoneda = montomoneda;
	}
	public java.math.BigDecimal getTipodecambio() {
		return tipodecambio;
	}

	public void setTipodecambio(java.math.BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
	}
	public java.math.BigDecimal getLetraproveedor() {
		return letraproveedor;
	}

	public void setLetraproveedor(java.math.BigDecimal letraproveedor) {
		this.letraproveedor = letraproveedor;
	}
	public java.math.BigDecimal getLetrasecuencia() {
		return letrasecuencia;
	}

	public void setLetrasecuencia(java.math.BigDecimal letrasecuencia) {
		this.letrasecuencia = letrasecuencia;
	}
	public java.math.BigDecimal getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(java.math.BigDecimal batchnumber) {
		this.batchnumber = batchnumber;
	}
	public java.util.Date getFechatransferencia() {
		return fechatransferencia;
	}

	public void setFechatransferencia(java.util.Date fechatransferencia) {
		this.fechatransferencia = fechatransferencia;
	}
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public String getFlujodecaja() {
		return flujodecaja;
	}

	public void setFlujodecaja(String flujodecaja) {
		this.flujodecaja = flujodecaja;
	}
	public String getCentrocostodestino() {
		return centrocostodestino;
	}

	public void setCentrocostodestino(String centrocostodestino) {
		this.centrocostodestino = centrocostodestino;
	}
	public java.math.BigDecimal getRegistronumero() {
		return registronumero;
	}

	public void setRegistronumero(java.math.BigDecimal registronumero) {
		this.registronumero = registronumero;
	}
	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public java.util.Date getFechadocumento() {
		return fechadocumento;
	}

	public void setFechadocumento(java.util.Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getProveedorinterfase() {
		return proveedorinterfase;
	}

	public void setProveedorinterfase(String proveedorinterfase) {
		this.proveedorinterfase = proveedorinterfase;
	}
	public String getInterfaseflag() {
		return interfaseflag;
	}

	public void setInterfaseflag(String interfaseflag) {
		this.interfaseflag = interfaseflag;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public String getConceptogasto() {
		return conceptogasto;
	}

	public void setConceptogasto(String conceptogasto) {
		this.conceptogasto = conceptogasto;
	}
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getCuentabancariadestino() {
		return cuentabancariadestino;
	}

	public void setCuentabancariadestino(String cuentabancariadestino) {
		this.cuentabancariadestino = cuentabancariadestino;
	}
	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
}
