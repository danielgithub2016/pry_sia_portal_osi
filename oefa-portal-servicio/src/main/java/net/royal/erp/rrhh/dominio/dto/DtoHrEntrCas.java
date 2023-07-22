package net.royal.erp.rrhh.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuesta
 */
@SuppressWarnings("serial")
public class DtoHrEntrCas implements java.io.Serializable {

	private String requerimiento;
	private String nro_requerimiento;
	private String puesto;
	private String unidad;
	private String estado;
	private String n_estado;
	private String n_partaptos;
	private String n_partentrevistados;
	private String fecha;
	
	public String getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(String requerimiento) {
		this.requerimiento = requerimiento;
	}

	public String getNro_requerimiento() {
		return nro_requerimiento;
	}

	public void setNro_requerimiento(String nro_requerimiento) {
		this.nro_requerimiento = nro_requerimiento;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getN_estado() {
		return n_estado;
	}

	public void setN_estado(String n_estado) {
		this.n_estado = n_estado;
	}

	public String getN_partaptos() {
		return n_partaptos;
	}

	public void setN_partaptos(String n_partaptos) {
		this.n_partaptos = n_partaptos;
	}

	public String getN_partentrevistados() {
		return n_partentrevistados;
	}

	public void setN_partentrevistados(String n_partentrevistados) {
		this.n_partentrevistados = n_partentrevistados;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha= fecha;
	}

}
