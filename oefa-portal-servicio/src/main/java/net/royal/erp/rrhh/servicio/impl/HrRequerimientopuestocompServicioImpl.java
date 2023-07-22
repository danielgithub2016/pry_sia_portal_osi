package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestocompDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestocompServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestocomp;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestocompPk;

@Service (value = "BeanServicioHrRequerimientopuestocomp")
public class HrRequerimientopuestocompServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestocompServicio {

	private HrRequerimientopuestocompDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestocompServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestocompDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
