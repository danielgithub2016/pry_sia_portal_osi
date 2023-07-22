package net.royal.seguridad.servicio.impl;

import java.util.List;

import net.royal.framework.web.core.UValidador;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.EmpleadomastDao;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.servicio.EmpleadomastServicio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service (value = "BeanServicioEmpleadomastSeguridad")
public class EmpleadomastServicioImpl extends GenericoServicioImpl implements EmpleadomastServicio {

	private EmpleadomastDao dao;

	private static Log LOGGER = LogFactory.getLog(EmpleadomastServicioImpl.class);

	@Autowired
	@Qualifier("empleadomastDaoImplSeguridad")
	public void setDao(EmpleadomastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}
	
	@Override
	public Empleadomast obtenerPorPersona(Integer persona) {
		Criteria c = dao.getCriteria();
		c.add(Restrictions.eq("pk.empleado", persona));
		List<Empleadomast> res = dao.listarPorCriterios(c);
		
		if(UValidador.esListaVacia(res))
			return null;
		else
			return res.get(0);
	}

}
