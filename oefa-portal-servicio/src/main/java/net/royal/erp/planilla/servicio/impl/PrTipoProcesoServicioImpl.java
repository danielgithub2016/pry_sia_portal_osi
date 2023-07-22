package net.royal.erp.planilla.servicio.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.planilla.dao.PrTipoProcesoDao;
import net.royal.erp.planilla.dao.PrTipoplanillaDao;
import net.royal.erp.planilla.servicio.PrTipoProcesoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioPrTipoProceso")
public class PrTipoProcesoServicioImpl extends GenericoServicioImpl implements PrTipoProcesoServicio {

	private PrTipoProcesoDao dao;

	private static Log LOGGER = LogFactory.getLog(PrTipoProcesoServicioImpl.class);

	@Autowired
	public void setDao(PrTipoProcesoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
