package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempenoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEmpleadodesempenoDao extends GenericoDao<HrEmpleadodesempeno, HrEmpleadodesempenoPk> {
	
	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit dw_hr_empleadodesempeno_edit 
	 * @param companyowner
	 * @param empleado
	 * @param secuenciaeval
	 * @param empleadoevaluador
	 * @return
	 */
	
	public List<HrEmpleadodesempeno> ListarEmpleadoDesempenoporParametros (String companyowner,Integer empleado,Integer secuenciaeval,Integer empleadoevaluador);

	
	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit TAB FORTALEZAS Y DEBILIDADES cb_agregar
	 * @param empleado
	 * @param secuenciaeval
	 * @return
	 */
	
	public Integer ObtenerMaximaSecuencia (Integer empleado,Integer secuenciaeval);
	public void grabardw5(List<HrEmpleadodesempeno> dw5);

	
}
