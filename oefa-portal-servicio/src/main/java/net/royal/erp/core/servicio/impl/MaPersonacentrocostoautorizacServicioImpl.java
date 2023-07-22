package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.MaPersonacentrocostoautorizacDao;
import net.royal.erp.core.servicio.MaPersonacentrocostoautorizacServicio;

import net.royal.erp.core.dominio.MaPersonacentrocostoautorizac;
import net.royal.erp.core.dominio.MaPersonacentrocostoautorizacPk;

@Service(value = "BeanServicioMaPersonacentrocostoautorizac")
public class MaPersonacentrocostoautorizacServicioImpl extends
		GenericoServicioImpl implements MaPersonacentrocostoautorizacServicio {

	private MaPersonacentrocostoautorizacDao dao;

	private static Log LOGGER = LogFactory
			.getLog(MaPersonacentrocostoautorizacServicioImpl.class);

	@Autowired
	public void setDao(MaPersonacentrocostoautorizacDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
