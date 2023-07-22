package net.royal.erp.rrhh.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.rrhh.dominio.HrPosRequer;
import net.royal.erp.rrhh.dominio.HrPosRequerPk;

/**
 * The Interface HrPosRequerDao.
 */
public interface HrPosRequerDao extends GenericoDao<HrPosRequer, HrPosRequerPk> {
	
	/**
	 * Obtener etapa actual.
	 *
	 * @param requerimiento the requerimiento
	 * @param commpanyowner the commpanyowner
	 * @return the integer
	 */
	public Integer obtenerEtapaActual(String requerimiento, String commpanyowner);
}
