package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrEvaluacionareaDao;
import net.royal.erp.rrhh.servicio.HrEvaluacionareaServicio;

import net.royal.erp.rrhh.dominio.HrEvaluacionarea;
import net.royal.erp.rrhh.dominio.HrEvaluacionareaPk;

@Service (value = "BeanServicioHrEvaluacionarea")
public class HrEvaluacionareaServicioImpl extends GenericoServicioImpl implements HrEvaluacionareaServicio {

	private HrEvaluacionareaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrEvaluacionareaServicioImpl.class);

	@Autowired
	public void setDao(HrEvaluacionareaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
