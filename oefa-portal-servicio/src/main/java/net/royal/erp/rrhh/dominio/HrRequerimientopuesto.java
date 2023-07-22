package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuesto
*/
public class HrRequerimientopuesto extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestoPk pk;
	private String descripcion;
	private String area;
	private java.util.Date fecha;
	private String comentarios;
	private String categoriafuncional;


	public HrRequerimientopuesto() {
		pk = new HrRequerimientopuestoPk();
	}

	public HrRequerimientopuestoPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestoPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getCategoriafuncional() {
		return categoriafuncional;
	}

	public void setCategoriafuncional(String categoriafuncional) {
		this.categoriafuncional = categoriafuncional;
	}

}
