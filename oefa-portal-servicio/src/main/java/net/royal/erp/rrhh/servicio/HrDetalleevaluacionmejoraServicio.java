package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrDetalleevaluacionmejoraServicio extends GenericoServicio {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit dw_hr_compromisomejora_edit
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @param empleadoevaluador
	 * @return
	 */
	public List<HrDetalleevaluacionmejora> obtenerListaCompromisoMejora(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador);

	
	public void eliminarDetalleEvaluacionMejora(String iv_compania,
			Integer iv_empleado, Integer iv_secuencia,
			Integer iv_empleadoevaluador);
	
	public void grabarDetalleMejora(List<HrDetalleevaluacionmejora>dwCompromisomejora);

}
