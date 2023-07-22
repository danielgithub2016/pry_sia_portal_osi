package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPlantillafactorevaluacion
*/
public class HrPlantillafactorevaluacionPk implements java.io.Serializable{

	private String plantilla;
	private Integer factor;

	public String getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(String plantilla) {
		this.plantilla = plantilla;
	}
	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
