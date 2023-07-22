package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrEvaluacionesrangoDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrango;
import net.royal.erp.rrhh.dominio.HrEvaluacionesrangoPk;

@Repository
public class HrEvaluacionesrangoDaoImpl extends GenericoDaoImpl<HrEvaluacionesrango, HrEvaluacionesrangoPk> implements HrEvaluacionesrangoDao {

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionesrango.class);

	public HrEvaluacionesrangoDaoImpl() {
		super("hrevaluacionesrango");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public String ObtenerEvaluacionesRango(BigDecimal desde,
			BigDecimal hasta) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.le("desde", desde)); 
		cri.add(Restrictions.ge("hasta", hasta));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("descripcion"));
		
		cri.setProjection(proj);

		List lista = cri.list();

		if (UValidador.esListaVacia(lista))
			return null;

		return (String) lista.get(0);

	}


}
