package net.royal.erp.asistencia.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.asistencia.dao.AsAccesosdiariosDao;
import net.royal.erp.asistencia.dominio.AsAccesosdiarios;
import net.royal.erp.asistencia.dominio.AsAccesosdiariosPk;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AsAccesosdiariosDaoImpl extends
		GenericoDaoImpl<AsAccesosdiarios, AsAccesosdiariosPk> implements
		AsAccesosdiariosDao {

	private static Log LOGGER = LogFactory.getLog(AsAccesosdiarios.class);

	public AsAccesosdiariosDaoImpl() {
		super("asaccesosdiarios");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	/**
	 * 
	 * Listar AsMarcar controladora: cwasmarcar
	 */
	@Override
	public List<AsAccesosdiarios> listarAsMarcar(String w_carnet,
			Date fechadesde, Date fechahasta) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.carnetid", w_carnet));
		cri.add(Restrictions.between("pk.fecha", fechadesde, fechahasta));

		List result = this.listarPorCriterios(cri);

		return result;
	}

	/**
	 * 
	 * Obtiene al empleado controladora: cwasmarcar
	 */
	@Override
	public Integer obtenerEmpleado(String w_carnet, Date w_fecha) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.carnetid", w_carnet));
		cri.add(Restrictions.eq("pk.fecha", w_fecha));

		List result = this.listarPorCriterios(cri);

		if (result.size() == 0)
			return null;

		AsAccesosdiarios accesoDiario = (AsAccesosdiarios) result.get(0);

		return accesoDiario.getPk().getEmpleado();

	}

	@Override
	public Integer obtenerTerminal(Integer empleado, Date fecha) {
		Criteria cri = this.getCriteria().add(
				Restrictions.and(Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("pk.fecha", fecha)));
		List<AsAccesosdiarios> lista = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(lista))
			return null;

		return lista.get(0).getTerminal();
	}

	@Override
	public void eliminarPorCamposA(Integer empleadoA, Date fechaA,
			String conceptoaccesoA, Date fechadesdeA) {
		List<AsAccesosdiarios> lista = this.listarPorCriterios(this
				.getCriteria().add(
						Restrictions.and(Restrictions
								.eq("empleadoA", empleadoA), Restrictions.eq(
								"fechaA", fechaA), Restrictions.eq(
								"conceptoaccesoA", conceptoaccesoA),
								Restrictions.eq("desdeA", fechadesdeA))));

		if (!UValidador.esListaVacia(lista)) {
			this.eliminar(lista.get(0));
		}

	}

	@Override
	public Integer incrementarPorEmpleadoFecha(Integer empleado, Date fecha) {
		Criteria cri = this
				.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("pk.fecha", fecha)))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("pk.secuencia")));

		return this.incrementarInteger(cri);
	}

	@Override
	public void eliminarPorEmpleadoFecha(Integer empleado, Date fecha) {
		// TODO Auto-generated method stub
		List<AsAccesosdiarios> lista = this.listarPorCriterios(this
				.getCriteria().add(
						Restrictions.and(
								Restrictions.eq("pk.empleado", empleado),
								Restrictions.eq("pk.fecha", fecha))));

		if (!UValidador.esListaVacia(lista)) {
			for (AsAccesosdiarios obj : lista) {
				this.eliminar(obj);
			}

		}
	}

	@Override
	public List<AsAccesosdiarios> listarAccesosdiariosxparam(Integer empleado,
			Date fechaA, Date fechaB) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.between("pk.fecha", fechaA, fechaB));

		List<AsAccesosdiarios> result = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(result))
			return null;
		
		return result;
	}

}
