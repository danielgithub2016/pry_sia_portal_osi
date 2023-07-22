package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrDepartamentoDao;
import net.royal.erp.rrhh.servicio.HrDepartamentoServicio;

import net.royal.erp.rrhh.dominio.HrDepartamento;
import net.royal.erp.rrhh.dominio.HrDepartamentoPk;

@Service (value = "BeanServicioHrDepartamento")
public class HrDepartamentoServicioImpl extends GenericoServicioImpl implements HrDepartamentoServicio {

	private HrDepartamentoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrDepartamentoServicioImpl.class);

	@Autowired
	public void setDao(HrDepartamentoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
