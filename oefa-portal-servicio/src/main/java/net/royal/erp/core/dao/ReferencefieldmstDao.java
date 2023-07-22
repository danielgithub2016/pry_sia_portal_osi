package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Referencefieldmst;
import net.royal.erp.core.dominio.ReferencefieldmstPk;
import java.util.List;

public interface ReferencefieldmstDao extends
		GenericoDao<Referencefieldmst, ReferencefieldmstPk> {

	public String obtenerTitulo(String ReferenceField);
}
