package net.royal.erp.core.servicio.impl;

import java.util.List;

import net.royal.erp.core.dao.DepartmentmstDao;
import net.royal.erp.core.dominio.Departmentmst;
import net.royal.erp.core.servicio.DepartmentmstServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioDepartmentmst")
public class DepartmentmstServicioImpl extends GenericoServicioImpl implements
		DepartmentmstServicio {

	private DepartmentmstDao dao;

	private static Log LOGGER = LogFactory
			.getLog(DepartmentmstServicioImpl.class);

	@Autowired
	public void setDao(DepartmentmstDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<Departmentmst> listarWarehouseAvailable() {
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("status", "A"));
		cri.add(Restrictions.eq("warehouseavailableflag", "Y"));

		List lista = dao.listarPorCriterios(cri);

		return lista;
	}

}
