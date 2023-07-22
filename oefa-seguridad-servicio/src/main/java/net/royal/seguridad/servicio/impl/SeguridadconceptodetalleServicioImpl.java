package net.royal.seguridad.servicio.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.SeguridadconceptodetalleDao;
import net.royal.seguridad.servicio.SeguridadconceptodetalleServicio;

@Service(value = "BeanServicioSeguridadconceptodetalleSeguridad")
public class SeguridadconceptodetalleServicioImpl extends GenericoServicioImpl
		implements SeguridadconceptodetalleServicio {

	private SeguridadconceptodetalleDao dao;

	private static Log LOGGER = LogFactory.getLog(SeguridadconceptodetalleServicioImpl.class);

	@Autowired
	@Qualifier("seguridadconceptodetalleDaoImplSeguridad")
	public void setDao(SeguridadconceptodetalleDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
