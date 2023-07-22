package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEncuestaDao;
import net.royal.erp.rrhh.dominio.HrEncuesta;
import net.royal.erp.rrhh.dominio.HrEncuestaPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrEncuestaDaoImpl extends GenericoDaoImpl<HrEncuesta, HrEncuestaPk> implements HrEncuestaDao {

	private static Log LOGGER = LogFactory.getLog(HrEncuesta.class);

	public HrEncuestaDaoImpl() {
		super("hrencuesta");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
