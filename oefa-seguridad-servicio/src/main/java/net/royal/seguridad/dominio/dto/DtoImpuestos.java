package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Impuestos
*/
public class DtoImpuestos implements java.io.Serializable{

	private String impuesto;
	private String descripcion;
	private String tipoimpuesto;
	private Integer factorporcentaje;
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

	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
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
	public Integer getFactorporcentaje() {
		return factorporcentaje;
	}

	public void setFactorporcentaje(Integer factorporcentaje) {
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
