package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.CompaniadistribucionsplitcxpDao;
import net.royal.erp.core.dominio.Companiadistribucionsplitcxp;
import net.royal.erp.core.dominio.CompaniadistribucionsplitcxpPk;

@Repository
public class CompaniadistribucionsplitcxpDaoImpl extends GenericoDaoImpl<Companiadistribucionsplitcxp, CompaniadistribucionsplitcxpPk> implements CompaniadistribucionsplitcxpDao {

	private static Log LOGGER = LogFactory.getLog(Companiadistribucionsplitcxp.class);

	public CompaniadistribucionsplitcxpDaoImpl() {
		super("companiadistribucionsplitcxp");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Companiadistribucionsplitcxp> listarCompaniaSplit(
			String companiaCodigo) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.compania", companiaCodigo));
		
		return this.listarPorCriterios(cri);
	}

}
