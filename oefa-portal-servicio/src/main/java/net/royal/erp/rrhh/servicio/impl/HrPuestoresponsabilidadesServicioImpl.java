package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoresponsabilidadesDao;
import net.royal.erp.rrhh.servicio.HrPuestoresponsabilidadesServicio;

import net.royal.erp.rrhh.dominio.HrPuestoresponsabilidades;
import net.royal.erp.rrhh.dominio.HrPuestoresponsabilidadesPk;

@Service (value = "BeanServicioHrPuestoresponsabilidades")
public class HrPuestoresponsabilidadesServicioImpl extends GenericoServicioImpl implements HrPuestoresponsabilidadesServicio {

	private HrPuestoresponsabilidadesDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoresponsabilidadesServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoresponsabilidadesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
