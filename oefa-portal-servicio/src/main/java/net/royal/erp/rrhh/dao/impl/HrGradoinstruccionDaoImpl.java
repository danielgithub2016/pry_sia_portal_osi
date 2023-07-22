package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrGradoinstruccionDao;
import net.royal.erp.rrhh.dominio.HrGradoinstruccion;
import net.royal.erp.rrhh.dominio.HrGradoinstruccionPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrGradoinstruccionDaoImpl extends GenericoDaoImpl<HrGradoinstruccion, HrGradoinstruccionPk> implements HrGradoinstruccionDao {

	private static Log LOGGER = LogFactory.getLog(HrGradoinstruccion.class);

	public HrGradoinstruccionDaoImpl() {
		super("hrgradoinstruccion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
