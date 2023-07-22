package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEncuestaplantilladetalle
*/
public class HrEncuestaplantilladetallePk implements java.io.Serializable{

	private Integer plantilla;
	private Integer pregunta;

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

}
