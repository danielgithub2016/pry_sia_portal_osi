package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPlantillafactorevaluacion
*/
public class HrPlantillafactorevaluacion extends DominioGenerico implements java.io.Serializable{

	private HrPlantillafactorevaluacionPk pk;
	private Integer ponderacion;
	private String flagpotencial;
	private Integer factorparticipacion;
	private Integer ordenfactor;


	public HrPlantillafactorevaluacion() {
		pk = new HrPlantillafactorevaluacionPk();
	}

	public HrPlantillafactorevaluacionPk getPk() {
		return pk;
	}

	public void setPk(HrPlantillafactorevaluacionPk pk) {
		this.pk = pk;
	}
	public Integer getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}
	public String getFlagpotencial() {
		return flagpotencial;
	}

	public void setFlagpotencial(String flagpotencial) {
		this.flagpotencial = flagpotencial;
	}
	public Integer getFactorparticipacion() {
		return factorparticipacion;
	}

	public void setFactorparticipacion(Integer factorparticipacion) {
		this.factorparticipacion = factorparticipacion;
	}
	public Integer getOrdenfactor() {
		return ordenfactor;
	}

	public void setOrdenfactor(Integer ordenfactor) {
		this.ordenfactor = ordenfactor;
	}

}
