package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodovalorDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodovalor;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodovalorPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository
public class HrEvaluacionperiodovalorDaoImpl extends
		GenericoDaoImpl<HrEvaluacionperiodovalor, HrEvaluacionperiodovalorPk>
		implements HrEvaluacionperiodovalorDao {

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacionperiodovalor.class);

	public HrEvaluacionperiodovalorDaoImpl() {
		super("hrevaluacionperiodovalor");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<DtoDwHrFactorvalorSelCore> listarEvaluacionPeriodoEvaluar(
			BigDecimal psecuenciaeval) {
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("secuenciaeval", BigDecimal.class,
				psecuenciaeval));

		List datos = this.listarPorQuery(DtoDwHrFactorvalorSelCore.class, "hrevaluacionperiodovalor.listarEvaluacionPeriodoEvaluar",
				filtro);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;
	}
}
