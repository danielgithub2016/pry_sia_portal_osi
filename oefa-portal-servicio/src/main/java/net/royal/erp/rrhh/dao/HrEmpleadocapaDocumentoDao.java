package net.royal.erp.rrhh.dao;

import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumento;
import net.royal.erp.rrhh.dominio.HrEmpleadocapaDocumentoPk;
import net.royal.framework.web.dao.GenericoDao;

/**
 * The Interface HrEmpleadocapaDocumentoDao.
 */
public interface HrEmpleadocapaDocumentoDao extends GenericoDao<HrEmpleadocapaDocumento, HrEmpleadocapaDocumentoPk> {

	/**
	 * Generar secuencia.
	 *
	 * @param capacitacion
	 *            the capacitacion
	 * @param empleado
	 *            the empleado
	 * @return the integer
	 */
	public Integer generarSecuencia(String capacitacion, Integer empleado);
}
