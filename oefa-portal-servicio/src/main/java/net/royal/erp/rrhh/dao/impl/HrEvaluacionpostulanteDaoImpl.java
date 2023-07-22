package net.royal.erp.rrhh.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.erp.rrhh.dao.HrEvaluacionpostulanteDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionpostulante;
import net.royal.erp.rrhh.dominio.HrEvaluacionpostulantePk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

/**
 * The Class HrEvaluacionpostulanteDaoImpl.
 */
@Repository
public class HrEvaluacionpostulanteDaoImpl extends GenericoDaoImpl<HrEvaluacionpostulante, HrEvaluacionpostulantePk>
		implements HrEvaluacionpostulanteDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HrEvaluacionpostulanteDaoImpl() {
		super("hrevaluacionpostulante");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}
}
