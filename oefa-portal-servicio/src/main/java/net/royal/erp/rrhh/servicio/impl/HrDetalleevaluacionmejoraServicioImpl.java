package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrDetalleevaluacionmejoraDao;
import net.royal.erp.rrhh.dominio.HrDetalleevaluacionmejora;
import net.royal.erp.rrhh.servicio.HrDetalleevaluacionmejoraServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrDetalleevaluacionmejora")
public class HrDetalleevaluacionmejoraServicioImpl extends GenericoServicioImpl
		implements HrDetalleevaluacionmejoraServicio {

	private HrDetalleevaluacionmejoraDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrDetalleevaluacionmejoraServicioImpl.class);

	@Autowired
	public void setDao(HrDetalleevaluacionmejoraDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrDetalleevaluacionmejora> obtenerListaCompromisoMejora(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {

		return dao.obtenerListaCompromisoMejora(companyowner, empleado,
				secuenciaeval, empleadoevaluador);
	}

	@Override
	@Transactional
	public void eliminarDetalleEvaluacionMejora(String iv_compania,
			Integer iv_empleado, Integer iv_secuencia,
			Integer iv_empleadoevaluador) {
		
		dao.eliminarDetalleEvaluacionMejora(iv_compania, iv_empleado, iv_secuencia, iv_empleadoevaluador);
	}

	@Override
	@Transactional
	public void grabarDetalleMejora(
			List<HrDetalleevaluacionmejora> dwCompromisomejora) {
		dao.grabarDetalleMejora(dwCompromisomejora);

	}

}
