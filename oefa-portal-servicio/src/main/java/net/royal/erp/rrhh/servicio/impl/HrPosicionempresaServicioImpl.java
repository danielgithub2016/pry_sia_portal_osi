package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPosicionempresaDao;
import net.royal.erp.rrhh.servicio.HrPosicionempresaServicio;

import net.royal.erp.rrhh.dominio.HrPosicionempresa;
import net.royal.erp.rrhh.dominio.HrPosicionempresaPk;

@Service (value = "BeanServicioHrPosicionempresa")
public class HrPosicionempresaServicioImpl extends GenericoServicioImpl implements HrPosicionempresaServicio {

	private HrPosicionempresaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPosicionempresaServicioImpl.class);

	@Autowired
	public void setDao(HrPosicionempresaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
