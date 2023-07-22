package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrEmpleadoconsiderapotencialDao;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencial;
import net.royal.erp.rrhh.dominio.HrEmpleadoconsiderapotencialPk;
import net.royal.erp.rrhh.servicio.HrEmpleadoconsiderapotencialServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "BeanServicioHrEmpleadoconsiderapotencial")
public class HrEmpleadoconsiderapotencialServicioImpl extends
		GenericoServicioImpl implements HrEmpleadoconsiderapotencialServicio {

	private HrEmpleadoconsiderapotencialDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrEmpleadoconsiderapotencialServicioImpl.class);

	@Autowired
	public void setDao(HrEmpleadoconsiderapotencialDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrEmpleadoconsiderapotencial> obtenerLista(
			String par_companyowner, Integer par_empleado,
			Integer par_secuenciaeval, Integer par_Evaluador) {
		return dao.obtenerLista(par_companyowner, par_empleado,
				par_secuenciaeval, par_Evaluador);
	}

	@Override
	@Transactional
	public void grabarPotencial(List<HrEmpleadoconsiderapotencial> dw10) {
		dao.grabarPotencial(dw10);

	}

	
}
