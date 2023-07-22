package net.royal.erp.planilla.dominio;

import java.util.Date;

import net.royal.framework.web.dominio.DominioGenerico;


public class PrCts extends DominioGenerico implements java.io.Serializable{

	private PrCtsPk pk;
	private String regimen;
	private String tipocancelacion;
	private String tipoplanilla;
	private Date fechapago;
	private Date fechainicio;
	private Date fechafin;
	private double remuneracion;
	private double iml;
	private double indemnizacionanual;
	private String tiempocancelar;
	private double tiempovalorizado;
	private Integer inasistencias;
	private String manejolocalcts;
	private String banco;
	private String tipocuentacts;
	private String monedacuentacts;
	private String numerocuentacts;
	private String estadocts;
	private float tipocambio;
	private double montolocal;
	private double montodolar;
	private String monedacts;
	private String flagtienedetalle;
	private String companiasocio;
	private double retencionjudicial;
	private double montointeres;
	private Date fechacalculo;
	private double interes;
	private double tasaefectivaanual;
	private String ultimousuario;
	private Date ultimafechamodif;
	private Integer diastranscurridos;
	private String flgcargainicial;
	private String referenciafiscal01;
	private String referenciafiscal02;
	private String referenciafiscal03;
	private String nivelservicio;
	private String centrocostos;
	private String locaciondepago;
	private String tipotrabajador;
	private String sucursal;
	private String tipocontrato;
	private Integer perfil;
	private String afe;
	private String tipopago;
	
	public PrCts() {
		pk = new PrCtsPk();
	}

	public PrCtsPk getPk() {
		return pk;
	}

	public void setPk(PrCtsPk pk) {
		this.pk = pk;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getTipocancelacion() {
		return tipocancelacion;
	}

	public void setTipocancelacion(String tipocancelacion) {
		this.tipocancelacion = tipocancelacion;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(Date fechapago) {
		this.fechapago = fechapago;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public double getRemuneracion() {
		return remuneracion;
	}

	public void setRemuneracion(double remuneracion) {
		this.remuneracion = remuneracion;
	}

	public double getIml() {
		return iml;
	}

	public void setIml(double iml) {
		this.iml = iml;
	}

	public double getIndemnizacionanual() {
		return indemnizacionanual;
	}

	public void setIndemnizacionanual(double indemnizacionanual) {
		this.indemnizacionanual = indemnizacionanual;
	}

	public String getTiempocancelar() {
		return tiempocancelar;
	}

	public void setTiempocancelar(String tiempocancelar) {
		this.tiempocancelar = tiempocancelar;
	}

	public double getTiempovalorizado() {
		return tiempovalorizado;
	}

	public void setTiempovalorizado(double tiempovalorizado) {
		this.tiempovalorizado = tiempovalorizado;
	}

	public Integer getInasistencias() {
		return inasistencias;
	}

	public void setInasistencias(Integer inasistencias) {
		this.inasistencias = inasistencias;
	}

	public String getManejolocalcts() {
		return manejolocalcts;
	}

	public void setManejolocalcts(String manejolocalcts) {
		this.manejolocalcts = manejolocalcts;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getTipocuentacts() {
		return tipocuentacts;
	}

	public void setTipocuentacts(String tipocuentacts) {
		this.tipocuentacts = tipocuentacts;
	}

	public String getMonedacuentacts() {
		return monedacuentacts;
	}

	public void setMonedacuentacts(String monedacuentacts) {
		this.monedacuentacts = monedacuentacts;
	}

	public String getNumerocuentacts() {
		return numerocuentacts;
	}

	public void setNumerocuentacts(String numerocuentacts) {
		this.numerocuentacts = numerocuentacts;
	}

	public String getEstadocts() {
		return estadocts;
	}

	public void setEstadocts(String estadocts) {
		this.estadocts = estadocts;
	}

	public float getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(float tipocambio) {
		this.tipocambio = tipocambio;
	}

	public double getMontolocal() {
		return montolocal;
	}

	public void setMontolocal(double montolocal) {
		this.montolocal = montolocal;
	}

	public double getMontodolar() {
		return montodolar;
	}

	public void setMontodolar(double montodolar) {
		this.montodolar = montodolar;
	}

	public String getMonedacts() {
		return monedacts;
	}

	public void setMonedacts(String monedacts) {
		this.monedacts = monedacts;
	}

	public String getFlagtienedetalle() {
		return flagtienedetalle;
	}

	public void setFlagtienedetalle(String flagtienedetalle) {
		this.flagtienedetalle = flagtienedetalle;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public double getRetencionjudicial() {
		return retencionjudicial;
	}

	public void setRetencionjudicial(double retencionjudicial) {
		this.retencionjudicial = retencionjudicial;
	}

	public double getMontointeres() {
		return montointeres;
	}

	public void setMontointeres(double montointeres) {
		this.montointeres = montointeres;
	}

	public Date getFechacalculo() {
		return fechacalculo;
	}

	public void setFechacalculo(Date fechacalculo) {
		this.fechacalculo = fechacalculo;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getTasaefectivaanual() {
		return tasaefectivaanual;
	}

	public void setTasaefectivaanual(double tasaefectivaanual) {
		this.tasaefectivaanual = tasaefectivaanual;
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
	
	public Integer getDiastranscurridos() {
		return diastranscurridos;
	}

	public void setDiastranscurridos(Integer diastranscurridos) {
		this.diastranscurridos = diastranscurridos;
	}

	public String getFlgcargainicial() {
		return flgcargainicial;
	}

	public void setFlgcargainicial(String flgcargainicial) {
		this.flgcargainicial = flgcargainicial;
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

	public String getNivelservicio() {
		return nivelservicio;
	}

	public void setNivelservicio(String nivelservicio) {
		this.nivelservicio = nivelservicio;
	}

	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

	public String getLocaciondepago() {
		return locaciondepago;
	}

	public void setLocaciondepago(String locaciondepago) {
		this.locaciondepago = locaciondepago;
	}

	public String getTipotrabajador() {
		return tipotrabajador;
	}

	public void setTipotrabajador(String tipotrabajador) {
		this.tipotrabajador = tipotrabajador;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getTipocontrato() {
		return tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public String getAfe() {
		return afe;
	}

	public void setAfe(String afe) {
		this.afe = afe;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	
}
