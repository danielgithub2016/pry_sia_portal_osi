package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrCargosmastDao;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrCargosmastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrCargosmastDaoImpl extends GenericoDaoImpl<HrCargosmast, HrCargosmastPk> implements HrCargosmastDao {

	private static Log LOGGER = LogFactory.getLog(HrCargosmast.class);

	public HrCargosmastDaoImpl() {
		super("hrcargosmast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrCargosmast> ListarCargosmast() {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("descripcionlocal"));
		List<HrCargosmast> datos = this.listarPorCriterios(cri);
		if(UValidador.esListaVacia(datos))
			return null;
		
		return datos;
	}

	@Override
	public HrCargosmast obtenerCargosmastxparam(String cargo) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.add(Restrictions.eq("pk.cargo", cargo));
		cri.addOrder(Order.asc("descripcionlocal"));
		
		List<HrCargosmast> datos = this.listarPorCriterios(cri);
		if(UValidador.esListaVacia(datos))
			return null;
		
		return datos.get(0);
	}

}
