package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoevaluacionDao;
import net.royal.erp.rrhh.servicio.HrPuestoevaluacionServicio;

import net.royal.erp.rrhh.dominio.HrPuestoevaluacion;
import net.royal.erp.rrhh.dominio.HrPuestoevaluacionPk;

@Service (value = "BeanServicioHrPuestoevaluacion")
public class HrPuestoevaluacionServicioImpl extends GenericoServicioImpl implements HrPuestoevaluacionServicio {

	private HrPuestoevaluacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoevaluacionServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoevaluacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
