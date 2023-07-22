package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEmpleadofuncionDao;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncionPk;
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
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HrEmpleadofuncionDaoImpl extends GenericoDaoImpl<HrEmpleadofuncion, HrEmpleadofuncionPk>
		implements HrEmpleadofuncionDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadofuncion.class);

	public HrEmpleadofuncionDaoImpl() {
		super("hrempleadofuncion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadofuncion> ObtenerEmpleadoFuncionporParametros(String companyowner, Integer empleado,
			Integer secuenciaeval, Integer empleadoevaluador) {

		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));

		List datos = this.listarPorCriterios(cri);
		if (UValidador.esListaVacia(datos)) {
			return null;
		}
		return datos;
	}

	public Integer obtenerMaximoSecuencia(Integer iv_empleado, Integer iv_secuencia) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", iv_empleado));
		cri.add(Restrictions.eq("pk.secuencia", iv_secuencia));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));

		cri.setProjection(proj);

		List<HrEmpleadofuncion> datos = listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos)) {
			return 1;
		}

		return datos.get(0).getPk().getSecuencia() + 1;
	}

	@Override
	public void grabarEmpleadoFuncion(List<HrEmpleadofuncion> dw11) {
		List<HrEmpleadofuncion> dw11ARemover = new ArrayList<HrEmpleadofuncion>();

		for (HrEmpleadofuncion dw_11 : dw11) {
			HrEmpleadofuncion empleadoFuncion = new HrEmpleadofuncion();
			HrEmpleadofuncionPk pk = new HrEmpleadofuncionPk();

			pk.setCompanyowner(dw_11.getPk().getCompanyowner());
			pk.setEmpleado(dw_11.getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_11.getPk().getEmpleadoevaluador());
			pk.setSecuencia(dw_11.getPk().getSecuencia());
			pk.setSecuenciaeval(dw_11.getPk().getSecuenciaeval());

			empleadoFuncion = this.obtenerPorId(pk, false);

			if (UValidador.estaVacio(dw_11.getEliminado())) {
				dw_11.setEliminado("N");
			}
			
			if (UValidador.esNulo(dw_11.getEliminado())) {
				dw_11.setEliminado("N");
			}
			

				if (dw_11.getEliminado().equals("N")) {
					empleadoFuncion = this.obtenerPorId(pk, false);
					if (UValidador.esNulo(empleadoFuncion)) {
						empleadoFuncion = new HrEmpleadofuncion();
						empleadoFuncion.setPk(pk);

						setearValores(dw_11, empleadoFuncion);

						this.registrar(empleadoFuncion);
					} else {
						setearValores(dw_11, empleadoFuncion);
						this.actualizar(empleadoFuncion);
					}

				} else {
					empleadoFuncion = this.obtenerPorId(pk, false);
					if (!UValidador.esNulo(empleadoFuncion)) {
						this.eliminar(empleadoFuncion);
					} else {
						dw11ARemover.add(dw_11);
					}
				}
			
		}

		for (int i = 0; i < dw11ARemover.size(); i++) {
			for (int a = 0; a < dw11.size(); a++) {
				if (dw11.get(a).getPk().getSecuencia().equals(dw11ARemover.get(i).getPk().getSecuencia())
						&& dw11.get(a).getEliminado().equals("S")) {

					dw11.remove(a);
				}
			}
		}

	}

	private void setearValores(HrEmpleadofuncion dw_11, HrEmpleadofuncion empleadoFuncion) {

		empleadoFuncion.setAlcanzado(dw_11.getAlcanzado());
		empleadoFuncion.setCalificacion(dw_11.getCalificacion());
		empleadoFuncion.setComentarios(dw_11.getComentarios());
		empleadoFuncion.setFactorparticipacion(dw_11.getFactorparticipacion());
		empleadoFuncion.setFactorsecuencia(dw_11.getFactorsecuencia());
		empleadoFuncion.setFuncion(dw_11.getFuncion());
		empleadoFuncion.setUltimaFechaModif(dw_11.getUltimaFechaModif());
		empleadoFuncion.setUltimoUsuario(dw_11.getUltimoUsuario());

	}
}
