package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrCentroestudiosDao;
import net.royal.erp.rrhh.dominio.HrCentroestudios;
import net.royal.erp.rrhh.hrothers.dominio.dto.DtoHrCentroEstudios;
import net.royal.erp.rrhh.servicio.HrCentroestudiosServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrCentroestudios")
public class HrCentroestudiosServicioImpl extends GenericoServicioImpl implements HrCentroestudiosServicio {

	private HrCentroestudiosDao dao;

	private static Log LOGGER = LogFactory.getLog(HrCentroestudiosServicioImpl.class);

	@Autowired
	public void setDao(HrCentroestudiosDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<DtoHrCentroEstudios> listarCentroEstudios(String s, String criterio){
		return dao.listarCentroEstudios(s,criterio);
	}
	
	@Override
	public List<HrCentroestudios> listarCentroEstudios() {
		Criteria c = dao.getCriteria();
		c.addOrder(Order.asc("descripcion"));
		return dao.listarPorCriterios(c);
	}
}
