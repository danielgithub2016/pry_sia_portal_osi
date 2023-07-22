package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrActividadbeneficiario
*/
public class HrActividadbeneficiario extends DominioGenerico implements java.io.Serializable{

	private HrActividadbeneficiarioPk pk;


	public HrActividadbeneficiario() {
		pk = new HrActividadbeneficiarioPk();
	}

	public HrActividadbeneficiarioPk getPk() {
		return pk;
	}

	public void setPk(HrActividadbeneficiarioPk pk) {
		this.pk = pk;
	}

}
