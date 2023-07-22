package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientodocaprobacionDao;
import net.royal.erp.rrhh.servicio.HrRequerimientodocaprobacionServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientodocaprobacion;
import net.royal.erp.rrhh.dominio.HrRequerimientodocaprobacionPk;

@Service (value = "BeanServicioHrRequerimientodocaprobacion")
public class HrRequerimientodocaprobacionServicioImpl extends GenericoServicioImpl implements HrRequerimientodocaprobacionServicio {

	private HrRequerimientodocaprobacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientodocaprobacionServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientodocaprobacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
