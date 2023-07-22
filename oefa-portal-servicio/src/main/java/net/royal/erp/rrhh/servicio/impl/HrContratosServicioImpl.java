package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrContratosDao;
import net.royal.erp.rrhh.servicio.HrContratosServicio;

import net.royal.erp.rrhh.dominio.HrContratos;
import net.royal.erp.rrhh.dominio.HrContratosPk;

@Service (value = "BeanServicioHrContratos")
public class HrContratosServicioImpl extends GenericoServicioImpl implements HrContratosServicio {

	private HrContratosDao dao;

	private static Log LOGGER = LogFactory.getLog(HrContratosServicioImpl.class);

	@Autowired
	public void setDao(HrContratosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
