package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrTipocontratoDao;
import net.royal.erp.rrhh.servicio.HrTipocontratoServicio;

import net.royal.erp.rrhh.dominio.HrTipocontrato;
import net.royal.erp.rrhh.dominio.HrTipocontratoPk;

@Service (value = "BeanServicioHrTipocontrato")
public class HrTipocontratoServicioImpl extends GenericoServicioImpl implements HrTipocontratoServicio {

	private HrTipocontratoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrTipocontratoServicioImpl.class);

	@Autowired
	public void setDao(HrTipocontratoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
