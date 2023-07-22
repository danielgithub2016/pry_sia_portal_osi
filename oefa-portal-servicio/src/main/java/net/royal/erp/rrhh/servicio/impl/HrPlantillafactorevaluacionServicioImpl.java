package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPlantillafactorevaluacionDao;
import net.royal.erp.rrhh.servicio.HrPlantillafactorevaluacionServicio;

import net.royal.erp.rrhh.dominio.HrPlantillafactorevaluacion;
import net.royal.erp.rrhh.dominio.HrPlantillafactorevaluacionPk;

@Service (value = "BeanServicioHrPlantillafactorevaluacion")
public class HrPlantillafactorevaluacionServicioImpl extends GenericoServicioImpl implements HrPlantillafactorevaluacionServicio {

	private HrPlantillafactorevaluacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPlantillafactorevaluacionServicioImpl.class);

	@Autowired
	public void setDao(HrPlantillafactorevaluacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
