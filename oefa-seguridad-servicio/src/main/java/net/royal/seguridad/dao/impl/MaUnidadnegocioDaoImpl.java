package net.royal.seguridad.dao.impl;

import javax.annotation.Resource;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.seguridad.dao.MaUnidadnegocioDao;
import net.royal.seguridad.dominio.MaUnidadnegocio;
import net.royal.seguridad.dominio.MaUnidadnegocioPk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("maUnidadnegocioDaoImplSeguridad")
public class MaUnidadnegocioDaoImpl extends
		GenericoDaoImpl<MaUnidadnegocio, MaUnidadnegocioPk> implements
		MaUnidadnegocioDao {

	private static Log LOGGER = LogFactory.getLog(MaUnidadnegocio.class);

	public MaUnidadnegocioDaoImpl() {
		super("seguridad.maunidadnegocio");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
