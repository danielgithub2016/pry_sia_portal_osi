package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrFactorvalorcapac;
import net.royal.erp.rrhh.dominio.HrFactorvalorcapacPk;

import java.math.BigDecimal;
import java.util.List;

public interface HrFactorvalorcapacDao extends GenericoDao<HrFactorvalorcapac, HrFactorvalorcapacPk> {

	/**
	 * @powerbuilder dw_hr_factoresvalorcapac_list - dw_hr_factoresvalorcapac_list
	 * @param p_factor
	 * @return
	 */
	public List listarFactor(Integer p_factor);

	/**
	 * @powerbuilder f_sql_factorvalorcapac_rango
	 * @param p_factor
	 * @param p_respuesta
	 * @return
	 */
	public String f_sql_factorvalorcapac_rango(Integer p_factor,
			BigDecimal p_respuesta);
}
