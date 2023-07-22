package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrGradosalariomastDao;
import net.royal.erp.rrhh.dominio.HrGradosalariomast;
import net.royal.erp.rrhh.servicio.HrGradosalariomastServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrGradosalariomast")
public class HrGradosalariomastServicioImpl extends GenericoServicioImpl
		implements HrGradosalariomastServicio {

	private HrGradosalariomastDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrGradosalariomastServicioImpl.class);

	@Autowired
	public void setDao(HrGradosalariomastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrGradosalariomast> listarGradoSalario() {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("estado", "A"));
		c.addOrder(Order.asc("descripcionlocal"));
		return dao.listarPorCriterios(c);
	}

	@Override
	public HrGradosalariomast obtenerGradoSalarioxParam(String gradosalario) {
		return dao.obtenerGradoSalarioxParam(gradosalario);
	}

	@Override
	public HrGradosalariomast obtenerGradoSalarioxCargo(String cargo) {
		// TODO Auto-generated method stub
		return dao.obtenerGradoSalarioxCargo(cargo);
	}
	
	public List listarGradoSalario(String ls_familia){
		return dao.listarGradoSalario(ls_familia);
	}

}
