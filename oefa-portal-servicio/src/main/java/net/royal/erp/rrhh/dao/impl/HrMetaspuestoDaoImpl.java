package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodoDao;
import net.royal.erp.rrhh.dao.HrMetaspuestoDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodo;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodoPk;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrMetaspuestoPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HrMetaspuestoDaoImpl extends
		GenericoDaoImpl<HrMetaspuesto, HrMetaspuestoPk> implements
		HrMetaspuestoDao {

	private static Log LOGGER = LogFactory.getLog(HrMetaspuesto.class);
	private HrEvaluacionperiodoDao daoEvaluacionperiodo;

	public HrMetaspuestoDaoImpl() {
		super("hrmetaspuesto");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Autowired
	public void setDaoEvaluacionperiodo(
			HrEvaluacionperiodoDao daoEvaluacionperiodo) {
		this.daoEvaluacionperiodo = daoEvaluacionperiodo;
	}

	@Override
	public List<HrMetaspuesto> listarTabObjetivosMetas(Integer codigopuesto) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigopuesto", codigopuesto));

		List<HrMetaspuesto> datos = this.listarPorCriterios(cri);
		
		if (UValidador.esListaVacia(datos))
			return null;
		
		HrEvaluacionperiodoPk pk = new HrEvaluacionperiodoPk();
		for (HrMetaspuesto x : datos) {
			
			if (UValidador.esNulo(x))
				return null;
			
			HrEvaluacionperiodo objevalperiodo = daoEvaluacionperiodo
					.ObtenerxSecuenciaeval(x.getSecuenciaeval());

			if (UValidador.esNulo(objevalperiodo))
				return null;
			
			x.setPeriodonombre(objevalperiodo.getDescripcion());


		}

		return datos;
	}

}
