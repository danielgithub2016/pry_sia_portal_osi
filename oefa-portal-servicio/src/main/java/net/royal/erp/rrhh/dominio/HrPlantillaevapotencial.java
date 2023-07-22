package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPlantillaevapotencial
*/
public class HrPlantillaevapotencial extends DominioGenerico implements java.io.Serializable{

	private HrPlantillaevapotencialPk pk;


	public HrPlantillaevapotencial() {
		pk = new HrPlantillaevapotencialPk();
	}

	public HrPlantillaevapotencialPk getPk() {
		return pk;
	}

	public void setPk(HrPlantillaevapotencialPk pk) {
		this.pk = pk;
	}

}
