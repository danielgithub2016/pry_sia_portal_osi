package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientofuncasdet
*/
public class HrRequerimientofuncasdet extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientofuncasdetPk pk;
	private String funciondescripcion;


	public HrRequerimientofuncasdet() {
		pk = new HrRequerimientofuncasdetPk();
	}

	public HrRequerimientofuncasdetPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientofuncasdetPk pk) {
		this.pk = pk;
	}
	public String getFunciondescripcion() {
		return funciondescripcion;
	}

	public void setFunciondescripcion(String funciondescripcion) {
		this.funciondescripcion = funciondescripcion;
	}

}
