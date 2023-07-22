package net.royal.erp.core.servicio.impl;

import java.util.List;

import net.royal.erp.core.dao.UnidadesmastDao;
import net.royal.erp.core.servicio.UnidadesmastServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioUnidadesmast")
public class UnidadesmastServicioImpl extends GenericoServicioImpl implements
		UnidadesmastServicio {

	private UnidadesmastDao dao;

	private static Log LOGGER = LogFactory
			.getLog(UnidadesmastServicioImpl.class);

	@Autowired
	public void setDao(UnidadesmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List DwMaUnidadesmastSelect() {
		Criteria criteria= dao.getCriteria();
		criteria.add(Restrictions.eq("estado", "A"));
		
		return dao.listarPorCriterios(criteria);
	}

}
