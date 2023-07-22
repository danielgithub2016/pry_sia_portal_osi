package net.royal.erp.asistencia.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsCarnetidentificacionDao;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacion;
import net.royal.erp.asistencia.dominio.AsCarnetidentificacionPk;
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
public class AsCarnetidentificacionDaoImpl extends
		GenericoDaoImpl<AsCarnetidentificacion, AsCarnetidentificacionPk>
		implements AsCarnetidentificacionDao {

	private static Log LOGGER = LogFactory.getLog(AsCarnetidentificacion.class);

	public AsCarnetidentificacionDaoImpl() {
		super("ascarnetidentificacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 * Obtiene maximo codigo de carnet controladora: cwasmarcar
	 */
	@Override
	public String obtenerMaximoCodigoCarnet(Integer w_empleado) {
		LOGGER.debug("logger para obtenerMaximoCodigoCarnet");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", w_empleado));
		List result = this.listarPorCriterios(cri);

		if (result.size() == 0)
			return null;

		AsCarnetidentificacion carnetIde = (AsCarnetidentificacion) result
				.get(0);

		return carnetIde.getPk().getCodigocarnet();
	}

	/**
	 * Obtiene el maximo empleado por carnet controladora: cwasmarcar
	 */
	@Override
	public Integer obtenerMaximoEmpleadoXCarnet(String w_carnet) {
		LOGGER.debug("logger para obtenerMaximoEmpleadoCarnet");
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.codigocarnet", w_carnet));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.empleado"));

		cri.setProjection(proj);

		if (UValidador.estaVacio(cri.list())) {
			return 0;
		}

		return (Integer) cri.list().get(0);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String obtenerMaximoComportamientoSobretiempo(Integer empleado) {
		List lista = this
				.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("estado", "A")))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("comportamientosobretiempo")))
				.list();

		if (UValidador.esListaVacia(lista))
			return null;

		return (String) lista.get(0);
	}

	@Override
	public String obtenerMaximoCodigoCarnetActivo(Integer w_empleado) {
		// TODO Auto-generated method stub
		String codigomaximo = null;
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.and(
						Restrictions.eq("pk.empleado", w_empleado),
						Restrictions.eq("estado", "A")))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("pk.codigocarnet")));

		List result = cri.list();

		if (!UValidador.esListaVacia(result)) {
			codigomaximo = (String) result.get(0);
		}

		return codigomaximo;
	}
}
