package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestofun
*/
public class HrRequerimientopuestofun extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestofunPk pk;
	private String descripcion;


	public HrRequerimientopuestofun() {
		pk = new HrRequerimientopuestofunPk();
	}

	public HrRequerimientopuestofunPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestofunPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
