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
import net.royal.seguridad.dao.SeguridadgrupoDao;
import net.royal.seguridad.dominio.Seguridadgrupo;
import net.royal.seguridad.dominio.SeguridadgrupoPk;
import net.royal.seguridad.servicio.SeguridadgrupoServicio;

@Service (value = "BeanServicioSeguridadgrupoSeguridad")
public class SeguridadgrupoServicioImpl extends GenericoServicioImpl implements SeguridadgrupoServicio {

	private SeguridadgrupoDao dao;

	private static Log LOGGER = LogFactory.getLog(SeguridadgrupoServicioImpl.class);

	@Autowired
	@Qualifier("seguridadgrupoDaoImplSeguridad")
	public void setDao(SeguridadgrupoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
