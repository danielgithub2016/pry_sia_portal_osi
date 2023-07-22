package net.royal.erp.rrhh.servicio.impl;

import java.util.List;

import net.royal.erp.rrhh.dao.HrRequerimientoreemplazoDao;
import net.royal.erp.rrhh.dominio.HrRequerimientoreemplazo;
import net.royal.erp.rrhh.servicio.HrRequerimientoreemplazoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "BeanServicioHrRequerimientoreemplazo")
public class HrRequerimientoreemplazoServicioImpl extends GenericoServicioImpl
		implements HrRequerimientoreemplazoServicio {

	private HrRequerimientoreemplazoDao dao;

	@Autowired
	public void setDao(HrRequerimientoreemplazoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	public List<HrRequerimientoreemplazo> listarReuqerimientoReemplazo(
			String companyOwner, String requerimiento) {
		return dao.listarReuqerimientoReemplazo(companyOwner, requerimiento);
	}

	@Override
	public void eliminarRequerimientoReemplazo(String companyOwner,
			String requerimiento) {
		dao.eliminarRequerimientoReemplazo(companyOwner, requerimiento);

	}

}
