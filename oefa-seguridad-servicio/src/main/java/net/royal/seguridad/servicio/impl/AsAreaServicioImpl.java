package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.AsAreaDao;
import net.royal.seguridad.servicio.AsAreaServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioAsAreaSeguridad")
public class AsAreaServicioImpl extends GenericoServicioImpl implements
		AsAreaServicio {

	private AsAreaDao dao;

	private static Log LOGGER = LogFactory.getLog(AsAreaServicioImpl.class);

	@Autowired
	@Qualifier("asAreaDaoImplSeguridad")
	public void setDao(AsAreaDao dao) {
		this.dao = dao;
		this.setGenericoDao(this.dao);
	}

}
