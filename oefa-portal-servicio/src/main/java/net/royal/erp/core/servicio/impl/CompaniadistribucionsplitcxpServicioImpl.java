package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.CompaniadistribucionsplitcxpDao;
import net.royal.erp.core.servicio.CompaniadistribucionsplitcxpServicio;

import net.royal.erp.core.dominio.Companiadistribucionsplitcxp;
import net.royal.erp.core.dominio.CompaniadistribucionsplitcxpPk;

@Service (value = "BeanServicioCompaniadistribucionsplitcxp")
public class CompaniadistribucionsplitcxpServicioImpl extends GenericoServicioImpl implements CompaniadistribucionsplitcxpServicio {

	private CompaniadistribucionsplitcxpDao dao;

	private static Log LOGGER = LogFactory.getLog(CompaniadistribucionsplitcxpServicioImpl.class);

	@Autowired
	public void setDao(CompaniadistribucionsplitcxpDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
