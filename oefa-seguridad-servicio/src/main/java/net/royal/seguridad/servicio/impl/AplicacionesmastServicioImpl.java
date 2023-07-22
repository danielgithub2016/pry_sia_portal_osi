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
import net.royal.seguridad.dao.AplicacionesmastDao;
import net.royal.seguridad.dominio.Aplicacionesmast;
import net.royal.seguridad.dominio.AplicacionesmastPk;
import net.royal.seguridad.servicio.AplicacionesmastServicio;

@Service (value = "BeanServicioAplicacionesmastSeguridad")
public class AplicacionesmastServicioImpl extends GenericoServicioImpl implements AplicacionesmastServicio {

	private AplicacionesmastDao dao;

	private static Log LOGGER = LogFactory.getLog(AplicacionesmastServicioImpl.class);

	@Autowired
	@Qualifier("aplicacionesmastDaoImplSeguridad")
	public void setDao(AplicacionesmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public String obtenerPeriodoContable(String aplicacioncodigo) {
		return dao.obtenerPeriodoContable(aplicacioncodigo);
	}

}
