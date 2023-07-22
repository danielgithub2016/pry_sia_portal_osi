package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrGradosalariomastDao;
import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.dominio.HrGradosalariomastPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrGradosalariomastDaoImpl extends
		GenericoDaoImpl<HrGradosalariomast, HrGradosalariomastPk> implements
		HrGradosalariomastDao {

	private static Log LOGGER = LogFactory.getLog(HrGradosalariomast.class);

	public HrGradosalariomastDaoImpl() {
		super("hrgradosalariomast");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public HrGradosalariomast obtenerGradoSalarioxParam(String gradosalario) {
		Criteria c = this.getCriteria();
		c.add(Restrictions.eq("pk.gradosalario", gradosalario));
		c.add(Restrictions.eq("estado", "A"));
		c.addOrder(Order.asc("descripcionlocal"));

		List<HrGradosalariomast> datos = this.listarPorCriterios(c);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos.get(0);
	}

	@Override
	public HrGradosalariomast obtenerGradoSalarioxCargo(String cargo) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("cargo", cargo));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.min("pk.gradosalario"));

		cri.setProjection(proj);

		List lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		return (HrGradosalariomast) lista.get(0);
	}

	public List listarGradoSalario(String ls_familia) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));

		cri.addOrder(Order.asc("descripcionlocal"));
		
		cri.add(Restrictions.sqlRestriction(" NVL(CATEGORIA,1) = NVL( '"
				+ ls_familia + "', NVL(CATEGORIA,1)) "));
		
		List lista = cri.list();

		if (UValidador.esListaVacia(lista)) {
			return null;
		}

		return lista;
	}
}
