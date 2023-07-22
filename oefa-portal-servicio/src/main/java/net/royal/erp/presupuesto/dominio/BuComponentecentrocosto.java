package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuComponentecentrocosto
*/
public class BuComponentecentrocosto extends DominioGenerico implements java.io.Serializable{

	private BuComponentecentrocostoPk pk;
	private String estado;


	public BuComponentecentrocosto() {
		pk = new BuComponentecentrocostoPk();
	}

	public BuComponentecentrocostoPk getPk() {
		return pk;
	}

	public void setPk(BuComponentecentrocostoPk pk) {
		this.pk = pk;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
