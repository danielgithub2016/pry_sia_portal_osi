package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Referencefieldvalues;
import net.royal.erp.core.dominio.ReferencefieldvaluesPk;

import java.util.List;

public interface ReferencefieldvaluesDao extends
		GenericoDao<Referencefieldvalues, ReferencefieldvaluesPk> {

	public List<Referencefieldvalues> listaDw1(String ReferenceField);

}
