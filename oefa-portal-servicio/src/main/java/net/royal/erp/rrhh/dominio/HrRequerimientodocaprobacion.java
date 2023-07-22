package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientodocaprobacion
*/
public class HrRequerimientodocaprobacion extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientodocaprobacionPk pk;
	private Integer idgrupoaprobacion;
	private Integer responsable;
	private Integer indicadoraprobacion;
	private java.util.Date fechaaprobacion;
	private String comentario;
	private String estado;
	private String usuariocreacion;
	private java.util.Date fechacreacion;
	private String usuariomodificacion;
	private java.util.Date fechamodificacion;


	public HrRequerimientodocaprobacion() {
		pk = new HrRequerimientodocaprobacionPk();
	}

	public HrRequerimientodocaprobacionPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientodocaprobacionPk pk) {
		this.pk = pk;
	}
	public Integer getIdgrupoaprobacion() {
		return idgrupoaprobacion;
	}

	public void setIdgrupoaprobacion(Integer idgrupoaprobacion) {
		this.idgrupoaprobacion = idgrupoaprobacion;
	}
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}
	public Integer getIndicadoraprobacion() {
		return indicadoraprobacion;
	}

	public void setIndicadoraprobacion(Integer indicadoraprobacion) {
		this.indicadoraprobacion = indicadoraprobacion;
	}
	public java.util.Date getFechaaprobacion() {
		return fechaaprobacion;
	}

	public void setFechaaprobacion(java.util.Date fechaaprobacion) {
		this.fechaaprobacion = fechaaprobacion;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuariocreacion() {
		return usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}
	public java.util.Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(java.util.Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	public String getUsuariomodificacion() {
		return usuariomodificacion;
	}

	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}
	public java.util.Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(java.util.Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

}
