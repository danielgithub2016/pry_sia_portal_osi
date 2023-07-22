package net.royal.erp.planilla.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder planilla.PrVacacionesprogramadas
 */
public class PrVacacionesprogramadas extends DominioGenerico implements java.io.Serializable {

	private PrVacacionesprogramadasPk pk;
	private String periodoasistencia;
	private Integer diaspago;
	private java.util.Date fechainicio;
	private java.util.Date fechafin;
	private String observacion;
	private String observacionorigen;
	private Integer anovacacion;
	private String tipoutilizacion;
	private String estadoutilizacion;
	private String estado;

	public PrVacacionesprogramadas() {
		pk = new PrVacacionesprogramadasPk();
	}

	public PrVacacionesprogramadasPk getPk() {
		return pk;
	}

	public void setPk(PrVacacionesprogramadasPk pk) {
		this.pk = pk;
	}

	public String getPeriodoasistencia() {
		return periodoasistencia;
	}

	public void setPeriodoasistencia(String periodoasistencia) {
		this.periodoasistencia = periodoasistencia;
	}

	public Integer getDiaspago() {
		return diaspago;
	}

	public void setDiaspago(Integer diaspago) {
		this.diaspago = diaspago;
	}

	public java.util.Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(java.util.Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public java.util.Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(java.util.Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getAnovacacion() {
		return anovacacion;
	}

	public void setAnovacacion(Integer anovacacion) {
		this.anovacacion = anovacacion;
	}

	public String getTipoutilizacion() {
		return tipoutilizacion;
	}

	public void setTipoutilizacion(String tipoutilizacion) {
		this.tipoutilizacion = tipoutilizacion;
	}

	public String getEstadoutilizacion() {
		return estadoutilizacion;
	}

	public void setEstadoutilizacion(String estadoutilizacion) {
		this.estadoutilizacion = estadoutilizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacionorigen() {
		return observacionorigen;
	}

	public void setObservacionorigen(String observacionorigen) {
		this.observacionorigen = observacionorigen;
	}

}
