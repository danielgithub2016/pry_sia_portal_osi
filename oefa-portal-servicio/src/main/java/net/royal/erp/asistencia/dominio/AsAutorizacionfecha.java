package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsAutorizacionfecha
*/
public class AsAutorizacionfecha extends DominioGenerico implements java.io.Serializable{

	private AsAutorizacionfechaPk pk;
	private String tipo;
	private java.util.Date hasta;
	private java.math.BigDecimal cantidad;
	private java.math.BigDecimal cantidadreal;
	private java.math.BigDecimal diferencia;
	private String estado;


	public AsAutorizacionfecha() {
		pk = new AsAutorizacionfechaPk();
	}

	public AsAutorizacionfechaPk getPk() {
		return pk;
	}

	public void setPk(AsAutorizacionfechaPk pk) {
		this.pk = pk;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public java.util.Date getHasta() {
		return hasta;
	}

	public void setHasta(java.util.Date hasta) {
		this.hasta = hasta;
	}
	public java.math.BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(java.math.BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public java.math.BigDecimal getCantidadreal() {
		return cantidadreal;
	}

	public void setCantidadreal(java.math.BigDecimal cantidadreal) {
		this.cantidadreal = cantidadreal;
	}
	public java.math.BigDecimal getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(java.math.BigDecimal diferencia) {
		this.diferencia = diferencia;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
