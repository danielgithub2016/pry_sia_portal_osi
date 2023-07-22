package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuControlpresupuestal
*/
public class BuControlpresupuestal extends DominioGenerico implements java.io.Serializable{

	private BuControlpresupuestalPk pk;
	private java.util.Date fechadocumento;
	private java.util.Date fechaasignacion;
	private String centrocosto;
	private String centrocostoanterior;
	private String numerodocumentointerno;
	private String monedadocumento;
	private BigDecimal montototal;
	private BigDecimal montopendiente;
	private BigDecimal montototaldolares;
	private BigDecimal tipodecambio;
	private String comentario;
	private String razonrechazo;
	private String unidadnegocio;
	private String responsablecodigo;
	private String periodo;
	private String voucherno;
	private String estado;
	private Integer proveedorcotizacion;
	private Integer aprobadopor;
	private java.util.Date fechaaprobacion;
	private String responsablecodigoanterior;
	private Integer revisadopor;
	private java.util.Date fecharevision;
	private String comprometidodiferidoflag;
	private Integer cantidad;
	private String item;
	private String commodity;
	private String siafExpediente;
	private String fase;
	private String tipoajuste;
	private String siafSecuencia;
	private String siafCorrelativo;
	private String voucherpresupuestal;
	private Integer secuenciaanterior;
	private String ciclo;
	private Integer nivelservicio;
	private String certificacionnumero;
	private String certificacionsecuencia;
	private String ano;


	public BuControlpresupuestal() {
		pk = new BuControlpresupuestalPk();
	}

	public BuControlpresupuestalPk getPk() {
		return pk;
	}

	public void setPk(BuControlpresupuestalPk pk) {
		this.pk = pk;
	}
	public java.util.Date getFechadocumento() {
		return fechadocumento;
	}

	public void setFechadocumento(java.util.Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}
	public java.util.Date getFechaasignacion() {
		return fechaasignacion;
	}

	public void setFechaasignacion(java.util.Date fechaasignacion) {
		this.fechaasignacion = fechaasignacion;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getCentrocostoanterior() {
		return centrocostoanterior;
	}

	public void setCentrocostoanterior(String centrocostoanterior) {
		this.centrocostoanterior = centrocostoanterior;
	}
	public String getNumerodocumentointerno() {
		return numerodocumentointerno;
	}

	public void setNumerodocumentointerno(String numerodocumentointerno) {
		this.numerodocumentointerno = numerodocumentointerno;
	}
	public String getMonedadocumento() {
		return monedadocumento;
	}

	public void setMonedadocumento(String monedadocumento) {
		this.monedadocumento = monedadocumento;
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getRazonrechazo() {
		return razonrechazo;
	}

	public void setRazonrechazo(String razonrechazo) {
		this.razonrechazo = razonrechazo;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getResponsablecodigo() {
		return responsablecodigo;
	}

	public void setResponsablecodigo(String responsablecodigo) {
		this.responsablecodigo = responsablecodigo;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno) {
		this.voucherno = voucherno;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getProveedorcotizacion() {
		return proveedorcotizacion;
	}

	public void setProveedorcotizacion(Integer proveedorcotizacion) {
		this.proveedorcotizacion = proveedorcotizacion;
	}
	public Integer getAprobadopor() {
		return aprobadopor;
	}

	public void setAprobadopor(Integer aprobadopor) {
		this.aprobadopor = aprobadopor;
	}
	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public String getResponsablecodigoanterior() {
		return responsablecodigoanterior;
	}

	public void setResponsablecodigoanterior(String responsablecodigoanterior) {
		this.responsablecodigoanterior = responsablecodigoanterior;
	}
	public Integer getRevisadopor() {
		return revisadopor;
	}

	public void setRevisadopor(Integer revisadopor) {
		this.revisadopor = revisadopor;
	}
	public java.util.Date getFecharevision() {
		return fecharevision;
	}

	public void setFecharevision(java.util.Date fecharevision) {
		this.fecharevision = fecharevision;
	}
	public String getComprometidodiferidoflag() {
		return comprometidodiferidoflag;
	}

	public void setComprometidodiferidoflag(String comprometidodiferidoflag) {
		this.comprometidodiferidoflag = comprometidodiferidoflag;
	}
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getSiafExpediente() {
		return siafExpediente;
	}

	public void setSiafExpediente(String siafExpediente) {
		this.siafExpediente = siafExpediente;
	}
	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}
	public String getTipoajuste() {
		return tipoajuste;
	}

	public void setTipoajuste(String tipoajuste) {
		this.tipoajuste = tipoajuste;
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
	public String getVoucherpresupuestal() {
		return voucherpresupuestal;
	}

	public void setVoucherpresupuestal(String voucherpresupuestal) {
		this.voucherpresupuestal = voucherpresupuestal;
	}
	public Integer getSecuenciaanterior() {
		return secuenciaanterior;
	}

	public void setSecuenciaanterior(Integer secuenciaanterior) {
		this.secuenciaanterior = secuenciaanterior;
	}
	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public Integer getNivelservicio() {
		return nivelservicio;
	}

	public void setNivelservicio(Integer nivelservicio) {
		this.nivelservicio = nivelservicio;
	}
	public String getCertificacionnumero() {
		return certificacionnumero;
	}

	public void setCertificacionnumero(String certificacionnumero) {
		this.certificacionnumero = certificacionnumero;
	}
	public String getCertificacionsecuencia() {
		return certificacionsecuencia;
	}

	public void setCertificacionsecuencia(String certificacionsecuencia) {
		this.certificacionsecuencia = certificacionsecuencia;
	}
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal getMontototal() {
		return montototal;
	}

	public void setMontototal(BigDecimal montototal) {
		this.montototal = montototal;
	}

	public BigDecimal getMontopendiente() {
		return montopendiente;
	}

	public void setMontopendiente(BigDecimal montopendiente) {
		this.montopendiente = montopendiente;
	}

	public BigDecimal getMontototaldolares() {
		return montototaldolares;
	}

	public void setMontototaldolares(BigDecimal montototaldolares) {
		this.montototaldolares = montototaldolares;
	}

	public BigDecimal getTipodecambio() {
		return tipodecambio;
	}

	public void setTipodecambio(BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
	}

}
