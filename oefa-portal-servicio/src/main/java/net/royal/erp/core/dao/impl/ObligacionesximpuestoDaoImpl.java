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
import net.royal.erp.core.dao.ObligacionesximpuestoDao;
import net.royal.erp.core.dominio.Obligacionesximpuesto;
import net.royal.erp.core.dominio.ObligacionesximpuestoPk;

@Repository
public class ObligacionesximpuestoDaoImpl extends GenericoDaoImpl<Obligacionesximpuesto, ObligacionesximpuestoPk> implements ObligacionesximpuestoDao {

	private static Log LOGGER = LogFactory.getLog(Obligacionesximpuesto.class);

	public ObligacionesximpuestoDaoImpl() {
		super("obligacionesximpuesto");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<Obligacionesximpuesto> listarPorIdObligaciones(
			Integer proveedor, String tipodocumento, String numerodocumento,
			String impuesto) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.proveedor", proveedor));
		cri.add(Restrictions.eq("pk.tipodocumento", tipodocumento));
		cri.add(Restrictions.eq("pk.numerodocumento", numerodocumento));
		cri.addOrder(Order.asc("pk.impuesto"));
		List result = this.listarPorCriterios(cri);
		
		return result;
	}

}
