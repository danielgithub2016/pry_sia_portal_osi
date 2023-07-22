package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Companiamast;
import net.royal.erp.core.dominio.CompaniamastPk;

import java.util.List;

public interface CompaniamastDao extends
		GenericoDao<Companiamast, CompaniamastPk> {

	public Boolean afectoIgv(String companiacodigo);
	/**
	 * f_sql_read_company_name
	 */
	public String obtenerNombreCompania(String par_company);
}
