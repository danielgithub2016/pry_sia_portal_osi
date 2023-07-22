package net.royal.erp.rrhh.servicio.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrSeguridadDao;
import net.royal.erp.rrhh.servicio.HrSeguridadServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service (value = "BeanServicioHrSeguridad")
public class HrSeguridadServicioImpl extends GenericoServicioImpl implements HrSeguridadServicio {

	private HrSeguridadDao dao;

	private static Log LOGGER = LogFactory.getLog(HrSeguridadServicioImpl.class);

	@Autowired
	public void setDao(HrSeguridadDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
