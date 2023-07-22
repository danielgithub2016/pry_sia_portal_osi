package net.royal.erp.rrhh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.royal.erp.rrhh.dao.HrDetalleevaluacionDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionPk;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dao.impl.GenericoDaoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HrDetalleevaluacionDaoImpl extends
		GenericoDaoImpl<HrDetalleevaluacion, HrDetalleevaluacionPk> implements
		HrDetalleevaluacionDao {

	private static Log LOGGER = LogFactory.getLog(HrDetalleevaluacion.class);

	public HrDetalleevaluacionDaoImpl() {
		super("hrdetalleevaluacion");
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public List<HrDetalleevaluacion> obtenerLista(String companyowner,
			Integer secuencia, Integer empleado, Integer empleadoevaluador,String tipo) {
		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", companyowner));
		cri.add(Restrictions.eq("pk.secuencia", secuencia));
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.empleadoevaluador", empleadoevaluador));
		cri.add(Restrictions.eq("pk.tipo",tipo));

		List datos = this.listarPorCriterios(cri);

		if (UValidador.esListaVacia(datos))
			return null;

		return datos;
	}
	
	
	@Override
	public void grabarDetalleEvaluacion(List<DtoHrDetalleEvaluacion> dw1) {

		for (DtoHrDetalleEvaluacion dw_1 : dw1) {
			HrDetalleevaluacion detalle = new HrDetalleevaluacion();
			HrDetalleevaluacionPk pk = new HrDetalleevaluacionPk();

			pk.setCompanyowner(dw_1.getCompanyowner());
			pk.setEmpleado(dw_1.getEmpleado().intValue());
			pk.setEmpleadoevaluador(dw_1.getEmpleadoevaluador().intValue());
			pk.setSecuencia(dw_1.getSecuencia().intValue());
			pk.setSecuenciaeval(dw_1.getSecuenciaeval().intValue());
			pk.setTipo(dw_1.getTipo());

			detalle = this.obtenerPorId(pk,false);

			if (UValidador.esNulo(detalle)) {
				detalle = new HrDetalleevaluacion();
				detalle.setPk(pk);
				setearValores(dw_1, detalle);
				this.registrar(detalle);
			} else {
				setearValores(dw_1, detalle);
				this.actualizar(detalle);
			}
		}
	}

	private void setearValores(DtoHrDetalleEvaluacion dw1Origen,
			HrDetalleevaluacion detalle) {

		detalle.setCalificacion(dw1Origen.getCalificacion());
		detalle.setFactor(dw1Origen.getFactor());
		detalle.setFactorcompetencia(dw1Origen.getFactorcompetencia());
		detalle.setFactorponderacion(dw1Origen.getFactorponderacion());
		detalle.setOrdenfactor(dw1Origen.getOrdenfactor());
		detalle.setPlantilla(dw1Origen.getPlantilla());
		detalle.setSecuenciacompetencia(dw1Origen.getSecuenciacompetencia());
		detalle.setUltimaFechaModif(new Date());
		detalle.setValorcompetencia(dw1Origen.getValorcompetencia());
		detalle.setValorhastacompetencia(dw1Origen.getValorhastacompetencia());

	}

	@Override
	public Integer obtenerMaximoDetalleEvaluacion(Integer empleado,
			Integer secuenciaeval) {

		Criteria cri = this.getCriteria();
		cri.add(Restrictions.eq("pk.empleado", empleado));
		cri.add(Restrictions.eq("pk.secuenciaeval", secuenciaeval));
		cri.add(Restrictions.eq("pk.tipo", "O"));

		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("pk.secuencia"));

		cri.setProjection(proj);


		return incrementarInteger(cri);

	}
	
	
	@Override
	public void grabarEvaluacionDetalleP(
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9) {
		for (DtoDwHrEmpleadoevaluacionDetailP dw_9 : dw9) {
			HrDetalleevaluacion detalle = new HrDetalleevaluacion();
			HrDetalleevaluacionPk pk = new HrDetalleevaluacionPk();

			pk.setCompanyowner(dw_9.getCompanyowner());
			pk.setEmpleado(dw_9.getEmpleado().intValue());
			pk.setEmpleadoevaluador(dw_9.getEmpleadoevaluador().intValue());
			pk.setSecuencia(dw_9.getSecuencia().intValue());
			pk.setSecuenciaeval(dw_9.getSecuenciaeval().intValue());
			pk.setTipo(dw_9.getTipo());

			detalle = this.obtenerPorId(pk,false);

			if (UValidador.esNulo(detalle)) {
				detalle = new HrDetalleevaluacion();
				detalle.setPk(pk);
				setearValoresDetalle(dw_9, detalle);
				this.registrar(detalle);
			} else {
				setearValoresDetalle(dw_9, detalle);
				this.actualizar(detalle);
			}
		}

	}

	private void setearValoresDetalle(
			DtoDwHrEmpleadoevaluacionDetailP dw1Origen,
			HrDetalleevaluacion detalle) {

		detalle.setCalificacion(dw1Origen.getCalificacion());
		detalle.setFactor(dw1Origen.getFactor());
		detalle.setFactorponderacion(dw1Origen.getFactorponderacion());
		detalle.setOrdenfactor(dw1Origen.getOrdenfactor());
		detalle.setPlantilla(dw1Origen.getPlantilla());
		detalle.setUltimaFechaModif(new Date());
	}

	@Override
	public void grabardwCampo(List<HrDetalleevaluacion> dwCampo) {
		for (HrDetalleevaluacion dw_campo : dwCampo) {
			HrDetalleevaluacion detalle = new HrDetalleevaluacion();
			HrDetalleevaluacionPk pk = new HrDetalleevaluacionPk();

			pk.setCompanyowner(dw_campo.getPk().getCompanyowner());
			pk.setEmpleado(dw_campo.getPk().getEmpleado().intValue());
			pk.setEmpleadoevaluador(dw_campo.getPk().getEmpleadoevaluador()
					.intValue());
			pk.setSecuencia(dw_campo.getPk().getSecuencia().intValue());
			pk.setSecuenciaeval(dw_campo.getPk().getSecuenciaeval().intValue());
			pk.setTipo(dw_campo.getPk().getTipo());

			detalle = this.obtenerPorId(pk,false);

			if (UValidador.esNulo(detalle)) {
				detalle = new HrDetalleevaluacion();
				detalle.setPk(pk);
				setearValoresCampo(dw_campo, detalle);
				this.registrar(detalle);
			} else {
				setearValoresCampo(dw_campo, detalle);
				this.actualizar(detalle);
			}
		}
	}

	private void setearValoresCampo(HrDetalleevaluacion dw_campo,
			HrDetalleevaluacion detalle) {
		detalle.setAreaponderacion(dw_campo.getAreaponderacion());
		detalle.setBrecha(dw_campo.getBrecha());
		detalle.setCalificacion(dw_campo.getCalificacion());
		detalle.setCalificacionponderada(dw_campo.getCalificacionponderada());
		detalle.setComentario(dw_campo.getComentario());
		detalle.setComentarios(dw_campo.getComentarios());
		detalle.setCursosdesarrollo(dw_campo.getCursosdesarrollo());
		detalle.setDescripcion(dw_campo.getDescripcion());
		detalle.setEjecuciondesde(dw_campo.getEjecuciondesde());
		detalle.setEjecucionhasta(dw_campo.getEjecucionhasta());
		detalle.setFactor(dw_campo.getFactor());
		detalle.setFactorcompetencia(dw_campo.getFactorcompetencia());
		detalle.setFactorparticipacion(dw_campo.getFactorparticipacion());
		detalle.setFactorponderacion(dw_campo.getFactorponderacion());
		detalle.setFactorsecuencia(dw_campo.getFactorsecuencia());
		detalle.setFlagcapacitacion(dw_campo.getFlagcapacitacion());
		detalle.setOrdenfactor(dw_campo.getOrdenfactor());
		detalle.setPercentil(dw_campo.getPercentil());
		detalle.setPlantilla(dw_campo.getPlantilla());
		detalle.setRespaldaobjetivos(dw_campo.getRespaldaobjetivos());
		detalle.setSecuenciacompetencia(dw_campo.getSecuenciacompetencia());
		detalle.setUltimaFechaModif(new Date());
		detalle.setUltimoUsuario(dw_campo.getUltimoUsuario());
		detalle.setUnidadnegocio(dw_campo.getUnidadnegocio());
		detalle.setValorcompetencia(dw_campo.getValorcompetencia());
		detalle.setValorhastacompetencia(dw_campo.getValorhastacompetencia());
		detalle.setValorrequerido(dw_campo.getValorrequerido());

	}


}
