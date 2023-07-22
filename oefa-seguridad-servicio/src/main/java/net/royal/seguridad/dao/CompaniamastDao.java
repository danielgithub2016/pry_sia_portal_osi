package net.royal.seguridad.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.seguridad.dominio.Companiamast;
import net.royal.seguridad.dominio.CompaniamastPk;

public interface CompaniamastDao extends
		GenericoDao<Companiamast, CompaniamastPk> {
	public String obtenerPlanContable(String companiaCodigo);
}
