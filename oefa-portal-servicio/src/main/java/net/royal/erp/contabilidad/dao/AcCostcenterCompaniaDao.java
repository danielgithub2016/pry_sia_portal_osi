package net.royal.erp.contabilidad.dao;

import java.util.List;

import net.royal.erp.contabilidad.dominio.AcCostcenterCompania;
import net.royal.erp.contabilidad.dominio.AcCostcenterCompaniaPk;
import net.royal.framework.web.dao.GenericoDao;

// TODO: Auto-generated Javadoc
/**
 * The Interface AcCostcenterCompaniaDao.
 */
public interface AcCostcenterCompaniaDao extends
		GenericoDao<AcCostcenterCompania, AcCostcenterCompaniaPk> {

	/**
	 * Listar area crea demanda.
	 *
	 * @powerbuilder dw_bu_dddw_areas_crea_demandas
	 * @param compania
	 *            the compania
	 * @param ano
	 *            the ano
	 * @param version
	 *            the version
	 * @return the list
	 */
	public List<AcCostcenterCompania> listarAreaCreaDemanda(String compania,
			String ano, Integer version);
}
