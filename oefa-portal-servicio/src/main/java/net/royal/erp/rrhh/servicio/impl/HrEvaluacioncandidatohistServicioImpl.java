package net.royal.erp.rrhh.servicio.impl;

import java.util.Date;
import java.util.List;

import net.royal.erp.rrhh.dao.HrEvaluacioncandidatohistDao;
import net.royal.erp.rrhh.dominio.HrEvaluacioncandidatohist;
import net.royal.erp.rrhh.servicio.HrEvaluacioncandidatohistServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrEvaluacioncandidatohist")
public class HrEvaluacioncandidatohistServicioImpl extends GenericoServicioImpl
		implements HrEvaluacioncandidatohistServicio {

	private HrEvaluacioncandidatohistDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacioncandidatohistServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacioncandidatohistDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrEvaluacioncandidatohist> listarCompetenciasxparam(
			String str_companyowner, Integer empleado) {
		return dao.listarCompetenciasxparam(str_companyowner, empleado);
	}

	@Override
	@Transactional
	public void eliminarEvaluacionHistoria(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado,
			Integer parEvaluador, String parTipo) {
		dao.eliminarEvaluacionHistoria(parCompany, parSecuenciaEval,
				parEmpleado, parEvaluador, parTipo);

	}

	@Override
	@Transactional
	public void grabarHistoriaEvaluacion(String parCompany,
			Integer parSecuenciaEval, Integer parEmpleado, Integer parEvaluador) {
		dao.grabarHistoriaEvaluacion(parCompany, parSecuenciaEval, parEmpleado, parEvaluador);

	}

}
