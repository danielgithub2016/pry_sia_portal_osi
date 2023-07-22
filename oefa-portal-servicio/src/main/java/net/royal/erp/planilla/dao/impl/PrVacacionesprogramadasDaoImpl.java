package net.royal.erp.planilla.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.planilla.dao.PrVacacionesprogramadasDao;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadas;
import net.royal.erp.planilla.dominio.PrVacacionesprogramadasPk;
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
public class PrVacacionesprogramadasDaoImpl extends GenericoDaoImpl<PrVacacionesprogramadas, PrVacacionesprogramadasPk>
		implements PrVacacionesprogramadasDao {

	private static Log LOGGER = LogFactory.getLog(PrVacacionesprogramadas.class);

	public PrVacacionesprogramadasDaoImpl() {
		super("prvacacionesprogramadas");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public BigDecimal obtenerMaximoVacacionesProgramadas(Integer empleado, String periodo) {
		LOGGER.debug("logger para prueba");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", BigDecimal.valueOf(empleado)));
		cri.add(Restrictions.eq("pk.periodo", periodo));
		// cri.add(Restrictions.eq("pk.estadovacacion", BigDecimal.ZERO));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));

		cri.setProjection(proj);

		return incrementarBigDecimal(cri);
	}

	@Override
	public List<PrVacacionesprogramadas> listarVacacionesProgramadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", BigDecimal.valueOf(empleado)));
		// cri.add(Restrictions.eq("pk.numeroperiodo", BigDecimal.ONE));
//		cri.add(Restrictions.eq("pk.estadovacacion", BigDecimal.ZERO));
		cri.add(Restrictions.eq("periodoasistencia", periodoasistencia));
		cri.add(Restrictions.eq("fechainicio", fechainicio));
		cri.add(Restrictions.eq("fechafin", fechafin));

		return cri.list();
	}

	@Override
	public List<PrVacacionesprogramadas> listarVacacionesEjecutadas(Integer empleado, String periodoasistencia,
			Date fechainicio, Date fechafin) {
		// TODO Auto-generated method stub
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", BigDecimal.valueOf(empleado)));
		cri.add(Restrictions.eq("pk.numeroperiodo", BigDecimal.ONE));
		cri.add(Restrictions.eq("pk.estadovacacion", BigDecimal.ONE));
		cri.add(Restrictions.eq("periodoasistencia", periodoasistencia));
		cri.add(Restrictions.eq("fechainicio", fechainicio));
		cri.add(Restrictions.eq("fechafin", fechafin));

		return cri.list();
	}

}
