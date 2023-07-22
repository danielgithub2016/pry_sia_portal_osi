package net.royal.seguridad.dao.impl;

import java.math.BigDecimal;
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
import net.royal.seguridad.dao.ImpuestosDao;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.dominio.Impuestos;
import net.royal.seguridad.dominio.ImpuestosPk;

@Repository("impuestosDaoImplSeguridad")
public class ImpuestosDaoImpl extends GenericoDaoImpl<Impuestos, ImpuestosPk> implements ImpuestosDao {

	private static Log LOGGER = LogFactory.getLog(Impuestos.class);

	public ImpuestosDaoImpl() {
		super("seguridad.impuestos");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public BigDecimal obtenerFactorPorcentaje(String impuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.impuesto", impuesto));
		List<Impuestos> list = this
				.listarPorCriterios(cri);
		if (list==null)
			return null;
		if (list.size()!=1)
			return null;
		return list.get(0).getFactorporcentaje();
	}

}
