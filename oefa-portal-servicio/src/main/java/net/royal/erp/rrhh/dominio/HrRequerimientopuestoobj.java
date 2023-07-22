package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestoobj
*/
public class HrRequerimientopuestoobj extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestoobjPk pk;
	private String descripcion;


	public HrRequerimientopuestoobj() {
		pk = new HrRequerimientopuestoobjPk();
	}

	public HrRequerimientopuestoobjPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestoobjPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
