package net.royal.erp.planilla.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrCalendarioferiados
*/
public class PrCalendarioferiadosPk implements java.io.Serializable{

	private String fechamesdia;
	private String allsucursal;
	private String sucursal;

	public String getFechamesdia() {
		return fechamesdia;
	}

	public void setFechamesdia(String fechamesdia) {
		this.fechamesdia = fechamesdia;
	}

	public String getAllsucursal() {
		return allsucursal;
	}

	public void setAllsucursal(String allsucursal) {
		this.allsucursal = allsucursal;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

}
