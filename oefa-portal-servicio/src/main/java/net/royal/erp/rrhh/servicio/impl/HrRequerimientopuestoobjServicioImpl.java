package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestoobjDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestoobjServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestoobj;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestoobjPk;

@Service (value = "BeanServicioHrRequerimientopuestoobj")
public class HrRequerimientopuestoobjServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestoobjServicio {

	private HrRequerimientopuestoobjDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestoobjServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestoobjDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
