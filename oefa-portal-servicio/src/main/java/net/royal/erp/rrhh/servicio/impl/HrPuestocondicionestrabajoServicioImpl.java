package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestocondicionestrabajoDao;
import net.royal.erp.rrhh.servicio.HrPuestocondicionestrabajoServicio;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajo;
import net.royal.erp.rrhh.dominio.HrPuestocondicionestrabajoPk;

@Service (value = "BeanServicioHrPuestocondicionestrabajo")
public class HrPuestocondicionestrabajoServicioImpl extends GenericoServicioImpl implements HrPuestocondicionestrabajoServicio {

	private HrPuestocondicionestrabajoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestocondicionestrabajoServicioImpl.class);

	@Autowired
	public void setDao(HrPuestocondicionestrabajoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestocondicionestrabajo> listarCondicionesTrabajo(
			Integer codigopuesto) {
		return dao.listarCondicionesTrabajo(codigopuesto);
	}

}
