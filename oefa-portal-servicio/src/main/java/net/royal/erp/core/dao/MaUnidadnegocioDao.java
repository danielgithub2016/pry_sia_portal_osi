package net.royal.erp.core.dao;

import net.royal.framework.web.dao.GenericoDao;
import net.royal.erp.core.dominio.MaUnidadnegocio;
import net.royal.erp.core.dominio.MaUnidadnegocioPk;

import java.util.List;

public interface MaUnidadnegocioDao extends
		GenericoDao<MaUnidadnegocio, MaUnidadnegocioPk> {

	/**
	 * Dw_Ma_Unidadnegocio_Select
	 * @param par_unidad
	 * @return
	 */
	public List<MaUnidadnegocio> obtenerCombo();
	
	/**
	 * 
	 * @param par_unidad
	 * @return
	 */
	public List<MaUnidadnegocio> listarUnidadNegocio(String par_unidad);
	
	public String obtenerNombreUnidadNegocio(String par_unidad);
}
