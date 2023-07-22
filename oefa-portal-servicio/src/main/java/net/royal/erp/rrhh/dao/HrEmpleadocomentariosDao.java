package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentarios;
import net.royal.erp.rrhh.dominio.HrEmpleadocomentariosPk;
import java.util.List;

public interface HrEmpleadocomentariosDao extends
		GenericoDao<HrEmpleadocomentarios, HrEmpleadocomentariosPk> {

	/**
	 * @powerbuilder dw_hr_empleadocomentario_edit
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @param empleadoevaluador
	 * @return
	 */
	public List<HrEmpleadocomentarios> obtenerListaComentarios(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador);
	
	public void grabardwComentario(List<HrEmpleadocomentarios> dwComentario);
}
