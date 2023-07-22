package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestoformacionDao;
import net.royal.erp.rrhh.servicio.HrPuestoformacionServicio;
import net.royal.erp.rrhh.dominio.HrPuestoformacion;
import net.royal.erp.rrhh.dominio.HrPuestoformacionPk;

@Service (value = "BeanServicioHrPuestoformacion")
public class HrPuestoformacionServicioImpl extends GenericoServicioImpl implements HrPuestoformacionServicio {

	private HrPuestoformacionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoformacionServicioImpl.class);

	@Autowired
	public void setDao(HrPuestoformacionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoformacion> listarPuestoFormacion(Integer codigopuesto) {
		return dao.listarPuestoFormacion(codigopuesto);
	}

}
