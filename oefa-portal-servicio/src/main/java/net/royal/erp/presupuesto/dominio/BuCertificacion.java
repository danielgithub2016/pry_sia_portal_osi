package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuCertificacion
*/
public class BuCertificacion extends DominioGenerico implements java.io.Serializable{

	private BuCertificacionPk pk;
	private String tipodocumento;
	private java.util.Date fechadocumento;
	private java.util.Date fechapreparacion;
	private Integer preparadopor;
	private java.util.Date fechaaprobacion;
	private Integer aprobadopor;
	private String centrocosto;
	private Integer tipocambio;
	private String moneda;
	private Integer montooriginal;
	private Integer montototal;
	private String estado;
	private String periodo;
	private String referenciatipodocumento;
	private String referencianumerodocumento;
	private String observacion;
	private Integer proveedor;
	private String referenciafiscal03;
	private String tipoajuste;
	private String tipoproceso;
	private String tipocertificacion;
	private String unidadnegocio;
	private String tipooperacion;
	private String documentorelacionado;
	private String tiporegistroflag;
	private String etapa;
	private String estado2;
	private String observacionrechazo;
	private String numerocontrato;
	private String voucher;
	private String siafCertificacion;
	private String siafSecuencia;
	private String siafCorrelativo;
	private String intSecuencial;
	private String intEstadoproceso;
	private String intEstadoenvio;
	private String mefEstado;


	public BuCertificacion() {
		pk = new BuCertificacionPk();
	}

	public BuCertificacionPk getPk() {
		return pk;
	}

	public void setPk(BuCertificacionPk pk) {
		this.pk = pk;
	}
	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public java.util.Date getFechadocumento() {
		return fechadocumento;
	}

	public void setFechadocumento(java.util.Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}
	public java.util.Date getFechapreparacion() {
		return fechapreparacion;
	}

	public void setFechapreparacion(java.util.Date fechapreparacion) {
		this.fechapreparacion = fechapreparacion;
	}
	public Integer getPreparadopor() {
		return preparadopor;
	}

	public void setPreparadopor(Integer preparadopor) {
		this.preparadopor = preparadopor;
	}
	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public Integer getAprobadopor() {
		return aprobadopor;
	}

	public void setAprobadopor(Integer aprobadopor) {
		this.aprobadopor = aprobadopor;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public Integer getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(Integer tipocambio) {
		this.tipocambio = tipocambio;
	}
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Integer getMontooriginal() {
		return montooriginal;
	}

	public void setMontooriginal(Integer montooriginal) {
		this.montooriginal = montooriginal;
	}
	public Integer getMontototal() {
		return montototal;
	}

	public void setMontototal(Integer montototal) {
		this.montototal = montototal;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getReferenciatipodocumento() {
		return referenciatipodocumento;
	}

	public void setReferenciatipodocumento(String referenciatipodocumento) {
		this.referenciatipodocumento = referenciatipodocumento;
	}
	public String getReferencianumerodocumento() {
		return referencianumerodocumento;
	}

	public void setReferencianumerodocumento(String referencianumerodocumento) {
		this.referencianumerodocumento = referencianumerodocumento;
	}
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public String getReferenciafiscal03() {
		return referenciafiscal03;
	}

	public void setReferenciafiscal03(String referenciafiscal03) {
		this.referenciafiscal03 = referenciafiscal03;
	}
	public String getTipoajuste() {
		return tipoajuste;
	}

	public void setTipoajuste(String tipoajuste) {
		this.tipoajuste = tipoajuste;
	}
	public String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}
	public String getTipocertificacion() {
		return tipocertificacion;
	}

	public void setTipocertificacion(String tipocertificacion) {
		this.tipocertificacion = tipocertificacion;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}
	public String getDocumentorelacionado() {
		return documentorelacionado;
	}

	public void setDocumentorelacionado(String documentorelacionado) {
		this.documentorelacionado = documentorelacionado;
	}
	public String getTiporegistroflag() {
		return tiporegistroflag;
	}

	public void setTiporegistroflag(String tiporegistroflag) {
		this.tiporegistroflag = tiporegistroflag;
	}
	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getEstado2() {
		return estado2;
	}

	public void setEstado2(String estado2) {
		this.estado2 = estado2;
	}
	public String getObservacionrechazo() {
		return observacionrechazo;
	}

	public void setObservacionrechazo(String observacionrechazo) {
		this.observacionrechazo = observacionrechazo;
	}
	public String getNumerocontrato() {
		return numerocontrato;
	}

	public void setNumerocontrato(String numerocontrato) {
		this.numerocontrato = numerocontrato;
	}
	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public String getSiafCertificacion() {
		return siafCertificacion;
	}

	public void setSiafCertificacion(String siafCertificacion) {
		this.siafCertificacion = siafCertificacion;
	}
	public String getSiafSecuencia() {
		return siafSecuencia;
	}

	public void setSiafSecuencia(String siafSecuencia) {
		this.siafSecuencia = siafSecuencia;
	}
	public String getSiafCorrelativo() {
		return siafCorrelativo;
	}

	public void setSiafCorrelativo(String siafCorrelativo) {
		this.siafCorrelativo = siafCorrelativo;
	}
	public String getIntSecuencial() {
		return intSecuencial;
	}

	public void setIntSecuencial(String intSecuencial) {
		this.intSecuencial = intSecuencial;
	}
	public String getIntEstadoproceso() {
		return intEstadoproceso;
	}

	public void setIntEstadoproceso(String intEstadoproceso) {
		this.intEstadoproceso = intEstadoproceso;
	}
	public String getIntEstadoenvio() {
		return intEstadoenvio;
	}

	public void setIntEstadoenvio(String intEstadoenvio) {
		this.intEstadoenvio = intEstadoenvio;
	}
	public String getMefEstado() {
		return mefEstado;
	}

	public void setMefEstado(String mefEstado) {
		this.mefEstado = mefEstado;
	}

}
