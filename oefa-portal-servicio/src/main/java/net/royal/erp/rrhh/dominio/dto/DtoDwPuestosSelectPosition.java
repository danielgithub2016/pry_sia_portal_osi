package net.royal.erp.rrhh.dominio.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoDwPuestosSelectPosition implements Serializable {
	private String sleBuscar;
	private String tipobusqueda;
	
	public String getSleBuscar() {
		return sleBuscar;
	}
	public String getTipobusqueda() {
		return tipobusqueda;
	}
	public void setSleBuscar(String sleBuscar) {
		this.sleBuscar = sleBuscar;
	}
	public void setTipobusqueda(String tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}

}
