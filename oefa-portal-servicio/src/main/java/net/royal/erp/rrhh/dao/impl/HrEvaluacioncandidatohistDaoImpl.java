package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacioncandidatohistDao;
import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohist;
import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohistPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HrEvaluacioncandidatohistDaoImpl extends
		GenericoDaoImpl<HrEvaluacioncandidatohist, HrEvaluacioncandidatohistPk>
		implements HrEvaluacioncandidatohistDao {

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacioncandidatohist.class);

	public HrEvaluacioncandidatohistDaoImpl() {
		super("hrevaluacioncandidatohist");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<HrEvaluacioncandidatohist> listarCompetenciasxparam(
			String str_companyowner, Integer empleado) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", str_companyowner));
		cri.add(Restrictions.eq("empleado", empleado));
		
		cri.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<HrEvaluacioncandidatohist> datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;

	}

	@Override
	public void eliminarEvaluacionHistoria(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado,
			Integer parEvaluador, String parTipo) {

		HrEvaluacioncandidatohist evaHistoria = new HrEvaluacioncandidatohist();

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", parCompany));
		cri.add(Restrictions.eq("pk.secuencia", parSecuenciaEval));
		cri.add(Restrictions.eq("pk.evaluacion", parEvaluador));
		cri.add(Restrictions.eq("tipo", parTipo));
		cri.add(Restrictions.eq("empleado", parEmpleado));

		List<HrEvaluacioncandidatohist> lista = this.listarPorCriterios(cri);
		if (!UValidador.esListaVacia(lista)) {
			evaHistoria = lista.get(0);
			this.eliminar(evaHistoria);
		}
	}

	@Override
	public void insertarCandidatosHistoria(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado,
			Integer parEvaluador, String parTipo, Date wGetDate) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();

		parametros.add(new ParametroPersistenciaGenerico("iv_compania",
				String.class, parCompany));
		parametros.add(new ParametroPersistenciaGenerico("iv_secuencia",
				Integer.class, parSecuenciaEval));
		parametros.add(new ParametroPersistenciaGenerico("iv_empleado",
				Integer.class, parEmpleado));
		parametros.add(new ParametroPersistenciaGenerico(
				"iv_empleadoevaluador", Integer.class, parEvaluador));
		parametros.add(new ParametroPersistenciaGenerico("tipo", String.class,
				parTipo));
		parametros.add(new ParametroPersistenciaGenerico("w_getdate",
				Date.class, wGetDate));

		this.ejecutarPorQuery(
				"hrevaluacioncandidatohist.insertaEvaluacionCandidatos",
				parametros);

	}
	
	
	@Override
	public void grabarHistoriaEvaluacion(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado, Integer parEvaluador) {

		Date w_getdate;
		// ...Registro del historico de Evaluaciones:
		w_getdate = new Date();

		eliminarEvaluacionHistoria(parCompany, parSecuenciaEval, parEmpleado,
				parEvaluador, "N");

		insertarCandidatosHistoria(parCompany, parSecuenciaEval,
				parEmpleado, parEvaluador, "N", w_getdate);
		
		// ...Registro del historico de Potencial:
		eliminarEvaluacionHistoria(parCompany, parSecuenciaEval, parEmpleado,
				parEvaluador, "F");

		insertarCandidatosHistoria(parCompany, parSecuenciaEval,
				parEmpleado, parEvaluador, "F", w_getdate);

	}
}
