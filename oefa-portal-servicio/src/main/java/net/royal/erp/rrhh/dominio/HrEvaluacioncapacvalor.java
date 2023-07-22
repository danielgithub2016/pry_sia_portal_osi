package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluacioncapacvalor
*/
public class HrEvaluacioncapacvalor extends DominioGenerico implements java.io.Serializable{

	private HrEvaluacioncapacvalorPk pk;
	private Integer valor;
	private String descripcion;
	private String estado;
	private String flagaprobado;


	public HrEvaluacioncapacvalor() {
		pk = new HrEvaluacioncapacvalorPk();
	}

	public HrEvaluacioncapacvalorPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacioncapacvalorPk pk) {
		this.pk = pk;
	}
	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
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
	public String getFlagaprobado() {
		return flagaprobado;
	}

	public void setFlagaprobado(String flagaprobado) {
		this.flagaprobado = flagaprobado;
	}

}
