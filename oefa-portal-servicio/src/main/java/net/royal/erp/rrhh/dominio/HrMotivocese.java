package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrMotivocese
*/
public class HrMotivocese extends DominioGenerico implements java.io.Serializable{

	private HrMotivocesePk pk;
	private String descripcion;
	private String estado;
	private String codigortps;
	private String motivortps;


	public HrMotivocese() {
		pk = new HrMotivocesePk();
	}

	public HrMotivocesePk getPk() {
		return pk;
	}

	public void setPk(HrMotivocesePk pk) {
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
	public String getCodigortps() {
		return codigortps;
	}

	public void setCodigortps(String codigortps) {
		this.codigortps = codigortps;
	}
	public String getMotivortps() {
		return motivortps;
	}

	public void setMotivortps(String motivortps) {
		this.motivortps = motivortps;
	}

}
