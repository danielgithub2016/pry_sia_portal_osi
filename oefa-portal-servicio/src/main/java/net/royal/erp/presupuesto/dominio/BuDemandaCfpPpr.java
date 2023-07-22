package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuDemandaCfpPpr
*/
public class BuDemandaCfpPpr extends DominioGenerico implements java.io.Serializable{

	private BuDemandaCfpPprPk pk;
	private String metodo;
	private String nivel;


	public BuDemandaCfpPpr() {
		pk = new BuDemandaCfpPprPk();
	}

	public BuDemandaCfpPprPk getPk() {
		return pk;
	}

	public void setPk(BuDemandaCfpPprPk pk) {
		this.pk = pk;
	}
	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
