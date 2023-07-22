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
import net.royal.seguridad.dao.ClientemastDao;
import net.royal.seguridad.dominio.Clientemast;
import net.royal.seguridad.dominio.ClientemastPk;

@Repository("clientemastDaoImplSeguridad")
public class ClientemastDaoImpl extends GenericoDaoImpl<Clientemast, ClientemastPk> implements ClientemastDao {

	private static Log LOGGER = LogFactory.getLog(Clientemast.class);

	public ClientemastDaoImpl() {
		super("seguridad.clientemast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
