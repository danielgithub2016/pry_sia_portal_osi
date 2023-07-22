package net.royal.erp.asistencia.dominio;

import java.math.BigDecimal;

import net.royal.framework.web.dominio.DominioGenerico;

/**
 *
 * @author desarrollo
 * @powerbuilder asistencia.AsEmpleadoexcepcionsolicitud
*/
public class AsEmpleadoexcepcionsolicitud extends DominioGenerico implements java.io.Serializable{

	private AsEmpleadoexcepcionsolicitudPk pk;
	private String descripcion;
	private String intervaloacceso;
	private Integer tipodia;
	private String estado;
	
	private double auxHoras;


	public AsEmpleadoexcepcionsolicitud() {
		pk = new AsEmpleadoexcepcionsolicitudPk();
	}

	public AsEmpleadoexcepcionsolicitudPk getPk() {
		return pk;
	}

	public void setPk(AsEmpleadoexcepcionsolicitudPk pk) {
		this.pk = pk;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIntervaloacceso() {
		return intervaloacceso;
	}

	public void setIntervaloacceso(String intervaloacceso) {
		this.intervaloacceso = intervaloacceso;
	}
	public Integer getTipodia() {
		return tipodia;
	}

	public void setTipodia(Integer tipodia) {
		this.tipodia = tipodia;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getAuxHoras() {
		return auxHoras;
	}

	public void setAuxHoras(double auxHoras) {
		this.auxHoras = auxHoras;
	}



}
