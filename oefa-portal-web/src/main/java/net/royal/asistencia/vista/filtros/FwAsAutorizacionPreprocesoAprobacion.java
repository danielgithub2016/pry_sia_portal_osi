package net.royal.asistencia.vista.filtros;

import java.util.Date;

import net.royal.framework.web.core.UValidador;

public class FwAsAutorizacionPreprocesoAprobacion {

	private Boolean isperiodo;
	private Boolean isfecha;
	private Boolean istodos;
	private Date fechadesde;
	private Date fechaHasta;
	private Boolean iscesados;
	private Boolean isinactivos;
	private Boolean isseltodosaprobados;
	private Boolean isseltodosrechazados;
	private String estado;
	private String periodo;
	private String alllocation;
	private String location;
	private String departamentooperacionalall;
	private String departamentooperacional;
	private String alltipoplanilla;
	private Integer fechas;
	private String nroresolucion;

	private String empleado;
	private String puesto;
	private String centrocosto;
	private Boolean isexceden;

	/**
	 * @return the isperiodo
	 */
	public Boolean getIsperiodo() {
		return isperiodo;
	}

	/**
	 * @param isperiodo
	 *            the isperiodo to set
	 */
	public void setIsperiodo(Boolean isperiodo) {
		this.isperiodo = isperiodo;
	}

	/**
	 * @return the isfecha
	 */
	public Boolean getIsfecha() {
		return isfecha;
	}

	/**
	 * @param isfecha
	 *            the isfecha to set
	 */
	public void setIsfecha(Boolean isfecha) {
		this.isfecha = isfecha;
	}

	/**
	 * @return the istodos
	 */
	public Boolean getIstodos() {
		return istodos;
	}

	/**
	 * @param istodos
	 *            the istodos to set
	 */
	public void setIstodos(Boolean istodos) {
		this.istodos = istodos;
	}

	/**
	 * @return the fechadesde
	 */
	public Date getFechadesde() {
		return fechadesde;
	}

	/**
	 * @param fechadesde
	 *            the fechadesde to set
	 */
	public void setFechadesde(Date fechadesde) {
		this.fechadesde = fechadesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechaHasta
	 *            the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @return the iscesados
	 */
	public Boolean getIscesados() {
		return iscesados;
	}

	/**
	 * @param iscesados
	 *            the iscesados to set
	 */
	public void setIscesados(Boolean iscesados) {
		this.iscesados = iscesados;
	}

	/**
	 * @return the isinactivos
	 */
	public Boolean getIsinactivos() {
		return isinactivos;
	}

	/**
	 * @param isinactivos
	 *            the isinactivos to set
	 */
	public void setIsinactivos(Boolean isinactivos) {
		this.isinactivos = isinactivos;
	}

	/**
	 * @return the isseltodosaprobados
	 */
	public Boolean getIsseltodosaprobados() {
		return isseltodosaprobados;
	}

	/**
	 * @param isseltodosaprobados
	 *            the isseltodosaprobados to set
	 */
	public void setIsseltodosaprobados(Boolean isseltodosaprobados) {
		this.isseltodosaprobados = isseltodosaprobados;
	}

	/**
	 * @return the isseltodosrechazados
	 */
	public Boolean getIsseltodosrechazados() {
		return isseltodosrechazados;
	}

	/**
	 * @param isseltodosrechazados
	 *            the isseltodosrechazados to set
	 */
	public void setIsseltodosrechazados(Boolean isseltodosrechazados) {
		this.isseltodosrechazados = isseltodosrechazados;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the alllocation
	 */
	public String getAlllocation() {
		if (UValidador.estaVacio(alllocation)) {
			alllocation = "N";
		}
		return alllocation;
	}

	/**
	 * @param alllocation
	 *            the alllocation to set
	 */
	public void setAlllocation(String alllocation) {
		this.alllocation = alllocation;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the departamentooperacionalall
	 */
	public String getDepartamentooperacionalall() {
		return departamentooperacionalall;
	}

	/**
	 * @param departamentooperacionalall
	 *            the departamentooperacionalall to set
	 */
	public void setDepartamentooperacionalall(String departamentooperacionalall) {
		this.departamentooperacionalall = departamentooperacionalall;
	}

	/**
	 * @return the departamentooperacional
	 */
	public String getDepartamentooperacional() {
		return departamentooperacional;
	}

	/**
	 * @param departamentooperacional
	 *            the departamentooperacional to set
	 */
	public void setDepartamentooperacional(String departamentooperacional) {
		this.departamentooperacional = departamentooperacional;
	}

	/**
	 * @return the alltipoplanilla
	 */
	public String getAlltipoplanilla() {
		return alltipoplanilla;
	}

	/**
	 * @param alltipoplanilla
	 *            the alltipoplanilla to set
	 */
	public void setAlltipoplanilla(String alltipoplanilla) {
		this.alltipoplanilla = alltipoplanilla;
	}

	/**
	 * @return the fechas
	 */
	public Integer getFechas() {

		return fechas;
	}

	/**
	 * @param fechas
	 *            the fechas to set
	 */
	public void setFechas(Integer fechas) {
		this.fechas = fechas;
	}

	/**
	 * @return the nroresolucion
	 */
	public String getNroresolucion() {
		return nroresolucion;
	}

	/**
	 * @param nroresolucion
	 *            the nroresolucion to set
	 */
	public void setNroresolucion(String nroresolucion) {
		this.nroresolucion = nroresolucion;
	}

	/**
	 * @return the empleado
	 */
	public String getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado
	 *            the empleado to set
	 */
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * @param puesto
	 *            the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	/**
	 * @return the centrocosto
	 */
	public String getCentrocosto() {
		return centrocosto;
	}

	/**
	 * @param centrocosto
	 *            the centrocosto to set
	 */
	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public Boolean getIsexceden() {
		if (UValidador.esNulo(isexceden)) {
			isexceden = false;
		}
		return isexceden;
	}

	public void setIsexceden(Boolean isexceden) {
		this.isexceden = isexceden;
	}

}
