package net.royal.erp.core.dao.impl;

import java.math.BigDecimal;
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
import net.royal.erp.core.dao.OrdenpagoDao;
import net.royal.erp.core.dominio.Ordenpago;
import net.royal.erp.core.dominio.OrdenpagoPk;

@Repository
public class OrdenpagoDaoImpl extends GenericoDaoImpl<Ordenpago, OrdenpagoPk> implements OrdenpagoDao {

	private static Log LOGGER = LogFactory.getLog(Ordenpago.class);

	public OrdenpagoDaoImpl() {
		super("ordenpago");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Ordenpago obtenerPorId(BigDecimal proveedor, String tipodocumento,
			String numerodocumento) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.proveedor", proveedor));
		cri.add(Restrictions.eq("pk.tipodocumento", tipodocumento));
		cri.add(Restrictions.eq("pk.numerodocumento", numerodocumento));		
		List result = this.listarPorCriterios(cri);
		
		if (result==null)
			return null;
		if (result.size()!=1)
			return null;
		
		return (Ordenpago) result.get(0);
	}

}
