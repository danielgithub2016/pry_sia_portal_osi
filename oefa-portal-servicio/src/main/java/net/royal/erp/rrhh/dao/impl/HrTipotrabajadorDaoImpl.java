package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrTipotrabajadorDao;
import net.royal.erp.rrhh.dominio.HrTipotrabajador;
import net.royal.erp.rrhh.dominio.HrTipotrabajadorPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrTipotrabajadorDaoImpl extends
		GenericoDaoImpl<HrTipotrabajador, HrTipotrabajadorPk> implements
		HrTipotrabajadorDao {

	private static Log LOGGER = LogFactory.getLog(HrTipotrabajador.class);

	public HrTipotrabajadorDaoImpl() {
		super("hrtipotrabajador");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrTipotrabajador> listarTipoTrabajadorActivo() {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("descripcionlocal"));

		List<HrTipotrabajador> lista = this.listarPorCriterios(cri);

		return lista;
	}

}
