package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestoestDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestoestServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestoest;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestoestPk;

@Service (value = "BeanServicioHrRequerimientopuestoest")
public class HrRequerimientopuestoestServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestoestServicio {

	private HrRequerimientopuestoestDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestoestServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestoestDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
