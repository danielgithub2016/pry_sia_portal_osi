package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrCapacitacioneval
*/
public class HrCapacitacioneval extends DominioGenerico implements java.io.Serializable{

	private HrCapacitacionevalPk pk;
	private String estado;
	private String ultimousuario;
	private String ultimafechamodif;

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public String getUltimafechamodif() {
		return ultimafechamodif;
	}

	public void setUltimafechamodif(String ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}

	public HrCapacitacioneval() {
		pk = new HrCapacitacionevalPk();
	}

	public HrCapacitacionevalPk getPk() {
		return pk;
	}

	public void setPk(HrCapacitacionevalPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
