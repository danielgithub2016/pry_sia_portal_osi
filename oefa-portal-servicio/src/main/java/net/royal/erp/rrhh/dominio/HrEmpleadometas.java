package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadometas
 */
public class HrEmpleadometas extends DominioGenerico implements
		java.io.Serializable {

	private HrEmpleadometasPk pk;
	private String periodo;
	private String descripcion;
	private Integer secuenciaevalpos;
	private BigDecimal alcanzado;
	private String comentarios;
	private Integer factorsecuencia;
	private BigDecimal calificacion;
	private BigDecimal factorparticipacion;
	private String plazo;
	
	private BigDecimal calificacionAnt;

	public HrEmpleadometas() {
		pk = new HrEmpleadometasPk();
	}

	// atributo auxiliar para validar si esta eliminado
	private String eliminado;

	public HrEmpleadometasPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadometasPk pk) {
		this.pk = pk;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getSecuenciaevalpos() {
		return secuenciaevalpos;
	}

	public void setSecuenciaevalpos(Integer secuenciaevalpos) {
		this.secuenciaevalpos = secuenciaevalpos;
	}

	public BigDecimal getAlcanzado() {
		return alcanzado;
	}

	public void setAlcanzado(BigDecimal alcanzado) {
		this.alcanzado = alcanzado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getFactorsecuencia() {
		return factorsecuencia;
	}

	public void setFactorsecuencia(Integer factorsecuencia) {
		this.factorsecuencia = factorsecuencia;
	}

	public BigDecimal getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public BigDecimal getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(BigDecimal factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

	public BigDecimal getCalificacionAnt() {
		return calificacionAnt;
	}

	public void setCalificacionAnt(BigDecimal calificacionAnt) {
		this.calificacionAnt = calificacionAnt;
	}

}
