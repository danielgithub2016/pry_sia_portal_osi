package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.Ordenpago;
import net.royal.erp.core.dominio.OrdenpagoPk;

import java.math.BigDecimal;
import java.util.List;

public interface OrdenpagoDao extends GenericoDao<Ordenpago, OrdenpagoPk> {

	public Ordenpago obtenerPorId(java.math.BigDecimal proveedor, String tipodocumento, String numerodocumento);
	
}
