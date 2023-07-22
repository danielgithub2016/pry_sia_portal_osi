package net.royal.erp.planilla.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrProcesoperiodo
*/
public class PrProcesoperiodoPk implements java.io.Serializable{

	private String companiasocio;
	private String periodo;
	private String tipoplanilla;
	private String tipoproceso;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}
	public String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

}
