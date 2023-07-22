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
import net.royal.seguridad.dao.SeguridadautorizacionesdetalleDao;
import net.royal.seguridad.dominio.Seguridadautorizacionesdetalle;
import net.royal.seguridad.dominio.SeguridadautorizacionesdetallePk;
import net.royal.seguridad.servicio.SeguridadautorizacionesdetalleServicio;

@Service (value = "BeanServicioSeguridadautorizacionesdetalleSeguridad")
public class SeguridadautorizacionesdetalleServicioImpl extends GenericoServicioImpl implements SeguridadautorizacionesdetalleServicio {

	private SeguridadautorizacionesdetalleDao dao;

	private static Log LOGGER = LogFactory.getLog(SeguridadautorizacionesdetalleServicioImpl.class);

	@Autowired
	@Qualifier("seguridadautorizacionesdetalleDaoImplSeguridad")
	public void setDao(SeguridadautorizacionesdetalleDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
