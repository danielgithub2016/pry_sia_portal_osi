package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacioncapacvalor;
import net.royal.erp.rrhh.dominio.HrEvaluacioncapacvalorPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacioncapacvalorDao extends GenericoDao<HrEvaluacioncapacvalor, HrEvaluacioncapacvalorPk> {

	/**
	 * @powerbuilder f_sql_evaluacioncapacvalor_des
	 * @param par_evaluacion
	 * @param par_valor
	 * @return
	 */
	public String f_sql_evaluacioncapacvalor_des(Integer par_evaluacion,
			BigDecimal par_valor);
	
	/**
	 * @powerbuilder dw_hr_evaluacioncapacvalor_list
	 * @param par_evaluacion
	 * @return
	 */
	public List listarEvaluacion(Integer par_evaluacion);
}
