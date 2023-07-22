package net.royal.erp.rrhh.dominio;

import java.io.Serializable;

import net.royal.framework.web.dominio.DominioGenerico;

public class HrEvaluacionetapa extends DominioGenerico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HrEvaluacionetapaPk pk;
	private String estado;
	private String flagincorporacion;
	private String observaciones;
	private String observacionfinetapa;

	public HrEvaluacionetapaPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluacionetapaPk pk) {
		this.pk = pk;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlagincorporacion() {
		return flagincorporacion;
	}

	public void setFlagincorporacion(String flagincorporacion) {
		this.flagincorporacion = flagincorporacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservacionfinetapa() {
		return observacionfinetapa;
	}

	public void setObservacionfinetapa(String observacionfinetapa) {
		this.observacionfinetapa = observacionfinetapa;
	}

}
