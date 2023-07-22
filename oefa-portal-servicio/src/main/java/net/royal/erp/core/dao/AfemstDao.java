package net.royal.erp.core.dao;

import net.royal.erp.core.dominio.Afemst;
import net.royal.erp.core.dominio.AfemstPk;
import net.royal.framework.web.dao.GenericoDao;

public interface AfemstDao extends GenericoDao<Afemst, AfemstPk> {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder sycommon.f_sql_validate_afe
	 */
	public Afemst validarAfe(String afe);
}
