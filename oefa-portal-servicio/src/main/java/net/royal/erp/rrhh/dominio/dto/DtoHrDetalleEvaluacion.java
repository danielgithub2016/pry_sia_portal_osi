package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import net.royal.framework.web.core.UValidador;

public class DtoHrDetalleEvaluacion {
	private String companyowner;
	private BigDecimal secuenciaeval;
	private BigDecimal empleado;
	private BigDecimal empleadoevaluador;
	private BigDecimal secuencia;
	private String tipo;
	private BigDecimal factor;
	private BigDecimal calificacion;
	private String explicacionfactor;
	private String factor_des;
	private BigDecimal cf_suma;
	private BigDecimal cf_cuenta;
	private String plantilla;
	private BigDecimal factorponderacion;
	private BigDecimal factorcompetencia;
	private BigDecimal secuenciacompetencia;
	private BigDecimal valorcompetencia;
	private BigDecimal valorhastacompetencia;
	private BigDecimal ordenfactor;
	private BigDecimal ordenplantilla;
	private String area;
	private String competencias;
	private BigDecimal cantevaluaciones;
	private Date fechaingreso;
	private String calificacionBoolean;
	
	/**
	 * @return the cantevaluaciones
	 */
	public BigDecimal getCantevaluaciones() {
		return cantevaluaciones;
	}

	/**
	 * @param cantevaluaciones the cantevaluaciones to set
	 */
	public void setCantevaluaciones(BigDecimal cantevaluaciones) {
		this.cantevaluaciones = cantevaluaciones;
	}

	/**
	 * @return the competencias
	 */
	public String getCompetencias() {
		return competencias;
	}

	/**
	 * @param competencias the competencias to set
	 */
	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	private List<DtoHrDetalleEvaluacion>detalle;

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

	public BigDecimal getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(BigDecimal empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		if(!UValidador.esNulo(calificacion)){
			calificacion=calificacion.setScale(0,RoundingMode.HALF_DOWN);
		}
		
		this.calificacion = calificacion;
	}
	

	public String getExplicacionfactor() {
		return explicacionfactor;
	}

	public void setExplicacionfactor(String explicacionfactor) {
		this.explicacionfactor = explicacionfactor;
	}

	public String getFactor_des() {
		return factor_des;
	}

	public void setFactor_des(String factor_des) {
		this.factor_des = factor_des;
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

	public BigDecimal getFactorcompetencia() {
		return factorcompetencia;
	}

	public void setFactorcompetencia(BigDecimal factorcompetencia) {
		this.factorcompetencia = factorcompetencia;
	}

	public BigDecimal getSecuenciacompetencia() {
		return secuenciacompetencia;
	}

	public void setSecuenciacompetencia(BigDecimal secuenciacompetencia) {
		this.secuenciacompetencia = secuenciacompetencia;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<DtoHrDetalleEvaluacion> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DtoHrDetalleEvaluacion> detalle) {
		this.detalle = detalle;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getCalificacionBoolean() {
		if(!UValidador.esNulo(calificacion)){
			if(calificacion.compareTo(new BigDecimal(0))==1){
				calificacionBoolean="Calificado";
			}else{
				calificacionBoolean="";
			}
			
		}
		return calificacionBoolean;
	}

	public void setCalificacionBoolean(String calificacionBoolean) {
		this.calificacionBoolean = calificacionBoolean;
	}



}
