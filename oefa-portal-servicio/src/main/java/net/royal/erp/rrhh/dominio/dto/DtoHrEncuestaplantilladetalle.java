package net.royal.erp.rrhh.dominio.dto;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestaplantilladetalle
*/
public class DtoHrEncuestaplantilladetalle implements java.io.Serializable{

	private Integer plantilla;
	private Integer pregunta;
	private String tipoencuesta;
	private Integer orden;

	public Integer getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(Integer plantilla) {
		this.plantilla = plantilla;
	}
	public Integer getPregunta() {
		return pregunta;
	}

	public void setPregunta(Integer pregunta) {
		this.pregunta = pregunta;
	}
	public String getTipoencuesta() {
		return tipoencuesta;
	}

	public void setTipoencuesta(String tipoencuesta) {
		this.tipoencuesta = tipoencuesta;
	}
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}
