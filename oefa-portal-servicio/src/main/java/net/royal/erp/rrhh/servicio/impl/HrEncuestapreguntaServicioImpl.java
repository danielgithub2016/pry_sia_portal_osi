package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEncuestapreguntaDao;
import net.royal.erp.rrhh.servicio.HrEncuestapreguntaServicio;

import net.royal.erp.rrhh.dominio.HrEncuestapregunta;
import net.royal.erp.rrhh.dominio.HrEncuestapreguntaPk;

@Service (value = "BeanServicioHrEncuestapregunta")
public class HrEncuestapreguntaServicioImpl extends GenericoServicioImpl implements HrEncuestapreguntaServicio {

	private HrEncuestapreguntaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEncuestapreguntaServicioImpl.class);

	@Autowired
	public void setDao(HrEncuestapreguntaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
