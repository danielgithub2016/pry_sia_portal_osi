package net.royal.erp.planilla.dao;

import java.util.List;

import net.royal.erp.planilla.dominio.PrFuentefinanciamiento;
import net.royal.erp.planilla.dominio.PrFuentefinanciamientoPk;
import net.royal.framework.web.dao.GenericoDao;

public interface PrFuentefinanciamientoDao extends GenericoDao<PrFuentefinanciamiento, PrFuentefinanciamientoPk> {

	public List<PrFuentefinanciamiento> listarPorAnioCompania(String anio, String compania);
}
