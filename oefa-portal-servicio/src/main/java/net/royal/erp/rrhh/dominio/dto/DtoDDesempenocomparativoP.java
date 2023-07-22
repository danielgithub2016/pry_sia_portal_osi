package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Class <strong>DtoDDesempenocomparativoP</strong>.
 * 
 * @author nunezh
 * @powerbuilder <strong>hroracle.d_desempenocomparativo_p</strong>
 */
@SuppressWarnings("serial")
public class DtoDDesempenocomparativoP implements Serializable {
	private BigDecimal empleado;
	private BigDecimal secuencia;
	private String companyowner;
	private BigDecimal secuenciaeval;
	private BigDecimal factor;
	private String descripcion_detalle;
	private BigDecimal valor;
	private String unidadnegocio;
	private String tipo;
	private BigDecimal factorsecuencia;
	private String plantilla;
	private String descripcion_evaluacion;
	private BigDecimal areaponderacion;
	private BigDecimal factorponderacion;
	private BigDecimal factorparticipacion;
	private String area;
	private BigDecimal valorrequerido;
	private BigDecimal valorminimoesperado;
	private String descripcion_factor;
	private String tipocompetencia;
	private BigDecimal ordenfactor;
	private BigDecimal ordenplantilla;

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

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public String getDescripcion_detalle() {
		return descripcion_detalle;
	}

	public void setDescripcion_detalle(String descripcion_detalle) {
		this.descripcion_detalle = descripcion_detalle;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getFactorsecuencia() {
		return factorsecuencia;
	}

	public void setFactorsecuencia(BigDecimal factorsecuencia) {
		this.factorsecuencia = factorsecuencia;
	}

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}

	public String getDescripcion_evaluacion() {
		return descripcion_evaluacion;
	}

	public void setDescripcion_evaluacion(String descripcion_evaluacion) {
		this.descripcion_evaluacion = descripcion_evaluacion;
	}

	public BigDecimal getAreaponderacion() {
		return areaponderacion;
	}

	public void setAreaponderacion(BigDecimal areaponderacion) {
		this.areaponderacion = areaponderacion;
	}

	public BigDecimal getFactorponderacion() {
		return factorponderacion;
	}

	public void setFactorponderacion(BigDecimal factorponderacion) {
		this.factorponderacion = factorponderacion;
	}

	public BigDecimal getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(BigDecimal factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getValorrequerido() {
		return valorrequerido;
	}

	public void setValorrequerido(BigDecimal valorrequerido) {
		this.valorrequerido = valorrequerido;
	}

	public BigDecimal getValorminimoesperado() {
		return valorminimoesperado;
	}

	public void setValorminimoesperado(BigDecimal valorminimoesperado) {
		this.valorminimoesperado = valorminimoesperado;
	}

	public String getDescripcion_factor() {
		return descripcion_factor;
	}

	public void setDescripcion_factor(String descripcion_factor) {
		this.descripcion_factor = descripcion_factor;
	}

	public String getTipocompetencia() {
		return tipocompetencia;
	}

	public void setTipocompetencia(String tipocompetencia) {
		this.tipocompetencia = tipocompetencia;
	}

	public BigDecimal getOrdenfactor() {
		return ordenfactor;
	}

	public void setOrdenfactor(BigDecimal ordenfactor) {
		this.ordenfactor = ordenfactor;
	}

	public BigDecimal getOrdenplantilla() {
		return ordenplantilla;
	}

	public void setOrdenplantilla(BigDecimal ordenplantilla) {
		this.ordenplantilla = ordenplantilla;
	}
}
