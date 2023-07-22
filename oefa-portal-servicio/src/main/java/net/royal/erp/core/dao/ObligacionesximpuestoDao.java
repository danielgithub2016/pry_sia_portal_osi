package net.royal.erp.core.dao;

import java.util.List;

import net.royal.erp.core.dominio.Obligacionesximpuesto;
import net.royal.erp.core.dominio.ObligacionesximpuestoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface ObligacionesximpuestoDao extends
		GenericoDao<Obligacionesximpuesto, ObligacionesximpuestoPk> {
	
	public List<Obligacionesximpuesto> listarPorIdObligaciones(
			Integer proveedor, String tipodocumento, String numerodocumento,
			String impuesto);

}
