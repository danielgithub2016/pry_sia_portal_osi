package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEmpleadodesempeno
*/
public class HrEmpleadodesempeno extends DominioGenerico implements java.io.Serializable{

	private HrEmpleadodesempenoPk pk;
	private String tipo;
	private String descripcion;
	
	private String descripcionFoda;
	private String eliminado;


	public HrEmpleadodesempeno() {
		pk = new HrEmpleadodesempenoPk();
	}

	public HrEmpleadodesempenoPk getPk() {
		return pk;
	}

	public void setPk(HrEmpleadodesempenoPk pk) {
		this.pk = pk;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionFoda() {
		return descripcionFoda;
	}

	public void setDescripcionFoda(String descripcionFoda) {
		this.descripcionFoda = descripcionFoda;
	}

	public String getEliminado() {
		return eliminado;
	}

	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}

}
