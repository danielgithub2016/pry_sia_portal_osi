package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrEmpleadoasistencias;
import net.royal.erp.rrhh.dominio.HrEmpleadoasistenciasPk;

import java.util.List;

public interface HrEmpleadoasistenciasDao extends GenericoDao<HrEmpleadoasistencias, HrEmpleadoasistenciasPk> {

	/**
	 * @powerbuilder  - dw_hr_capacitacionasistencias_edit
	 * @param capacitacion
	 * @return
	 */
	public List<HrEmpleadoasistencias> ListarEmpleadosAsistencias(String capacitacion);
	
}
