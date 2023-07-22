package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrActividadbeneficiarioDao;
import net.royal.erp.rrhh.servicio.HrActividadbeneficiarioServicio;

import net.royal.erp.rrhh.dominio.HrActividadbeneficiario;
import net.royal.erp.rrhh.dominio.HrActividadbeneficiarioPk;

@Service (value = "BeanServicioHrActividadbeneficiario")
public class HrActividadbeneficiarioServicioImpl extends GenericoServicioImpl implements HrActividadbeneficiarioServicio {

	private HrActividadbeneficiarioDao dao;

	private static Log LOGGER = LogFactory.getLog(HrActividadbeneficiarioServicioImpl.class);

	@Autowired
	public void setDao(HrActividadbeneficiarioDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
