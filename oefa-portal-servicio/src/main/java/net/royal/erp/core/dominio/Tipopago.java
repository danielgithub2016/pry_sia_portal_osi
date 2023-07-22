package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Tipopago
*/
public class Tipopago extends DominioGenerico implements java.io.Serializable{

	private TipopagoPk pk;
	private String descripcion;
	private String restringidoflag;
	private String cartaflag;
	private String generarnumeracionflag;
	private String entregableflag;
	private String estado;
	private String vouchersumarizadoflag;
	private String disponiblefeederflag;
	private String codigosiaf;
	private String descripcioningles;
	private String generarcomisionflag;
	private String cuentacomision;
	private Integer montocomisionlocal;
	private Integer montocomisionextranjera;
	private String generarinterfaseflag;
	private String tipopagortps;
	private String codigofiscal;
	private String cuentaorden;
	private String cuentaordenhaber;


	public Tipopago() {
		pk = new TipopagoPk();
	}

	public TipopagoPk getPk() {
		return pk;
	}

	public void setPk(TipopagoPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRestringidoflag() {
		return restringidoflag;
	}

	public void setRestringidoflag(String restringidoflag) {
		this.restringidoflag = restringidoflag;
	}
	public String getCartaflag() {
		return cartaflag;
	}

	public void setCartaflag(String cartaflag) {
		this.cartaflag = cartaflag;
	}
	public String getGenerarnumeracionflag() {
		return generarnumeracionflag;
	}

	public void setGenerarnumeracionflag(String generarnumeracionflag) {
		this.generarnumeracionflag = generarnumeracionflag;
	}
	public String getEntregableflag() {
		return entregableflag;
	}

	public void setEntregableflag(String entregableflag) {
		this.entregableflag = entregableflag;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getVouchersumarizadoflag() {
		return vouchersumarizadoflag;
	}

	public void setVouchersumarizadoflag(String vouchersumarizadoflag) {
		this.vouchersumarizadoflag = vouchersumarizadoflag;
	}
	public String getDisponiblefeederflag() {
		return disponiblefeederflag;
	}

	public void setDisponiblefeederflag(String disponiblefeederflag) {
		this.disponiblefeederflag = disponiblefeederflag;
	}
	public String getCodigosiaf() {
		return codigosiaf;
	}

	public void setCodigosiaf(String codigosiaf) {
		this.codigosiaf = codigosiaf;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getGenerarcomisionflag() {
		return generarcomisionflag;
	}

	public void setGenerarcomisionflag(String generarcomisionflag) {
		this.generarcomisionflag = generarcomisionflag;
	}
	public String getCuentacomision() {
		return cuentacomision;
	}

	public void setCuentacomision(String cuentacomision) {
		this.cuentacomision = cuentacomision;
	}
	public Integer getMontocomisionlocal() {
		return montocomisionlocal;
	}

	public void setMontocomisionlocal(Integer montocomisionlocal) {
		this.montocomisionlocal = montocomisionlocal;
	}
	public Integer getMontocomisionextranjera() {
		return montocomisionextranjera;
	}

	public void setMontocomisionextranjera(Integer montocomisionextranjera) {
		this.montocomisionextranjera = montocomisionextranjera;
	}
	public String getGenerarinterfaseflag() {
		return generarinterfaseflag;
	}

	public void setGenerarinterfaseflag(String generarinterfaseflag) {
		this.generarinterfaseflag = generarinterfaseflag;
	}
	public String getTipopagortps() {
		return tipopagortps;
	}

	public void setTipopagortps(String tipopagortps) {
		this.tipopagortps = tipopagortps;
	}
	public String getCodigofiscal() {
		return codigofiscal;
	}

	public void setCodigofiscal(String codigofiscal) {
		this.codigofiscal = codigofiscal;
	}
	public String getCuentaorden() {
		return cuentaorden;
	}

	public void setCuentaorden(String cuentaorden) {
		this.cuentaorden = cuentaorden;
	}
	public String getCuentaordenhaber() {
		return cuentaordenhaber;
	}

	public void setCuentaordenhaber(String cuentaordenhaber) {
		this.cuentaordenhaber = cuentaordenhaber;
	}

}
