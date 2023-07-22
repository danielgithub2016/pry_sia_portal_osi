package net.royal.erp.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.CompanyownerDao;
import net.royal.erp.core.dominio.Companyowner;
import net.royal.erp.core.dominio.CompanyownerPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyownerDaoImpl extends
		GenericoDaoImpl<Companyowner, CompanyownerPk> implements
		CompanyownerDao {

	private static Log LOGGER = LogFactory.getLog(Companyowner.class);

	public CompanyownerDaoImpl() {
		super("companyowner");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Companyowner> listarEjecutoras() {
		return this.listarPorCriterios(this.getCriteria().add(
				Restrictions.ne("pk.companyowner", "99999900")));
	}

}
