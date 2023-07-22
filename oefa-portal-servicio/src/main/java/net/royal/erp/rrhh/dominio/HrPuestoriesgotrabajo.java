package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoriesgotrabajo
*/
public class HrPuestoriesgotrabajo extends DominioGenerico implements java.io.Serializable{

	private HrPuestoriesgotrabajoPk pk;
	private String tiporiesgo;
	private String riesgo;
	private String estado;
	private String auxDescripcionlocal;


	public HrPuestoriesgotrabajo() {
		pk = new HrPuestoriesgotrabajoPk();
	}

	public HrPuestoriesgotrabajoPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoriesgotrabajoPk pk) {
		this.pk = pk;
	}
	public String getTiporiesgo() {
		return tiporiesgo;
	}

	public void setTiporiesgo(String tiporiesgo) {
		this.tiporiesgo = tiporiesgo;
	}
	public String getRiesgo() {
		return riesgo;
	}

	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAuxDescripcionlocal() {
		return auxDescripcionlocal;
	}

	public void setAuxDescripcionlocal(String auxDescripcionlocal) {
		this.auxDescripcionlocal = auxDescripcionlocal;
	}

}
