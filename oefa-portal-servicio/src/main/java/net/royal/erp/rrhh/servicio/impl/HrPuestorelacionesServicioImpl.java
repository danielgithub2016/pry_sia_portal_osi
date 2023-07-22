package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrPuestorelacionesDao;
import net.royal.erp.rrhh.servicio.HrPuestorelacionesServicio;
import net.royal.erp.rrhh.dominio.HrPuestorelaciones;
import net.royal.erp.rrhh.dominio.HrPuestorelacionesPk;

@Service (value = "BeanServicioHrPuestorelaciones")
public class HrPuestorelacionesServicioImpl extends GenericoServicioImpl implements HrPuestorelacionesServicio {

	private HrPuestorelacionesDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestorelacionesServicioImpl.class);

	@Autowired
	public void setDao(HrPuestorelacionesDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestorelaciones> listarTabPuestoRelacion(Integer codigopuesto) {
		return dao.listarTabPuestoRelacion(codigopuesto);
	}

}
