package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrRequerimientofunpracDao;
import net.royal.erp.rrhh.dominio.HrRequerimientofunprac;
import net.royal.erp.rrhh.dominio.HrRequerimientofunpracPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrRequerimientofunpracDaoImpl extends
		GenericoDaoImpl<HrRequerimientofunprac, HrRequerimientofunpracPk>
		implements HrRequerimientofunpracDao {

	private static Log LOGGER = LogFactory.getLog(HrRequerimientofunprac.class);

	public HrRequerimientofunpracDaoImpl() {
		super("hrrequerimientofunprac");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HrRequerimientofunprac> listarRequerimientoFunPrac(
			String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.requerimiento", requerimiento));

		return cri.list();
	}

}
