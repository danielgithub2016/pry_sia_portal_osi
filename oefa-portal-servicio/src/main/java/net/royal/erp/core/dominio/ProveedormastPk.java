package net.royal.erp.core.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder core.Proveedormast
*/
public class ProveedormastPk implements java.io.Serializable{

	private Integer proveedor;

	public ProveedormastPk(){}
	
	public ProveedormastPk(Integer proveedor){
		this.proveedor=proveedor;
	}
	
	public Integer getProveedor() {
		return proveedor;
	}

	public void setProveedor(Integer proveedor) {
		this.proveedor = proveedor;
	}

}
