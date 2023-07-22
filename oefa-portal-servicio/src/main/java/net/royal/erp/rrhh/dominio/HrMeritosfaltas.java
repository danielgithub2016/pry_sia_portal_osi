package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrMeritosfaltas
*/
public class HrMeritosfaltas extends DominioGenerico implements java.io.Serializable{

	private HrMeritosfaltasPk pk;
	private String periodo;
	private String descripcion;
	private java.util.Date fecha;
	private Integer responsable;
	private String unidadnegocio;
	private String unidadreplicacion;
	private String clasificacion;
	private String documento;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String flagsoloenevaluacion;
	private Integer diassuspension;
	private String tipofalta;
	private String medidadisciplinaria;
	private String rutadocumento;
	private byte[] ruta;


	public HrMeritosfaltas() {
		pk = new HrMeritosfaltasPk();
	}

	public HrMeritosfaltasPk getPk() {
		return pk;
	}

	public void setPk(HrMeritosfaltasPk pk) {
		this.pk = pk;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}
	public String getUnidadnegocio() {
		return unidadnegocio;
	}

	public void setUnidadnegocio(String unidadnegocio) {
		this.unidadnegocio = unidadnegocio;
	}
	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}
	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public java.util.Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}
	public String getFlagsoloenevaluacion() {
		return flagsoloenevaluacion;
	}

	public void setFlagsoloenevaluacion(String flagsoloenevaluacion) {
		this.flagsoloenevaluacion = flagsoloenevaluacion;
	}
	public Integer getDiassuspension() {
		return diassuspension;
	}

	public void setDiassuspension(Integer diassuspension) {
		this.diassuspension = diassuspension;
	}
	public String getTipofalta() {
		return tipofalta;
	}

	public void setTipofalta(String tipofalta) {
		this.tipofalta = tipofalta;
	}
	public String getMedidadisciplinaria() {
		return medidadisciplinaria;
	}

	public void setMedidadisciplinaria(String medidadisciplinaria) {
		this.medidadisciplinaria = medidadisciplinaria;
	}
	public String getRutadocumento() {
		return rutadocumento;
	}

	public void setRutadocumento(String rutadocumento) {
		this.rutadocumento = rutadocumento;
	}
	public byte[] getRuta() {
		return ruta;
	}

	public void setRuta(byte[] ruta) {
		this.ruta = ruta;
	}

}
