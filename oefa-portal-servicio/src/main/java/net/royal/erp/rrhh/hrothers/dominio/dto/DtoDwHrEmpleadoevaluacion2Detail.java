package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The Data Transfer Object DtoDwHrEmpleadoevaluacion2Detail.
 * @author nunezh
 * @powerbuilder mapero de hrothers.dw_hr_empleadoevaluacion_2_detail
 */
@SuppressWarnings("serial")
public class DtoDwHrEmpleadoevaluacion2Detail implements Serializable {
	private String companyowner;
	private BigDecimal secuenciaeval;
	private BigDecimal empleado;
	private BigDecimal empleadoevaluador;
	private BigDecimal secuencia;
	private String tipo;
	private BigDecimal factor;
	/** hr_detalleevaluacion.descripcion. */
	private String descripcion_deta;
	private BigDecimal calificacion;
	private String unidadnegocio;
	private String ultimousuario;
	private Date ultimafechamodif;
	private BigDecimal ordenfactor;
	private BigDecimal factorsecuencia;
	private String plantilla;
	/** hr_evaluacionarea.descripcion. */
	private String descripcion_eva;
	private BigDecimal areaponderacion;
	private BigDecimal factorponderacion;
	private BigDecimal factorparticipacion;
	private String area;
	private String comentarios;
	private String tipocompetencia;
	
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
	public String getDescripcion_deta() {
		return descripcion_deta;
	}
	public void setDescripcion_deta(String descripcion_deta) {
		this.descripcion_deta = descripcion_deta;
	}
	public BigDecimal getCalificacion() {
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
	public String getUltimousuario() {
		return ultimousuario;
	}
	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}
	public Date getUltimafechamodif() {
		return ultimafechamodif;
	}
	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}
	public BigDecimal getOrdenfactor() {
		return ordenfactor;
	}
	public void setOrdenfactor(BigDecimal ordenfactor) {
		this.ordenfactor = ordenfactor;
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
	public String getDescripcion_eva() {
		return descripcion_eva;
	}
	public void setDescripcion_eva(String descripcion_eva) {
		this.descripcion_eva = descripcion_eva;
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
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getTipocompetencia() {
		return tipocompetencia;
	}
	public void setTipocompetencia(String tipocompetencia) {
		this.tipocompetencia = tipocompetencia;
	}
	
	
}
