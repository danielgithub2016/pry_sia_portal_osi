package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEmpleadometasPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEmpleadometasDao extends
		GenericoDao<HrEmpleadometas, HrEmpleadometasPk> {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit dw_hr_empleadometas_edit
	 *               dw_hr_empleadometas_revision_edit
	 *               w_hr_evaluacionperiodo_rep_cedula
	 *               dw_hr_rep_desempeno_cedula_meta
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @param empleadoevaluador
	 * @return
	 */
	public List<HrEmpleadometas> ListarEmpleadoMetasporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador);

	public void guardarHrEmpleadoMetas(List<HrEmpleadometas> dw6);
}
