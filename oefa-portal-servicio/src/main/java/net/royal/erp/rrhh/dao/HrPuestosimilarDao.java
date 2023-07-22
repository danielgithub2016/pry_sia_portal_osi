package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestosimilar;
import net.royal.erp.rrhh.dominio.HrPuestosimilarPk;

import java.util.List;

public interface HrPuestosimilarDao extends GenericoDao<HrPuestosimilar, HrPuestosimilarPk> {

	/**
	 * @powerbuilder dw_hr_puestosimilar - TAB CONDICIONES TRABAJO
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestosimilar> listarPuestosSimilar(Integer codigopuesto);
}
