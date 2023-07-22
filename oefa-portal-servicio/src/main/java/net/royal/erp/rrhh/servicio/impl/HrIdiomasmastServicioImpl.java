package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrIdiomasmastDao;
import net.royal.erp.rrhh.servicio.HrIdiomasmastServicio;

import net.royal.erp.rrhh.dominio.HrIdiomasmast;
import net.royal.erp.rrhh.dominio.HrIdiomasmastPk;

@Service (value = "BeanServicioHrIdiomasmast")
public class HrIdiomasmastServicioImpl extends GenericoServicioImpl implements HrIdiomasmastServicio {

	private HrIdiomasmastDao dao;

	private static Log LOGGER = LogFactory.getLog(HrIdiomasmastServicioImpl.class);

	@Autowired
	public void setDao(HrIdiomasmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
