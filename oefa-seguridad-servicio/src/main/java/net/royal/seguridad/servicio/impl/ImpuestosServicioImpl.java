package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.ImpuestosDao;
import net.royal.seguridad.dominio.Impuestos;
import net.royal.seguridad.dominio.ImpuestosPk;
import net.royal.seguridad.servicio.ImpuestosServicio;

@Service (value = "BeanServicioImpuestosSeguridad")
public class ImpuestosServicioImpl extends GenericoServicioImpl implements ImpuestosServicio {

	private ImpuestosDao dao;

	private static Log LOGGER = LogFactory.getLog(ImpuestosServicioImpl.class);

	@Autowired
	@Qualifier("impuestosDaoImplSeguridad")
	public void setDao(ImpuestosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
