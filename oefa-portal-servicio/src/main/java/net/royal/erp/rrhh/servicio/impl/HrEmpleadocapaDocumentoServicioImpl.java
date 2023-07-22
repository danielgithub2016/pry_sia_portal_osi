/**
 * 
 */
package net.royal.erp.rrhh.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrEmpleadocapaDocumentoDao;
import net.royal.erp.rrhh.servicio.HrEmpleadocapaDocumentoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

/**
 * The Class HrEmpleadocapaDocumentoServicioImpl.
 *
 * @author nunezh
 */
@Service(value = "BeanServicioHrEmpleadocapaDocumento")
public class HrEmpleadocapaDocumentoServicioImpl extends GenericoServicioImpl
		implements HrEmpleadocapaDocumentoServicio {

	private HrEmpleadocapaDocumentoDao dao;

	/**
	 * Sets the dao.
	 *
	 * @param dao
	 *            the new dao
	 */
	@Autowired
	public void setDao(HrEmpleadocapaDocumentoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
