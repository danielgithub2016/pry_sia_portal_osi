package net.royal.erp.core.dao;

import java.util.List;

import net.royal.erp.core.dominio.Companiadistribucionsplitcxp;
import net.royal.erp.core.dominio.CompaniadistribucionsplitcxpPk;
import net.royal.framework.web.dao.GenericoDao;

public interface CompaniadistribucionsplitcxpDao extends GenericoDao<Companiadistribucionsplitcxp, CompaniadistribucionsplitcxpPk> {
	
	public List<Companiadistribucionsplitcxp>listarCompaniaSplit(String companiaCodigo);

}
