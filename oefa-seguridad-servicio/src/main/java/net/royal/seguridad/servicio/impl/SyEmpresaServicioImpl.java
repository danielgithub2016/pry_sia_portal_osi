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
import net.royal.seguridad.dao.SyEmpresaDao;
import net.royal.seguridad.dominio.SyEmpresa;
import net.royal.seguridad.dominio.SyEmpresaPk;
import net.royal.seguridad.servicio.SyEmpresaServicio;

@Service (value = "BeanServicioSyEmpresaSeguridad")
public class SyEmpresaServicioImpl extends GenericoServicioImpl implements SyEmpresaServicio {

	private SyEmpresaDao dao;

	private static Log LOGGER = LogFactory.getLog(SyEmpresaServicioImpl.class);

	@Autowired
	@Qualifier("syEmpresaDaoImplSeguridad")
	public void setDao(SyEmpresaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
