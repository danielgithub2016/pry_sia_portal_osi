package net.royal.erp.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.core.dao.ReferencefieldvaluesDao;
import net.royal.erp.core.dominio.Referencefieldvalues;
import net.royal.erp.core.dominio.ReferencefieldvaluesPk;

@Repository
public class ReferencefieldvaluesDaoImpl extends
		GenericoDaoImpl<Referencefieldvalues, ReferencefieldvaluesPk> implements
		ReferencefieldvaluesDao {

	private static Log LOGGER = LogFactory.getLog(Referencefieldvalues.class);

	public ReferencefieldvaluesDaoImpl() {
		super("referencefieldvalues");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<Referencefieldvalues> listaDw1(String ReferenceField) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.referencefield", ReferenceField));
		cri.addOrder(Order.asc("pk.referencevalue"));

		List result = this.listarPorCriterios(cri);

		return result;

	}

}
