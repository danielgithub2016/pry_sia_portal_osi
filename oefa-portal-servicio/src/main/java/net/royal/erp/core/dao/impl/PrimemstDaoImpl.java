package net.royal.erp.core.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.core.dao.PrimemstDao;
import net.royal.erp.core.dominio.Primemst;
import net.royal.erp.core.dominio.PrimemstPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PrimemstDaoImpl extends GenericoDaoImpl<Primemst, PrimemstPk> implements PrimemstDao {

	private static Log LOGGER = LogFactory.getLog(Primemst.class);

	public PrimemstDaoImpl() {
		super("primemst");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Primemst obtenerPorId(String prime) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.prime", prime));	
		List result = this.listarPorCriterios(cri);
		if (result.size()==1)
			return (Primemst) result.get(0);
		return null;
	}

	@Override
	public List<Primemst> listarCombo(Integer DigitsNumber) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("status", "A"));
		cri.add(Restrictions.eq("digitsnumber", DigitsNumber));
		cri.addOrder(Order.asc("pk.prime"));
		
		List result = this.listarPorCriterios(cri);
		
		return result;
	}

}
