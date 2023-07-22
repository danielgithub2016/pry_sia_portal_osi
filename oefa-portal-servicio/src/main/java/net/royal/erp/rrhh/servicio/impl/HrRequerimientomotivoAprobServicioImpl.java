package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrRequerimientomotivoAprobDao;
import net.royal.erp.rrhh.servicio.HrRequerimientomotivoAprobServicio;

import net.royal.erp.rrhh.dominio.HrRequerimientomotivoAprob;
import net.royal.erp.rrhh.dominio.HrRequerimientomotivoAprobPk;

@Service (value = "BeanServicioHrRequerimientomotivoAprob")
public class HrRequerimientomotivoAprobServicioImpl extends GenericoServicioImpl implements HrRequerimientomotivoAprobServicio {

	private HrRequerimientomotivoAprobDao dao;

	private static Log LOGGER = LogFactory.getLog(HrRequerimientomotivoAprobServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientomotivoAprobDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
