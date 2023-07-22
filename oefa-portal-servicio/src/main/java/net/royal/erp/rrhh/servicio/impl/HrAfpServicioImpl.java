package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrAfpDao;
import net.royal.erp.rrhh.servicio.HrAfpServicio;

import net.royal.erp.rrhh.dominio.HrAfp;
import net.royal.erp.rrhh.dominio.HrAfpPk;

@Service (value = "BeanServicioHrAfp")
public class HrAfpServicioImpl extends GenericoServicioImpl implements HrAfpServicio {

	private HrAfpDao dao;

	private static Log LOGGER = LogFactory.getLog(HrAfpServicioImpl.class);

	@Autowired
	public void setDao(HrAfpDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
