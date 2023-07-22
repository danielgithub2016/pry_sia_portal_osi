package net.royal.seguridad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Tipocambiomast
*/
public class Tipocambiomast extends DominioGenerico implements java.io.Serializable{

	private TipocambiomastPk pk;
	private String fechacambiostring;
	private String estado;
	
	private java.math.BigDecimal factor;
	private java.math.BigDecimal factorcompra;
	private java.math.BigDecimal factorventa;
	private java.math.BigDecimal factorpromedio;
	private java.math.BigDecimal factorcompraafp;
	private java.math.BigDecimal factorventaafp;
	private java.math.BigDecimal factorcomprasbs;
	private java.math.BigDecimal factorventasbs;
	private java.math.BigDecimal valorcuota;	
	private java.math.BigDecimal tasatamex;
	private java.math.BigDecimal tasatamn;
	private java.math.BigDecimal tasaanualtamex;
	private java.math.BigDecimal tasaanualtamn;
	private java.math.BigDecimal factorcobranzacompra;
	private java.math.BigDecimal factorcobranzaventa;


	public Tipocambiomast() {
		pk = new TipocambiomastPk();
	}

	public TipocambiomastPk getPk() {
		return pk;
	}

	public void setPk(TipocambiomastPk pk) {
		this.pk = pk;
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
	public java.math.BigDecimal getFactorcompra() {
		return factorcompra;
	}

	public void setFactorcompra(java.math.BigDecimal factorcompra) {
		this.factorcompra = factorcompra;
	}
	public java.math.BigDecimal getFactorventa() {
		return factorventa;
	}

	public void setFactorventa(java.math.BigDecimal factorventa) {
		this.factorventa = factorventa;
	}
	public java.math.BigDecimal getFactorpromedio() {
		return factorpromedio;
	}

	public void setFactorpromedio(java.math.BigDecimal factorpromedio) {
		this.factorpromedio = factorpromedio;
	}
	public java.math.BigDecimal getFactorcompraafp() {
		return factorcompraafp;
	}

	public void setFactorcompraafp(java.math.BigDecimal factorcompraafp) {
		this.factorcompraafp = factorcompraafp;
	}
	public java.math.BigDecimal getFactorventaafp() {
		return factorventaafp;
	}

	public void setFactorventaafp(java.math.BigDecimal factorventaafp) {
		this.factorventaafp = factorventaafp;
	}
	public java.math.BigDecimal getFactorcomprasbs() {
		return factorcomprasbs;
	}

	public void setFactorcomprasbs(java.math.BigDecimal factorcomprasbs) {
		this.factorcomprasbs = factorcomprasbs;
	}
	public java.math.BigDecimal getFactorventasbs() {
		return factorventasbs;
	}

	public void setFactorventasbs(java.math.BigDecimal factorventasbs) {
		this.factorventasbs = factorventasbs;
	}
	public java.math.BigDecimal getValorcuota() {
		return valorcuota;
	}

	public void setValorcuota(java.math.BigDecimal valorcuota) {
		this.valorcuota = valorcuota;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public java.math.BigDecimal getTasatamex() {
		return tasatamex;
	}

	public void setTasatamex(java.math.BigDecimal tasatamex) {
		this.tasatamex = tasatamex;
	}
	public java.math.BigDecimal getTasatamn() {
		return tasatamn;
	}

	public void setTasatamn(java.math.BigDecimal tasatamn) {
		this.tasatamn = tasatamn;
	}
	public java.math.BigDecimal getTasaanualtamex() {
		return tasaanualtamex;
	}

	public void setTasaanualtamex(java.math.BigDecimal tasaanualtamex) {
		this.tasaanualtamex = tasaanualtamex;
	}
	public java.math.BigDecimal getTasaanualtamn() {
		return tasaanualtamn;
	}

	public void setTasaanualtamn(java.math.BigDecimal tasaanualtamn) {
		this.tasaanualtamn = tasaanualtamn;
	}
	public java.math.BigDecimal getFactorcobranzacompra() {
		return factorcobranzacompra;
	}

	public void setFactorcobranzacompra(java.math.BigDecimal factorcobranzacompra) {
		this.factorcobranzacompra = factorcobranzacompra;
	}
	public java.math.BigDecimal getFactorcobranzaventa() {
		return factorcobranzaventa;
	}

	public void setFactorcobranzaventa(java.math.BigDecimal factorcobranzaventa) {
		this.factorcobranzaventa = factorcobranzaventa;
	}

}
