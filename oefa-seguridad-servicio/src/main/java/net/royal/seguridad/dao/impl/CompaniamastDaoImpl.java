package net.royal.seguridad.dao.impl;

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
import net.royal.seguridad.dao.CompaniamastDao;
import net.royal.seguridad.dominio.Companiamast;
import net.royal.seguridad.dominio.CompaniamastPk;
import net.royal.seguridad.dominio.Empleadomast;

@Repository("companiamastDaoImplSeguridad")
public class CompaniamastDaoImpl extends GenericoDaoImpl<Companiamast, CompaniamastPk> implements CompaniamastDao {

	private static Log LOGGER = LogFactory.getLog(Companiamast.class);

	public CompaniamastDaoImpl() {
		super("seguridad.companiamast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String obtenerPlanContable(String companiaCodigo) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companiacodigo", companiaCodigo));
		List<Companiamast> list = this
				.listarPorCriterios(cri);
		if (list==null)
			return null;
		if (list.size()!=1)
			return null;
		return list.get(0).getPlancontable();
	}

}
