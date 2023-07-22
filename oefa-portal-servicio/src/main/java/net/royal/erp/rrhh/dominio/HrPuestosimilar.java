package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestosimilar
*/
public class HrPuestosimilar extends DominioGenerico implements java.io.Serializable{

	private HrPuestosimilarPk pk;
	private String estado;


	public HrPuestosimilar() {
		pk = new HrPuestosimilarPk();
	}

	public HrPuestosimilarPk getPk() {
		return pk;
	}

	public void setPk(HrPuestosimilarPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
