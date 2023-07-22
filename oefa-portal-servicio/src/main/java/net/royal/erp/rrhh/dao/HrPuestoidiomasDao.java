package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrPuestocursos;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;
import net.royal.erp.rrhh.dominio.HrPuestoidiomasPk;

import java.util.List;

public interface HrPuestoidiomasDao extends GenericoDao<HrPuestoidiomas, HrPuestoidiomasPk> {


	/**
	 * @powerbuilder dw_hr_puestoidioma_edit - TAB FORMACION
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestoidiomas> listarPuestoidiomas(Integer codigopuesto);
}
