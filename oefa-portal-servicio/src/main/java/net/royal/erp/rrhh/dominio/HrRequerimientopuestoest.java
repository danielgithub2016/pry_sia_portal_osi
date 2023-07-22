package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrRequerimientopuestoest
*/
public class HrRequerimientopuestoest extends DominioGenerico implements java.io.Serializable{

	private HrRequerimientopuestoestPk pk;
	private String informatica;
	private String nivel;


	public HrRequerimientopuestoest() {
		pk = new HrRequerimientopuestoestPk();
	}

	public HrRequerimientopuestoestPk getPk() {
		return pk;
	}

	public void setPk(HrRequerimientopuestoestPk pk) {
		this.pk = pk;
	}
	public String getInformatica() {
		return informatica;
	}

	public void setInformatica(String informatica) {
		this.informatica = informatica;
	}
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
