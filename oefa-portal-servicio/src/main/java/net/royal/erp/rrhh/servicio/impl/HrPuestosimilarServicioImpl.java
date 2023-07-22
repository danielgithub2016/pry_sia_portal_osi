package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestosimilarDao;
import net.royal.erp.rrhh.servicio.HrPuestosimilarServicio;
import net.royal.erp.rrhh.dominio.HrPuestosimilar;
import net.royal.erp.rrhh.dominio.HrPuestosimilarPk;

@Service (value = "BeanServicioHrPuestosimilar")
public class HrPuestosimilarServicioImpl extends GenericoServicioImpl implements HrPuestosimilarServicio {

	private HrPuestosimilarDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestosimilarServicioImpl.class);

	@Autowired
	public void setDao(HrPuestosimilarDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestosimilar> listarPuestosSimilar(Integer codigopuesto) {
		return dao.listarPuestosSimilar(codigopuesto);
	}

}
