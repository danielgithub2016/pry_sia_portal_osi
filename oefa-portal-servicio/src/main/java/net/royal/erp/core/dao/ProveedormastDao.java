package net.royal.erp.core.dao;

import net.royal.erp.core.dominio.Proveedormast;
import net.royal.erp.core.dominio.ProveedormastPk;
import net.royal.framework.web.dao.GenericoDao;

public interface ProveedormastDao extends
		GenericoDao<Proveedormast, ProveedormastPk> {

	/**
	 *
	 * @author desarrollo
	 * @powerbuilder whothers.f_sql_get_name_for_check
	*/
	public String obtenerNmobrePagarA(Integer proveedor);
	
	public Proveedormast obtenerProveedor(Integer proveedor);
	
}
