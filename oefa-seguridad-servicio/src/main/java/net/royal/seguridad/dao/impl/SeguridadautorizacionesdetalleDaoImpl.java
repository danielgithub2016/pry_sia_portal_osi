package net.royal.seguridad.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.seguridad.dao.SeguridadautorizacionesdetalleDao;
import net.royal.seguridad.dominio.Seguridadautorizacionesdetalle;
import net.royal.seguridad.dominio.SeguridadautorizacionesdetallePk;

@Repository("seguridadautorizacionesdetalleDaoImplSeguridad")
public class SeguridadautorizacionesdetalleDaoImpl extends GenericoDaoImpl<Seguridadautorizacionesdetalle, SeguridadautorizacionesdetallePk> implements SeguridadautorizacionesdetalleDao {

	private static Log LOGGER = LogFactory.getLog(Seguridadautorizacionesdetalle.class);

	public SeguridadautorizacionesdetalleDaoImpl() {
		super("seguridad.seguridadautorizacionesdetalle");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
