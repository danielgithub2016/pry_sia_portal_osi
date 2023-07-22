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
import net.royal.seguridad.dao.SeguridadautorizacionreporteDao;
import net.royal.seguridad.dominio.Seguridadautorizacionreporte;
import net.royal.seguridad.dominio.SeguridadautorizacionreportePk;
import net.royal.seguridad.servicio.SeguridadautorizacionreporteServicio;

@Service (value = "BeanServicioSeguridadautorizacionreporteSeguridad")
public class SeguridadautorizacionreporteServicioImpl extends GenericoServicioImpl implements SeguridadautorizacionreporteServicio {

	private SeguridadautorizacionreporteDao dao;

	private static Log LOGGER = LogFactory.getLog(SeguridadautorizacionreporteServicioImpl.class);

	@Autowired
	@Qualifier("seguridadautorizacionreporteDaoImplSeguridad")
	public void setDao(SeguridadautorizacionreporteDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
