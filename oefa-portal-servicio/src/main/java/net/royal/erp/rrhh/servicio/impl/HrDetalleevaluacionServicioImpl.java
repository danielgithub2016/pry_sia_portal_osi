package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dao.HrDetalleevaluacionDao;
import net.royal.erp.rrhh.dao.HrEvaluacioncandidatohistDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacion;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionPk;
import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohist;
import net.royal.erp.rrhh.dominio.dto.DtoHrDetalleEvaluacion;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadoevaluacionDetailP;
import net.royal.erp.rrhh.servicio.HrDetalleevaluacionServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.dominio.ParametroPersistenciaGenerico;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrDetalleevaluacion")
public class HrDetalleevaluacionServicioImpl extends GenericoServicioImpl
		implements HrDetalleevaluacionServicio {

	private HrDetalleevaluacionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrDetalleevaluacionServicioImpl.class);

	@Autowired
	public void setDao(HrDetalleevaluacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrDetalleevaluacion> obtenerLista(String companyowner,
			Integer secuencia, Integer empleado, Integer empleadoevaluador,
			String tipo) {
		return dao.obtenerLista(companyowner, secuencia, empleado,
				empleadoevaluador, tipo);
	}

	@Override
	public Integer obtenerMaximoDetalleEvaluacion(Integer empleado,
			Integer secuenciaeval) {
		return dao.obtenerMaximoDetalleEvaluacion(empleado, secuenciaeval);
	}

	@Override
	public List obtenerCantEvaluacionGrafico(String parCompany,
			Integer parSecuencia, Integer parEmpleado, Integer parEvaluador) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("parCompany",
				String.class, parCompany));
		parametros.add(new ParametroPersistenciaGenerico("parSecuencia",
				Integer.class, parSecuencia));
		parametros.add(new ParametroPersistenciaGenerico("parEmpleado",
				Integer.class, parEmpleado));
		parametros.add(new ParametroPersistenciaGenerico("parEvaluador",
				Integer.class, parEvaluador));

		List datos = dao.listarPorQuery(DtoHrDetalleEvaluacion.class,
				"hrdetalleevaluacion.obtenerCantEvaluacionGrafico", parametros);
		return datos;
	}

	@Override
	@Transactional
	public void eliminarevaluacion(String parCompany, Integer parSecuenciaEval,
			Integer parEmpleado, Integer parEvaluador, String parTipo) {

		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("pk.companyowner", parCompany));
		cri.add(Restrictions.eq("pk.secuenciaeval", parSecuenciaEval));
		cri.add(Restrictions.eq("pk.empleado", parEmpleado));
		cri.add(Restrictions.eq("pk.empleadoevaluador", parEvaluador));
		cri.add(Restrictions.eq("pk.tipo", parTipo));

		List<HrDetalleevaluacion> datos = dao.listarPorCriterios(cri);

		for (HrDetalleevaluacion evaluacion : datos) {
			dao.eliminar(evaluacion);
		}
	}

	@Override  
	@Transactional
	public void grabarDetalleEvaluacion(List<DtoHrDetalleEvaluacion> dw1) {
		dao.grabarDetalleEvaluacion(dw1);
	}

	

	@Override
	public Integer obtenerSumaEvaluacion(String companyowner,
			Integer secuencia, Integer empleado, Integer empleadoevaluador,
			String tipo) {

		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		parametros.add(new ParametroPersistenciaGenerico("iv_compania",
				String.class, companyowner));
		parametros.add(new ParametroPersistenciaGenerico("iv_secuencia",
				Integer.class, secuencia));
		parametros.add(new ParametroPersistenciaGenerico("iv_empleado",
				Integer.class, empleado));
		parametros.add(new ParametroPersistenciaGenerico(
				"iv_empleadoevaluador", Integer.class, empleadoevaluador));
		parametros.add(new ParametroPersistenciaGenerico("tipo", String.class,
				tipo));

		return dao.contar("hrdetalleevaluacion.obtenerSumaEvaluacion",
				parametros);
	}

	@Override
	@Transactional
	public void grabarEvaluacionDetalleP(
			List<DtoDwHrEmpleadoevaluacionDetailP> dw9) {
		dao.grabarEvaluacionDetalleP(dw9);
	}
	
	@Override
	@Transactional
	public void grabardwCampo(List<HrDetalleevaluacion> dwCampo) {
		dao.grabardwCampo(dwCampo);
	}

	
}
