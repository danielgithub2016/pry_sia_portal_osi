package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Cuentabancaria
*/
public class Cuentabancaria extends DominioGenerico implements java.io.Serializable{

	private CuentabancariaPk pk;
	private String descripcion;
	private String companiacodigo;
	private java.util.Date fechaapertura;
	private java.util.Date fechacierrecuenta;
	private String monedacodigo;
	private String tipocuenta;
	private String cuentacontable;
	private Integer sobregiroautorizado;
	private String agenciabanco;
	private String agenciadistrito;
	private String sucursalcodigo;
	private String idioma;
	private String ultimoperiodoconciliacion;
	private String vouchertipo;
	private String voucherclasificacion;
	private String atencionpersona;
	private String atencioncargo;
	private String flujodecajaflag;
	private Integer flujodecajaorden;
	private String codigodiskette;
	private String conciliacionbancariaflag;
	private String estado;
	private String smartcredflag;
	private String numctabanco;
	private Integer montoapertura;
	private String cuentabancariaconsolidada;
	private String cuentabancooriginal;
	private String cuentacontabledescuento;
	private String archivodiskette;
	private String referenciafiscal03;
	private String unidadnegocio;
	private String itfflag;
	private String conciliacionapflag;
	private String conciliacionperiodo;
	private String pagosinterfaseflag;
	private String codigosiaf;
	private String multifondoflag;
	private String transitoflag;
	private String funcioncuentaflag;
	private String cutflag;


	public Cuentabancaria() {
		pk = new CuentabancariaPk();
	}

	public CuentabancariaPk getPk() {
		return pk;
	}

	public void setPk(CuentabancariaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCompaniacodigo() {
		return companiacodigo;
	}

	public void setCompaniacodigo(String companiacodigo) {
		this.companiacodigo = companiacodigo;
	}
	public java.util.Date getFechaapertura() {
		return fechaapertura;
	}

	public void setFechaapertura(java.util.Date fechaapertura) {
		this.fechaapertura = fechaapertura;
	}
	public java.util.Date getFechacierrecuenta() {
		return fechacierrecuenta;
	}

	public void setFechacierrecuenta(java.util.Date fechacierrecuenta) {
		this.fechacierrecuenta = fechacierrecuenta;
	}
	public String getMonedacodigo() {
		return monedacodigo;
	}

	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}
	public String getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public Integer getSobregiroautorizado() {
		return sobregiroautorizado;
	}

	public void setSobregiroautorizado(Integer sobregiroautorizado) {
		this.sobregiroautorizado = sobregiroautorizado;
	}
	public String getAgenciabanco() {
		return agenciabanco;
	}

	public void setAgenciabanco(String agenciabanco) {
		this.agenciabanco = agenciabanco;
	}
	public String getAgenciadistrito() {
		return agenciadistrito;
	}

	public void setAgenciadistrito(String agenciadistrito) {
		this.agenciadistrito = agenciadistrito;
	}
	public String getSucursalcodigo() {
		return sucursalcodigo;
	}

	public void setSucursalcodigo(String sucursalcodigo) {
		this.sucursalcodigo = sucursalcodigo;
	}
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getUltimoperiodoconciliacion() {
		return ultimoperiodoconciliacion;
	}

	public void setUltimoperiodoconciliacion(String ultimoperiodoconciliacion) {
		this.ultimoperiodoconciliacion = ultimoperiodoconciliacion;
	}
	public String getVouchertipo() {
		return vouchertipo;
	}

	public void setVouchertipo(String vouchertipo) {
		this.vouchertipo = vouchertipo;
	}
	public String getVoucherclasificacion() {
		return voucherclasificacion;
	}

	public void setVoucherclasificacion(String voucherclasificacion) {
		this.voucherclasificacion = voucherclasificacion;
	}
	public String getAtencionpersona() {
		return atencionpersona;
	}

	public void setAtencionpersona(String atencionpersona) {
		this.atencionpersona = atencionpersona;
	}
	public String getAtencioncargo() {
		return atencioncargo;
	}

	public void setAtencioncargo(String atencioncargo) {
		this.atencioncargo = atencioncargo;
	}
	public String getFlujodecajaflag() {
		return flujodecajaflag;
	}

	public void setFlujodecajaflag(String flujodecajaflag) {
		this.flujodecajaflag = flujodecajaflag;
	}
	public Integer getFlujodecajaorden() {
		return flujodecajaorden;
	}

	public void setFlujodecajaorden(Integer flujodecajaorden) {
		this.flujodecajaorden = flujodecajaorden;
	}
	public String getCodigodiskette() {
		return codigodiskette;
	}

	public void setCodigodiskette(String codigodiskette) {
		this.codigodiskette = codigodiskette;
	}
	public String getConciliacionbancariaflag() {
		return conciliacionbancariaflag;
	}

	public void setConciliacionbancariaflag(String conciliacionbancariaflag) {
		this.conciliacionbancariaflag = conciliacionbancariaflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSmartcredflag() {
		return smartcredflag;
	}

	public void setSmartcredflag(String smartcredflag) {
		this.smartcredflag = smartcredflag;
	}
	public String getNumctabanco() {
		return numctabanco;
	}

	public void setNumctabanco(String numctabanco) {
		this.numctabanco = numctabanco;
	}
	public Integer getMontoapertura() {
		return montoapertura;
	}

	public void setMontoapertura(Integer montoapertura) {
		this.montoapertura = montoapertura;
	}
	public String getCuentabancariaconsolidada() {
		return cuentabancariaconsolidada;
	}

	public void setCuentabancariaconsolidada(String cuentabancariaconsolidada) {
		this.cuentabancariaconsolidada = cuentabancariaconsolidada;
	}
	public String getCuentabancooriginal() {
		return cuentabancooriginal;
	}

	public void setCuentabancooriginal(String cuentabancooriginal) {
		this.cuentabancooriginal = cuentabancooriginal;
	}
	public String getCuentacontabledescuento() {
		return cuentacontabledescuento;
	}

	public void setCuentacontabledescuento(String cuentacontabledescuento) {
		this.cuentacontabledescuento = cuentacontabledescuento;
	}
	public String getArchivodiskette() {
		return archivodiskette;
	}

	public void setArchivodiskette(String archivodiskette) {
		this.archivodiskette = archivodiskette;
	}
	public String getReferenciafiscal03() {
		return referenciafiscal03;
	}

	public void setReferenciafiscal03(String referenciafiscal03) {
		this.referenciafiscal03 = referenciafiscal03;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getItfflag() {
		return itfflag;
	}

	public void setItfflag(String itfflag) {
		this.itfflag = itfflag;
	}
	public String getConciliacionapflag() {
		return conciliacionapflag;
	}

	public void setConciliacionapflag(String conciliacionapflag) {
		this.conciliacionapflag = conciliacionapflag;
	}
	public String getConciliacionperiodo() {
		return conciliacionperiodo;
	}

	public void setConciliacionperiodo(String conciliacionperiodo) {
		this.conciliacionperiodo = conciliacionperiodo;
	}
	public String getPagosinterfaseflag() {
		return pagosinterfaseflag;
	}

	public void setPagosinterfaseflag(String pagosinterfaseflag) {
		this.pagosinterfaseflag = pagosinterfaseflag;
	}
	public String getCodigosiaf() {
		return codigosiaf;
	}

	public void setCodigosiaf(String codigosiaf) {
		this.codigosiaf = codigosiaf;
	}
	public String getMultifondoflag() {
		return multifondoflag;
	}

	public void setMultifondoflag(String multifondoflag) {
		this.multifondoflag = multifondoflag;
	}
	public String getTransitoflag() {
		return transitoflag;
	}

	public void setTransitoflag(String transitoflag) {
		this.transitoflag = transitoflag;
	}
	public String getFuncioncuentaflag() {
		return funcioncuentaflag;
	}

	public void setFuncioncuentaflag(String funcioncuentaflag) {
		this.funcioncuentaflag = funcioncuentaflag;
	}
	public String getCutflag() {
		return cutflag;
	}

	public void setCutflag(String cutflag) {
		this.cutflag = cutflag;
	}

}
