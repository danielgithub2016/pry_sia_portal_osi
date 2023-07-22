package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrActividadRutasDao;
import net.royal.erp.rrhh.servicio.HrActividadRutasServicio;

import net.royal.erp.rrhh.dominio.HrActividadRutas;
import net.royal.erp.rrhh.dominio.HrActividadRutasPk;

@Service (value = "BeanServicioHrActividadRutas")
public class HrActividadRutasServicioImpl extends GenericoServicioImpl implements HrActividadRutasServicio {

	private HrActividadRutasDao dao;

	private static Log LOGGER = LogFactory.getLog(HrActividadRutasServicioImpl.class);

	@Autowired
	public void setDao(HrActividadRutasDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
