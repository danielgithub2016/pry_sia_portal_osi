package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_cp_obligacion_retrieve
 */
public class DtoDwCpObligacionRetrieve implements java.io.Serializable {
	private BigDecimal proveedor;
	private String tipodocumento;
	private String numerodocumento;
	private String cuentabancaria;
	private String companiacodigo;
	private String responsablecodigo;
	private String tipopago;
	private Date fecharegistro;
	private Date fechavencimiento;
	private Date fechavencimientooriginal;
	private Date fechapago;
	private String generarpago;
	private String tiposervicio;
	private String monedadocumento;
	private String conversionrequerida;
	private String monedapago;
	private String referenciatipodocumento;
	private BigDecimal montoobligacion;
	private BigDecimal montoimpuestoventas;
	private BigDecimal montonoafecto;
	private BigDecimal montoimponible;
	private BigDecimal montoadelantos;
	private BigDecimal montoimpuestos;
	private BigDecimal netomonedalocal;
	private BigDecimal netomonedaextranjera;
	private BigDecimal tipodecambio;
	private BigDecimal aprobadopor;
	private BigDecimal aprobadocp1;
	private BigDecimal aprobadocp2;
	private BigDecimal ingresadopor;
	private BigDecimal revisadopor;
	private BigDecimal retenidopor;
	private String estadodocumento;
	private String contabilizacionpendiente;
	private String chequeindividual;
	private String voucher;
	private Date fechavoucher;
	private BigDecimal numeropago;
	private BigDecimal numeroproceso;
	private BigDecimal procesosecuencia;
	private BigDecimal registronumero;
	private String comentarios;
	private String ultimousuario;
	private Date ultimafechamodif;
	private String unidadnegocio;
	private String referenciacodigointerno;
	private String facturaafectasplitflag;
	private String factorrvalidacion;
	private String comentariosadicional;
	private String razonrechazo;
	private String unidadreplicacion;
	private BigDecimal canjeregistronumero;
	private String referencianumerodocumento;
	private String obligacionrelacionadatipo;
	private String obligacionrelacionadanumero;
	private BigDecimal montopagoparcial;
	private String numerodocumentointerno;
	private String centrocosto;
	private String partidapresupuestal;
	private String flujodecaja;
	private String centrocostocp;
	private Date fecharecepcion;
	private BigDecimal proveedorpagara;
	private String controlpresupuestalflag;
	private Date fechaaprobacion;
	private String cargoflag;
	private BigDecimal montocreditofiscal;
	private Date fechadocumento;
	private String pagaranombre;
	private BigDecimal tipodecambioprovision;
	private String afectoigvflag;
	private String diferidoflag;
	private String voucheranulacion;
	private String adelantoflag;
	private String transferenciaexcluidaflag;
	private String pagocajachicaflag;
	private String pagodiferidoflag;
	private BigDecimal montoretenidodolares;
	private BigDecimal montoretenidolocal;
	private String detraccioncodigoflag;
	private String detraccioncodigo;
	private String defaultcamporeferencia;
	private BigDecimal detraccionmontoreferencial;
	private String siaf_expediente;
	private String tiporetencion;
	private String certificacionnumero;
	private String compromisonumero;
	private String ano;
	private String siaf_secuencia;
	private String siaf_correlativo;
	private Date siaf_fechapago;
	private String mef_estado;
	private String csiaf_expediente;
	private String csiaf_secuencia;
	private String csiaf_correlativo;
	private Date csiaf_fechapago;
	private String cmef_estado;
	private String cuentaprovision;
	private BigDecimal secuenciacp;
	private String cuentacontablelocal;
	private String cuentacontabledolares;
	private String adelantocuentalocal;
	private String adelantocuentadolares;
	private String normalflag;
	private String cuentacontableservlocal;
	private String cuentacontableservdolares;
	private String vouchertipo;
	private String vouchertipomateriales;
	private String codigofiscal;
	private String esadelanto;
	private String generarprovisionflag;
	private String regimenfiscal;
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
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public Date getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(Date fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public Date getFechavencimientooriginal() {
		return fechavencimientooriginal;
	}
	public void setFechavencimientooriginal(Date fechavencimientooriginal) {
		this.fechavencimientooriginal = fechavencimientooriginal;
	}
	public Date getFechapago() {
		return fechapago;
	}
	public void setFechapago(Date fechapago) {
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
	public BigDecimal getTipodecambio() {
		return tipodecambio;
	}
	public void setTipodecambio(BigDecimal tipodecambio) {
		this.tipodecambio = tipodecambio;
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
	public Date getFechavoucher() {
		return fechavoucher;
	}
	public void setFechavoucher(Date fechavoucher) {
		this.fechavoucher = fechavoucher;
	}
	public BigDecimal getNumeropago() {
		return numeropago;
	}
	public void setNumeropago(BigDecimal numeropago) {
		this.numeropago = numeropago;
	}
	public BigDecimal getNumeroproceso() {
		return numeroproceso;
	}
	public void setNumeroproceso(BigDecimal numeroproceso) {
		this.numeroproceso = numeroproceso;
	}
	public BigDecimal getProcesosecuencia() {
		return procesosecuencia;
	}
	public void setProcesosecuencia(BigDecimal procesosecuencia) {
		this.procesosecuencia = procesosecuencia;
	}
	public BigDecimal getRegistronumero() {
		return registronumero;
	}
	public void setRegistronumero(BigDecimal registronumero) {
		this.registronumero = registronumero;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getUltimousuario() {
		return ultimousuario;
	}
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}
	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getReferenciacodigointerno() {
		return referenciacodigointerno;
	}
	public void setReferenciacodigointerno(String referenciacodigointerno) {
		this.referenciacodigointerno = referenciacodigointerno;
	}
	public String getFacturaafectasplitflag() {
		return facturaafectasplitflag;
	}
	public void setFacturaafectasplitflag(String facturaafectasplitflag) {
		this.facturaafectasplitflag = facturaafectasplitflag;
	}
	public String getFactorrvalidacion() {
		return factorrvalidacion;
	}
	public void setFactorrvalidacion(String factorrvalidacion) {
		this.factorrvalidacion = factorrvalidacion;
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
	public BigDecimal getCanjeregistronumero() {
		return canjeregistronumero;
	}
	public void setCanjeregistronumero(BigDecimal canjeregistronumero) {
		this.canjeregistronumero = canjeregistronumero;
	}
	public String getReferencianumerodocumento() {
		return referencianumerodocumento;
	}
	public void setReferencianumerodocumento(String referencianumerodocumento) {
		this.referencianumerodocumento = referencianumerodocumento;
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
	public BigDecimal getMontopagoparcial() {
		return montopagoparcial;
	}
	public void setMontopagoparcial(BigDecimal montopagoparcial) {
		this.montopagoparcial = montopagoparcial;
	}
	public String getNumerodocumentointerno() {
		return numerodocumentointerno;
	}
	public void setNumerodocumentointerno(String numerodocumentointerno) {
		this.numerodocumentointerno = numerodocumentointerno;
	}
	public String getCentrocosto() {
		return centrocosto;
	}
	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
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
	public String getCentrocostocp() {
		return centrocostocp;
	}
	public void setCentrocostocp(String centrocostocp) {
		this.centrocostocp = centrocostocp;
	}
	public Date getFecharecepcion() {
		return fecharecepcion;
	}
	public void setFecharecepcion(Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}
	public BigDecimal getProveedorpagara() {
		return proveedorpagara;
	}
	public void setProveedorpagara(BigDecimal proveedorpagara) {
		this.proveedorpagara = proveedorpagara;
	}
	public String getControlpresupuestalflag() {
		return controlpresupuestalflag;
	}
	public void setControlpresupuestalflag(String controlpresupuestalflag) {
		this.controlpresupuestalflag = controlpresupuestalflag;
	}
	public Date getFechaaprobacion() {
		return fechaaprobacion;
	}
	public void setFechaaprobacion(Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public String getCargoflag() {
		return cargoflag;
	}
	public void setCargoflag(String cargoflag) {
		this.cargoflag = cargoflag;
	}
	public BigDecimal getMontocreditofiscal() {
		return montocreditofiscal;
	}
	public void setMontocreditofiscal(BigDecimal montocreditofiscal) {
		this.montocreditofiscal = montocreditofiscal;
	}
	public Date getFechadocumento() {
		return fechadocumento;
	}
	public void setFechadocumento(Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}
	public String getPagaranombre() {
		return pagaranombre;
	}
	public void setPagaranombre(String pagaranombre) {
		this.pagaranombre = pagaranombre;
	}
	public BigDecimal getTipodecambioprovision() {
		return tipodecambioprovision;
	}
	public void setTipodecambioprovision(BigDecimal tipodecambioprovision) {
		this.tipodecambioprovision = tipodecambioprovision;
	}
	public String getAfectoigvflag() {
		return afectoigvflag;
	}
	public void setAfectoigvflag(String afectoigvflag) {
		this.afectoigvflag = afectoigvflag;
	}
	public String getDiferidoflag() {
		return diferidoflag;
	}
	public void setDiferidoflag(String diferidoflag) {
		this.diferidoflag = diferidoflag;
	}
	public String getVoucheranulacion() {
		return voucheranulacion;
	}
	public void setVoucheranulacion(String voucheranulacion) {
		this.voucheranulacion = voucheranulacion;
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
	public BigDecimal getMontoretenidodolares() {
		return montoretenidodolares;
	}
	public void setMontoretenidodolares(BigDecimal montoretenidodolares) {
		this.montoretenidodolares = montoretenidodolares;
	}
	public BigDecimal getMontoretenidolocal() {
		return montoretenidolocal;
	}
	public void setMontoretenidolocal(BigDecimal montoretenidolocal) {
		this.montoretenidolocal = montoretenidolocal;
	}
	public String getDetraccioncodigoflag() {
		return detraccioncodigoflag;
	}
	public void setDetraccioncodigoflag(String detraccioncodigoflag) {
		this.detraccioncodigoflag = detraccioncodigoflag;
	}
	public String getDetraccioncodigo() {
		return detraccioncodigo;
	}
	public void setDetraccioncodigo(String detraccioncodigo) {
		this.detraccioncodigo = detraccioncodigo;
	}
	public String getDefaultcamporeferencia() {
		return defaultcamporeferencia;
	}
	public void setDefaultcamporeferencia(String defaultcamporeferencia) {
		this.defaultcamporeferencia = defaultcamporeferencia;
	}
	public BigDecimal getDetraccionmontoreferencial() {
		return detraccionmontoreferencial;
	}
	public void setDetraccionmontoreferencial(BigDecimal detraccionmontoreferencial) {
		this.detraccionmontoreferencial = detraccionmontoreferencial;
	}
	public String getSiaf_expediente() {
		return siaf_expediente;
	}
	public void setSiaf_expediente(String siaf_expediente) {
		this.siaf_expediente = siaf_expediente;
	}
	public String getTiporetencion() {
		return tiporetencion;
	}
	public void setTiporetencion(String tiporetencion) {
		this.tiporetencion = tiporetencion;
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
	public String getSiaf_secuencia() {
		return siaf_secuencia;
	}
	public void setSiaf_secuencia(String siaf_secuencia) {
		this.siaf_secuencia = siaf_secuencia;
	}
	public String getSiaf_correlativo() {
		return siaf_correlativo;
	}
	public void setSiaf_correlativo(String siaf_correlativo) {
		this.siaf_correlativo = siaf_correlativo;
	}
	public Date getSiaf_fechapago() {
		return siaf_fechapago;
	}
	public void setSiaf_fechapago(Date siaf_fechapago) {
		this.siaf_fechapago = siaf_fechapago;
	}
	public String getMef_estado() {
		return mef_estado;
	}
	public void setMef_estado(String mef_estado) {
		this.mef_estado = mef_estado;
	}
	public String getCsiaf_expediente() {
		return csiaf_expediente;
	}
	public void setCsiaf_expediente(String csiaf_expediente) {
		this.csiaf_expediente = csiaf_expediente;
	}
	public String getCsiaf_secuencia() {
		return csiaf_secuencia;
	}
	public void setCsiaf_secuencia(String csiaf_secuencia) {
		this.csiaf_secuencia = csiaf_secuencia;
	}
	public String getCsiaf_correlativo() {
		return csiaf_correlativo;
	}
	public void setCsiaf_correlativo(String csiaf_correlativo) {
		this.csiaf_correlativo = csiaf_correlativo;
	}
	public Date getCsiaf_fechapago() {
		return csiaf_fechapago;
	}
	public void setCsiaf_fechapago(Date csiaf_fechapago) {
		this.csiaf_fechapago = csiaf_fechapago;
	}
	public String getCmef_estado() {
		return cmef_estado;
	}
	public void setCmef_estado(String cmef_estado) {
		this.cmef_estado = cmef_estado;
	}
	public String getCuentaprovision() {
		return cuentaprovision;
	}
	public void setCuentaprovision(String cuentaprovision) {
		this.cuentaprovision = cuentaprovision;
	}
	public BigDecimal getSecuenciacp() {
		return secuenciacp;
	}
	public void setSecuenciacp(BigDecimal secuenciacp) {
		this.secuenciacp = secuenciacp;
	}
	public String getCuentacontablelocal() {
		return cuentacontablelocal;
	}
	public void setCuentacontablelocal(String cuentacontablelocal) {
		this.cuentacontablelocal = cuentacontablelocal;
	}
	public String getCuentacontabledolares() {
		return cuentacontabledolares;
	}
	public void setCuentacontabledolares(String cuentacontabledolares) {
		this.cuentacontabledolares = cuentacontabledolares;
	}
	public String getAdelantocuentalocal() {
		return adelantocuentalocal;
	}
	public void setAdelantocuentalocal(String adelantocuentalocal) {
		this.adelantocuentalocal = adelantocuentalocal;
	}
	public String getAdelantocuentadolares() {
		return adelantocuentadolares;
	}
	public void setAdelantocuentadolares(String adelantocuentadolares) {
		this.adelantocuentadolares = adelantocuentadolares;
	}
	public String getNormalflag() {
		return normalflag;
	}
	public void setNormalflag(String normalflag) {
		this.normalflag = normalflag;
	}
	public String getCuentacontableservlocal() {
		return cuentacontableservlocal;
	}
	public void setCuentacontableservlocal(String cuentacontableservlocal) {
		this.cuentacontableservlocal = cuentacontableservlocal;
	}
	public String getCuentacontableservdolares() {
		return cuentacontableservdolares;
	}
	public void setCuentacontableservdolares(String cuentacontableservdolares) {
		this.cuentacontableservdolares = cuentacontableservdolares;
	}
	public String getVouchertipo() {
		return vouchertipo;
	}
	public void setVouchertipo(String vouchertipo) {
		this.vouchertipo = vouchertipo;
	}
	public String getVouchertipomateriales() {
		return vouchertipomateriales;
	}
	public void setVouchertipomateriales(String vouchertipomateriales) {
		this.vouchertipomateriales = vouchertipomateriales;
	}
	public String getCodigofiscal() {
		return codigofiscal;
	}
	public void setCodigofiscal(String codigofiscal) {
		this.codigofiscal = codigofiscal;
	}
	public String getEsadelanto() {
		return esadelanto;
	}
	public void setEsadelanto(String esadelanto) {
		this.esadelanto = esadelanto;
	}
	public String getGenerarprovisionflag() {
		return generarprovisionflag;
	}
	public void setGenerarprovisionflag(String generarprovisionflag) {
		this.generarprovisionflag = generarprovisionflag;
	}
	public String getRegimenfiscal() {
		return regimenfiscal;
	}
	public void setRegimenfiscal(String regimenfiscal) {
		this.regimenfiscal = regimenfiscal;
	}
	
	

}
