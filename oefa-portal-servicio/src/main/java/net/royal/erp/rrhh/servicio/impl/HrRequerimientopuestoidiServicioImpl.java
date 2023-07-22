package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestoidiDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestoidiServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestoidi;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestoidiPk;

@Service (value = "BeanServicioHrRequerimientopuestoidi")
public class HrRequerimientopuestoidiServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestoidiServicio {

	private HrRequerimientopuestoidiDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestoidiServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestoidiDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
