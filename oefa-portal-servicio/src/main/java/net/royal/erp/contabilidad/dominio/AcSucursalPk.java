package net.royal.erp.contabilidad.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

public class AcSucursalPk extends DominioGenerico implements java.io.Serializable {

	private String sucursal;

	public AcSucursalPk(){
		
	}
	
	public AcSucursalPk(String sucursal) {
		super();
		this.sucursal = sucursal;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
}
