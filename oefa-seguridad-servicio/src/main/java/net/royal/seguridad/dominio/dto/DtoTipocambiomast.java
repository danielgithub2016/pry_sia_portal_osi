package net.royal.seguridad.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Tipocambiomast
*/
public class DtoTipocambiomast implements java.io.Serializable{

	private String monedacodigo;
	private String monedacambiocodigo;
	private java.util.Date fechacambio;
	private String fechacambiostring;
	private java.math.BigDecimal factor;
	private Integer factorcompra;
	private Integer factorventa;
	private Integer factorpromedio;
	private Integer factorcompraafp;
	private Integer factorventaafp;
	private Integer factorcomprasbs;
	private Integer factorventasbs;
	private Integer valorcuota;
	private String estado;
	private Integer tasatamex;
	private Integer tasatamn;
	private Integer tasaanualtamex;
	private Integer tasaanualtamn;
	private Integer factorcobranzacompra;
	private Integer factorcobranzaventa;

	public String getMonedacodigo() {
		return monedacodigo;
	}

	public void setMonedacodigo(String monedacodigo) {
		this.monedacodigo = monedacodigo;
	}
	public String getMonedacambiocodigo() {
		return monedacambiocodigo;
	}

	public void setMonedacambiocodigo(String monedacambiocodigo) {
		this.monedacambiocodigo = monedacambiocodigo;
	}
	public java.util.Date getFechacambio() {
		return fechacambio;
	}

	public void setFechacambio(java.util.Date fechacambio) {
		this.fechacambio = fechacambio;
	}
	public String getFechacambiostring() {
		return fechacambiostring;
	}

	public void setFechacambiostring(String fechacambiostring) {
		this.fechacambiostring = fechacambiostring;
	}
	public java.math.BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(java.math.BigDecimal factor) {
		this.factor = factor;
	}
	public Integer getFactorcompra() {
		return factorcompra;
	}

	public void setFactorcompra(Integer factorcompra) {
		this.factorcompra = factorcompra;
	}
	public Integer getFactorventa() {
		return factorventa;
	}

	public void setFactorventa(Integer factorventa) {
		this.factorventa = factorventa;
	}
	public Integer getFactorpromedio() {
		return factorpromedio;
	}

	public void setFactorpromedio(Integer factorpromedio) {
		this.factorpromedio = factorpromedio;
	}
	public Integer getFactorcompraafp() {
		return factorcompraafp;
	}

	public void setFactorcompraafp(Integer factorcompraafp) {
		this.factorcompraafp = factorcompraafp;
	}
	public Integer getFactorventaafp() {
		return factorventaafp;
	}

	public void setFactorventaafp(Integer factorventaafp) {
		this.factorventaafp = factorventaafp;
	}
	public Integer getFactorcomprasbs() {
		return factorcomprasbs;
	}

	public void setFactorcomprasbs(Integer factorcomprasbs) {
		this.factorcomprasbs = factorcomprasbs;
	}
	public Integer getFactorventasbs() {
		return factorventasbs;
	}

	public void setFactorventasbs(Integer factorventasbs) {
		this.factorventasbs = factorventasbs;
	}
	public Integer getValorcuota() {
		return valorcuota;
	}

	public void setValorcuota(Integer valorcuota) {
		this.valorcuota = valorcuota;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getTasatamex() {
		return tasatamex;
	}

	public void setTasatamex(Integer tasatamex) {
		this.tasatamex = tasatamex;
	}
	public Integer getTasatamn() {
		return tasatamn;
	}

	public void setTasatamn(Integer tasatamn) {
		this.tasatamn = tasatamn;
	}
	public Integer getTasaanualtamex() {
		return tasaanualtamex;
	}

	public void setTasaanualtamex(Integer tasaanualtamex) {
		this.tasaanualtamex = tasaanualtamex;
	}
	public Integer getTasaanualtamn() {
		return tasaanualtamn;
	}

	public void setTasaanualtamn(Integer tasaanualtamn) {
		this.tasaanualtamn = tasaanualtamn;
	}
	public Integer getFactorcobranzacompra() {
		return factorcobranzacompra;
	}

	public void setFactorcobranzacompra(Integer factorcobranzacompra) {
		this.factorcobranzacompra = factorcobranzacompra;
	}
	public Integer getFactorcobranzaventa() {
		return factorcobranzaventa;
	}

	public void setFactorcobranzaventa(Integer factorcobranzaventa) {
		this.factorcobranzaventa = factorcobranzaventa;
	}

}
