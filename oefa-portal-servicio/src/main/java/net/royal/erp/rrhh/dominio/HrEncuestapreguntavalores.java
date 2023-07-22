package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestapreguntavalores
*/
public class HrEncuestapreguntavalores extends DominioGenerico implements java.io.Serializable{

	private HrEncuestapreguntavaloresPk pk;
	private String descripcion;
	private String calificacion;

	public HrEncuestapreguntavalores() {
		pk = new HrEncuestapreguntavaloresPk();
	}

	public HrEncuestapreguntavaloresPk getPk() {
		return pk;
	}

	public void setPk(HrEncuestapreguntavaloresPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

}
