package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadofuncionDao;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncion;
import net.royal.erp.rrhh.dominio.HrEmpleadofuncionPk;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.servicio.HrEmpleadofuncionServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrEmpleadofuncion")
public class HrEmpleadofuncionServicioImpl extends GenericoServicioImpl
		implements HrEmpleadofuncionServicio {

	private HrEmpleadofuncionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEmpleadofuncionServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadofuncionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrEmpleadofuncion> ObtenerEmpleadoFuncionporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {

		return dao.ObtenerEmpleadoFuncionporParametros(companyowner, empleado,
				secuenciaeval, empleadoevaluador);
	}

	public Integer obtenerMaximoSecuencia(Integer iv_empleado,
			Integer iv_secuencia) {
		return dao.obtenerMaximoSecuencia(iv_empleado, iv_secuencia);
	}

	@Override
	@Transactional
	public void grabarEmpleadoFuncion(List<HrEmpleadofuncion> dw11) {
		

	}
	
	private void setearValores(HrEmpleadofuncion dw_11, HrEmpleadofuncion empleadoFuncion){
		
		
		
	}
}
