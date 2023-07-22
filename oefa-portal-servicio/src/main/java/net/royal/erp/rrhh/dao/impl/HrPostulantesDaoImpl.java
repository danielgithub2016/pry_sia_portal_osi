package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrPostulantesDao;
import net.royal.erp.rrhh.dominio.HrPostulantes;
import net.royal.erp.rrhh.dominio.HrPostulantesPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings("serial")
@Repository("hrPostulantesDaoImpl")
public class HrPostulantesDaoImpl extends
		GenericoDaoImpl<HrPostulantes, HrPostulantesPk> implements
		HrPostulantesDao {

	@SuppressWarnings("unused")
	private static Log LOGGER = LogFactory.getLog(HrPostulantesDaoImpl.class);

	public HrPostulantesDaoImpl() {
		super("hrpostulantes");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
