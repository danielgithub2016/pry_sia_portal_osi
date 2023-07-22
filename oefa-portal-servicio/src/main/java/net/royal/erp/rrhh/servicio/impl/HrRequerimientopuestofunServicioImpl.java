package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientopuestofunDao;
import net.royal.erp.rrhh.servicio.HrRequerimientopuestofunServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientopuestofun;
import net.royal.erp.rrhh.dominio.HrRequerimientopuestofunPk;

@Service (value = "BeanServicioHrRequerimientopuestofun")
public class HrRequerimientopuestofunServicioImpl extends GenericoServicioImpl implements HrRequerimientopuestofunServicio {

	private HrRequerimientopuestofunDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientopuestofunServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientopuestofunDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
