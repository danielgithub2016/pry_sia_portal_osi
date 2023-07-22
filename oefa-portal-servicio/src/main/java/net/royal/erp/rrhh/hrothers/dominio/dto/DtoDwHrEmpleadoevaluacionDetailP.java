package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Class <strong>DtoDwHrEmpleadoevaluacionDetailP</strong>.
 * 
 * @author nunezh
 * @powerbuilder <strong>hrothers.dw_hr_empleadoevaluacion_detail_p</strong>
 */
@SuppressWarnings("serial")
public class DtoDwHrEmpleadoevaluacionDetailP implements Serializable {
	private String companyowner;
	private BigDecimal secuenciaeval;
	private BigDecimal empleado;
	private BigDecimal secuencia;
	private BigDecimal factor;
	private BigDecimal calificacion;
	private String factor_des;
	private String factorvalor_des;
	private String explicacion_factor;
	private String explicacion;
	private BigDecimal valor;
	private String marca;
	private String marca_2;
	private String marca_3;
	private String marca_4;
	private BigDecimal cf_suma;
	private BigDecimal cf_cuenta;
	private String tipo;
	private String plantilla;
	private BigDecimal factorponderacion;
	private BigDecimal empleadoevaluador;
	private BigDecimal ordenfactor;
	private BigDecimal valorhasta;

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public BigDecimal getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(BigDecimal secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public BigDecimal getEmpleado() {
		return empleado;
	}

	public void setEmpleado(BigDecimal empleado) {
		this.empleado = empleado;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public BigDecimal getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public String getFactor_des() {
		return factor_des;
	}

	public void setFactor_des(String factor_des) {
		this.factor_des = factor_des;
	}

	public String getFactorvalor_des() {
		return factorvalor_des;
	}

	public void setFactorvalor_des(String factorvalor_des) {
		this.factorvalor_des = factorvalor_des;
	}

	public String getExplicacion_factor() {
		return explicacion_factor;
	}

	public void setExplicacion_factor(String explicacion_factor) {
		this.explicacion_factor = explicacion_factor;
	}

	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca_2() {
		return marca_2;
	}

	public void setMarca_2(String marca_2) {
		this.marca_2 = marca_2;
	}

	public String getMarca_3() {
		return marca_3;
	}

	public void setMarca_3(String marca_3) {
		this.marca_3 = marca_3;
	}

	public String getMarca_4() {
		return marca_4;
	}

	public void setMarca_4(String marca_4) {
		this.marca_4 = marca_4;
	}

	public BigDecimal getCf_suma() {
		return cf_suma;
	}

	public void setCf_suma(BigDecimal cf_suma) {
		this.cf_suma = cf_suma;
	}

	public BigDecimal getCf_cuenta() {
		return cf_cuenta;
	}

	public void setCf_cuenta(BigDecimal cf_cuenta) {
		this.cf_cuenta = cf_cuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	public BigDecimal getFactorponderacion() {
		return factorponderacion;
	}

	public void setFactorponderacion(BigDecimal factorponderacion) {
		this.factorponderacion = factorponderacion;
	}

	public BigDecimal getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(BigDecimal empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

	public BigDecimal getOrdenfactor() {
		return ordenfactor;
	}

	public void setOrdenfactor(BigDecimal ordenfactor) {
		this.ordenfactor = ordenfactor;
	}

	public BigDecimal getValorhasta() {
		return valorhasta;
	}

	public void setValorhasta(BigDecimal valorhasta) {
		this.valorhasta = valorhasta;
	}

}
