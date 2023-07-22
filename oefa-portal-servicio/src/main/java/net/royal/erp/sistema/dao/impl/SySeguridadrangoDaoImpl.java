package net.royal.erp.sistema.dao.impl;

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
import net.royal.erp.sistema.dao.SySeguridadrangoDao;
import net.royal.erp.sistema.dominio.SySeguridadrango;
import net.royal.erp.sistema.dominio.SySeguridadrangoPk;

@Repository
public class SySeguridadrangoDaoImpl extends GenericoDaoImpl<SySeguridadrango, SySeguridadrangoPk> implements SySeguridadrangoDao {

	private static Log LOGGER = LogFactory.getLog(SySeguridadrango.class);

	public SySeguridadrangoDaoImpl() {
		super("syseguridadrango");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
