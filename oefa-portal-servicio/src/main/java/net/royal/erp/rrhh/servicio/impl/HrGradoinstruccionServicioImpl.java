package net.royal.erp.rrhh.servicio.impl;

import net.royal.erp.rrhh.dao.HrGradoinstruccionDao;
import net.royal.erp.rrhh.dominio.HrGradoinstruccion;
import net.royal.erp.rrhh.servicio.HrGradoinstruccionServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrGradoinstruccion")
public class HrGradoinstruccionServicioImpl extends GenericoServicioImpl implements HrGradoinstruccionServicio {

	private HrGradoinstruccionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrGradoinstruccionServicioImpl.class);

	@Autowired
	public void setDao(HrGradoinstruccionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	
	@Override
	public List<HrGradoinstruccion> listarGradoInstruccion() {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("estado", "A"));
		c.addOrder(Order.asc("descripcion"));
		
		return dao.listarPorCriterios(c);
	}
}
