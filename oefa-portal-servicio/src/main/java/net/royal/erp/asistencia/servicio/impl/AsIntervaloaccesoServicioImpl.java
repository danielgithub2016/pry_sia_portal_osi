package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.asistencia.dao.AsIntervaloaccesoDao;
import net.royal.erp.asistencia.servicio.AsIntervaloaccesoServicio;

import net.royal.erp.asistencia.dominio.AsIntervaloacceso;
import net.royal.erp.asistencia.dominio.AsIntervaloaccesoPk;

@Service(value = "BeanServicioAsIntervaloacceso")
public class AsIntervaloaccesoServicioImpl extends GenericoServicioImpl
		implements AsIntervaloaccesoServicio {

	private AsIntervaloaccesoDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsIntervaloaccesoServicioImpl.class);

	@Autowired
	public void setDao(AsIntervaloaccesoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
