package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoconfianzaDao;
import net.royal.erp.rrhh.servicio.HrPuestoconfianzaServicio;

import net.royal.erp.rrhh.dominio.HrPuestoconfianza;
import net.royal.erp.rrhh.dominio.HrPuestoconfianzaPk;

@Service (value = "BeanServicioHrPuestoconfianza")
public class HrPuestoconfianzaServicioImpl extends GenericoServicioImpl implements HrPuestoconfianzaServicio {

	private HrPuestoconfianzaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoconfianzaServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoconfianzaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
