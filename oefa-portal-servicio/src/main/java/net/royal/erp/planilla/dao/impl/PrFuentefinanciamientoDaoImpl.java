package net.royal.erp.planilla.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.royal.erp.planilla.dao.PrFuentefinanciamientoDao;
import net.royal.erp.planilla.dominio.PrFuentefinanciamiento;
import net.royal.erp.planilla.dominio.PrFuentefinanciamientoPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings("serial")
@Repository
public class PrFuentefinanciamientoDaoImpl extends GenericoDaoImpl<PrFuentefinanciamiento, PrFuentefinanciamientoPk>
		implements PrFuentefinanciamientoDao {

	public PrFuentefinanciamientoDaoImpl() {
		super("prfuentefinanciamiento");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<PrFuentefinanciamiento> listarPorAnioCompania(String anio, String compania) {
		Criteria criteria;

		criteria = this.getCriteria().add(Restrictions.and(Restrictions.eq("pk.ano", anio),
				Restrictions.eq("pk.companiasocio", compania), Restrictions.eq("estado", "A")));

		criteria.addOrder(Order.asc("descripcion"));

		return this.listarPorCriterios(criteria);
	}

}
