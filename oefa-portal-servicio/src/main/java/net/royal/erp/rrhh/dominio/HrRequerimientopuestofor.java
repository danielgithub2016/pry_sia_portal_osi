package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestofor
*/
public class HrRequerimientopuestofor extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestoforPk pk;
	private Integer secuencia;
	private String descripcion1;
	private String descripcion2;


	public HrRequerimientopuestofor() {
		pk = new HrRequerimientopuestoforPk();
	}

	public HrRequerimientopuestoforPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestoforPk pk) {
		this.pk = pk;
	}
	public Integer getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Integer secuencia) {
		this.secuencia = secuencia;
	}
	public String getDescripcion1() {
		return descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}
	public String getDescripcion2() {
		return descripcion2;
	}

	public void setDescripcion2(String descripcion2) {
		this.descripcion2 = descripcion2;
	}

}
