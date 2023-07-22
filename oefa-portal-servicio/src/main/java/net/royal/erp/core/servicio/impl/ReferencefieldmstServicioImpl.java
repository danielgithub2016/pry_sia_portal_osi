package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ReferencefieldmstDao;
import net.royal.erp.core.servicio.ReferencefieldmstServicio;

import net.royal.erp.core.dominio.Referencefieldmst;
import net.royal.erp.core.dominio.ReferencefieldmstPk;

@Service(value = "BeanServicioReferencefieldmst")
public class ReferencefieldmstServicioImpl extends GenericoServicioImpl
		implements ReferencefieldmstServicio {

	private ReferencefieldmstDao dao;

	private static Log LOGGER = LogFactory
			.getLog(ReferencefieldmstServicioImpl.class);

	@Autowired
	public void setDao(ReferencefieldmstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	public String obtenerTitulo(String ReferenceField){
		return dao.obtenerTitulo(ReferenceField);
	}

}
