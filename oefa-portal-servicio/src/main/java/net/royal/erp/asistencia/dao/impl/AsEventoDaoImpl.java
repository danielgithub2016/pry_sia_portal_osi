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
import net.royal.erp.asistencia.dao.AsEventoDao;
import net.royal.erp.asistencia.dominio.AsEvento;
import net.royal.erp.asistencia.dominio.AsEventoPk;

@Repository
public class AsEventoDaoImpl extends GenericoDaoImpl<AsEvento, AsEventoPk>
		implements AsEventoDao {

	private static Log LOGGER = LogFactory.getLog(AsEvento.class);

	public AsEventoDaoImpl() {
		super("asevento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
