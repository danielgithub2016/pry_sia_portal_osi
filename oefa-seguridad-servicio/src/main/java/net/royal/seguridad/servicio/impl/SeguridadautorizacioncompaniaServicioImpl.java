package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.SeguridadautorizacioncompaniaDao;
import net.royal.seguridad.dominio.Seguridadautorizacioncompania;
import net.royal.seguridad.dominio.SeguridadautorizacioncompaniaPk;
import net.royal.seguridad.servicio.SeguridadautorizacioncompaniaServicio;

@Service (value = "BeanServicioSeguridadautorizacioncompaniaSeguridad")
public class SeguridadautorizacioncompaniaServicioImpl extends GenericoServicioImpl implements SeguridadautorizacioncompaniaServicio {

	private SeguridadautorizacioncompaniaDao dao;

	private static Log LOGGER = LogFactory.getLog(SeguridadautorizacioncompaniaServicioImpl.class);

	@Autowired
	@Qualifier("seguridadautorizacioncompaniaDaoImplSeguridad")
	public void setDao(SeguridadautorizacioncompaniaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
