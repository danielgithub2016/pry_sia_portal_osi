package net.royal.erp.rrhh.dao.impl;

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

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrPuestosimilarDao;
import net.royal.erp.rrhh.dominio.HrPuestoriesgotrabajo;
import net.royal.erp.rrhh.dominio.HrPuestosimilar;
import net.royal.erp.rrhh.dominio.HrPuestosimilarPk;

@Repository
public class HrPuestosimilarDaoImpl extends GenericoDaoImpl<HrPuestosimilar, HrPuestosimilarPk> implements HrPuestosimilarDao {

	private static Log LOGGER = LogFactory.getLog(HrPuestosimilar.class);

	public HrPuestosimilarDaoImpl() {
		super("hrpuestosimilar");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrPuestosimilar> listarPuestosSimilar(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrPuestosimilar> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
	}

}
