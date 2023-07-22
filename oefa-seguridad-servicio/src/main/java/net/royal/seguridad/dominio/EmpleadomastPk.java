package net.royal.seguridad.dominio;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Empleadomast
 */
public class EmpleadomastPk implements java.io.Serializable {

	private Integer empleado;
	private String companiasocio;

	public EmpleadomastPk() {
	}

	public EmpleadomastPk(Integer empleado) {
		this.empleado = empleado;
	}

	public EmpleadomastPk(String companiasocio, Integer empleado) {
		this.companiasocio = companiasocio;
		this.empleado = empleado;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

}
