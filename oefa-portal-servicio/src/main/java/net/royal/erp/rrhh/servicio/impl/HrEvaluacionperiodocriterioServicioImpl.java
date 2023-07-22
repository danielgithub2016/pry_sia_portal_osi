package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEvaluacionperiodocriterioDao;
import net.royal.erp.rrhh.dominio.HrEvaluacionperiodocriterio;
import net.royal.erp.rrhh.servicio.HrEvaluacionperiodocriterioServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrEvaluacionperiodocriterio")
public class HrEvaluacionperiodocriterioServicioImpl extends
		GenericoServicioImpl implements HrEvaluacionperiodocriterioServicio {

	private HrEvaluacionperiodocriterioDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEvaluacionperiodocriterioServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionperiodocriterioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrEvaluacionperiodocriterio> listarPorCompaniaSecuenciaTipoEval(
			String companiaSocio, Integer secuenciaEval, String tipoEval) {
		return dao.listarPorCompaniaSecuenciaTipoEval(companiaSocio,
				secuenciaEval, tipoEval);
	}

}
