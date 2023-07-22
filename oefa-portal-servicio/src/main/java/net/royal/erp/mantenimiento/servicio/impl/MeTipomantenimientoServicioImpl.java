package net.royal.erp.mantenimiento.servicio.impl;

import java.util.List;

import net.royal.erp.mantenimiento.dao.MeTipomantenimientoDao;
import net.royal.erp.mantenimiento.servicio.MeTipomantenimientoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioMeTipomantenimiento")
public class MeTipomantenimientoServicioImpl extends GenericoServicioImpl implements MeTipomantenimientoServicio {

	private MeTipomantenimientoDao dao;

	private static Log LOGGER = LogFactory.getLog(MeTipomantenimientoServicioImpl.class);

	@Autowired
	public void setDao(MeTipomantenimientoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}


}
