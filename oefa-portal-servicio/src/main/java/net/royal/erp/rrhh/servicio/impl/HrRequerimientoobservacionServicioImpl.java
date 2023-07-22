package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientoobservacionDao;
import net.royal.erp.rrhh.servicio.HrRequerimientoobservacionServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientoobservacion;
import net.royal.erp.rrhh.dominio.HrRequerimientoobservacionPk;

@Service (value = "BeanServicioHrRequerimientoobservacion")
public class HrRequerimientoobservacionServicioImpl extends GenericoServicioImpl implements HrRequerimientoobservacionServicio {

	private HrRequerimientoobservacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientoobservacionServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientoobservacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
