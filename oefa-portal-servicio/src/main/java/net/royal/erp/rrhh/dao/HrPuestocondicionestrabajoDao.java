package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajo;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajoPk;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;

import java.util.List;

public interface HrPuestocondicionestrabajoDao extends GenericoDao<HrPuestocondicionestrabajo, HrPuestocondicionestrabajoPk> {

	/**
	 * @powerbuilder dw_hr_puestocondicionestrabajo_edit - TAB CONDICIONES TRABAJO
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestocondicionestrabajo> listarCondicionesTrabajo(Integer codigopuesto);
}
