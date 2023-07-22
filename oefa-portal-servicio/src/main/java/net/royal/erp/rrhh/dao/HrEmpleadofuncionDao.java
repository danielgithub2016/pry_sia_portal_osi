package net.royal.erp.rrhh.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncionPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEmpleadofuncionDao extends
		GenericoDao<HrEmpleadofuncion, HrEmpleadofuncionPk> {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit dw_hr_empleadofuncion_edit
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @param empleadoevaluador
	 * @return
	 */

	public List<HrEmpleadofuncion> ObtenerEmpleadoFuncionporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador);

	/**
	 * TAB FUNCIONES
	 * 
	 * @return
	 */
	public Integer obtenerMaximoSecuencia(Integer iv_empleado,
			Integer iv_secuencia);
	
	@Transactional
	public void grabarEmpleadoFuncion(List<HrEmpleadofuncion> dw11);
}
