package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrDetalleevaluacionServicio extends GenericoServicio {

	public List<HrDetalleevaluacion> obtenerLista(String companyowner,
			Integer secuencia, Integer empleado, Integer empleadoevaluador,String tipo);

	public Integer obtenerMaximoDetalleEvaluacion(Integer empleado,
			Integer secuenciaeval);

	public List obtenerCantEvaluacionGrafico(String parCompany,
			Integer parSecuencia, Integer parEmpleado, Integer parEvaluador);

	public void eliminarevaluacion(String parCompany, Integer parSecuenciaEval,
			Integer parEmpleado, Integer parEvaluador, String parTipo);
	
	public void grabarDetalleEvaluacion(List<DtoHrDetalleEvaluacion> dw1);
	
	
	public Integer obtenerSumaEvaluacion(String companyowner,
			Integer secuencia, Integer empleado, Integer empleadoevaluador,String tipo);
	
	public void grabarEvaluacionDetalleP(List<DtoDwHrEmpleadoevaluacionDetailP> dw9);
	
	public void grabardwCampo(List<HrDetalleevaluacion> dwCampo);

}
