package net.royal.erp.asistencia.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

@SuppressWarnings("serial")
public class DtoDwAsRep001Sobretiempo implements Serializable {
	private BigDecimal empleado;
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
	private BigDecimal tipohorarioempleado;
	private String conceptoacceso;
	private Date fecha;
	private BigDecimal cantidadreal;
	private String estadoempleado;

	private BigDecimal tipodia;

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public BigDecimal getTipohorario() {
		if (UValidador.esNulo(tipohorario)) {
			tipohorario = BigDecimal.ZERO;
		}
		return tipohorario;
	}

	public void setTipohorario(BigDecimal tipohorario) {
		this.tipohorario = tipohorario;
	}

	public String getConceptoacceso() {
		return conceptoacceso;
	}

	public void setConceptoacceso(String conceptoacceso) {
		this.conceptoacceso = conceptoacceso;
	}

	public BigDecimal getCantidadreal() {
		return cantidadreal;
	}

	public void setCantidadreal(BigDecimal cantidadreal) {
		this.cantidadreal = cantidadreal;
	}

	public String getEstadoempleado() {
		return estadoempleado;
	}

	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}

	public BigDecimal getTipodia() {
		if (UValidador.esNulo(tipodia)) {
			tipodia = BigDecimal.ZERO;
		}
		return tipodia;
	}

	public void setTipodia(BigDecimal tipodia) {
		this.tipodia = tipodia;
	}

	public BigDecimal getTipohorarioempleado() {
		if (UValidador.esNulo(tipohorarioempleado)) {
			tipohorarioempleado = BigDecimal.ZERO;
		}
		return tipohorarioempleado;
	}

	public void setTipohorarioempleado(BigDecimal tipohorarioempleado) {
		this.tipohorarioempleado = tipohorarioempleado;
	}

}
