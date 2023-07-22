package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestoexpDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestoexpServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestoexp;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestoexpPk;

@Service (value = "BeanServicioHrRequerimientopuestoexp")
public class HrRequerimientopuestoexpServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestoexpServicio {

	private HrRequerimientopuestoexpDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestoexpServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestoexpDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
