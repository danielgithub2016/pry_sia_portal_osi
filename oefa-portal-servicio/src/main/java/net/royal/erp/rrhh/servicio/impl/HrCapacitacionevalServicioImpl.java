package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrCapacitacionevalDao;
import net.royal.erp.rrhh.servicio.HrCapacitacionevalServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrCapacitacioneval")
public class HrCapacitacionevalServicioImpl extends GenericoServicioImpl
		implements HrCapacitacionevalServicio {

	private HrCapacitacionevalDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrCapacitacionevalServicioImpl.class);

	@Autowired
	public void setDao(HrCapacitacionevalDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List listarCapacitacionEval(String par_companyowner,
			String capacitacion) {
		return dao.listarCapacitacionEval(par_companyowner, capacitacion);
	}

}
