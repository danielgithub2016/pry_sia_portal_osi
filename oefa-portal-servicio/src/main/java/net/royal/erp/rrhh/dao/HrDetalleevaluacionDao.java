package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionPk;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;

import java.math.BigDecimal;
import java.util.List;

public interface HrDetalleevaluacionDao extends
		GenericoDao<HrDetalleevaluacion, HrDetalleevaluacionPk> {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit
	 *               dw_hr_empleadoevaluacioncampo_edit
	 * @param companyowner
	 * @param secuencia
	 * @param empleado
	 * @param empleadoevaluador
	 * @return
	 */
	public List<HrDetalleevaluacion> obtenerLista(String companyowner,
			Integer secuencia, Integer empleado, Integer empleadoevaluador,String tipo);

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit TAB EVALUACION DE CAMPO
	 *               cb_agregarcampo
	 * @param empleado
	 * @param secuenciaeval
	 * @return
	 */
	public Integer obtenerMaximoDetalleEvaluacion(Integer empleado,
			Integer secuenciaeval);
	
	public void grabarDetalleEvaluacion(List<DtoHrDetalleEvaluacion> dw1);
	public void grabarEvaluacionDetalleP(
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9);
	public void grabardwCampo(List<HrDetalleevaluacion> dwCampo);
	

}
