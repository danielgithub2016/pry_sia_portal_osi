package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Pais;
import net.royal.erp.core.dominio.PaisPk;
import java.util.List;

public interface PaisDao extends GenericoDao<Pais, PaisPk> {

	/**
	 * @powerbuilder dw_ma_pais_select
	 * @return Lista
	 */
	public List<Pais> ListarPaisesxEstado();
}
