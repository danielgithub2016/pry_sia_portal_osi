package net.royal.erp.presupuesto.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class DtoDwBuDemanda implements Serializable {
	private String demanda;
	private String resultadoespecifico;
	private Date fechacreacion;
	private Date fechademanda;
	private String estado;
	private String costcenter;
	private String glosa;
	private String ultimousuario;
	private String descripcion;
	private String sucursal;
	private BigDecimal totaldemanda;

	private String sucursaldescripcion;
	private String estadodescripcion;

	public String getDemanda() {
		return demanda;
	}

	public void setDemanda(String demanda) {
		this.demanda = demanda;
	}

	public String getResultadoespecifico() {
		return resultadoespecifico;
	}

	public void setResultadoespecifico(String resultadoespecifico) {
		this.resultadoespecifico = resultadoespecifico;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechademanda() {
		return fechademanda;
	}

	public void setFechademanda(Date fechademanda) {
		this.fechademanda = fechademanda;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public BigDecimal getTotaldemanda() {
		return totaldemanda;
	}

	public void setTotaldemanda(BigDecimal totaldemanda) {
		this.totaldemanda = totaldemanda;
	}

	public String getEstadodescripcion() {
		if (!UValidador.esNulo(estado)) {
			switch (estado) {
			case "GE":
				estadodescripcion = "GENERADO";
				break;
			case "EN":
				estadodescripcion = "ENVIADO";
				break;
			case "AP":
				estadodescripcion = "APROBADO";
				break;
			case "RE":
				estadodescripcion = "RECHAZADO";
				break;
			case "OB":
				estadodescripcion = "OBSERVADO";
				break;
			case "RV":
				estadodescripcion = "REVISADO";
				break;
			case "GN":
				estadodescripcion = "ENVIO NIV.SERV.";
				break;
			}
		}
		return estadodescripcion;
	}

	public void setEstadodescripcion(String estadodescripcion) {
		this.estadodescripcion = estadodescripcion;
	}

	public String getSucursaldescripcion() {
		return sucursaldescripcion;
	}

	public void setSucursaldescripcion(String sucursaldescripcion) {
		this.sucursaldescripcion = sucursaldescripcion;
	}

}
