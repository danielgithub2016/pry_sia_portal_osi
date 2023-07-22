package net.royal.erp.rrhh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodocriterioDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterio;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterioPk;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrEvaluacionperiodocriterioDaoImpl
		extends
		GenericoDaoImpl<HrEvaluacionperiodocriterio, HrEvaluacionperiodocriterioPk>
		implements HrEvaluacionperiodocriterioDao {

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacionperiodocriterio.class);

	public HrEvaluacionperiodocriterioDaoImpl() {
		super("hrevaluacionperiodocriterio");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEvaluacionperiodocriterio> listarPorCompaniaSecuenciaTipoEval(
			String companiaSocio, Integer secuenciaEval, String tipoEval) {
		return this.listarPorCriterios(this.getCriteria().add(
				Restrictions.and(
						Restrictions.eq("pk.companyowner", companiaSocio),
						Restrictions.eq("pk.secuenciaeval", secuenciaEval),
						Restrictions.eq("pk.tipoevaluador", tipoEval))));
	}

}
