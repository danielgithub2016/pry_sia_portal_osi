package net.royal.erp.asistencia.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.asistencia.dao.AsEmpleadosAutorizadosDao;
import net.royal.erp.asistencia.servicio.AsEmpleadosAutorizadosServicio;

import net.royal.erp.asistencia.dominio.AsEmpleadosAutorizados;
import net.royal.erp.asistencia.dominio.AsEmpleadosAutorizadosPk;

@Service(value = "BeanServicioAsEmpleadosAutorizados")
public class AsEmpleadosAutorizadosServicioImpl extends GenericoServicioImpl
		implements AsEmpleadosAutorizadosServicio {

	private AsEmpleadosAutorizadosDao dao;

	private static Log LOGGER = LogFactory
			.getLog(AsEmpleadosAutorizadosServicioImpl.class);

	@Autowired
	public void setDao(AsEmpleadosAutorizadosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
