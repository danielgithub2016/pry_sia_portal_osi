package net.royal.framework.web.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.framework.web.dao.ComunDao;

@Repository
public class ComunDaoImpl extends GenericoDaoImpl<Object, Long> implements
		ComunDao {

	private static final long serialVersionUID = 1068424617811161830L;
	private static final Log LOGGER = LogFactory.getLog(ComunDaoImpl.class);

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
