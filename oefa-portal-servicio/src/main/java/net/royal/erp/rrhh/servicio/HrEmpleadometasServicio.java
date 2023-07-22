package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.framework.web.servicio.GenericoServicio;

public interface HrEmpleadometasServicio extends GenericoServicio {

	public List<HrEmpleadometas> ListarEmpleadoMetasporParametros (String companyowner,Integer empleado,Integer secuenciaeval,Integer empleadoevaluador);
	
	public void guardarHrEmpleadoMetas(List<HrEmpleadometas>dw6);
	
	
}
