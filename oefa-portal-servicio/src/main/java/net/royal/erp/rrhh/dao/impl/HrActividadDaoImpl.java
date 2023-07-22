package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrActividadDao;
import net.royal.erp.rrhh.dominio.HrActividad;
import net.royal.erp.rrhh.dominio.HrActividadPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrActividadDaoImpl extends
		GenericoDaoImpl<HrActividad, HrActividadPk> implements HrActividadDao {

	private static Log LOGGER = LogFactory.getLog(HrActividad.class);

	public HrActividadDaoImpl() {
		super("hractividad");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
