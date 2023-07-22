package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestoDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestoServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuesto;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestoPk;

@Service (value = "BeanServicioHrRequerimientopuesto")
public class HrRequerimientopuestoServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestoServicio {

	private HrRequerimientopuestoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestoServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
