package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestoforDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestoforServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestofor;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestoforPk;

@Service (value = "BeanServicioHrRequerimientopuestofor")
public class HrRequerimientopuestoforServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestoforServicio {

	private HrRequerimientopuestoforDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestoforServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestoforDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
