package net.royal.erp.rrhh.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.royal.framework.web.servicio.impl.GenericoServicioImpl;
import net.royal.erp.rrhh.dao.HrCargosmastDao;
import net.royal.erp.rrhh.servicio.HrCargosmastServicio;
import net.royal.erp.rrhh.dominio.HrCargosmast;
import net.royal.erp.rrhh.dominio.HrCargosmastPk;

@Service (value = "BeanServicioHrCargosmast")
public class HrCargosmastServicioImpl extends GenericoServicioImpl implements HrCargosmastServicio {

	private HrCargosmastDao dao;

	private static Log LOGGER = LogFactory.getLog(HrCargosmastServicioImpl.class);

	@Autowired
	public void setDao(HrCargosmastDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrCargosmast> ListarCargosmast() {
		return dao.ListarCargosmast();
	}

	@Override
	public HrCargosmast obtenerCargosmastxparam(String cargo) {
		return dao.obtenerCargosmastxparam(cargo);
	}

}
