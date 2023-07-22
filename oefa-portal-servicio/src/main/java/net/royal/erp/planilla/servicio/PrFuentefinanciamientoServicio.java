package net.royal.erp.planilla.servicio;

import java.util.List;

import net.royal.erp.planilla.dominio.PrFuentefinanciamiento;
import net.royal.framework.web.servicio.GenericoServicio;

public interface PrFuentefinanciamientoServicio extends GenericoServicio {
	public List<PrFuentefinanciamiento> listarPorAnioCompania(String anio, String compania);

}
