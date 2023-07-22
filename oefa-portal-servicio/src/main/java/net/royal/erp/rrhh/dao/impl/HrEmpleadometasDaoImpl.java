package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrEmpleadometasDao;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEmpleadometasPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HrEmpleadometasDaoImpl extends
		GenericoDaoImpl<HrEmpleadometas, HrEmpleadometasPk> implements
		HrEmpleadometasDao {

	private static Log LOGGER = LogFactory.getLog(HrEmpleadometas.class);

	public HrEmpleadometasDaoImpl() {
		super("hrempleadometas");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadometas> ListarEmpleadoMetasporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {
		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));

		List datos = this.listarPorCriterios(cri);

		if (UValidador.esNulo(datos)) {
			return null;
		}
		return datos;
	}

	@Override
	public void guardarHrEmpleadoMetas(List<HrEmpleadometas> dw6) {

		List<HrEmpleadometas> dw6ARemover = new ArrayList<HrEmpleadometas>();

		for (HrEmpleadometas dw_6 : dw6) {
			HrEmpleadometasPk pk = new HrEmpleadometasPk();
			HrEmpleadometas necesidad = new HrEmpleadometas();

			pk.setCompanyowner(dw_6.getPk().getCompanyowner());
			pk.setEmpleado(dw_6.getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_6.getPk().getEmpleadoevaluador());
			pk.setSecuencia(dw_6.getPk().getSecuencia());
			pk.setSecuenciaeval(dw_6.getPk().getSecuenciaeval());
			//
			if (dw_6.getEliminado().equals("N")) {
				necesidad = this.obtenerPorId(pk,false);
				if (UValidador.esNulo(necesidad)) {
					necesidad = new HrEmpleadometas();
					necesidad.setPk(pk);

					setearValores(dw_6, necesidad);

					this.registrar(necesidad);
				} else {
					setearValores(dw_6, necesidad);
					this.actualizar(necesidad);
				}

			} else {
				necesidad = this.obtenerPorId(pk,false);
				if (!UValidador.esNulo(necesidad)) {
					this.eliminar(necesidad);
				} else {
					dw6ARemover.add(dw_6);
				}
			}
		}

		for (int i = 0; i < dw6ARemover.size(); i++) {
			for (int a = 0; a < dw6.size(); a++) {
				if (dw6.get(a).getPk().getSecuencia()
						.equals(dw6ARemover.get(i).getPk().getSecuencia())
						&& dw6.get(a).getEliminado().equals("S")) {

					dw6.remove(a);

				}
			}
		}
	}

	private void setearValores(HrEmpleadometas dw_6, HrEmpleadometas necesidad) {
		necesidad.setAlcanzado(dw_6.getAlcanzado());
		necesidad.setCalificacion(dw_6.getCalificacion());
		necesidad.setComentarios(dw_6.getComentarios());
		necesidad.setDescripcion(dw_6.getDescripcion());
		necesidad.setFactorparticipacion(dw_6.getFactorparticipacion());
		necesidad.setFactorsecuencia(dw_6.getFactorsecuencia());

		necesidad.setPeriodo(obtenerPeriodo(dw_6.getPeriodo()));
		necesidad.setPlazo(dw_6.getPlazo());
		necesidad.setSecuenciaevalpos(dw_6.getSecuenciaevalpos());
		necesidad.setUltimaFechaModif(dw_6.getUltimaFechaModif());
		necesidad.setUltimoUsuario(dw_6.getUltimoUsuario());
	}

	private String obtenerPeriodo(String periodoExterno) {
		String periodo = periodoExterno;
		String periodocad;
		if (!UValidador.estaVacio(periodoExterno)
				&& periodoExterno.length() > 6) {
			periodocad = periodoExterno.substring(5, 7);
			periodoExterno = periodoExterno.substring(0, 4);
			periodo = periodoExterno + periodocad;
		}
		return periodo;
	}

}
