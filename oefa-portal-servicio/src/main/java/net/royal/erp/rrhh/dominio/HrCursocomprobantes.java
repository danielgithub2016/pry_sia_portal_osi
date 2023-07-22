package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCursocomprobantes
*/
public class HrCursocomprobantes extends DominioGenerico implements java.io.Serializable{

	private HrCursocomprobantesPk pk;
	private String numero;
	private String descripcion;
	private java.util.Date fecha;
	private Integer total;
	private Integer subtotal;
	private Integer totalimpuestos;
	private String moneda;
	private String unidadnegocio;
	private String flagcargar;
	private String flaglogistica;
	private java.math.BigDecimal tipocambio;
	private String tipodocumento;
	private Integer proveedor;
	private String numerodocumento;
	private String companyowner;


	public HrCursocomprobantes() {
		pk = new HrCursocomprobantesPk();
	}

	public HrCursocomprobantesPk getPk() {
		return pk;
	}

	public void setPk(HrCursocomprobantesPk pk) {
		this.pk = pk;
	}
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getTotalimpuestos() {
		return totalimpuestos;
	}

	public void setTotalimpuestos(Integer totalimpuestos) {
		this.totalimpuestos = totalimpuestos;
	}
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getFlagcargar() {
		return flagcargar;
	}

	public void setFlagcargar(String flagcargar) {
		this.flagcargar = flagcargar;
	}
	public String getFlaglogistica() {
		return flaglogistica;
	}

	public void setFlaglogistica(String flaglogistica) {
		this.flaglogistica = flaglogistica;
	}
	public java.math.BigDecimal getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(java.math.BigDecimal tipocambio) {
		this.tipocambio = tipocambio;
	}
	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

}
