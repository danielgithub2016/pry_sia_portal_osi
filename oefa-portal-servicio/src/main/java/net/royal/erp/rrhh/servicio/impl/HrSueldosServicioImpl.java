package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrSueldosDao;
import net.royal.erp.rrhh.servicio.HrSueldosServicio;

import net.royal.erp.rrhh.dominio.HrSueldos;
import net.royal.erp.rrhh.dominio.HrSueldosPk;

@Service (value = "BeanServicioHrSueldos")
public class HrSueldosServicioImpl extends GenericoServicioImpl implements HrSueldosServicio {

	private HrSueldosDao dao;

	private static Log LOGGER = LogFactory.getLog(HrSueldosServicioImpl.class);

	@Autowired
	public void setDao(HrSueldosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
