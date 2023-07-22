package net.royal.erp.sistema.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder syfinan.dw_wh_importacion_select_bl_detail
 */
public class DtoDwWhImportacionSelectBlDetail implements java.io.Serializable {
	
	private String companiasocio;
	private String blnumero;
	private String referencianumerodocumento;
	private String documentoreferencia;
	private String obligacion;
	private BigDecimal montototal;
	private String obligaciontipodocumento;
	private String obligacionnumerodocumento;
	private BigDecimal montoflete;
	private String busqueda;
	private BigDecimal proveedor;
	private String transaccionnumerodocumento;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getBlnumero() {
		return blnumero;
	}

	public void setBlnumero(String blnumero) {
		this.blnumero = blnumero;
	}

	public String getReferencianumerodocumento() {
		return referencianumerodocumento;
	}

	public void setReferencianumerodocumento(String referencianumerodocumento) {
		this.referencianumerodocumento = referencianumerodocumento;
	}

	public String getDocumentoreferencia() {
		return documentoreferencia;
	}

	public void setDocumentoreferencia(String documentoreferencia) {
		this.documentoreferencia = documentoreferencia;
	}

	public BigDecimal getMontototal() {
		return montototal;
	}

	public void setMontototal(BigDecimal montototal) {
		this.montototal = montototal;
	}

	public String getObligaciontipodocumento() {
		return obligaciontipodocumento;
	}

	public void setObligaciontipodocumento(String obligaciontipodocumento) {
		this.obligaciontipodocumento = obligaciontipodocumento;
	}

	public String getObligacionnumerodocumento() {
		return obligacionnumerodocumento;
	}

	public void setObligacionnumerodocumento(String obligacionnumerodocumento) {
		this.obligacionnumerodocumento = obligacionnumerodocumento;
	}

	public BigDecimal getMontoflete() {
		return montoflete;
	}

	public void setMontoflete(BigDecimal montoflete) {
		this.montoflete = montoflete;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public BigDecimal getProveedor() {
		return proveedor;
	}

	public void setProveedor(BigDecimal proveedor) {
		this.proveedor = proveedor;
	}

	public String getTransaccionnumerodocumento() {
		return transaccionnumerodocumento;
	}

	public void setTransaccionnumerodocumento(String transaccionnumerodocumento) {
		this.transaccionnumerodocumento = transaccionnumerodocumento;
	}

	public String getObligacion() {
		return obligacion;
	}

	public void setObligacion(String obligacion) {
		this.obligacion = obligacion;
	}


}
