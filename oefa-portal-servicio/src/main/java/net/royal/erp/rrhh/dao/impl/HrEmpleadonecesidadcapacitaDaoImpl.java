package net.royal.erp.rrhh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.erp.rrhh.dao.HrEmpleadonecesidadcapacitaDao;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacitaPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;

@Repository
public class HrEmpleadonecesidadcapacitaDaoImpl
		extends
		GenericoDaoImpl<HrEmpleadonecesidadcapacita, HrEmpleadonecesidadcapacitaPk>
		implements HrEmpleadonecesidadcapacitaDao {

	private static Log LOGGER = LogFactory
			.getLog(HrEmpleadonecesidadcapacita.class);

	public HrEmpleadonecesidadcapacitaDaoImpl() {
		super("hrempleadonecesidadcapacita");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	@Override
	public List<HrEmpleadonecesidadcapacita> ListarEmpleadoNecesidadCapacitaxParam(
			String companyowner, Integer empleado, Integer secuenciaeval) {

		Criteria cri = this.getCriteria();

		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));

		List datos = this.listarPorCriterios(cri);

		return datos;
	}

	@Override
	public Integer ObtenerMaximaSecuencia(Integer empleado,
			Integer secuenciaeval) {

		Criteria cri = this
				.getCriteria()
				.add(Restrictions.and(Restrictions.eq("pk.empleado", empleado),
						Restrictions.eq("pk.secuenciaeval", secuenciaeval)))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("pk.secuencia")));

		return this.incrementarInteger(cri);

	}

	@Override
	public void grabarEmpleadoNecesidad(
			List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7) {

		List<DtoDwHrEmpleadonecesidadcapacitaEdit> dw7ARemover = new ArrayList<DtoDwHrEmpleadonecesidadcapacitaEdit>();

		for (DtoDwHrEmpleadonecesidadcapacitaEdit dw_7 : dw7) {
			HrEmpleadonecesidadcapacitaPk pk = new HrEmpleadonecesidadcapacitaPk();
			HrEmpleadonecesidadcapacita necesidad = new HrEmpleadonecesidadcapacita();

			pk.setCompanyowner(dw_7.getBean().getPk().getCompanyowner());
			pk.setEmpleado(dw_7.getBean().getPk().getEmpleado());
			pk.setEmpleadoevaluador(dw_7.getBean().getPk()
					.getEmpleadoevaluador());
			pk.setSecuencia(dw_7.getBean().getPk().getSecuencia());
			pk.setSecuenciaeval(dw_7.getBean().getPk().getSecuenciaeval());
			//
			if (dw_7.getEliminado().equals("N")) {
				necesidad = this.obtenerPorId(pk,false);
				if (UValidador.esNulo(necesidad)) {
					necesidad = new HrEmpleadonecesidadcapacita();
					necesidad.setPk(pk);

					setearValores(dw_7, necesidad);

					this.registrar(necesidad);
				} else {
					setearValores(dw_7, necesidad);
					this.actualizar(necesidad);
				}

			} else {
				necesidad = this.obtenerPorId(pk,false);
				if (!UValidador.esNulo(necesidad)) {
					this.eliminar(necesidad);
				} else {
					dw7ARemover.add(dw_7);
				}
			}
		}

		for (int i = 0; i < dw7ARemover.size(); i++) {
			for (int a = 0; a < dw7.size(); a++) {
				if (dw7.get(a)
						.getBean()
						.getPk()
						.getSecuencia()
						.equals(dw7ARemover.get(i).getBean().getPk()
								.getSecuencia())
						&& dw7.get(a).getEliminado().equals("S")) {
					   
					dw7.remove(a);

				}
			}
		}
	}

	private void setearValores(DtoDwHrEmpleadonecesidadcapacitaEdit dw_7,
			HrEmpleadonecesidadcapacita necesidad) {
		necesidad.setCapacitacion(dw_7.getBean().getCapacitacion());
		necesidad.setCurso(dw_7.getBean().getCurso());
		necesidad.setNecesidad(dw_7.getBean().getNecesidad());
		necesidad.setObjetivo(dw_7.getBean().getObjetivo());
		necesidad.setPrioridad(dw_7.getBean().getPrioridad());
		necesidad.setUltimaFechaModif(dw_7.getBean().getUltimaFechaModif());
		necesidad.setUltimoUsuario(dw_7.getBean().getUltimoUsuario());
	}

}
