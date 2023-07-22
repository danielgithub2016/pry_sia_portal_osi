package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Obligacionesxcuenta
*/
public class Obligacionesxcuenta extends DominioGenerico implements java.io.Serializable{

	private ObligacionesxcuentaPk pk;
	private BigDecimal monto;
	private BigDecimal persona;
	private String cuentacontable;
	private String proyecto;
	private String destinocompaniasocio;
	private String destinocuenta;
	private String centrocostodestino;
	private String centrocosto;
	private String descripcion;
	private String flujodecaja;
	private String partidapresupuestal;
	private String documentoreferencia;
	private String activo;
	private String diferidoflag;
	private String sucursal;
	private String camporeferencia;
	private String noafectoigvflag;
	private String splitdistributionflag;
	private String numeroorden;
	private String referenciafiscal01;
	private String referenciafiscal02;
	private String referenciafiscal03;
	private String conceptogasto;
	private String nivelservicio;
	private Obligaciones obligaciones;

	public Obligacionesxcuenta() {
		pk = new ObligacionesxcuentaPk();
	}

	public ObligacionesxcuentaPk getPk() {
		return pk;
	}

	public void setPk(ObligacionesxcuentaPk pk) {
		this.pk = pk;
	}
	
	public String getCuentacontable() {
		return cuentacontable;
	}

	public void setCuentacontable(String cuentacontable) {
		this.cuentacontable = cuentacontable;
	}
	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public String getDestinocompaniasocio() {
		return destinocompaniasocio;
	}

	public void setDestinocompaniasocio(String destinocompaniasocio) {
		this.destinocompaniasocio = destinocompaniasocio;
	}
	public String getDestinocuenta() {
		return destinocuenta;
	}

	public void setDestinocuenta(String destinocuenta) {
		this.destinocuenta = destinocuenta;
	}
	public String getCentrocostodestino() {
		return centrocostodestino;
	}

	public void setCentrocostodestino(String centrocostodestino) {
		this.centrocostodestino = centrocostodestino;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFlujodecaja() {
		return flujodecaja;
	}

	public void setFlujodecaja(String flujodecaja) {
		this.flujodecaja = flujodecaja;
	}
	public String getPartidapresupuestal() {
		return partidapresupuestal;
	}

	public void setPartidapresupuestal(String partidapresupuestal) {
		this.partidapresupuestal = partidapresupuestal;
	}
	public String getDocumentoreferencia() {
		return documentoreferencia;
	}

	public void setDocumentoreferencia(String documentoreferencia) {
		this.documentoreferencia = documentoreferencia;
	}
	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getDiferidoflag() {
		return diferidoflag;
	}

	public void setDiferidoflag(String diferidoflag) {
		this.diferidoflag = diferidoflag;
	}
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public String getCamporeferencia() {
		return camporeferencia;
	}

	public void setCamporeferencia(String camporeferencia) {
		this.camporeferencia = camporeferencia;
	}
	public String getNoafectoigvflag() {
		return noafectoigvflag;
	}

	public void setNoafectoigvflag(String noafectoigvflag) {
		this.noafectoigvflag = noafectoigvflag;
	}
	public String getSplitdistributionflag() {
		return splitdistributionflag;
	}

	public void setSplitdistributionflag(String splitdistributionflag) {
		this.splitdistributionflag = splitdistributionflag;
	}
	public String getNumeroorden() {
		return numeroorden;
	}

	public void setNumeroorden(String numeroorden) {
		this.numeroorden = numeroorden;
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
	public String getConceptogasto() {
		return conceptogasto;
	}

	public void setConceptogasto(String conceptogasto) {
		this.conceptogasto = conceptogasto;
	}
	public String getNivelservicio() {
		return nivelservicio;
	}

	public void setNivelservicio(String nivelservicio) {
		this.nivelservicio = nivelservicio;
	}

	public Obligaciones getObligaciones() {
		return obligaciones;
	}

	public void setObligaciones(Obligaciones obligaciones) {
		this.obligaciones = obligaciones;
	}

	public BigDecimal getPersona() {
		return persona;
	}

	public void setPersona(BigDecimal persona) {
		this.persona = persona;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

}
