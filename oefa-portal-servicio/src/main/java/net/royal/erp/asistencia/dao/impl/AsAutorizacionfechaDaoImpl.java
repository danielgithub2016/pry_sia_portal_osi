package net.royal.erp.asistencia.dao.impl;

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
import net.royal.erp.asistencia.dao.AsAutorizacionfechaDao;
import net.royal.erp.asistencia.dominio.AsAutorizacionfecha;
import net.royal.erp.asistencia.dominio.AsAutorizacionfechaPk;

@Repository
public class AsAutorizacionfechaDaoImpl extends GenericoDaoImpl<AsAutorizacionfecha, AsAutorizacionfechaPk> implements AsAutorizacionfechaDao {

	private static Log LOGGER = LogFactory.getLog(AsAutorizacionfecha.class);

	public AsAutorizacionfechaDaoImpl() {
		super("asautorizacionfecha");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
