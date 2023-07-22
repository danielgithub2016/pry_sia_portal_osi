package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrClasificadorcargoDao;
import net.royal.erp.rrhh.servicio.HrClasificadorcargoServicio;
import net.royal.erp.rrhh.dominio.HrClasificadorcargo;
import net.royal.erp.rrhh.dominio.HrClasificadorcargoPk;

@Service (value = "BeanServicioHrClasificadorcargo")
public class HrClasificadorcargoServicioImpl extends GenericoServicioImpl implements HrClasificadorcargoServicio {

	private HrClasificadorcargoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrClasificadorcargoServicioImpl.class);

	@Autowired
	public void setDao(HrClasificadorcargoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public HrClasificadorcargo obtenerClasificadorCargoparam(
			String clasificadorcargo) {
		return dao.obtenerClasificadorCargoparam(clasificadorcargo);
	}

}
