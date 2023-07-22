package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadocursos;
import net.royal.erp.rrhh.dominio.HrEmpleadocursosPk;
import java.util.List;

public interface HrEmpleadocursosDao extends GenericoDao<HrEmpleadocursos, HrEmpleadocursosPk> {
	public List<HrEmpleadocursos> listarPorEmpleado(Integer empleado,String curso,String capacitaciones);
}
