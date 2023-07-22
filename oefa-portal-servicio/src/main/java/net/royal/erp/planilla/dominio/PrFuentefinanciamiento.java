package net.royal.erp.planilla.dominio;

import java.io.Serializable;

import net.royal.framework.web.dominio.DominioGenerico;

public class PrFuentefinanciamiento extends DominioGenerico implements Serializable {
	private PrFuentefinanciamientoPk pk;
	private String descripcion;
	private String estado;

	public PrFuentefinanciamiento() {
		this.pk = new PrFuentefinanciamientoPk();
	}

	public PrFuentefinanciamientoPk getPk() {
		return pk;
	}

	public void setPk(PrFuentefinanciamientoPk pk) {
		this.pk = pk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
