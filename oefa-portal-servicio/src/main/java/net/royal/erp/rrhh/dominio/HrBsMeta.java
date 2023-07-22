package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrBsMeta
*/
public class HrBsMeta extends DominioGenerico implements java.io.Serializable{

	private HrBsMetaPk pk;
	private String descripcion;
	private String comentario;
	private String motivodelcambio;
	private String estado;
	private Integer orden;


	public HrBsMeta() {
		pk = new HrBsMetaPk();
	}

	public HrBsMetaPk getPk() {
		return pk;
	}

	public void setPk(HrBsMetaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getMotivodelcambio() {
		return motivodelcambio;
	}

	public void setMotivodelcambio(String motivodelcambio) {
		this.motivodelcambio = motivodelcambio;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
