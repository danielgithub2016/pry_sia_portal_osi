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
import net.royal.seguridad.dao.SyPreferencesDao;
import net.royal.seguridad.dominio.SyPreferences;
import net.royal.seguridad.dominio.SyPreferencesPk;
import net.royal.seguridad.servicio.SyPreferencesServicio;

@Service (value = "BeanServicioSyPreferencesSeguridad")
public class SyPreferencesServicioImpl extends GenericoServicioImpl implements SyPreferencesServicio {

	private SyPreferencesDao dao;

	private static Log LOGGER = LogFactory.getLog(SyPreferencesServicioImpl.class);

	@Autowired
	@Qualifier("syPreferencesDaoImplSeguridad")
	public void setDao(SyPreferencesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
