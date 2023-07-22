package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrMetaspuestoDao;
import net.royal.erp.rrhh.servicio.HrMetaspuestoServicio;
import net.royal.erp.rrhh.dominio.HrMetaspuesto;
import net.royal.erp.rrhh.dominio.HrMetaspuestoPk;

@Service (value = "BeanServicioHrMetaspuesto")
public class HrMetaspuestoServicioImpl extends GenericoServicioImpl implements HrMetaspuestoServicio {

	private HrMetaspuestoDao dao;

	private static Log LOGGER = LogFactory.getLog(HrMetaspuestoServicioImpl.class);

	@Autowired
	public void setDao(HrMetaspuestoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrMetaspuesto> listarTabObjetivosMetas(Integer codigopuesto) {
		return dao.listarTabObjetivosMetas(codigopuesto);
	}

}
