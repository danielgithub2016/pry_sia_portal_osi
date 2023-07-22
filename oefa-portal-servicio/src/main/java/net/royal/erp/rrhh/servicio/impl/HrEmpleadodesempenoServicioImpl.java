package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadodesempenoDao;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempeno;
import net.royal.erp.rrhh.dominio.HrEmpleadodesempenoPk;
import net.royal.erp.rrhh.servicio.HrEmpleadodesempenoServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service (value = "BeanServicioHrEmpleadodesempeno")
public class HrEmpleadodesempenoServicioImpl extends GenericoServicioImpl implements HrEmpleadodesempenoServicio {

	private HrEmpleadodesempenoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEmpleadodesempenoServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadodesempenoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrEmpleadodesempeno> ListarEmpleadoDesempenoporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {
		
		return dao.ListarEmpleadoDesempenoporParametros(companyowner, empleado, secuenciaeval, empleadoevaluador);
	}

	@Override
	public Integer ObtenerMaximaSecuencia(Integer empleado,
			Integer secuenciaeval) {
		
		return dao.ObtenerMaximaSecuencia(empleado, secuenciaeval);
	}

	@Override
	@Transactional
	public void grabardw5(List<HrEmpleadodesempeno> dw5) {
	  dao.grabardw5(dw5);
	}
	
  
	

}
