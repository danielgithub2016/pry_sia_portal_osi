package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Tipopago;
import net.royal.erp.core.dominio.TipopagoPk;
import java.util.List;

public interface TipopagoDao extends GenericoDao<Tipopago, TipopagoPk> {

	/**
	 * DwMaTipopagoSelect
	 * @return
	 */
	public List listarTipoPago();
}
