package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrRequerimientofunpracDao;
import net.royal.erp.rrhh.dominio.HrRequerimientofunprac;
import net.royal.erp.rrhh.servicio.HrRequerimientofunpracServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrRequerimientofunprac")
public class HrRequerimientofunpracServicioImpl extends GenericoServicioImpl
		implements HrRequerimientofunpracServicio {

	private HrRequerimientofunpracDao dao;

	private static Log LOGGER = LogFactory
			.getLog(HrRequerimientofunpracServicioImpl.class);

	@Autowired
	public void setDao(HrRequerimientofunpracDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<HrRequerimientofunprac> listarRequerimientoFunPrac(
			String companyowner, String requerimiento) {
		// TODO Auto-generated method stub
		return dao.listarRequerimientoFunPrac(companyowner, requerimiento);
	}

}
