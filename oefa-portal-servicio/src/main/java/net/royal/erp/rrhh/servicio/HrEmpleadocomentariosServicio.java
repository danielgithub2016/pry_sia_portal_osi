package net.royal.erp.rrhh.servicio;

import java.util.List;

import net.royal.framework.web.servicio.GenericoServicio;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentariosPk;

public interface HrEmpleadocomentariosServicio extends GenericoServicio {

	public List<HrEmpleadocomentarios> obtenerListaComentarios(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador);
	
	public void grabardwComentario(List<HrEmpleadocomentarios> dwComentario);
}


