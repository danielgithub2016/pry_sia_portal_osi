package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrActividadparticipanteDao;
import net.royal.erp.rrhh.servicio.HrActividadparticipanteServicio;

import net.royal.erp.rrhh.dominio.HrActividadparticipante;
import net.royal.erp.rrhh.dominio.HrActividadparticipantePk;

@Service (value = "BeanServicioHrActividadparticipante")
public class HrActividadparticipanteServicioImpl extends GenericoServicioImpl implements HrActividadparticipanteServicio {

	private HrActividadparticipanteDao dao;

	private static Log LOGGER = LogFactory.getLog(HrActividadparticipanteServicioImpl.class);

	@Autowired
	public void setDao(HrActividadparticipanteDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
