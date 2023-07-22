package net.royal.seguridad.servicio.impl;

import java.util.List;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.MaUnidadnegocioDao;
import net.royal.seguridad.dominio.MaUnidadnegocio;
import net.royal.seguridad.servicio.MaUnidadnegocioServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioMaUnidadnegocioSeguridad")
public class MaUnidadnegocioServicioImpl extends GenericoServicioImpl implements
		MaUnidadnegocioServicio {

	private MaUnidadnegocioDao dao;

	private static Log LOGGER = LogFactory
			.getLog(MaUnidadnegocioServicioImpl.class);

	@Autowired
	@Qualifier("maUnidadnegocioDaoImplSeguridad")
	public void setDao(MaUnidadnegocioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
}
