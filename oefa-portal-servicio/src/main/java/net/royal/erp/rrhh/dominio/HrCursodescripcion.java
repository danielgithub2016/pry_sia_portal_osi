package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCursodescripcion
*/
public class HrCursodescripcion extends DominioGenerico implements java.io.Serializable{

	private HrCursodescripcionPk pk;
	private String descripcion;
	private String descripcioningles;
	private String tipo;
	private String unidadnegocio;
	private String nivelacademico;
	private String area;
	private String carrera;
	private Integer costoestimado;
	private String estado;
	private String monedacosto;
	private String commodity;
	private String pertenecea;


	public HrCursodescripcion() {
		pk = new HrCursodescripcionPk();
	}

	public HrCursodescripcionPk getPk() {
		return pk;
	}

	public void setPk(HrCursodescripcionPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcioningles() {
		return descripcioningles;
	}

	public void setDescripcioningles(String descripcioningles) {
		this.descripcioningles = descripcioningles;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getNivelacademico() {
		return nivelacademico;
	}

	public void setNivelacademico(String nivelacademico) {
		this.nivelacademico = nivelacademico;
	}
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public Integer getCostoestimado() {
		return costoestimado;
	}

	public void setCostoestimado(Integer costoestimado) {
		this.costoestimado = costoestimado;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMonedacosto() {
		return monedacosto;
	}

	public void setMonedacosto(String monedacosto) {
		this.monedacosto = monedacosto;
	}
	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getPertenecea() {
		return pertenecea;
	}

	public void setPertenecea(String pertenecea) {
		this.pertenecea = pertenecea;
	}

}
