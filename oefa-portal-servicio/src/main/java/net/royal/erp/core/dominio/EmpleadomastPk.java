package net.royal.erp.core.dominio;


/**
 *
 * @author desarrollo
 * @powerbuilder core.Empleadomast
*/
public class EmpleadomastPk implements java.io.Serializable{

	private Integer empleado;
	private String companiasocio;
	
	public EmpleadomastPk(){
	}

	public EmpleadomastPk(Integer empleado, String companiasocio) {
		super();
		this.empleado = empleado;
		this.companiasocio = companiasocio;
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
