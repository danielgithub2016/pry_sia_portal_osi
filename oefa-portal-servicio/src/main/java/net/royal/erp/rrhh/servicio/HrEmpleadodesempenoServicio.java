package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempenoPk;

public interface HrEmpleadodesempenoServicio extends GenericoServicio {

	public List<HrEmpleadodesempeno> ListarEmpleadoDesempenoporParametros (String companyowner,Integer empleado,Integer secuenciaeval,Integer empleadoevaluador);

	public Integer ObtenerMaximaSecuencia (Integer empleado,Integer secuenciaeval);
	
	public void grabardw5(List<HrEmpleadodesempeno> dw5);
}
