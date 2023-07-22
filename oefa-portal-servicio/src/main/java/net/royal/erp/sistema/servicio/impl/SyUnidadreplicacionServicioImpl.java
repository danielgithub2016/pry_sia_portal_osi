package net.royal.erp.sistema.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.sistema.dao.SyUnidadreplicacionDao;
import net.royal.erp.sistema.servicio.SyUnidadreplicacionServicio;

import net.royal.erp.sistema.dominio.SyUnidadreplicacion;
import net.royal.erp.sistema.dominio.SyUnidadreplicacionPk;

@Service(value = "BeanServicioSyUnidadreplicacion")
public class SyUnidadreplicacionServicioImpl extends GenericoServicioImpl
		implements SyUnidadreplicacionServicio {

	private SyUnidadreplicacionDao dao;

	private static Log LOGGER = LogFactory
			.getLog(SyUnidadreplicacionServicioImpl.class);

	@Autowired
	public void setDao(SyUnidadreplicacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	public List listaUnidadReplicacion(){
		return dao.listaUnidadReplicacion();
	}

}
