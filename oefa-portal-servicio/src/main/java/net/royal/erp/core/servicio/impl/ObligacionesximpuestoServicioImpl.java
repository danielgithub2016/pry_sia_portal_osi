package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ObligacionesximpuestoDao;
import net.royal.erp.core.servicio.ObligacionesximpuestoServicio;

import net.royal.erp.core.dominio.Obligacionesximpuesto;
import net.royal.erp.core.dominio.ObligacionesximpuestoPk;

@Service (value = "BeanServicioObligacionesximpuesto")
public class ObligacionesximpuestoServicioImpl extends GenericoServicioImpl implements ObligacionesximpuestoServicio {

	private ObligacionesximpuestoDao dao;

	private static Log LOGGER = LogFactory.getLog(ObligacionesximpuestoServicioImpl.class);

	@Autowired
	public void setDao(ObligacionesximpuestoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
