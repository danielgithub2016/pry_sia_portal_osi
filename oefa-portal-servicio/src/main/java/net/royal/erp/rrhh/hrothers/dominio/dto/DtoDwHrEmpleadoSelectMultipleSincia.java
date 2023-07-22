package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DtoDwHrEmpleadoSelectMultipleSincia implements Serializable {

	private BigDecimal persona;
	private String nombrecompleto;
	private String seleccionado;
	private String estado;
	private String estadoempleado;
	private String centrocostos;
	private String companiasocio;
	private String cargo;
	private String tipoplanilla;
	private BigDecimal dptoareaoperativa;
	
	
	
	private boolean boolseleccionado;
	
	private BigDecimal total;
	
	public BigDecimal getPersona() {
		return persona;
	}
	public void setPersona(BigDecimal persona) {
		this.persona = persona;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getSeleccionado() {
		
		if(seleccionado.equals("S")){
			boolseleccionado=true;
		}else {
			boolseleccionado=false;
		}
		
		return seleccionado;
	}
	public void setSeleccionado(String seleccionado) {
		this.seleccionado = seleccionado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEstadoempleado() {
		return estadoempleado;
	}
	public void setEstadoempleado(String estadoempleado) {
		this.estadoempleado = estadoempleado;
	}
	public String getCentrocostos() {
		return centrocostos;
	}
	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getCompaniasocio() {
		return companiasocio;
	}
	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getTipoplanilla() {
		return tipoplanilla;
	}
	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}
	public BigDecimal getDptoareaoperativa() {
		return dptoareaoperativa;
	}
	public void setDptoareaoperativa(BigDecimal dptoareaoperativa) {
		this.dptoareaoperativa = dptoareaoperativa;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public boolean isBoolseleccionado() {
		return boolseleccionado;
	}
	public void setBoolseleccionado(boolean boolseleccionado) {
		this.boolseleccionado = boolseleccionado;
	}
	
}
