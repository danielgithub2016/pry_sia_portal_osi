package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrPuestocursos;
import net.royal.erp.rrhh.dominio.HrPuestocursosPk;
import net.royal.erp.rrhh.dominio.HrPuestosubordinado;

import java.util.List;

public interface HrPuestocursosDao extends GenericoDao<HrPuestocursos, HrPuestocursosPk> {

	/**
	 * @powerbuilder dw_hr_puestocursos - TAB OTROS ESTUDIOS
	 * @param codigopuesto
	 * @return
	 */
	public List<HrPuestocursos> listarTabOtrosEstudios(Integer codigopuesto);
}
