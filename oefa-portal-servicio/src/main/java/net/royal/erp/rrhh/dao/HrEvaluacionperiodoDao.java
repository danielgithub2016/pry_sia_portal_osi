package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionperiodoDao extends
		GenericoDao<HrEvaluacionperiodo, HrEvaluacionperiodoPk> {

	public StrPass FEvaluacionPeriodoCabecera(StrPass strpass);

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit TAB NECESIDADES DE
	 *               CAPACITACION cb_selecciona_capacita
	 * @param secuenciaeval
	 * @return
	 */

	public HrEvaluacionperiodo ObtenerxSecuenciaeval(Integer secuenciaeval);

	
	public HrEvaluacionperiodo obtenerXSecuenciaEvalCompania(
			Integer secuenciaeval, String compania);
	
	/**
	 * @powerbuilder dddw_hr_evaluacionperiodo_select
	 * @param companiasocio
	 * @return
	 */

	public List<HrEvaluacionperiodo> listarEvalPeriodoxCompania(String companiasocio);
}
