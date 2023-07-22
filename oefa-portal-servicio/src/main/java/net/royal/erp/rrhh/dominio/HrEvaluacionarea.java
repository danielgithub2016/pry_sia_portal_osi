package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionarea
*/
public class HrEvaluacionarea extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacionareaPk pk;
	private String descripcion;
	private Integer ponderacion;
	private String estado;
	private String tipoevaluacion;
	private Integer orden;


	public HrEvaluacionarea() {
		pk = new HrEvaluacionareaPk();
	}

	public HrEvaluacionareaPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionareaPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoevaluacion() {
		return tipoevaluacion;
	}

	public void setTipoevaluacion(String tipoevaluacion) {
		this.tipoevaluacion = tipoevaluacion;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
