package net.royal.erp.rrhh.dominio;

import net.royal.framework.web.dominio.DominioGenerico;
import java.util.Date;

/**
 *
 * @author desarrollo
 * @powerbuilder rrhh.HrEvaluaciontipoevaluador
*/
public class HrEvaluaciontipoevaluador extends DominioGenerico implements java.io.Serializable{

	private HrEvaluaciontipoevaluadorPk pk;
	private java.math.BigDecimal porcentajepeso;


	public HrEvaluaciontipoevaluador() {
		pk = new HrEvaluaciontipoevaluadorPk();
	}

	public HrEvaluaciontipoevaluadorPk getPk() {
		return pk;
	}

	public void setPk(HrEvaluaciontipoevaluadorPk pk) {
		this.pk = pk;
	}
	public java.math.BigDecimal getPorcentajepeso() {
		return porcentajepeso;
	}

	public void setPorcentajepeso(java.math.BigDecimal porcentajepeso) {
		this.porcentajepeso = porcentajepeso;
	}

}
