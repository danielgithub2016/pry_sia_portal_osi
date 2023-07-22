package net.royal.erp.presupuesto.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuControlpresupuestalSummary
*/
public class DtoBuControlpresupuestalSummary implements java.io.Serializable{

	private String companiasocio;
	private String tipodocumento;
	private String numerodocumento;
	private Integer proveedor;
	private Integer secuencia;
	private String centrocosto;
	private java.util.Date fechatransaccion;
	private String accion;
	private String comentario;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
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
	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public java.util.Date getFechatransaccion() {
		return fechatransaccion;
	}

	public void setFechatransaccion(java.util.Date fechatransaccion) {
		this.fechatransaccion = fechatransaccion;
	}
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
