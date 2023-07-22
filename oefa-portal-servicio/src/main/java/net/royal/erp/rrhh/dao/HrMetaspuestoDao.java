package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrMetaspuestoPk;
import net.royal.erp.rrhh.dominio.HrPuestocursos;

import java.util.List;

public interface HrMetaspuestoDao extends GenericoDao<HrMetaspuesto, HrMetaspuestoPk> {


	/**
	 * @powerbuilder dw_hr_puestometas_list - TAB OBJETIVOS METAS
	 * @param codigopuesto
	 * @return
	 */
	public List<HrMetaspuesto> listarTabObjetivosMetas(Integer codigopuesto);
}
