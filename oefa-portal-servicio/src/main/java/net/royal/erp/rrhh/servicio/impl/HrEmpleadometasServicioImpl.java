package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadometasDao;
import net.royal.erp.rrhh.dominio.HrEmpleadometas;
import net.royal.erp.rrhh.dominio.HrEmpleadometasPk;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacita;
import net.royal.erp.rrhh.dominio.HrEmpleadonecesidadcapacitaPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrEmpleadonecesidadcapacitaEdit;
import net.royal.erp.rrhh.servicio.HrEmpleadometasServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrEmpleadometas")
public class HrEmpleadometasServicioImpl extends GenericoServicioImpl implements
		HrEmpleadometasServicio {

	private HrEmpleadometasDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEmpleadometasServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadometasDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrEmpleadometas> ListarEmpleadoMetasporParametros(
			String companyowner, Integer empleado, Integer secuenciaeval,
			Integer empleadoevaluador) {

		return dao.ListarEmpleadoMetasporParametros(companyowner, empleado,
				secuenciaeval, empleadoevaluador);
	}

	@Override
	@Transactional
	public void guardarHrEmpleadoMetas(List<HrEmpleadometas> dw6) {
           dao.guardarHrEmpleadoMetas(dw6);
	}

}
