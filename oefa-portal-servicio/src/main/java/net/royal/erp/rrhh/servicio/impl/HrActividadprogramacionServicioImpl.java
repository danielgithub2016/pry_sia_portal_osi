package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrActividadprogramacionDao;
import net.royal.erp.rrhh.servicio.HrActividadprogramacionServicio;

import net.royal.erp.rrhh.dominio.HrActividadprogramacion;
import net.royal.erp.rrhh.dominio.HrActividadprogramacionPk;

@Service (value = "BeanServicioHrActividadprogramacion")
public class HrActividadprogramacionServicioImpl extends GenericoServicioImpl implements HrActividadprogramacionServicio {

	private HrActividadprogramacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrActividadprogramacionServicioImpl.class);

	@Autowired
	public void setDao(HrActividadprogramacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
