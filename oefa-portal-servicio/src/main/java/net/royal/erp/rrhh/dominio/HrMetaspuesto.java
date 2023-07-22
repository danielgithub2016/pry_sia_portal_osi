package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrMetaspuesto
*/
public class HrMetaspuesto extends DominioGenerico implements java.io.Serializable{

	private HrMetaspuestoPk pk;
	private String descripcion;
	private String estado;
	private Integer secuenciaeval;
	private Integer factorparticipacion;
	
	private String periodonombre;

	public HrMetaspuesto() {
		pk = new HrMetaspuestoPk();
	}

	public HrMetaspuestoPk getPk() {
		return pk;
	}

	public void setPk(HrMetaspuestoPk pk) {
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
	public Integer getSecuenciaeval() {
		return secuenciaeval;
	}

	public void setSecuenciaeval(Integer secuenciaeval) {
		this.secuenciaeval = secuenciaeval;
	}
	public Integer getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(Integer factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}

	public String getPeriodonombre() {
		return periodonombre;
	}

	public void setPeriodonombre(String periodonombre) {
		this.periodonombre = periodonombre;
	}

}
