package net.royal.erp.sistema.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.sistema.dao.SySeguridadrangoDao;
import net.royal.erp.sistema.servicio.SySeguridadrangoServicio;

import net.royal.erp.sistema.dominio.SySeguridadrango;
import net.royal.erp.sistema.dominio.SySeguridadrangoPk;

@Service (value = "BeanServicioSySeguridadrango")
public class SySeguridadrangoServicioImpl extends GenericoServicioImpl implements SySeguridadrangoServicio {

	private SySeguridadrangoDao dao;

	private static Log LOGGER = LogFactory.getLog(SySeguridadrangoServicioImpl.class);

	@Autowired
	public void setDao(SySeguridadrangoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
