package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrEvaluacionDao;
import net.royal.erp.rrhh.servicio.HrEvaluacionServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service (value = "BeanServicioHrEvaluacion")
public class HrEvaluacionServicioImpl extends GenericoServicioImpl implements HrEvaluacionServicio {

	private HrEvaluacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List listarDescripcion() {
		return dao.listarDescripcion();
	}

}
