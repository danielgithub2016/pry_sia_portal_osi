package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrBsLineadeaccionDao;
import net.royal.erp.rrhh.servicio.HrBsLineadeaccionServicio;

import net.royal.erp.rrhh.dominio.HrBsLineadeaccion;
import net.royal.erp.rrhh.dominio.HrBsLineadeaccionPk;

@Service (value = "BeanServicioHrBsLineadeaccion")
public class HrBsLineadeaccionServicioImpl extends GenericoServicioImpl implements HrBsLineadeaccionServicio {

	private HrBsLineadeaccionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrBsLineadeaccionServicioImpl.class);

	@Autowired
	public void setDao(HrBsLineadeaccionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
