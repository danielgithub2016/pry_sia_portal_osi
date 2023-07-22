package net.royal.erp.mantenimiento.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.mantenimiento.dao.MeTipomantenimientogrupoDao;
import net.royal.erp.mantenimiento.servicio.MeTipomantenimientogrupoServicio;

import net.royal.erp.mantenimiento.dominio.MeTipomantenimientogrupo;
import net.royal.erp.mantenimiento.dominio.MeTipomantenimientogrupoPk;

@Service (value = "BeanServicioMeTipomantenimientogrupo")
public class MeTipomantenimientogrupoServicioImpl extends GenericoServicioImpl implements MeTipomantenimientogrupoServicio {

	private MeTipomantenimientogrupoDao dao;

	private static Log LOGGER = LogFactory.getLog(MeTipomantenimientogrupoServicioImpl.class);

	@Autowired
	public void setDao(MeTipomantenimientogrupoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
