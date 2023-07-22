package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEncuestaplantillaDao;
import net.royal.erp.rrhh.servicio.HrEncuestaplantillaServicio;

import net.royal.erp.rrhh.dominio.HrEncuestaplantilla;
import net.royal.erp.rrhh.dominio.HrEncuestaplantillaPk;

@Service (value = "BeanServicioHrEncuestaplantilla")
public class HrEncuestaplantillaServicioImpl extends GenericoServicioImpl implements HrEncuestaplantillaServicio {

	private HrEncuestaplantillaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEncuestaplantillaServicioImpl.class);

	@Autowired
	public void setDao(HrEncuestaplantillaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
