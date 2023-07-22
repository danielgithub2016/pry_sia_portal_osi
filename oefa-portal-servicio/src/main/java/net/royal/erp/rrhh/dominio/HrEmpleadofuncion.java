package net.royal.erp.rrhh.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadofuncion
*/
@SuppressWarnings("serial")
public class HrEmpleadofuncion extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadofuncionPk pk;
	private String funcion;
	private BigDecimal alcanzado;
	private String comentarios;
	private BigDecimal calificacion;
	private Integer factorsecuencia;
	private BigDecimal factorparticipacion;
	private String eliminado;


	public HrEmpleadofuncion() {
		pk = new HrEmpleadofuncionPk();
	}


	public HrEmpleadofuncionPk getPk() {
		return pk;
	}


	public void setPk(HrEmpleadofuncionPk pk) {
		this.pk = pk;
	}


	public String getFuncion() {
		return funcion;
	}


	public void setFuncion(String funcion) {
		this.funcion = funcion;
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


	public BigDecimal getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}


	public Integer getFactorsecuencia() {
		return factorsecuencia;
	}


	public void setFactorsecuencia(Integer factorsecuencia) {
		this.factorsecuencia = factorsecuencia;
	}


	public BigDecimal getFactorparticipacion() {
		return factorparticipacion;
	}


	public void setFactorparticipacion(BigDecimal factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}


	public String getEliminado() {
		return eliminado;
	}


	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}


}
