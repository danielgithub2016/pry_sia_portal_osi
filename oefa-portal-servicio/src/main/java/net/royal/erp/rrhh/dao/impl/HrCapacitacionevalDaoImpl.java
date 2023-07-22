package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrCapacitacionevalDao;
import net.royal.erp.rrhh.dominio.HrCapacitacioneval;
import net.royal.erp.rrhh.dominio.HrCapacitacionevalPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrCapacitacionevalDaoImpl extends
		GenericoDaoImpl<HrCapacitacioneval, HrCapacitacionevalPk> implements
		HrCapacitacionevalDao {

	private static Log LOGGER = LogFactory.getLog(HrCapacitacioneval.class);

	public HrCapacitacionevalDaoImpl() {
		super("hrcapacitacioneval");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List listarCapacitacionEval(String par_companyowner,
			String capacitacion) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", par_companyowner));
		cri.add(Restrictions.eq("pk.capacitacion", capacitacion));

		List datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;
	}
}
