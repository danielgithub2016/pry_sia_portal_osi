package net.royal.erp.presupuesto.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder presupuesto.BuControlpresupuestalSummary
*/
public class BuControlpresupuestalSummary extends DominioGenerico implements java.io.Serializable{

	private BuControlpresupuestalSummaryPk pk;
	private String centrocosto;
	private java.util.Date fechatransaccion;
	private String accion;
	private String comentario;


	public BuControlpresupuestalSummary() {
		pk = new BuControlpresupuestalSummaryPk();
	}

	public BuControlpresupuestalSummaryPk getPk() {
		return pk;
	}

	public void setPk(BuControlpresupuestalSummaryPk pk) {
		this.pk = pk;
	}
	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}
	public java.util.Date getFechatransaccion() {
		return fechatransaccion;
	}

	public void setFechatransaccion(java.util.Date fechatransaccion) {
		this.fechatransaccion = fechatransaccion;
	}
	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
