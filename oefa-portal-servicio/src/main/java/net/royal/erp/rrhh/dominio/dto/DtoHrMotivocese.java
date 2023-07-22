package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrMotivocese
*/
public class DtoHrMotivocese implements java.io.Serializable{

	private Integer motivo;
	private String descripcion;
	private String estado;
	private String codigortps;
	private String motivortps;

	public Integer getMotivo() {
		return motivo;
	}

	public void setMotivo(Integer motivo) {
		this.motivo = motivo;
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
	public String getCodigortps() {
		return codigortps;
	}

	public void setCodigortps(String codigortps) {
		this.codigortps = codigortps;
	}
	public String getMotivortps() {
		return motivortps;
	}

	public void setMotivortps(String motivortps) {
		this.motivortps = motivortps;
	}

}
