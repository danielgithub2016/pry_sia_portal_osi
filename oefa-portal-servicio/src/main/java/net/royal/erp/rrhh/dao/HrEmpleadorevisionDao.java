package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.HrEmpleadorevisionPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEmpleadorevisionDao extends
		GenericoDao<HrEmpleadorevision, HrEmpleadorevisionPk> {

	public List<HrEmpleadorevision> obtenerListaRevision(String companyowner,
			Integer empleado, Integer secuenciaeval, Integer empleadoevaluador);
	
	public void grabarEmpleadoRevision(List<HrEmpleadorevision> dwrevision);
}
