package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajo;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajoPk;

import java.util.List;

public interface HrPuestoriesgotrabajoDao extends GenericoDao<HrPuestoriesgotrabajo, HrPuestoriesgotrabajoPk> {

	/**
	 * @powerbuilder dw_hr_puestoriesgos_edit - TAB CONDICIONES TRABAJO
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoriesgotrabajo> listarRiesgosTrabajo(Integer codigopuesto);
}
