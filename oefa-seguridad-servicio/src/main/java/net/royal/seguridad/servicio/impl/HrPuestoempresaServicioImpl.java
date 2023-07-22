package net.royal.seguridad.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.seguridad.dao.HrPuestoempresaDao;
import net.royal.seguridad.dominio.Empleadomast;
import net.royal.seguridad.dominio.HrPuestoempresa;
import net.royal.seguridad.dominio.HrPuestoempresaPk;
import net.royal.seguridad.servicio.HrPuestoempresaServicio;

@Service (value = "BeanServicioHrPuestoempresaSeguridad")
public class HrPuestoempresaServicioImpl extends GenericoServicioImpl implements HrPuestoempresaServicio {

	private HrPuestoempresaDao dao;

	private static Log LOGGER = LogFactory.getLog(HrPuestoempresaServicioImpl.class);

	@Autowired
	@Qualifier("hrPuestoempresaDaoImplSeguridad")
	public void setDao(HrPuestoempresaDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrPuestoempresa> listarActivos() {
		Criteria cri = dao.getCriteria();
		cri.add(Restrictions.eq("estado", "A"));
		cri.addOrder(Order.asc("descripcion"));
		List<HrPuestoempresa> list = dao
				.listarPorCriterios(cri);		
		return list;
	}

}
