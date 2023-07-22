package net.royal.erp.core.servicio.impl;

import net.royal.erp.core.dao.ImpuestosDao;
import net.royal.erp.core.servicio.ImpuestosServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioImpuestosCore")
public class ImpuestosServicioImpl extends GenericoServicioImpl implements ImpuestosServicio {

	private ImpuestosDao dao;

	private static Log LOGGER = LogFactory.getLog(ImpuestosServicioImpl.class);

	@Autowired
	@Qualifier("impuestosDaoImplCore")
	public void setDao(ImpuestosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
