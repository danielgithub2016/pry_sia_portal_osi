package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacionperiodovalor
*/
public class HrEvaluacionperiodovalor extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacionperiodovalorPk pk;
	private String descripcion;
	private String explicacion;
	private java.math.BigDecimal valor;
	private String explicacion2;


	public HrEvaluacionperiodovalor() {
		pk = new HrEvaluacionperiodovalorPk();
	}

	public HrEvaluacionperiodovalorPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionperiodovalorPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getExplicacion() {
		return explicacion;
	}

	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public java.math.BigDecimal getValor() {
		return valor;
	}

	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}
	public String getExplicacion2() {
		return explicacion2;
	}

	public void setExplicacion2(String explicacion2) {
		this.explicacion2 = explicacion2;
	}

}
