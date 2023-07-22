package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadorevisionDao;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.dominio.HrEmpleadorevisionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadorevision;
import net.royal.erp.rrhh.servicio.HrEmpleadorevisionServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrEmpleadorevision")
public class HrEmpleadorevisionServicioImpl extends GenericoServicioImpl
		implements HrEmpleadorevisionServicio {

	private HrEmpleadorevisionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEmpleadorevisionServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadorevisionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrEmpleadorevision> obtenerListaRevision(String companyowner,
			Integer empleado, Integer secuenciaeval, Integer empleadoevaluador) {
		return dao.obtenerListaRevision(companyowner, empleado, secuenciaeval,
				empleadoevaluador);
	}

	@Override
	@Transactional
	public void grabarEmpleadoRevision(List<HrEmpleadorevision> dwrevision) {

		dao.grabarEmpleadoRevision(dwrevision);
	}

}
