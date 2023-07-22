package net.royal.erp.core.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.core.dao.ServicioximpuestoDao;
import net.royal.erp.core.servicio.ServicioximpuestoServicio;
import net.royal.erp.core.dominio.Servicioximpuesto;
import net.royal.erp.core.dominio.ServicioximpuestoPk;

@Service (value = "BeanServicioServicioximpuesto")
public class ServicioximpuestoServicioImpl extends GenericoServicioImpl implements ServicioximpuestoServicio {

	private ServicioximpuestoDao dao;

	private static Log LOGGER = LogFactory.getLog(ServicioximpuestoServicioImpl.class);

	@Autowired
	public void setDao(ServicioximpuestoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List DwCpTiposervicioFactor(String tiposervicio) {
		return dao.DwCpTiposervicioFactor(tiposervicio);
	}

}
