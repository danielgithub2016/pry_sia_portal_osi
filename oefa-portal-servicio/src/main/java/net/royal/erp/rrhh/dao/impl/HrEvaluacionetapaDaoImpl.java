package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEvaluacionetapaDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionetapa;
import net.royal.erp.rrhh.dominio.HrEvaluacionetapaPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@Repository
public class HrEvaluacionetapaDaoImpl extends GenericoDaoImpl<HrEvaluacionetapa, HrEvaluacionetapaPk>
		implements HrEvaluacionetapaDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HrEvaluacionetapaDaoImpl() {
		super("hrevaluacionetapa");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
