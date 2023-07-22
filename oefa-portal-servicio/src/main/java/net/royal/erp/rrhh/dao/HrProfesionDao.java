package net.royal.erp.rrhh.dao;

import net.royal.erp.rrhh.dominio.HrProfesion;
import net.royal.erp.rrhh.dominio.HrProfesionPk;
import net.royal.framework.web.dao.GenericoDao;

public interface HrProfesionDao extends GenericoDao<HrProfesion, HrProfesionPk> {

	/**
	 * @powerbuilder f_sql_get_nombre_profesion
	 * @param par_profesion
	 * @return
	 */
	public HrProfesion obtenerProfesion(String par_profesion);
	
}
