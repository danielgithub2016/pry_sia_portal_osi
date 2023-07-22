package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrCursodescripcionDao;
import net.royal.erp.rrhh.servicio.HrCursodescripcionServicio;

import net.royal.erp.rrhh.dominio.HrCursodescripcion;
import net.royal.erp.rrhh.dominio.HrCursodescripcionPk;

@Service (value = "BeanServicioHrCursodescripcion")
public class HrCursodescripcionServicioImpl extends GenericoServicioImpl implements HrCursodescripcionServicio {

	private HrCursodescripcionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrCursodescripcionServicioImpl.class);

	@Autowired
	public void setDao(HrCursodescripcionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
