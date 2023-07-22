package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrMeritosfaltasDao;
import net.royal.erp.rrhh.dominio.HrMeritosfaltas;
import net.royal.erp.rrhh.dominio.HrMeritosfaltasPk;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoDwHrIncidentecriticoList;
import net.royal.erp.rrhh.servicio.HrMeritosfaltasServicio;
import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service (value = "BeanServicioHrMeritosfaltas")
public class HrMeritosfaltasServicioImpl extends GenericoServicioImpl implements HrMeritosfaltasServicio {

	private HrMeritosfaltasDao dao;

	private static Log LOGGER = LogFactory.getLog(HrMeritosfaltasServicioImpl.class);

	@Autowired
	public void setDao(HrMeritosfaltasDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public Integer ObtenerMaximaSecuenciaxEmp(Integer empleado) {
		return dao.ObtenerMaximaSecuenciaxEmp(empleado);
	}

	@Override
	@Transactional
	public void grabardw3(List<DtoDwHrIncidentecriticoList> dw3) {  
		dao.grabardw3(dw3);
	}
	
	
	
}
