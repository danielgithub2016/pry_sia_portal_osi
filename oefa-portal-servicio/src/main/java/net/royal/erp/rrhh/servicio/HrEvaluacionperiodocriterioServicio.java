package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterio;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEvaluacionperiodocriterioServicio extends GenericoServicio {
	
	/**
	 * Listar por compania secuencia tipo eval.
	 *
	 *@author nunezh
	 *@powerbuilder hrmast.dw_hr_evaluacionperiodocriterio_visual
	 * @param companiaSocio the compania socio
	 * @param secuenciaEval the secuencia eval
	 * @param tipoEval the tipo eval
	 * @return the list
	 */
	public List<HrEvaluacionperiodocriterio> listarPorCompaniaSecuenciaTipoEval(
			String companiaSocio, Integer secuenciaEval, String tipoEval);
}
