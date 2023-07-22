package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrBsMetaDao;
import net.royal.erp.rrhh.servicio.HrBsMetaServicio;

import net.royal.erp.rrhh.dominio.HrBsMeta;
import net.royal.erp.rrhh.dominio.HrBsMetaPk;

@Service (value = "BeanServicioHrBsMeta")
public class HrBsMetaServicioImpl extends GenericoServicioImpl implements HrBsMetaServicio {

	private HrBsMetaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrBsMetaServicioImpl.class);

	@Autowired
	public void setDao(HrBsMetaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
