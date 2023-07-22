package net.royal.erp.rrhh.servicio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.dto.DtoHrEvaluacionperiodo;
import net.royal.erp.sistema.syroyal.estructura.StrPass;
import net.royal.framework.web.servicio.GenericoServicio;

// TODO: Auto-generated Javadoc
/**
 * The Interface HrEvaluacionperiodoServicio.
 */
public interface HrEvaluacionperiodoServicio extends GenericoServicio {

	/**
	 * F evaluacion periodo cabecera.
	 *
	 * @powerbuilder f_hr_evaluacionperiodo_cabecera
	 * @param strpass
	 *            the strpass
	 * @return the str pass
	 */

	public StrPass FEvaluacionPeriodoCabecera(StrPass strpass);

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit TAB NECESIDADES DE
	 *               CAPACITACION cb_selecciona_capacita
	 * @param secuenciaeval
	 * @return
	 */

	public HrEvaluacionperiodo ObtenerxSecuenciaeval(Integer secuenciaeval);

	/**
	 * consulta para saber si el empleado tiene historial de mejoras 
	 * pop up w_factores_competencia_calificar
	 * @return
	 */
	public Integer obtenerCantHistorial(String iv_compania,
			Integer iv_empleado, Integer il_factor, Integer iv_secuencia);

	/**
	 * 
	 * @return
	 */
	public List obtenerListadeEvauluaciones();
	
	
	/**
	 * Obtener x secuencia eval compania.
	 *
	 * @author nunezh
	 * @powerbuilder query 'suelto' en <strong>wf_copy_metas</strong> de
	 *               <strong>w_hr_evaluacionempleado_edit</strong>
	 * @param secuenciaeval
	 *            the secuenciaeval
	 * @param compania
	 *            the compania
	 * @return the hr evaluacionperiodo
	 */
	public HrEvaluacionperiodo obtenerXSecuenciaEvalCompania(
			Integer secuenciaeval, String compania) ;
	
	public List<HrEvaluacionperiodo> listarEvalPeriodoxCompania(String companiasocio);
	
}
