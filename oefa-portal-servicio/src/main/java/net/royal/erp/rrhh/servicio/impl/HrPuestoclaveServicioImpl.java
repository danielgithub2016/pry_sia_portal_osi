package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoclaveDao;
import net.royal.erp.rrhh.servicio.HrPuestoclaveServicio;

import net.royal.erp.rrhh.dominio.HrPuestoclave;
import net.royal.erp.rrhh.dominio.HrPuestoclavePk;

@Service (value = "BeanServicioHrPuestoclave")
public class HrPuestoclaveServicioImpl extends GenericoServicioImpl implements HrPuestoclaveServicio {

	private HrPuestoclaveDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoclaveServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoclaveDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
