package net.royal.erp.core.dao;

import java.util.List;

import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.dominio.CompanyownerPk;
import net.royal.framework.web.dao.GenericoDao;

public interface CompanyownerDao extends
		GenericoDao<Companyowner, CompanyownerPk> {

	public List<Companyowner> listarEjecutoras();
}
