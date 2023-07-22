package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrRequerimientofuncasDao;
import net.royal.erp.rrhh.dominio.HrRequerimientofuncas;
import net.royal.erp.rrhh.servicio.HrRequerimientofuncasServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrRequerimientofuncas")
public class HrRequerimientofuncasServicioImpl extends GenericoServicioImpl
		implements HrRequerimientofuncasServicio {

	private HrRequerimientofuncasDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrRequerimientofuncasServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientofuncasDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrRequerimientofuncas> listarRequerimientoFuncas(
			String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		return dao.listarRequerimientoFuncas(companyowner, requerimiento);
	}

	@Override
	public void eliminarporCampos(String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		dao.eliminarporCampos(companyowner, requerimiento);
	}

}
