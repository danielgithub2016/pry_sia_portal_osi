package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoriesgotrabajoDao;
import net.royal.erp.rrhh.servicio.HrPuestoriesgotrabajoServicio;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajoPk;

@Service (value = "BeanServicioHrPuestoriesgotrabajo")
public class HrPuestoriesgotrabajoServicioImpl extends GenericoServicioImpl implements HrPuestoriesgotrabajoServicio {

	private HrPuestoriesgotrabajoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoriesgotrabajoServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoriesgotrabajoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoriesgotrabajo> listarRiesgosTrabajo(Integer codigopuesto) {
		return dao.listarRiesgosTrabajo(codigopuesto);
	}

}
