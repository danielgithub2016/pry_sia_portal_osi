package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestorelaciones
*/
public class HrPuestorelaciones extends DominioGenerico implements java.io.Serializable{

	private HrPuestorelacionesPk pk;
	private String enterelacionado;
	private String estado;


	public HrPuestorelaciones() {
		pk = new HrPuestorelacionesPk();
	}

	public HrPuestorelacionesPk getPk() {
		return pk;
	}

	public void setPk(HrPuestorelacionesPk pk) {
		this.pk = pk;
	}
	public String getEnterelacionado() {
		return enterelacionado;
	}

	public void setEnterelacionado(String enterelacionado) {
		this.enterelacionado = enterelacionado;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
