package net.royal.erp.rrhh.dao;

import java.math.BigDecimal;
import java.util.List;

import net.royal.erp.rrhh.dominio.HrEvaluacionesrango;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrangoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrEvaluacionesrangoDao extends GenericoDao<HrEvaluacionesrango, HrEvaluacionesrangoPk> {

	/**
	 * @powerbuilder hrothers f_evaluacionesrango_des
	 * @param desde
	 * @param hasta
	 * @return
	 */
	
	public String ObtenerEvaluacionesRango(BigDecimal desde, BigDecimal hasta);
}
