package net.royal.erp.rrhh.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrFactorvalorDao;
import net.royal.erp.rrhh.dominio.HrFactorvalor;
import net.royal.erp.rrhh.dominio.HrFactorvalorPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrFactorvalorSelCore;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository
public class HrFactorvalorDaoImpl extends
		GenericoDaoImpl<HrFactorvalor, HrFactorvalorPk> implements
		HrFactorvalorDao {

	private static Log LOGGER = LogFactory.getLog(HrFactorvalor.class);

	public HrFactorvalorDaoImpl() {
		super("hrfactorvalor");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<HrFactorvalor> obtenerLista(Integer factor) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.factor", factor));
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("pk.secuencia"));

		List datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return null;
		}

		return datos;
	}

	@Override
	public Integer obtenerMax(Integer factor) {
		LOGGER.debug("logger para obtener el maximo");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.factor", factor));
		cri.add(Restrictions.eq("estado", "A"));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("valorhasta"));

		cri.setProjection(proj);
		List lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		BigDecimal entero=(BigDecimal) lista.get(0);

		return entero.intValue();
	}

	@Override
	public Integer obtenerMim(Integer factor) {
		LOGGER.debug("logger para obtener el maximo");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.factor", factor));
		cri.add(Restrictions.eq("estado", "A"));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.min("valor"));

		cri.setProjection(proj);
		List lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;
		
		BigDecimal entero=(BigDecimal) lista.get(0);

		return entero.intValue();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<DtoDwHrFactorvalorSelCore> listarDw1(Integer par_factor) {
		List<ParametroPersistenciaGenerico> filtro = new ArrayList<ParametroPersistenciaGenerico>();
		filtro.add(new ParametroPersistenciaGenerico("par_factor",
				Integer.class, par_factor));
		return (List) this.listarPorQuery(DtoDwHrFactorvalorSelCore.class,
				"hrfactorvalor.listarDw1", filtro);
	}
}
