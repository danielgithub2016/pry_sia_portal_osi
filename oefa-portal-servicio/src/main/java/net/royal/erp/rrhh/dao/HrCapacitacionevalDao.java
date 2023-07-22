package net.royal.erp.rrhh.dao;

import java.util.List;

import net.royal.erp.rrhh.dominio.HrCapacitacioneval;
import net.royal.erp.rrhh.dominio.HrCapacitacionevalPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrCapacitacionevalDao extends GenericoDao<HrCapacitacioneval, HrCapacitacionevalPk> {

	/**
	 * @powerbuilder dw_hr_capacitacion_evalpart
	 * @param par_companyowner
	 * @param capacitacion
	 * @return
	 */
	public List listarCapacitacionEval(String par_companyowner, String capacitacion);
}
