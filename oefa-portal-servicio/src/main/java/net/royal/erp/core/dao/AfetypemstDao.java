package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Afetypemst;
import net.royal.erp.core.dominio.AfetypemstPk;
import java.util.List;

public interface AfetypemstDao extends GenericoDao<Afetypemst, AfetypemstPk> {

	/**
	 * listartipoproyecto
	 * DwMaAfetypeSelect
	 * @return
	 */
	public List<Afetypemst> listarTipoProyecto();
}
