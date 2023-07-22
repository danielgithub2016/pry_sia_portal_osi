package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrRequerimientofuncasdetDao;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncasdet;
import net.royal.erp.rrhh.servicio.HrRequerimientofuncasdetServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrRequerimientofuncasdet")
public class HrRequerimientofuncasdetServicioImpl extends GenericoServicioImpl
		implements HrRequerimientofuncasdetServicio {

	private HrRequerimientofuncasdetDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrRequerimientofuncasdetServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientofuncasdetDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrRequerimientofuncasdet> listarRequerimientoFuncasDet(
			String compania, String requerimiento) {
		// TODO Auto-generated method stub
		return dao.listarRequerimientoFuncasDet(compania, requerimiento);
	}

	@Override
	public void eliminarporCampos(String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		dao.eliminarporCampos(companyowner, requerimiento);
	}
}
