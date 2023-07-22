package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEncuestaplantilladetalleDao;
import net.royal.erp.rrhh.servicio.HrEncuestaplantilladetalleServicio;

import net.royal.erp.rrhh.dominio.HrEncuestaplantilladetalle;
import net.royal.erp.rrhh.dominio.HrEncuestaplantilladetallePk;

@Service (value = "BeanServicioHrEncuestaplantilladetalle")
public class HrEncuestaplantilladetalleServicioImpl extends GenericoServicioImpl implements HrEncuestaplantilladetalleServicio {

	private HrEncuestaplantilladetalleDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEncuestaplantilladetalleServicioImpl.class);

	@Autowired
	public void setDao(HrEncuestaplantilladetalleDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
