package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEmpleadorevisionServicio extends GenericoServicio {

	/**
	 * @powerBuilder w_hr_evaluacionempleado_edit dw_hr_empleadorevision_edit
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @param empleadoevaluador
	 * @return
	 */
	public List<HrEmpleadorevision> obtenerListaRevision(String companyowner,
			Integer empleado, Integer secuenciaeval, Integer empleadoevaluador);
	
	public void grabarEmpleadoRevision(List<HrEmpleadorevision>dw_revision);
}
