package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrProfesionDao;
import net.royal.erp.rrhh.dominio.HrProfesion;
import net.royal.erp.rrhh.servicio.HrProfesionServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioHrProfesion")
public class HrProfesionServicioImpl extends GenericoServicioImpl implements HrProfesionServicio {

	private HrProfesionDao dao;

	private static Log LOGGER = LogFactory.getLog(HrProfesionServicioImpl.class);

	@Autowired
	public void setDao(HrProfesionDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public HrProfesion obtenerProfesion(String par_profesion){
		return dao.obtenerProfesion(par_profesion);
	}
	
	@Override
	public List<HrProfesion> listarProfesion() {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("estado", "A"));
		return dao.listarPorCriterios(c);
	}
}
