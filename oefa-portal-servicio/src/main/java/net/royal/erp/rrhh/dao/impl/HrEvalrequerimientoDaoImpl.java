package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEvalrequerimientoDao;
import net.royal.erp.rrhh.dominio.HrEvalrequerimiento;
import net.royal.erp.rrhh.dominio.HrEvalrequerimientoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

/**
 * The Class HrEvalrequerimientoDaoImpl.
 */
@Repository
public class HrEvalrequerimientoDaoImpl extends GenericoDaoImpl<HrEvalrequerimiento, HrEvalrequerimientoPk>
		implements HrEvalrequerimientoDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HrEvalrequerimientoDaoImpl() {
		super("hrevalrequerimiento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
}
