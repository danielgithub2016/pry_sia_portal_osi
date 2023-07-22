package net.royal.seguridad.servicio.impl;

import java.util.List;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.AcSucursalDao;
import net.royal.seguridad.dominio.AcSucursal;
import net.royal.seguridad.servicio.AcSucursalServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service (value = "BeanAcSucursalServicioSeguridad")
public class AcSucursalServicioImpl extends GenericoServicioImpl implements AcSucursalServicio {

	private AcSucursalDao dao;

	private static Log LOGGER = LogFactory.getLog(AcSucursalServicioImpl.class);

	@Autowired
	@Qualifier("acSucursalDaoImplSeguridad")
	public void setDao(AcSucursalDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

}
