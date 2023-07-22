package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Obligaciones
*/
public class Obligaciones extends DominioGenerico implements java.io.Serializable{

	private ObligacionesPk pk;
	private String cuentabancaria;
	private String companiacodigo;
	private String unidadnegocio;
	private String responsablecodigo;
	private String tipopago;
	private java.util.Date fechadocumento;
	private java.util.Date fecharegistro;
	private java.util.Date fechavencimiento;
	private java.util.Date fechavencimientooriginal;
	private java.util.Date fecharecepcion;
	private java.util.Date fechapago;
	private String generarpago;
	private String tiposervicio;
	private String monedadocumento;
	private String conversionrequerida;
	private String monedapago;
	private String referenciatipodocumento;
	private String referencianumerodocumento;
	private String referenciacodigointerno;
	private String obligacionrelacionadatipo;
	private String obligacionrelacionadanumero;
	private BigDecimal montoobligacion;
	private BigDecimal montoimpuestoventas;
	private BigDecimal montonoafecto;
	private BigDecimal montoimponible;
	private BigDecimal montoadelantos;
	private BigDecimal montoimpuestos;
	private BigDecimal netomonedalocal;
	private BigDecimal netomonedaextranjera;
	private BigDecimal montopagoparcial;
	private BigDecimal tipodecambio;
	private BigDecimal aprobadopor;
	private BigDecimal aprobadocp1;
	private BigDecimal aprobadocp2;
	private BigDecimal ingresadopor;
	private BigDecimal revisadopor;
	private BigDecimal retenidopor;
	private String estadodocumento;
	private String contabilizacionpendiente;
	private String facturaafectasplitflag;
	private String chequeindividual;
	private String voucher;
	private String voucheranulacion;
	private java.util.Date fechavoucher;
	private Integer numeropago;
	private Integer numeroproceso;
	private Integer procesosecuencia;
	private Integer registronumero;
	private Integer canjeregistronumero;
	private String factorrvalidacion;
	private String comentarios;
	private String comentariosadicional;
	private String razonrechazo;
	private String unidadreplicacion;
	private BigDecimal proveedorpagara;
	private String partidapresupuestal;
	private String flujodecaja;
	private String centrocosto;
	private String centrocostocp;
	private java.util.Date fechaaprobacion;
	private java.util.Date fecharevision;
	private String controlpresupuestalflag;
	private String numerodocumentointerno;
	private String cargoflag;
	private BigDecimal montocreditofiscal;
	private Integer tipodecambioprovision;
	private String afectoigvflag;
	private String pagaranombre;
	private String diferidoflag;
	private String adelantoflag;
	private String transferenciaexcluidaflag;
	private String pagocajachicaflag;
	private BigDecimal montoretenidolocal;
	private BigDecimal montoretenidodolares;
	private String pagodiferidoflag;
	private String archivoadjunto;
	private String defaultcamporeferencia;
	private String detraccioncodigo;
	private String detraccioncodigoflag;
	private String detracciondocumento;
	private String siafExpediente;
	private java.util.Date detraccionfecha;
	private String observaciones;
	private BigDecimal detraccionmontoreferencial;
	private String intSecuencial;
	private String intEstadoproceso;
	private String intEstadoenvio;
	private String siafSecuencia;
	private String siafCorrelativo;
	private java.util.Date siafFechapago;
	private String mefEstado;
	private BigDecimal tipocambiosiaf;
	private String cintSecuencial;
	private String cintEstadoproceso;
	private String cintEstadoenvio;
	private String csiafExpediente;
	private String csiafSecuencia;
	private String csiafCorrelativo;
	private java.util.Date csiafFechapago;
	private String cmefEstado;
	private Integer secuenciacp;
	private String cuentaprovision;
	private String tiporetencion;
	private Integer nivelservicio;
	private String certificacionnumero;
	private String compromisonumero;
	private String ano;
	private String certificacionestado;
	private String compromisoestado;
	private Tipodocumentocxp tipodocumentocxp;
	
	private List<Obligacionesxcuenta> listaObligacionesxcuenta;

	public Obligaciones() {
		pk = new ObligacionesPk();
	}

	public ObligacionesPk getPk() {
		return pk;
	}

	public void setPk(ObligacionesPk pk) {
		this.pk = pk;
	}
	public String getCuentabancaria() {
		return cuentabancaria;
	}

	public void setCuentabancaria(String cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}
	public String getCompaniacodigo() {
		return companiacodigo;
	}

	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
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
	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public java.util.Date getFechadocumento() {
		return fechadocumento;
	}

	public void setFechadocumento(java.util.Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}
	public java.util.Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(java.util.Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public java.util.Date getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(java.util.Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public java.util.Date getFechavencimientooriginal() {
		return fechavencimientooriginal;
	}

	public void setFechavencimientooriginal(java.util.Date fechavencimientooriginal) {
		this.fechavencimientooriginal = fechavencimientooriginal;
	}
	public java.util.Date getFecharecepcion() {
		return fecharecepcion;
	}

	public void setFecharecepcion(java.util.Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}
	public java.util.Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(java.util.Date fechapago) {
		this.fechapago = fechapago;
	}
	public String getGenerarpago() {
		return generarpago;
	}

	public void setGenerarpago(String generarpago) {
		this.generarpago = generarpago;
	}
	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}
	public String getMonedadocumento() {
		return monedadocumento;
	}

	public void setMonedadocumento(String monedadocumento) {
		this.monedadocumento = monedadocumento;
	}
	public String getConversionrequerida() {
		return conversionrequerida;
	}

	public void setConversionrequerida(String conversionrequerida) {
		this.conversionrequerida = conversionrequerida;
	}
	public String getMonedapago() {
		return monedapago;
	}

	public void setMonedapago(String monedapago) {
		this.monedapago = monedapago;
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
	public String getReferenciacodigointerno() {
		return referenciacodigointerno;
	}

	public void setReferenciacodigointerno(String referenciacodigointerno) {
		this.referenciacodigointerno = referenciacodigointerno;
	}
	public String getObligacionrelacionadatipo() {
		return obligacionrelacionadatipo;
	}

	public void setObligacionrelacionadatipo(String obligacionrelacionadatipo) {
		this.obligacionrelacionadatipo = obligacionrelacionadatipo;
	}
	public String getObligacionrelacionadanumero() {
		return obligacionrelacionadanumero;
	}

	public void setObligacionrelacionadanumero(String obligacionrelacionadanumero) {
		this.obligacionrelacionadanumero = obligacionrelacionadanumero;
	}

	public String getEstadodocumento() {
		return estadodocumento;
	}

	public void setEstadodocumento(String estadodocumento) {
		this.estadodocumento = estadodocumento;
	}
	public String getContabilizacionpendiente() {
		return contabilizacionpendiente;
	}

	public void setContabilizacionpendiente(String contabilizacionpendiente) {
		this.contabilizacionpendiente = contabilizacionpendiente;
	}
	public String getFacturaafectasplitflag() {
		return facturaafectasplitflag;
	}

	public void setFacturaafectasplitflag(String facturaafectasplitflag) {
		this.facturaafectasplitflag = facturaafectasplitflag;
	}
	public String getChequeindividual() {
		return chequeindividual;
	}

	public void setChequeindividual(String chequeindividual) {
		this.chequeindividual = chequeindividual;
	}
	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public String getVoucheranulacion() {
		return voucheranulacion;
	}

	public void setVoucheranulacion(String voucheranulacion) {
		this.voucheranulacion = voucheranulacion;
	}
	public java.util.Date getFechavoucher() {
		return fechavoucher;
	}

	public void setFechavoucher(java.util.Date fechavoucher) {
		this.fechavoucher = fechavoucher;
	}
	public Integer getNumeropago() {
		return numeropago;
	}

	public void setNumeropago(Integer numeropago) {
		this.numeropago = numeropago;
	}
	public Integer getNumeroproceso() {
		return numeroproceso;
	}

	public void setNumeroproceso(Integer numeroproceso) {
		this.numeroproceso = numeroproceso;
	}
	public Integer getProcesosecuencia() {
		return procesosecuencia;
	}

	public void setProcesosecuencia(Integer procesosecuencia) {
		this.procesosecuencia = procesosecuencia;
	}
	public Integer getRegistronumero() {
		return registronumero;
	}

	public void setRegistronumero(Integer registronumero) {
		this.registronumero = registronumero;
	}
	public Integer getCanjeregistronumero() {
		return canjeregistronumero;
	}

	public void setCanjeregistronumero(Integer canjeregistronumero) {
		this.canjeregistronumero = canjeregistronumero;
	}
	public String getFactorrvalidacion() {
		return factorrvalidacion;
	}

	public void setFactorrvalidacion(String factorrvalidacion) {
		this.factorrvalidacion = factorrvalidacion;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getComentariosadicional() {
		return comentariosadicional;
	}

	public void setComentariosadicional(String comentariosadicional) {
		this.comentariosadicional = comentariosadicional;
	}
	public String getRazonrechazo() {
		return razonrechazo;
	}

	public void setRazonrechazo(String razonrechazo) {
		this.razonrechazo = razonrechazo;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	
	public String getPartidapresupuestal() {
		return partidapresupuestal;
	}

	public void setPartidapresupuestal(String partidapresupuestal) {
		this.partidapresupuestal = partidapresupuestal;
	}
	public String getFlujodecaja() {
		return flujodecaja;
	}

	public void setFlujodecaja(String flujodecaja) {
		this.flujodecaja = flujodecaja;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getCentrocostocp() {
		return centrocostocp;
	}

	public void setCentrocostocp(String centrocostocp) {
		this.centrocostocp = centrocostocp;
	}
	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public java.util.Date getFecharevision() {
		return fecharevision;
	}

	public void setFecharevision(java.util.Date fecharevision) {
		this.fecharevision = fecharevision;
	}
	public String getControlpresupuestalflag() {
		return controlpresupuestalflag;
	}

	public void setControlpresupuestalflag(String controlpresupuestalflag) {
		this.controlpresupuestalflag = controlpresupuestalflag;
	}
	public String getNumerodocumentointerno() {
		return numerodocumentointerno;
	}

	public void setNumerodocumentointerno(String numerodocumentointerno) {
		this.numerodocumentointerno = numerodocumentointerno;
	}
	public String getCargoflag() {
		return cargoflag;
	}

	public void setCargoflag(String cargoflag) {
		this.cargoflag = cargoflag;
	}
	
	public Integer getTipodecambioprovision() {
		return tipodecambioprovision;
	}

	public void setTipodecambioprovision(Integer tipodecambioprovision) {
		this.tipodecambioprovision = tipodecambioprovision;
	}
	public String getAfectoigvflag() {
		return afectoigvflag;
	}

	public void setAfectoigvflag(String afectoigvflag) {
		this.afectoigvflag = afectoigvflag;
	}
	public String getPagaranombre() {
		return pagaranombre;
	}

	public void setPagaranombre(String pagaranombre) {
		this.pagaranombre = pagaranombre;
	}
	public String getDiferidoflag() {
		return diferidoflag;
	}

	public void setDiferidoflag(String diferidoflag) {
		this.diferidoflag = diferidoflag;
	}
	public String getAdelantoflag() {
		return adelantoflag;
	}

	public void setAdelantoflag(String adelantoflag) {
		this.adelantoflag = adelantoflag;
	}
	public String getTransferenciaexcluidaflag() {
		return transferenciaexcluidaflag;
	}

	public void setTransferenciaexcluidaflag(String transferenciaexcluidaflag) {
		this.transferenciaexcluidaflag = transferenciaexcluidaflag;
	}
	public String getPagocajachicaflag() {
		return pagocajachicaflag;
	}

	public void setPagocajachicaflag(String pagocajachicaflag) {
		this.pagocajachicaflag = pagocajachicaflag;
	}
	 
	public String getPagodiferidoflag() {
		return pagodiferidoflag;
	}

	public void setPagodiferidoflag(String pagodiferidoflag) {
		this.pagodiferidoflag = pagodiferidoflag;
	}
	public String getArchivoadjunto() {
		return archivoadjunto;
	}

	public void setArchivoadjunto(String archivoadjunto) {
		this.archivoadjunto = archivoadjunto;
	}
	public String getDefaultcamporeferencia() {
		return defaultcamporeferencia;
	}

	public void setDefaultcamporeferencia(String defaultcamporeferencia) {
		this.defaultcamporeferencia = defaultcamporeferencia;
	}
	public String getDetraccioncodigo() {
		return detraccioncodigo;
	}

	public void setDetraccioncodigo(String detraccioncodigo) {
		this.detraccioncodigo = detraccioncodigo;
	}
	public String getDetraccioncodigoflag() {
		return detraccioncodigoflag;
	}

	public void setDetraccioncodigoflag(String detraccioncodigoflag) {
		this.detraccioncodigoflag = detraccioncodigoflag;
	}
	public String getDetracciondocumento() {
		return detracciondocumento;
	}

	public void setDetracciondocumento(String detracciondocumento) {
		this.detracciondocumento = detracciondocumento;
	}
	public String getSiafExpediente() {
		return siafExpediente;
	}

	public void setSiafExpediente(String siafExpediente) {
		this.siafExpediente = siafExpediente;
	}
	public java.util.Date getDetraccionfecha() {
		return detraccionfecha;
	}

	public void setDetraccionfecha(java.util.Date detraccionfecha) {
		this.detraccionfecha = detraccionfecha;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	public java.util.Date getSiafFechapago() {
		return siafFechapago;
	}

	public void setSiafFechapago(java.util.Date siafFechapago) {
		this.siafFechapago = siafFechapago;
	}
	public String getMefEstado() {
		return mefEstado;
	}

	public void setMefEstado(String mefEstado) {
		this.mefEstado = mefEstado;
	}
	
	public String getCintSecuencial() {
		return cintSecuencial;
	}

	public void setCintSecuencial(String cintSecuencial) {
		this.cintSecuencial = cintSecuencial;
	}
	public String getCintEstadoproceso() {
		return cintEstadoproceso;
	}

	public void setCintEstadoproceso(String cintEstadoproceso) {
		this.cintEstadoproceso = cintEstadoproceso;
	}
	public String getCintEstadoenvio() {
		return cintEstadoenvio;
	}

	public void setCintEstadoenvio(String cintEstadoenvio) {
		this.cintEstadoenvio = cintEstadoenvio;
	}
	public String getCsiafExpediente() {
		return csiafExpediente;
	}

	public void setCsiafExpediente(String csiafExpediente) {
		this.csiafExpediente = csiafExpediente;
	}
	public String getCsiafSecuencia() {
		return csiafSecuencia;
	}

	public void setCsiafSecuencia(String csiafSecuencia) {
		this.csiafSecuencia = csiafSecuencia;
	}
	public String getCsiafCorrelativo() {
		return csiafCorrelativo;
	}

	public void setCsiafCorrelativo(String csiafCorrelativo) {
		this.csiafCorrelativo = csiafCorrelativo;
	}
	public java.util.Date getCsiafFechapago() {
		return csiafFechapago;
	}

	public void setCsiafFechapago(java.util.Date csiafFechapago) {
		this.csiafFechapago = csiafFechapago;
	}
	public String getCmefEstado() {
		return cmefEstado;
	}

	public void setCmefEstado(String cmefEstado) {
		this.cmefEstado = cmefEstado;
	}
	public Integer getSecuenciacp() {
		return secuenciacp;
	}

	public void setSecuenciacp(Integer secuenciacp) {
		this.secuenciacp = secuenciacp;
	}
	public String getCuentaprovision() {
		return cuentaprovision;
	}

	public void setCuentaprovision(String cuentaprovision) {
		this.cuentaprovision = cuentaprovision;
	}
	public String getTiporetencion() {
		return tiporetencion;
	}

	public void setTiporetencion(String tiporetencion) {
		this.tiporetencion = tiporetencion;
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
	public String getCompromisonumero() {
		return compromisonumero;
	}

	public void setCompromisonumero(String compromisonumero) {
		this.compromisonumero = compromisonumero;
	}
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCertificacionestado() {
		return certificacionestado;
	}

	public void setCertificacionestado(String certificacionestado) {
		this.certificacionestado = certificacionestado;
	}
	public String getCompromisoestado() {
		return compromisoestado;
	}

	public void setCompromisoestado(String compromisoestado) {
		this.compromisoestado = compromisoestado;
	}

	public Tipodocumentocxp getTipodocumentocxp() {
		return tipodocumentocxp;
	}

	public void setTipodocumentocxp(Tipodocumentocxp tipodocumentocxp) {
		this.tipodocumentocxp = tipodocumentocxp;
	}

	public List<Obligacionesxcuenta> getListaObligacionesxcuenta() {
		return listaObligacionesxcuenta;
	}

	public void setListaObligacionesxcuenta(
			List<Obligacionesxcuenta> listaObligacionesxcuenta) {
		this.listaObligacionesxcuenta = listaObligacionesxcuenta;
	}

	public BigDecimal getMontoobligacion() {
		return montoobligacion;
	}

	public void setMontoobligacion(BigDecimal montoobligacion) {
		this.montoobligacion = montoobligacion;
	}

	public BigDecimal getMontoimpuestoventas() {
		return montoimpuestoventas;
	}

	public void setMontoimpuestoventas(BigDecimal montoimpuestoventas) {
		this.montoimpuestoventas = montoimpuestoventas;
	}

	public BigDecimal getMontonoafecto() {
		return montonoafecto;
	}

	public void setMontonoafecto(BigDecimal montonoafecto) {
		this.montonoafecto = montonoafecto;
	}

	public BigDecimal getMontoimponible() {
		return montoimponible;
	}

	public void setMontoimponible(BigDecimal montoimponible) {
		this.montoimponible = montoimponible;
	}

	public BigDecimal getMontoadelantos() {
		return montoadelantos;
	}

	public void setMontoadelantos(BigDecimal montoadelantos) {
		this.montoadelantos = montoadelantos;
	}

	public BigDecimal getMontoimpuestos() {
		return montoimpuestos;
	}

	public void setMontoimpuestos(BigDecimal montoimpuestos) {
		this.montoimpuestos = montoimpuestos;
	}

	public BigDecimal getNetomonedalocal() {
		return netomonedalocal;
	}

	public void setNetomonedalocal(BigDecimal netomonedalocal) {
		this.netomonedalocal = netomonedalocal;
	}

	public BigDecimal getNetomonedaextranjera() {
		return netomonedaextranjera;
	}

	public void setNetomonedaextranjera(BigDecimal netomonedaextranjera) {
		this.netomonedaextranjera = netomonedaextranjera;
	}

	public BigDecimal getMontopagoparcial() {
		return montopagoparcial;
	}

	public void setMontopagoparcial(BigDecimal montopagoparcial) {
		this.montopagoparcial = montopagoparcial;
	}

	public BigDecimal getTipodecambio() {
		return tipodecambio;
	}

	public void setTipodecambio(BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
	}

	public BigDecimal getMontoretenidolocal() {
		return montoretenidolocal;
	}

	public void setMontoretenidolocal(BigDecimal montoretenidolocal) {
		this.montoretenidolocal = montoretenidolocal;
	}

	public BigDecimal getMontoretenidodolares() {
		return montoretenidodolares;
	}

	public void setMontoretenidodolares(BigDecimal montoretenidodolares) {
		this.montoretenidodolares = montoretenidodolares;
	}

	public BigDecimal getMontocreditofiscal() {
		return montocreditofiscal;
	}

	public void setMontocreditofiscal(BigDecimal montocreditofiscal) {
		this.montocreditofiscal = montocreditofiscal;
	}

	public BigDecimal getProveedorpagara() {
		return proveedorpagara;
	}

	public void setProveedorpagara(BigDecimal proveedorpagara) {
		this.proveedorpagara = proveedorpagara;
	}

	public BigDecimal getIngresadopor() {
		return ingresadopor;
	}

	public void setIngresadopor(BigDecimal ingresadopor) {
		this.ingresadopor = ingresadopor;
	}

	public BigDecimal getRevisadopor() {
		return revisadopor;
	}

	public void setRevisadopor(BigDecimal revisadopor) {
		this.revisadopor = revisadopor;
	}

	public BigDecimal getRetenidopor() {
		return retenidopor;
	}

	public void setRetenidopor(BigDecimal retenidopor) {
		this.retenidopor = retenidopor;
	}

	public BigDecimal getAprobadopor() {
		return aprobadopor;
	}

	public void setAprobadopor(BigDecimal aprobadopor) {
		this.aprobadopor = aprobadopor;
	}

	public BigDecimal getAprobadocp1() {
		return aprobadocp1;
	}

	public void setAprobadocp1(BigDecimal aprobadocp1) {
		this.aprobadocp1 = aprobadocp1;
	}

	public BigDecimal getAprobadocp2() {
		return aprobadocp2;
	}

	public void setAprobadocp2(BigDecimal aprobadocp2) {
		this.aprobadocp2 = aprobadocp2;
	}

	public BigDecimal getDetraccionmontoreferencial() {
		return detraccionmontoreferencial;
	}

	public void setDetraccionmontoreferencial(BigDecimal detraccionmontoreferencial) {
		this.detraccionmontoreferencial = detraccionmontoreferencial;
	}

	public BigDecimal getTipocambiosiaf() {
		return tipocambiosiaf;
	}

	public void setTipocambiosiaf(BigDecimal tipocambiosiaf) {
		this.tipocambiosiaf = tipocambiosiaf;
	}

	
}
