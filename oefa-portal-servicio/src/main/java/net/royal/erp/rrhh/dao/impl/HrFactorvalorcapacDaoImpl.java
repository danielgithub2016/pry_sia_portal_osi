package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrFactorvalorcapacDao;
import net.royal.erp.rrhh.dominio.HrFactorvalorcapac;
import net.royal.erp.rrhh.dominio.HrFactorvalorcapacPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrFactorvalorcapacDaoImpl extends
		GenericoDaoImpl<HrFactorvalorcapac, HrFactorvalorcapacPk> implements
		HrFactorvalorcapacDao {

	private static Log LOGGER = LogFactory.getLog(HrFactorvalorcapac.class);

	public HrFactorvalorcapacDaoImpl() {
		super("hrfactorvalorcapac");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List listarFactor(Integer p_factor) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.factor", p_factor));

		List datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;

	}

	public String f_sql_factorvalorcapac_rango(Integer p_factor,
			BigDecimal p_respuesta) {
		String w_descripcion;

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.factor", p_factor));
		cri.add(Restrictions.eq("valor", p_respuesta));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("descripcion"));

		cri.setProjection(proj);

		List datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		w_descripcion = (String) datos.get(0);

		if (UValidador.esNulo(w_descripcion)) {
			w_descripcion = "";
		}

		return w_descripcion;
	}

}
