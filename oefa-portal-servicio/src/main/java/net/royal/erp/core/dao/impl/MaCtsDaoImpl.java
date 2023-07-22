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
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.core.dao.MaCtsDao;
import net.royal.erp.core.dominio.MaCts;
import net.royal.erp.core.dominio.MaCtsPk;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.planilla.dominio.dto.DtoPeriodos;

@Repository
public class MaCtsDaoImpl extends GenericoDaoImpl<MaCts, MaCtsPk> implements MaCtsDao {

	private static Log LOGGER = LogFactory.getLog(MaCts.class);

	public MaCtsDaoImpl() {
		super("macts");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<MaCts> obtenerCombo() {
		LOGGER.debug("Antes del combo");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.desc("pk.numerocts"));
		
		List<MaCts> result = this.listarPorCriterios(cri);

		return result;
	}

	@Override
	public List<DtoPeriodos> obtenerPeriodos() {
		LOGGER.debug("Antes del combo2");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.desc("pk.numerocts"));
		
		List<MaCts> result = this.listarPorCriterios(cri);
		return null;
	}

}
