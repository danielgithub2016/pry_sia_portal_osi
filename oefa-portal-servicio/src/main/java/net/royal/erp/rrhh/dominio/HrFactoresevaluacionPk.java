package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrFactoresevaluacion
*/
public class HrFactoresevaluacionPk implements java.io.Serializable{

	private Integer factor;
	
	public HrFactoresevaluacionPk(){
		 this.factor=factor;
	}
	
	public HrFactoresevaluacionPk(Integer factor){
		 this.factor=factor;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
