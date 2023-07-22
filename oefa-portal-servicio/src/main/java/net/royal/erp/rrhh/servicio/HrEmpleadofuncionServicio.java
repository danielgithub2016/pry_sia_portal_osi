package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEmpleadofuncionServicio extends GenericoServicio {

	public List<HrEmpleadofuncion> ObtenerEmpleadoFuncionporParametros (String companyowner,Integer empleado,Integer secuenciaeval,Integer empleadoevaluador);

	public Integer obtenerMaximoSecuencia(Integer iv_empleado, Integer iv_secuencia);
	
	public void grabarEmpleadoFuncion(List<HrEmpleadofuncion> dw11);
}
