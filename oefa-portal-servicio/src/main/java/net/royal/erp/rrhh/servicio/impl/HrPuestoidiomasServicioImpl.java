package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoidiomasDao;
import net.royal.erp.rrhh.servicio.HrPuestoidiomasServicio;
import net.royal.erp.rrhh.dominio.HrPuestoidiomas;
import net.royal.erp.rrhh.dominio.HrPuestoidiomasPk;

@Service (value = "BeanServicioHrPuestoidiomas")
public class HrPuestoidiomasServicioImpl extends GenericoServicioImpl implements HrPuestoidiomasServicio {

	private HrPuestoidiomasDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoidiomasServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoidiomasDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoidiomas> listarPuestoidiomas(Integer codigopuesto) {
		return dao.listarPuestoidiomas(codigopuesto);
	}

}
