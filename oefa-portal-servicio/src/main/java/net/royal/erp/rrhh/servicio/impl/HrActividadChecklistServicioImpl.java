package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrActividadChecklistDao;
import net.royal.erp.rrhh.servicio.HrActividadChecklistServicio;

import net.royal.erp.rrhh.dominio.HrActividadChecklist;
import net.royal.erp.rrhh.dominio.HrActividadChecklistPk;

@Service (value = "BeanServicioHrActividadChecklist")
public class HrActividadChecklistServicioImpl extends GenericoServicioImpl implements HrActividadChecklistServicio {

	private HrActividadChecklistDao dao;

	private static Log LOGGER = LogFactory.getLog(HrActividadChecklistServicioImpl.class);

	@Autowired
	public void setDao(HrActividadChecklistDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
