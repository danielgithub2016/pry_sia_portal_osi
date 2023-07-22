package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import net.royal.framework.web.core.UValidador;

public class DtoHrDetalleEvaluacionGrafico {
	private BigDecimal empleado;
	private BigDecimal secuencia;
	private String companyowner;
	private BigDecimal secuenciaeval;
	private BigDecimal factor;
	private String descripcion;
	private BigDecimal calificacion;
	private String unidadnegocio;
	private String tipo;
	private BigDecimal factorsecuencia;
	private String plantilla;
	private String descripcioncabezera;
	private BigDecimal areaponderacion;
	private BigDecimal factorponderacion;
	private BigDecimal factorparticipacion;
	private String area;
	private BigDecimal valorrequerido;
	private BigDecimal valorminimoesperado;
	private String descripcion2;
	private String tipocompetencia;
	private BigDecimal ordenfactor;
	private BigDecimal ordenplantilla;
	private BigDecimal valorcompetencia;
	private BigDecimal valorhastacompetencia;
	private BigDecimal minimovalor;
	private String desvalorrequerido;
	private String desvalorregistrado;
	private BigDecimal ordenplantilla1;
	private List<DtoHrDetalleEvaluacionGrafico>detallegrafico;
	private BigDecimal promediocategoria;
	
	private BigDecimal valorrequeridocolor;
	private BigDecimal calificacioncolor;
	private BigDecimal promediocategoriacolor;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getCalificacion() {
		if(!UValidador.esNulo(calificacion)){
			calificacion=calificacion.setScale(2,RoundingMode.HALF_UP);
		}
		
		return calificacion;
		
		
		
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
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
		if(!UValidador.esNulo(valorrequerido)){
			valorrequerido=valorrequerido.setScale(2,RoundingMode.HALF_UP);
		}
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

	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
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

	public BigDecimal getValorcompetencia() {
		return valorcompetencia;
	}

	public void setValorcompetencia(BigDecimal valorcompetencia) {
		this.valorcompetencia = valorcompetencia;
	}

	public BigDecimal getValorhastacompetencia() {
		return valorhastacompetencia;
	}

	public void setValorhastacompetencia(BigDecimal valorhastacompetencia) {
		this.valorhastacompetencia = valorhastacompetencia;
	}

	public BigDecimal getMinimovalor() {
		return minimovalor;
	}

	public void setMinimovalor(BigDecimal minimovalor) {
		this.minimovalor = minimovalor;
	}

	public String getDesvalorrequerido() {
		return desvalorrequerido;
	}

	public void setDesvalorrequerido(String desvalorrequerido) {
		this.desvalorrequerido = desvalorrequerido;
	}

	public String getDesvalorregistrado() {
		return desvalorregistrado;
	}

	public void setDesvalorregistrado(String desvalorregistrado) {
		this.desvalorregistrado = desvalorregistrado;
	}

	public BigDecimal getOrdenplantilla1() {
		return ordenplantilla1;
	}

	public void setOrdenplantilla1(BigDecimal ordenplantilla1) {
		this.ordenplantilla1 = ordenplantilla1;
	}

	public List<DtoHrDetalleEvaluacionGrafico> getDetallegrafico() {
		return detallegrafico;
	}

	public void setDetallegrafico(List<DtoHrDetalleEvaluacionGrafico> detallegrafico) {
		this.detallegrafico = detallegrafico;
	}

	public String getDescripcioncabezera() {
		return descripcioncabezera;
	}

	public void setDescripcioncabezera(String descripcioncabezera) {
		this.descripcioncabezera = descripcioncabezera;
	}

	public BigDecimal getValorrequeridocolor() {
		if(!UValidador.esNulo(valorrequerido)){
			valorrequeridocolor=valorrequerido.multiply(new BigDecimal(20));
		}
		return valorrequeridocolor;
	}

	public void setValorrequeridocolor(BigDecimal valorrequeridocolor) {
		this.valorrequeridocolor = valorrequeridocolor;
	}

	public BigDecimal getPromediocategoriacolor() {
		return promediocategoriacolor;
	}

	public void setPromediocategoriacolor(BigDecimal promediocategoriacolor) {
		this.promediocategoriacolor = promediocategoriacolor;
	}

	public BigDecimal getCalificacioncolor() {
		return calificacioncolor;
	}

	public void setCalificacioncolor(BigDecimal calificacioncolor) {
		this.calificacioncolor = calificacioncolor;
	}

	public BigDecimal getPromediocategoria() {
		return promediocategoria;
	}

	public void setPromediocategoria(BigDecimal promediocategoria) {
		this.promediocategoria = promediocategoria;
	}
}
