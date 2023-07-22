package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrDetalleevaluacion
 */
public class HrDetalleevaluacionPk implements java.io.Serializable {

	private String companyowner;
	private Integer secuenciaeval;
	private Integer empleado;
	private Integer empleadoevaluador;
	private Integer secuencia;
	private String tipo;

	public HrDetalleevaluacionPk() {

	}

	public HrDetalleevaluacionPk(String companyowner, Integer secuenciaeval,
			Integer empleado, Integer empleadoevaluador, Integer secuencia,
			String tipo) {
		this.companyowner = companyowner;
		this.secuenciaeval = secuenciaeval;
		this.empleado = empleado;
		this.empleadoevaluador = empleadoevaluador;
		this.secuencia = secuencia;
		this.tipo = tipo;
	}

	public String getCompanyowner() {
		return companyowner;
	}

	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}

	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getEmpleadoevaluador() {
		return empleadoevaluador;
	}

	public void setEmpleadoevaluador(Integer empleadoevaluador) {
		this.empleadoevaluador = empleadoevaluador;
	}

	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
