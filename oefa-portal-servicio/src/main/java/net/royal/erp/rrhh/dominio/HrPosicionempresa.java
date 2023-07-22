package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPosicionempresa
*/
public class HrPosicionempresa extends DominioGenerico implements java.io.Serializable{

	private HrPosicionempresaPk pk;
	private Integer codigotipo;
	private String descripcion;
	private String descripcioningles;
	private String flagstaff;
	private String centrocostos;
	private String comentarios;
	private String estado;
	private String unidadreplicacion;
	private String unidadoperativa;
	private Integer orden;
	private String responsibleRrhh;
	private String department;
	private Integer codigoposicionsuperior;


	public HrPosicionempresa() {
		pk = new HrPosicionempresaPk();
	}

	public HrPosicionempresaPk getPk() {
		return pk;
	}

	public void setPk(HrPosicionempresaPk pk) {
		this.pk = pk;
	}
	public Integer getCodigotipo() {
		return codigotipo;
	}

	public void setCodigotipo(Integer codigotipo) {
		this.codigotipo = codigotipo;
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
	public String getFlagstaff() {
		return flagstaff;
	}

	public void setFlagstaff(String flagstaff) {
		this.flagstaff = flagstaff;
	}
	public String getCentrocostos() {
		return centrocostos;
	}

	public void setCentrocostos(String centrocostos) {
		this.centrocostos = centrocostos;
	}
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getUnidadoperativa() {
		return unidadoperativa;
	}

	public void setUnidadoperativa(String unidadoperativa) {
		this.unidadoperativa = unidadoperativa;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getResponsibleRrhh() {
		return responsibleRrhh;
	}

	public void setResponsibleRrhh(String responsibleRrhh) {
		this.responsibleRrhh = responsibleRrhh;
	}
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getCodigoposicionsuperior() {
		return codigoposicionsuperior;
	}

	public void setCodigoposicionsuperior(Integer codigoposicionsuperior) {
		this.codigoposicionsuperior = codigoposicionsuperior;
	}

}
