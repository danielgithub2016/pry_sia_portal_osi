package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadoexcepcion
 */
public class AsEmpleadoexcepcion extends DominioGenerico implements
		java.io.Serializable {

	private AsEmpleadoexcepcionPk pk;
	private String descripcion;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String sabado;
	private String domingo;
	private String estado;
	private String observaciones;
	private String claseexcepcion;
	private Integer horastempranas;
	private String clasehorario;

	public AsEmpleadoexcepcion() {
		pk = new AsEmpleadoexcepcionPk();
	}

	public AsEmpleadoexcepcionPk getPk() {
		return pk;
	}

	public void setPk(AsEmpleadoexcepcionPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLunes() {
		return lunes;
	}

	public void setLunes(String lunes) {
		this.lunes = lunes;
	}

	public String getMartes() {
		return martes;
	}

	public void setMartes(String martes) {
		this.martes = martes;
	}

	public String getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}

	public String getJueves() {
		return jueves;
	}

	public void setJueves(String jueves) {
		this.jueves = jueves;
	}

	public String getViernes() {
		return viernes;
	}

	public void setViernes(String viernes) {
		this.viernes = viernes;
	}

	public String getSabado() {
		return sabado;
	}

	public void setSabado(String sabado) {
		this.sabado = sabado;
	}

	public String getDomingo() {
		return domingo;
	}

	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getClaseexcepcion() {
		return claseexcepcion;
	}

	public void setClaseexcepcion(String claseexcepcion) {
		this.claseexcepcion = claseexcepcion;
	}

	public Integer getHorastempranas() {
		return horastempranas;
	}

	public void setHorastempranas(Integer horastempranas) {
		this.horastempranas = horastempranas;
	}

	public String getClasehorario() {
		return clasehorario;
	}

	public void setClasehorario(String clasehorario) {
		this.clasehorario = clasehorario;
	}

}
