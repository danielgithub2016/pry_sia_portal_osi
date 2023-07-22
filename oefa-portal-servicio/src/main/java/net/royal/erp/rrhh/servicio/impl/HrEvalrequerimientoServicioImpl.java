package net.royal.erp.rrhh.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrEvalrequerimientoDao;
import net.royal.erp.rrhh.servicio.HrEvalrequerimientoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

/**
 * The Class HrEvalrequerimientoServicioImpl.
 */
@Service(value = "BeanServicioHrEvalrequerimiento")
public class HrEvalrequerimientoServicioImpl extends GenericoServicioImpl implements HrEvalrequerimientoServicio {
	private HrEvalrequerimientoDao dao;

	@Autowired
	public void setDao(HrEvalrequerimientoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
