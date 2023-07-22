package net.royal.erp.asistencia.dominio;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsAccesosdiarios
 */
public class AsAccesosdiarios extends DominioGenerico implements java.io.Serializable {

	private AsAccesosdiariosPk pk;
	private String codigotransaccion;
	private String clasificacion;
	private String tipovalidacion;
	private String carnetsupervisor;
	private Integer empleadosupervisor;
	private java.util.Date hora;
	private String observacion;
	private String lugarrecoleccion;
	private String unidadreplicacion;
	private Integer ano;
	private Integer mes;
	private Integer dia;
	private String lectora;
	private Integer empleadoA;
	private java.util.Date fechaA;
	private String conceptoaccesoA;
	private java.util.Date desdeA;
	private Integer terminal;

	public AsAccesosdiarios() {
		pk = new AsAccesosdiariosPk();
	}

	public AsAccesosdiariosPk getPk() {
		return pk;
	}

	public void setPk(AsAccesosdiariosPk pk) {
		this.pk = pk;
	}

	public String getCodigotransaccion() {
		return codigotransaccion;
	}

	public void setCodigotransaccion(String codigotransaccion) {
		this.codigotransaccion = codigotransaccion;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getTipovalidacion() {
		return tipovalidacion;
	}

	public void setTipovalidacion(String tipovalidacion) {
		this.tipovalidacion = tipovalidacion;
	}

	public String getCarnetsupervisor() {
		return carnetsupervisor;
	}

	public void setCarnetsupervisor(String carnetsupervisor) {
		this.carnetsupervisor = carnetsupervisor;
	}

	public Integer getEmpleadosupervisor() {
		return empleadosupervisor;
	}

	public void setEmpleadosupervisor(Integer empleadosupervisor) {
		this.empleadosupervisor = empleadosupervisor;
	}

	public java.util.Date getHora() {
		return hora;
	}

	public void setHora(java.util.Date hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getLugarrecoleccion() {
		if (UValidador.estaVacio(lugarrecoleccion)) {
			lugarrecoleccion = "";
		}
		return lugarrecoleccion;
	}

	public void setLugarrecoleccion(String lugarrecoleccion) {
		this.lugarrecoleccion = lugarrecoleccion;
	}

	public String getUnidadreplicacion() {
		return unidadreplicacion;
	}

	public void setUnidadreplicacion(String unidadreplicacion) {
		this.unidadreplicacion = unidadreplicacion;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getLectora() {
		return lectora;
	}

	public void setLectora(String lectora) {
		this.lectora = lectora;
	}

	public Integer getEmpleadoA() {
		return empleadoA;
	}

	public void setEmpleadoA(Integer empleadoA) {
		this.empleadoA = empleadoA;
	}

	public java.util.Date getFechaA() {
		return fechaA;
	}

	public void setFechaA(java.util.Date fechaA) {
		this.fechaA = fechaA;
	}

	public String getConceptoaccesoA() {
		return conceptoaccesoA;
	}

	public void setConceptoaccesoA(String conceptoaccesoA) {
		this.conceptoaccesoA = conceptoaccesoA;
	}

	public java.util.Date getDesdeA() {
		return desdeA;
	}

	public void setDesdeA(java.util.Date desdeA) {
		this.desdeA = desdeA;
	}

	public Integer getTerminal() {
		return terminal;
	}

	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}

}
