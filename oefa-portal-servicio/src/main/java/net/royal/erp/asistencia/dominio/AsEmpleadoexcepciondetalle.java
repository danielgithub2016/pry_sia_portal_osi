package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadoexcepciondetalle
 */
public class AsEmpleadoexcepciondetalle extends DominioGenerico implements
		java.io.Serializable {

	private AsEmpleadoexcepciondetallePk pk;
	private java.util.Date horainicio;
	private java.util.Date horafin;
	private String flagrestriccion;
	private String conceptoaccesorestringido;
	private String conceptoaccesocomplemento;
	private java.util.Date tiemporestringido;
	private Integer tipohorario;
	private Integer tipodia;
	private String clasehorario;

	public AsEmpleadoexcepciondetalle() {
		pk = new AsEmpleadoexcepciondetallePk();
	}

	public AsEmpleadoexcepciondetallePk getPk() {
		return pk;
	}

	public void setPk(AsEmpleadoexcepciondetallePk pk) {
		this.pk = pk;
	}

	public java.util.Date getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(java.util.Date horainicio) {
		this.horainicio = horainicio;
	}

	public java.util.Date getHorafin() {
		return horafin;
	}

	public void setHorafin(java.util.Date horafin) {
		this.horafin = horafin;
	}

	public String getFlagrestriccion() {
		return flagrestriccion;
	}

	public void setFlagrestriccion(String flagrestriccion) {
		this.flagrestriccion = flagrestriccion;
	}

	public String getConceptoaccesorestringido() {
		return conceptoaccesorestringido;
	}

	public void setConceptoaccesorestringido(String conceptoaccesorestringido) {
		this.conceptoaccesorestringido = conceptoaccesorestringido;
	}

	public String getConceptoaccesocomplemento() {
		return conceptoaccesocomplemento;
	}

	public void setConceptoaccesocomplemento(String conceptoaccesocomplemento) {
		this.conceptoaccesocomplemento = conceptoaccesocomplemento;
	}

	public java.util.Date getTiemporestringido() {
		return tiemporestringido;
	}

	public void setTiemporestringido(java.util.Date tiemporestringido) {
		this.tiemporestringido = tiemporestringido;
	}

	public Integer getTipohorario() {
		return tipohorario;
	}

	public void setTipohorario(Integer tipohorario) {
		this.tipohorario = tipohorario;
	}

	public Integer getTipodia() {
		return tipodia;
	}

	public void setTipodia(Integer tipodia) {
		this.tipodia = tipodia;
	}

	public String getClasehorario() {
		return clasehorario;
	}

	public void setClasehorario(String clasehorario) {
		this.clasehorario = clasehorario;
	}

}
