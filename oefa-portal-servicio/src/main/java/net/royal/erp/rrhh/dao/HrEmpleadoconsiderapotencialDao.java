package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencialPk;
import java.util.List;

public interface HrEmpleadoconsiderapotencialDao
		extends
		GenericoDao<HrEmpleadoconsiderapotencial, HrEmpleadoconsiderapotencialPk> {

	/**
	 * @powerbuilder w_hr_evaluacionempleado_edit
	 *               dw_hr_empleadoconsiderapotencial_edit
	 * @param par_companyowner
	 * @param par_empleado
	 * @param par_secuenciaeval
	 * @param par_Evaluador
	 * @return
	 */
	public List<HrEmpleadoconsiderapotencial> obtenerLista(
			String par_companyowner, Integer par_empleado,
			Integer par_secuenciaeval, Integer par_Evaluador);
	
	public void grabarPotencial(List<HrEmpleadoconsiderapotencial> dw10);

}
