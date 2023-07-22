package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEmpleadoDao;
import net.royal.erp.rrhh.dominio.HrEmpleado;
import net.royal.erp.rrhh.dominio.HrEmpleadoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HrEmpleadoDaoImpl extends GenericoDaoImpl<HrEmpleado, HrEmpleadoPk> implements HrEmpleadoDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleado.class);

	public HrEmpleadoDaoImpl() {
		super("hrempleado");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
