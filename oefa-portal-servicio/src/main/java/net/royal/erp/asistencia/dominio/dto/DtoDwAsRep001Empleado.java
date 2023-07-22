package net.royal.erp.asistencia.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class DtoDwAsRep001Empleado implements Serializable {
	private BigDecimal empleado;
	private BigDecimal secuencia;
	private String tipodocumento;
	private String documento;
	private String nombrecompleto;
	private String companiasocio;
	private String tipoplanilla;
	private String locaciondepago;
	private String centrocostos;
	private String sucursal;
	private BigDecimal area;
	private BigDecimal tipohorario;
	private String estadoempleado;
	private String areaoperativa;

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getLocaciondepago() {
		return locaciondepago;
	}

	public void setLocaciondepago(String locaciondepago) {
		this.locaciondepago = locaciondepago;
	}

	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getEstadoempleado() {
		return estadoempleado;
	}

	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getAreaoperativa() {
		return areaoperativa;
	}

	public void setAreaoperativa(String areaoperativa) {
		this.areaoperativa = areaoperativa;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}
	
}
