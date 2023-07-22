package net.royal.erp.asistencia.asmain.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.core.UValidador;

public class DtoDwAsAsistenciaHextraEdit {

	private Date fecha;
	private Date desde;
	private Date hasta;
	private String tipo;
	private BigDecimal cantidad;
	private BigDecimal cantidadreal;
	private BigDecimal compensado;
	private BigDecimal diferencia;
	private String cantidadhor;
	private String compensadohor;
	private String diferenciahor;
	private String mostrar;
	private BigDecimal diasdfs;
	private BigDecimal diasdlv;
	private Boolean isseleccionado;
	private String seleccion;

	private Date fechamaxima;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getCantidad() {
		if (UValidador.esNulo(cantidad)) {
			cantidad = BigDecimal.ZERO;
		}
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCompensado() {
		if (UValidador.esNulo(compensado)) {
			compensado = BigDecimal.ZERO;
		}
		return compensado;
	}

	public void setCompensado(BigDecimal compensado) {
		this.compensado = compensado;
	}

	public BigDecimal getDiferencia() {
		if (UValidador.esNulo(diferencia)) {
			diferencia = BigDecimal.ZERO;
		}
		return diferencia;
	}

	public void setDiferencia(BigDecimal diferencia) {
		this.diferencia = diferencia;
	}

	public String getMostrar() {
		return mostrar;
	}

	public void setMostrar(String mostrar) {
		this.mostrar = mostrar;
	}

	public String getCantidadhor() {
		return cantidadhor;
	}

	public void setCantidadhor(String cantidadhor) {
		this.cantidadhor = cantidadhor;
	}

	public String getCompensadohor() {
		return compensadohor;
	}

	public void setCompensadohor(String compensadohor) {
		this.compensadohor = compensadohor;
	}

	public String getDiferenciahor() {
		return diferenciahor;
	}

	public void setDiferenciahor(String diferenciahor) {
		this.diferenciahor = diferenciahor;
	}

	public BigDecimal getDiasdfs() {
		if (UValidador.esNulo(diasdfs)) {
			diasdfs = BigDecimal.ZERO;
		}
		return diasdfs;
	}

	public void setDiasdfs(BigDecimal diasdfs) {
		this.diasdfs = diasdfs;
	}

	public BigDecimal getDiasdlv() {
		if (UValidador.esNulo(diasdlv)) {
			diasdlv = BigDecimal.ZERO;
		}
		return diasdlv;
	}

	public void setDiasdlv(BigDecimal diasdlv) {
		this.diasdlv = diasdlv;
	}

	public Date getFechamaxima() {

		fechamaxima = UFechaHora.obtenerFechaMasMeses(getFecha(),
				diasdlv.intValue());
		fechamaxima = UFechaHora.obtenerFechaMasdias(fechamaxima, -1);
		return fechamaxima;
	}

	public void setFechamaxima(Date fechamaxima) {
		this.fechamaxima = fechamaxima;
	}

	public Boolean getIsseleccionado() {
		if (UValidador.esNulo(isseleccionado)) {
			isseleccionado = false;
		}
		return isseleccionado;
	}

	public void setIsseleccionado(Boolean isseleccionado) {
		this.isseleccionado = isseleccionado;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getCantidadreal() {
		if (UValidador.esNulo(cantidadreal)) {
			cantidadreal = BigDecimal.ZERO;
		}
		return cantidadreal;
	}

	public void setCantidadreal(BigDecimal cantidadreal) {
		this.cantidadreal = cantidadreal;
	}

	public String getSeleccion() {
		if (UValidador.estaVacio(seleccion)) {
			seleccion = "";
		}
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

}
