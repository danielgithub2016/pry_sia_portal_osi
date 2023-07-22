package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadChecklist
*/
public class HrActividadChecklist extends DominioGenerico implements java.io.Serializable{

	private HrActividadChecklistPk pk;
	private String concepto;
	private Integer cantidad;
	private Integer responsable;
	private String observaciones;
	private String estado;


	public HrActividadChecklist() {
		pk = new HrActividadChecklistPk();
	}

	public HrActividadChecklistPk getPk() {
		return pk;
	}

	public void setPk(HrActividadChecklistPk pk) {
		this.pk = pk;
	}
	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getResponsable() {
		return responsable;
	}

	public void setResponsable(Integer responsable) {
		this.responsable = responsable;
	}
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
