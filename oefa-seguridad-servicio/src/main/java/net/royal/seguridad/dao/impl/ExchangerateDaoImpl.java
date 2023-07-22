package net.royal.seguridad.dao.impl;

import java.util.ArrayList;
import java.util.Date;
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

import net.royal.framework.web.core.UFechaHora;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.seguridad.dao.ExchangerateDao;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.dominio.Exchangerate;
import net.royal.seguridad.dominio.ExchangeratePk;

@Repository("exchangerateDaoImplSeguridad")
public class ExchangerateDaoImpl extends GenericoDaoImpl<Exchangerate, ExchangeratePk> implements ExchangerateDao {

	private static Log LOGGER = LogFactory.getLog(Exchangerate.class);

	public ExchangerateDaoImpl() {
		super("seguridad.exchangerate");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public Exchangerate obtenerPorPeriodo(Date fecha) {
		String periodo;
		
		periodo = UFechaHora.formatearFecha(fecha, "yyyyMM");
		
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.period", periodo));
		List<Exchangerate> list = this
				.listarPorCriterios(cri);
		
		if (list==null)
			return null;
		if (list.size()!=1)
			return null;
		return list.get(0);
	}

}
