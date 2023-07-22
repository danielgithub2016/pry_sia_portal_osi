package net.royal.erp.planilla.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import net.royal.erp.planilla.dao.PrPlanillaEmpleadoDao;
import net.royal.erp.planilla.dominio.PrPlanillaEmpleado;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings("serial")
@Repository
public class PrPlanillaEmpleadoDaoImpl extends GenericoDaoImpl<PrPlanillaEmpleado, Serializable> implements PrPlanillaEmpleadoDao {

	@SuppressWarnings("unused")
	private static Log LOGGER = LogFactory.getLog(PrPlanillaEmpleado.class);
	
	public PrPlanillaEmpleadoDaoImpl() {
		super("PrPlanillaEmpleado");
	}
	
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
}
