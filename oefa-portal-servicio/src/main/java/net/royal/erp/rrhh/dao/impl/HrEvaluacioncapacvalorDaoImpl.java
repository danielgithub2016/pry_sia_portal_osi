package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEvaluacioncapacvalorDao;
import net.royal.erp.rrhh.dominio.HrEvaluacioncapacvalor;
import net.royal.erp.rrhh.dominio.HrEvaluacioncapacvalorPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrEvaluacionCapacValor;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HrEvaluacioncapacvalorDaoImpl extends
		GenericoDaoImpl<HrEvaluacioncapacvalor, HrEvaluacioncapacvalorPk>
		implements HrEvaluacioncapacvalorDao {

	private static Log LOGGER = LogFactory.getLog(HrEvaluacioncapacvalor.class);

	public HrEvaluacioncapacvalorDaoImpl() {
		super("hrevaluacioncapacvalor");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public String f_sql_evaluacioncapacvalor_des(Integer par_evaluacion,
			BigDecimal par_valor) {
		String w_FlagAprobado;
		String p_valor;

		par_valor = BigDecimal.valueOf(par_valor.intValue());

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("valor", par_valor));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("valor"));

		cri.setProjection(proj);

		List datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		p_valor = (String) datos.get(0);

		Criteria cro = this.getCriteria();
		cro.add(Restrictions.eq("valor", p_valor));

		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.max("flagaprobado"));

		cro.setProjection(proj);

		List datos1 = this.listarPorCriterios(cro);
		if (UValidador.esListaVacia(datos1)) {
			return null;
		}

		w_FlagAprobado = (String) datos.get(0);
		return w_FlagAprobado;
	}

	public List listarEvaluacion(Integer par_evaluacion) {
		
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_evaluacion", Integer.class, par_evaluacion));
		
		List datos = this.listarPorQuery(DtoHrEvaluacionCapacValor.class, "hrevaluacioncapacvalor.dwhrevaluacioncapacvalorlist", filtro);
	
		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;
	}

}
