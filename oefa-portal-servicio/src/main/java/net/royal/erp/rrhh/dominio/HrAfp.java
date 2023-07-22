package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrAfp
*/
public class HrAfp extends DominioGenerico implements java.io.Serializable{

	private HrAfpPk pk;
	private String nombreafp;
	private String direccionafp;
	private String casillapostal;
	private String departamento;
	private String codigopostal;
	private String documentofiscal;
	private java.math.BigDecimal aportefondopensiones;
	private Integer topeaplicacionprima;
	private Integer comisionfija;
	private java.math.BigDecimal comisionvariable;
	private java.math.BigDecimal seguro;
	private Integer codigoproveedor;
	private String estado;
	private String codigointegra;
	private String codigosiete;
	private String codigortps;
	private String codigointerfaseafp;
	private java.math.BigDecimal comisionmixta;


	public HrAfp() {
		pk = new HrAfpPk();
	}

	public HrAfpPk getPk() {
		return pk;
	}

	public void setPk(HrAfpPk pk) {
		this.pk = pk;
	}
	public String getNombreafp() {
		return nombreafp;
	}

	public void setNombreafp(String nombreafp) {
		this.nombreafp = nombreafp;
	}
	public String getDireccionafp() {
		return direccionafp;
	}

	public void setDireccionafp(String direccionafp) {
		this.direccionafp = direccionafp;
	}
	public String getCasillapostal() {
		return casillapostal;
	}

	public void setCasillapostal(String casillapostal) {
		this.casillapostal = casillapostal;
	}
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getDocumentofiscal() {
		return documentofiscal;
	}

	public void setDocumentofiscal(String documentofiscal) {
		this.documentofiscal = documentofiscal;
	}
	public java.math.BigDecimal getAportefondopensiones() {
		return aportefondopensiones;
	}

	public void setAportefondopensiones(java.math.BigDecimal aportefondopensiones) {
		this.aportefondopensiones = aportefondopensiones;
	}
	public Integer getTopeaplicacionprima() {
		return topeaplicacionprima;
	}

	public void setTopeaplicacionprima(Integer topeaplicacionprima) {
		this.topeaplicacionprima = topeaplicacionprima;
	}
	public Integer getComisionfija() {
		return comisionfija;
	}

	public void setComisionfija(Integer comisionfija) {
		this.comisionfija = comisionfija;
	}
	public java.math.BigDecimal getComisionvariable() {
		return comisionvariable;
	}

	public void setComisionvariable(java.math.BigDecimal comisionvariable) {
		this.comisionvariable = comisionvariable;
	}
	public java.math.BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(java.math.BigDecimal seguro) {
		this.seguro = seguro;
	}
	public Integer getCodigoproveedor() {
		return codigoproveedor;
	}

	public void setCodigoproveedor(Integer codigoproveedor) {
		this.codigoproveedor = codigoproveedor;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigointegra() {
		return codigointegra;
	}

	public void setCodigointegra(String codigointegra) {
		this.codigointegra = codigointegra;
	}
	public String getCodigosiete() {
		return codigosiete;
	}

	public void setCodigosiete(String codigosiete) {
		this.codigosiete = codigosiete;
	}
	public String getCodigortps() {
		return codigortps;
	}

	public void setCodigortps(String codigortps) {
		this.codigortps = codigortps;
	}
	public String getCodigointerfaseafp() {
		return codigointerfaseafp;
	}

	public void setCodigointerfaseafp(String codigointerfaseafp) {
		this.codigointerfaseafp = codigointerfaseafp;
	}
	public java.math.BigDecimal getComisionmixta() {
		return comisionmixta;
	}

	public void setComisionmixta(java.math.BigDecimal comisionmixta) {
		this.comisionmixta = comisionmixta;
	}

}
