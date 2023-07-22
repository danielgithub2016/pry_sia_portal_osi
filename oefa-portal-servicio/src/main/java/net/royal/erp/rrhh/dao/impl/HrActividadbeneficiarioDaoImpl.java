package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrActividadbeneficiarioDao;
import net.royal.erp.rrhh.dominio.HrActividadbeneficiario;
import net.royal.erp.rrhh.dominio.HrActividadbeneficiarioPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrActividadbeneficiarioDaoImpl extends GenericoDaoImpl<HrActividadbeneficiario, HrActividadbeneficiarioPk> implements HrActividadbeneficiarioDao {

	private static Log LOGGER = LogFactory.getLog(HrActividadbeneficiario.class);

	public HrActividadbeneficiarioDaoImpl() {
		super("hractividadbeneficiario");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
