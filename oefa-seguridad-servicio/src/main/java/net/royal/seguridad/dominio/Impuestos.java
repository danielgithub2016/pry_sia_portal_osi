package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Impuestos
*/
public class Impuestos extends DominioGenerico implements java.io.Serializable{

	private ImpuestosPk pk;
	private String descripcion;
	private String tipoimpuesto;
	private BigDecimal factorporcentaje;
	private String cuentacontablelocal;
	private String cuentacontabledolares;
	private String signo;
	private String exportableflag;
	private String exportabletipodecambio;
	private String certificadorentaflag;
	private String estado;
	private String montonoafectoflag;
	private String cuentacontablerevlocal;
	private String cuentacontablerevdolares;
	private String voucherprovisionflag;
	private String montoimponibleflag;
	private Integer montoexonerado;
	private String codigointerno;


	public Impuestos() {
		pk = new ImpuestosPk();
	}

	public ImpuestosPk getPk() {
		return pk;
	}

	public void setPk(ImpuestosPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoimpuesto() {
		return tipoimpuesto;
	}

	public void setTipoimpuesto(String tipoimpuesto) {
		this.tipoimpuesto = tipoimpuesto;
	}
	public BigDecimal getFactorporcentaje() {
		return factorporcentaje;
	}

	public void setFactorporcentaje(BigDecimal factorporcentaje) {
		this.factorporcentaje = factorporcentaje;
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
	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}
	public String getExportableflag() {
		return exportableflag;
	}

	public void setExportableflag(String exportableflag) {
		this.exportableflag = exportableflag;
	}
	public String getExportabletipodecambio() {
		return exportabletipodecambio;
	}

	public void setExportabletipodecambio(String exportabletipodecambio) {
		this.exportabletipodecambio = exportabletipodecambio;
	}
	public String getCertificadorentaflag() {
		return certificadorentaflag;
	}

	public void setCertificadorentaflag(String certificadorentaflag) {
		this.certificadorentaflag = certificadorentaflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMontonoafectoflag() {
		return montonoafectoflag;
	}

	public void setMontonoafectoflag(String montonoafectoflag) {
		this.montonoafectoflag = montonoafectoflag;
	}
	public String getCuentacontablerevlocal() {
		return cuentacontablerevlocal;
	}

	public void setCuentacontablerevlocal(String cuentacontablerevlocal) {
		this.cuentacontablerevlocal = cuentacontablerevlocal;
	}
	public String getCuentacontablerevdolares() {
		return cuentacontablerevdolares;
	}

	public void setCuentacontablerevdolares(String cuentacontablerevdolares) {
		this.cuentacontablerevdolares = cuentacontablerevdolares;
	}
	public String getVoucherprovisionflag() {
		return voucherprovisionflag;
	}

	public void setVoucherprovisionflag(String voucherprovisionflag) {
		this.voucherprovisionflag = voucherprovisionflag;
	}
	public String getMontoimponibleflag() {
		return montoimponibleflag;
	}

	public void setMontoimponibleflag(String montoimponibleflag) {
		this.montoimponibleflag = montoimponibleflag;
	}
	public Integer getMontoexonerado() {
		return montoexonerado;
	}

	public void setMontoexonerado(Integer montoexonerado) {
		this.montoexonerado = montoexonerado;
	}
	public String getCodigointerno() {
		return codigointerno;
	}

	public void setCodigointerno(String codigointerno) {
		this.codigointerno = codigointerno;
	}

}
