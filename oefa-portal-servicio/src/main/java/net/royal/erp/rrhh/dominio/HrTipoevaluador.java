package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrTipoevaluador
*/
public class HrTipoevaluador extends DominioGenerico implements java.io.Serializable{

	private HrTipoevaluadorPk pk;
	private String descripcion;
	private String estado;
	private Integer orden;


	public HrTipoevaluador() {
		pk = new HrTipoevaluadorPk();
	}

	public HrTipoevaluadorPk getPk() {
		return pk;
	}

	public void setPk(HrTipoevaluadorPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
