package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsPeriodo
 */
public class AsPeriodo extends DominioGenerico implements java.io.Serializable {

	private AsPeriodoPk pk;
	private java.util.Date fechadesde;
	private String tipo;
	private java.util.Date fechahasta;
	private String nombre;
	private String estado;
	private String periodoplanilla;
	private String tipoplanilla;
	private String tipoproceso;
	private String flagtipoproceso;
	private java.util.Date fechadesdertps;
	private java.util.Date fechahastartps;
	private String flagingresoautorizaciones;
	private String estadoprog;

	public AsPeriodo() {
		pk = new AsPeriodoPk();
	}

	public AsPeriodoPk getPk() {
		return pk;
	}

	public void setPk(AsPeriodoPk pk) {
		this.pk = pk;
	}

	public java.util.Date getFechadesde() {
		return fechadesde;
	}

	public void setFechadesde(java.util.Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public java.util.Date getFechahasta() {
		return fechahasta;
	}

	public void setFechahasta(java.util.Date fechahasta) {
		this.fechahasta = fechahasta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPeriodoplanilla() {
		return periodoplanilla;
	}

	public void setPeriodoplanilla(String periodoplanilla) {
		this.periodoplanilla = periodoplanilla;
	}

	public String getTipoplanilla() {
		return tipoplanilla;
	}

	public void setTipoplanilla(String tipoplanilla) {
		this.tipoplanilla = tipoplanilla;
	}

	public String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	public String getFlagtipoproceso() {
		return flagtipoproceso;
	}

	public void setFlagtipoproceso(String flagtipoproceso) {
		this.flagtipoproceso = flagtipoproceso;
	}

	public java.util.Date getFechadesdertps() {
		return fechadesdertps;
	}

	public void setFechadesdertps(java.util.Date fechadesdertps) {
		this.fechadesdertps = fechadesdertps;
	}

	public java.util.Date getFechahastartps() {
		return fechahastartps;
	}

	public void setFechahastartps(java.util.Date fechahastartps) {
		this.fechahastartps = fechahastartps;
	}

	public String getFlagingresoautorizaciones() {
		return flagingresoautorizaciones;
	}

	public void setFlagingresoautorizaciones(String flagingresoautorizaciones) {
		this.flagingresoautorizaciones = flagingresoautorizaciones;
	}

	public String getEstadoprog() {
		return estadoprog;
	}

	public void setEstadoprog(String estadoprog) {
		this.estadoprog = estadoprog;
	}
	
}
