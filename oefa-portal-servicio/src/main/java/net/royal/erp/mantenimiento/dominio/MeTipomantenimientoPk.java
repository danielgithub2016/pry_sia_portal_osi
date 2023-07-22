package net.royal.erp.mantenimiento.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder mantenimiento.MeTipomantenimiento
*/
public class MeTipomantenimientoPk implements java.io.Serializable{

	private String tipomantenimiento;
	private String tipomantenimientogrupo;

	public String getTipomantenimiento() {
		return tipomantenimiento;
	}

	public void setTipomantenimiento(String tipomantenimiento) {
		this.tipomantenimiento = tipomantenimiento;
	}
	public String getTipomantenimientogrupo() {
		return tipomantenimientogrupo;
	}

	public void setTipomantenimientogrupo(String tipomantenimientogrupo) {
		this.tipomantenimientogrupo = tipomantenimientogrupo;
	}

}
