package net.royal.erp.sistema.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.sistema.dominio.SyUnidadreplicacion;
import net.royal.erp.sistema.dominio.SyUnidadreplicacionPk;
import java.util.List;

public interface SyUnidadreplicacionDao extends
		GenericoDao<SyUnidadreplicacion, SyUnidadreplicacionPk> {

	/**
	 * DwMaSyUnidadreplicacionSelect
	 * @return
	 */
	public List listaUnidadReplicacion();
}
