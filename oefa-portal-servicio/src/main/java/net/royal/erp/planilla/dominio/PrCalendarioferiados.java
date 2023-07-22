package net.royal.erp.planilla.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrCalendarioferiados
*/
public class PrCalendarioferiados extends DominioGenerico implements java.io.Serializable{

	private PrCalendarioferiadosPk pk;
	private String descripcion;
	private String feriadocompletoflag;
	private java.math.BigDecimal topediascompensar;
	private String flagcompensable;
	private String estado;


	public PrCalendarioferiados() {
		pk = new PrCalendarioferiadosPk();
	}

	public PrCalendarioferiadosPk getPk() {
		return pk;
	}

	public void setPk(PrCalendarioferiadosPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFeriadocompletoflag() {
		return feriadocompletoflag;
	}

	public void setFeriadocompletoflag(String feriadocompletoflag) {
		this.feriadocompletoflag = feriadocompletoflag;
	}
	public java.math.BigDecimal getTopediascompensar() {
		return topediascompensar;
	}

	public void setTopediascompensar(java.math.BigDecimal topediascompensar) {
		this.topediascompensar = topediascompensar;
	}
	public String getFlagcompensable() {
		return flagcompensable;
	}

	public void setFlagcompensable(String flagcompensable) {
		this.flagcompensable = flagcompensable;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
