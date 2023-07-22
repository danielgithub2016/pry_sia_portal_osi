package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ResponsiblemstDao;
import net.royal.erp.core.servicio.ResponsiblemstServicio;

import net.royal.erp.core.dominio.Responsiblemst;
import net.royal.erp.core.dominio.ResponsiblemstPk;

@Service(value = "BeanServicioResponsiblemst")
public class ResponsiblemstServicioImpl extends GenericoServicioImpl implements
		ResponsiblemstServicio {

	private ResponsiblemstDao dao;

	private static Log LOGGER = LogFactory
			.getLog(ResponsiblemstServicioImpl.class);

	@Autowired
	public void setDao(ResponsiblemstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
