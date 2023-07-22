package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrPuestoevaluacion
*/
public class HrPuestoevaluacion extends DominioGenerico implements java.io.Serializable{

	private HrPuestoevaluacionPk pk;
	private String etapa;
	private Integer evaluacion;
	private Integer factor;
	private String estado;


	public HrPuestoevaluacion() {
		pk = new HrPuestoevaluacionPk();
	}

	public HrPuestoevaluacionPk getPk() {
		return pk;
	}

	public void setPk(HrPuestoevaluacionPk pk) {
		this.pk = pk;
	}
	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public Integer getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Integer evaluacion) {
		this.evaluacion = evaluacion;
	}
	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
