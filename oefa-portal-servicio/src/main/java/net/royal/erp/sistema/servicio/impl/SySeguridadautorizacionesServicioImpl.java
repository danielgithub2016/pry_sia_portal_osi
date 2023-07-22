package net.royal.erp.sistema.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.sistema.dao.SySeguridadautorizacionesDao;
import net.royal.erp.sistema.servicio.SySeguridadautorizacionesServicio;
import net.royal.erp.sistema.dominio.SySeguridadautorizaciones;
import net.royal.erp.sistema.dominio.SySeguridadautorizacionesPk;

@Service(value = "BeanServicioSySeguridadautorizaciones")
public class SySeguridadautorizacionesServicioImpl extends GenericoServicioImpl
		implements SySeguridadautorizacionesServicio {

	private SySeguridadautorizacionesDao dao;

	private static Log LOGGER = LogFactory
			.getLog(SySeguridadautorizacionesServicioImpl.class);

	@Autowired
	public void setDao(SySeguridadautorizacionesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	@Override
	public List obtenerSeguridad(String par_option, String par_grupo,
			String par_concepto, String gvSeguridad, String gvEmpresa,
			String gvUserid, String gvApplication) {
		return dao.obtenerSeguridad(par_option, par_grupo, par_concepto, gvSeguridad, gvEmpresa, gvUserid, gvApplication);
	}


}
