package net.royal.erp.core.servicio.impl;

import java.util.List;

import net.royal.erp.core.dao.ReferencefieldvaluesDao;
import net.royal.erp.core.dominio.Referencefieldvalues;
import net.royal.erp.core.servicio.ReferencefieldvaluesServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioReferencefieldvalues")
public class ReferencefieldvaluesServicioImpl extends GenericoServicioImpl
		implements ReferencefieldvaluesServicio {

	private ReferencefieldvaluesDao dao;

	private static Log LOGGER = LogFactory
			.getLog(ReferencefieldvaluesServicioImpl.class);

	@Autowired
	public void setDao(ReferencefieldvaluesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	public List<Referencefieldvalues> listaDw1(String ReferenceField){
	return dao.listaDw1(ReferenceField);
	}

}
