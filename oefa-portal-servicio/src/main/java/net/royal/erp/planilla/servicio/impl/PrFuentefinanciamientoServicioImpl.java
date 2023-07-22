package net.royal.erp.planilla.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.royal.erp.planilla.dao.PrFuentefinanciamientoDao;
import net.royal.erp.planilla.dominio.PrFuentefinanciamiento;
import net.royal.erp.planilla.servicio.PrFuentefinanciamientoServicio;
import net.royal.framework.web.servicio.impl.GenericoServicioImpl;

@Service(value = "BeanServicioPrFuentefinanciamiento")
public class PrFuentefinanciamientoServicioImpl extends GenericoServicioImpl implements PrFuentefinanciamientoServicio {

	private PrFuentefinanciamientoDao dao;

	@Autowired
	public void setDao(PrFuentefinanciamientoDao dao) {
		this.dao = dao;
		this.setGenericoDao(dao);
	}

	@Override
	public List<PrFuentefinanciamiento> listarPorAnioCompania(String anio, String compania) {
		return this.dao.listarPorAnioCompania(anio, compania);
	}

}
