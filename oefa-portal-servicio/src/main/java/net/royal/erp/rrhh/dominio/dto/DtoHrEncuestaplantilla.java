package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestaplantilla
*/
public class DtoHrEncuestaplantilla implements java.io.Serializable{

	private Integer plantilla;
	private String descripcion;
	private String estado;
	private String tipoencuesta;

	public Integer getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Integer plantilla) {
		this.plantilla = plantilla;
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
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}

}
