package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.rrhh.dao.HrEvaluacionRequerimientoDao;
import net.royal.erp.rrhh.servicio.HrEvaluacionRequerimientoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service (value = "BeanServicioHrEvaluacionRequerimiento")
public class HrEvaluacionRequerimientoServicioImpl extends GenericoServicioImpl implements HrEvaluacionRequerimientoServicio {

	private HrEvaluacionRequerimientoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionRequerimientoServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionRequerimientoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List listarDescripcion() {
		return dao.listarDescripcion();
	}

}
