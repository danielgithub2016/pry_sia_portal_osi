package net.royal.erp.rrhh.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadofuncion
*/
public class HrEmpleadofuncionPk implements java.io.Serializable{

	private String companyowner;
	private Integer secuenciaeval;
	private Integer empleado;
	private Integer empleadoevaluador;
	private Integer secuencia;

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

}
