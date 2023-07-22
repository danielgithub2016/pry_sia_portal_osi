package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ObligacionesDao;
import net.royal.erp.core.servicio.ObligacionesServicio;

import net.royal.erp.core.dominio.Obligaciones;
import net.royal.erp.core.dominio.ObligacionesPk;

@Service (value = "BeanServicioObligaciones")
public class ObligacionesServicioImpl extends GenericoServicioImpl implements ObligacionesServicio {

	private ObligacionesDao dao;

	private static Log LOGGER = LogFactory.getLog(ObligacionesServicioImpl.class);

	@Autowired
	public void setDao(ObligacionesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
