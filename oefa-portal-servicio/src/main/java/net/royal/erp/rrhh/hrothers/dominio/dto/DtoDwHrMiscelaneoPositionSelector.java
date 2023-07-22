package net.royal.erp.rrhh.hrothers.dominio.dto;

import java.io.Serializable;

public class DtoDwHrMiscelaneoPositionSelector  implements Serializable {
	private String slebuscar;
	private String tipobusqueda;
	private Boolean boolseleccionados;
	
	public String getSlebuscar() {
		return slebuscar;
	}
	public String getTipobusqueda() {
		return tipobusqueda;
	}
	public void setSlebuscar(String slebuscar) {
		this.slebuscar = slebuscar;
	}
	public void setTipobusqueda(String tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}
	public Boolean getBoolseleccionados() {
		return boolseleccionados;
	}
	public void setBoolseleccionados(Boolean boolseleccionados) {
		this.boolseleccionados = boolseleccionados;
	}

}
