package net.royal.seguridad.servicio.impl;

import java.util.List;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.AcCostcentermstDao;
import net.royal.seguridad.dominio.AcCostcentermst;
import net.royal.seguridad.servicio.AcCostcentermstServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioAcCostcentermstSeguridad")
public class AcCostcentermstServicioImpl extends GenericoServicioImpl implements AcCostcentermstServicio {

	private AcCostcentermstDao dao;

	private static Log LOGGER = LogFactory.getLog(AcCostcentermstServicioImpl.class);

	@Autowired
	@Qualifier("acCostcentermstDaoImplSeguridad")
	public void setDao(AcCostcentermstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
}
